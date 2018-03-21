package com.share.bag.ui.activitys.mine;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.InputType;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.share.bag.R;
import com.share.bag.SBUrls;
import com.share.bag.entity.LoginBean;
import com.share.bag.entity.SMSBean;
import com.share.bag.utils.okhttp.OkHttpUtils;
import com.share.bag.utils.okhttp.callback.MyNetWorkCallback;

import java.util.HashMap;
import java.util.Map;
/*
用户注册
*
* */
public class Registered extends AppCompatActivity implements View.OnClickListener {

    private ImageView registered_return;
    private RelativeLayout relativeLayout;
    private EditText registered_phone;
    private LinearLayout linearLayout6;
    private EditText registered_verification;
    private TextView registered_obtain;
    private LinearLayout linearLayout7;
    private EditText registered_password,registered_password1,registered_invite;
    private LinearLayout linearLayout8;
    private Button registered_login;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registered3);
        initView();
        registered_password.setInputType(InputType.TYPE_CLASS_TEXT | InputType.TYPE_TEXT_VARIATION_PASSWORD);

        registered_return.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
        registered_obtain.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               
                try {
                    goSMS();
                }catch (Exception e){
                    Toast.makeText(Registered.this, "请稍后再试！！！", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    private void initView() {
        registered_return = (ImageView) findViewById(R.id.registered_return);
        relativeLayout = (RelativeLayout) findViewById(R.id.relativeLayout);
        registered_phone = (EditText) findViewById(R.id.registered_phone);
        linearLayout6 = (LinearLayout) findViewById(R.id.linearLayout6);
        registered_verification = (EditText) findViewById(R.id.registered_verification);
        registered_obtain = (TextView) findViewById(R.id.registered_obtain);
        linearLayout7 = (LinearLayout) findViewById(R.id.linearLayout7);
        registered_password = (EditText) findViewById(R.id.registered_password);
        linearLayout8 = (LinearLayout) findViewById(R.id.linearLayout8);
        registered_password1 = (EditText) findViewById(R.id.registered_password1);

        registered_invite = (EditText) findViewById(R.id.registered_invite);
        registered_login = (Button) findViewById(R.id.registered_login);

        registered_login.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.registered_login:
                goRegistered();
                break;
        }
    }

    private void submit() {
        // validate
        String phone = registered_phone.getText().toString().trim();
        if (TextUtils.isEmpty(phone)) {
            Toast.makeText(this, "phone不能为空", Toast.LENGTH_SHORT).show();
            return;
        }

        String verification = registered_verification.getText().toString().trim();
        if (TextUtils.isEmpty(verification)) {
            Toast.makeText(this, "verification不能为空", Toast.LENGTH_SHORT).show();
            return;
        }

        String password = registered_password.getText().toString().trim();
        if (TextUtils.isEmpty(password)) {
            Toast.makeText(this, "password不能为空", Toast.LENGTH_SHORT).show();
            return;
        }

        // TODO validate success, do something


    }


    // 获取验证码
    private void goSMS() {
        Map<String, String> map = new HashMap<>();
        String phoneNumber = registered_phone.getText().toString().trim();
        if (phoneNumber!=null&&phoneNumber.length()>0&&phoneNumber.length()<=11){
            map.put("username", registered_phone.getText().toString().trim());

            try {

                OkHttpUtils.getInstance().post(SBUrls.SMSURL, map, new MyNetWorkCallback<SMSBean>() {
                    @Override
                    public void onSuccess(SMSBean loginBean) {
//                TODO ---------- Message
                        Toast.makeText(Registered.this, loginBean.getInfo(), Toast.LENGTH_SHORT).show();
                    }

                    @Override
                    public void onError(int errorCode, String errorMsg) {
                        Toast.makeText(Registered.this, "失败"+errorMsg.toString()+errorCode, Toast.LENGTH_SHORT).show();
                        Log.e("TAG",errorMsg.toString()+errorCode);
                    }
                });
            }catch (Exception e){

                Toast.makeText(this, "请稍后再试", Toast.LENGTH_SHORT).show();

            }



        }else {
            Toast.makeText(Registered.this,"请输入正确的手机号",Toast.LENGTH_SHORT).show();
        }
    }

    //  注册--登录
    private void goRegistered() {

        String phone = registered_phone.getText().toString().trim();
        if (TextUtils.isEmpty(phone)) {
            Toast.makeText(this, "phone不能为空", Toast.LENGTH_SHORT).show();
            return;
        }

        String password1 = registered_password1.getText().toString().trim();
        if (TextUtils.isEmpty(password1)) {
            Toast.makeText(this, "phone不能为空", Toast.LENGTH_SHORT).show();
            return;
        }

        String verification = registered_verification.getText().toString().trim();
        if (TextUtils.isEmpty(verification)) {
            Toast.makeText(this, "verification不能为空", Toast.LENGTH_SHORT).show();
            return;
        }

        String password = registered_password.getText().toString().trim();
        if (TextUtils.isEmpty(password)) {
            Toast.makeText(this, "password不能为空", Toast.LENGTH_SHORT).show();
            return;
        }



        Map<String, String> map = new HashMap<>();
        map.put("username", registered_phone.getText().toString().trim());
        map.put("code", registered_verification.getText().toString().trim());
        map.put("password", registered_password.getText().toString().trim());

//        username   用户名    password 密码     code手机验证码
        OkHttpUtils.getInstance().post(SBUrls.REGISTEREDURL, map, new MyNetWorkCallback<LoginBean>() {

            @Override
            public void onSuccess(LoginBean loginBean) {
                Log.e("TGA",loginBean.getStatus()+loginBean.getInfo());
//                Toast.makeText(context, loginBean.getStatus()+"-------"+loginBean.getInfo(), Toast.LENGTH_SHORT).show();
                if(loginBean.getStatus().equals("0")){
                    Toast.makeText(Registered.this,loginBean.getInfo(),Toast.LENGTH_SHORT).show();
                }else{
                    startActivity(new Intent(Registered.this, Login.class));
                }
            }

            @Override
            public void onError(int errorCode, String errorMsg) {
//                ToastUtils.show(context, context.getClass().getSimpleName() + errorMsg);
            }
        });
    }
}
