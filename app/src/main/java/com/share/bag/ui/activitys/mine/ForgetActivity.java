package com.share.bag.ui.activitys.mine;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
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
import com.share.bag.entity.SMSBean;
import com.share.bag.utils.okhttp.OkHttpUtils;
import com.share.bag.utils.okhttp.callback.MyNetWorkCallback;

import org.json.JSONException;

import java.util.HashMap;
import java.util.Map;
/*
* 找回密码
* */
public class ForgetActivity extends AppCompatActivity implements View.OnClickListener {

    private ImageView forget_return;
    private RelativeLayout relativeLayout;
    private EditText forget_phone;
    private EditText forget_verification;
    private TextView forget_obtain;
    private LinearLayout linearLayout7;
    private EditText forget_password;
    private LinearLayout linearLayout8;
    private EditText forget_password1;
    private Button forget_login;
    private String phone;
    private String verification;
    private String password;
    private String password1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forget);
        initView();
        phone = forget_phone.getText().toString().trim();

        verification = forget_verification.getText().toString().trim();

        password = forget_password.getText().toString().trim();

        password1 = forget_password1.getText().toString().trim();
    }

    private void initView() {
        forget_return = (ImageView) findViewById(R.id.forget_return);
        relativeLayout = (RelativeLayout) findViewById(R.id.relativeLayout);
        forget_phone = (EditText) findViewById(R.id.forget_phone);
        forget_verification = (EditText) findViewById(R.id.forget_verification);
        forget_obtain = (TextView) findViewById(R.id.forget_obtain);
        linearLayout7 = (LinearLayout) findViewById(R.id.linearLayout7);
        forget_password = (EditText) findViewById(R.id.forget_password);
        linearLayout8 = (LinearLayout) findViewById(R.id.linearLayout8);
        forget_password1 = (EditText) findViewById(R.id.forget_password1);
        forget_login = (Button) findViewById(R.id.forget_login);

        forget_login.setOnClickListener(this);
        forget_return.setOnClickListener(this);
        forget_obtain.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.forget_login:

//                                       baobaoapi.ldlchat.com/Home/user/getnewpwd.html
                String strurl="http://baobaoapi.ldlchat.com/Home/user/getnewpwd.html";

                Map<String,String> stringStringMap=new HashMap<>();
                stringStringMap.put("username",forget_phone.getText().toString().trim());
                stringStringMap.put("newpwd",forget_password.getText().toString().trim());
                stringStringMap.put("confirmpwd",forget_password1.getText().toString().trim());
                stringStringMap.put("code",forget_verification.getText().toString().trim());

                OkHttpUtils.getInstance().post(SBUrls.FORGET, stringStringMap, new MyNetWorkCallback<ForgetBean>() {
                    @Override
                    public void onSuccess(ForgetBean forgetBean) throws JSONException {

                        Toast.makeText(ForgetActivity.this, "返回正常"+forgetBean.getInfo(), Toast.LENGTH_SHORT).show();
                        Log.e("TTAAG",forgetBean.getStatus()+"======="+forgetBean.getInfo());

                        String info = forgetBean.getInfo();

                        if (info.equals("修改成功")){
                            finish();
                        }else {
                            Toast.makeText(ForgetActivity.this, "请重新输入", Toast.LENGTH_SHORT).show();
                            forget_phone.setText(null);
                            forget_password.setText(null);
                            forget_password1.setText(null);
                            forget_verification.setText(null);

                        }




                    }

                    @Override
                    public void onError(int errorCode, String errorMsg) {

                    }
                });
                break;
            case R.id.forget_return:
                    finish();
                break;
            case R.id.forget_obtain:
                Map<String,String> map=new HashMap<>();
                map.put("username",forget_phone.getText().toString().trim());
                OkHttpUtils.getInstance().post(SBUrls.SMSURL, map, new MyNetWorkCallback<SMSBean>() {
                    @Override
                    public void onSuccess(SMSBean loginBean) {
//                TODO ---------- Message
                        Toast.makeText(ForgetActivity.this, loginBean.getInfo(), Toast.LENGTH_SHORT).show();
                    }

                    @Override
                    public void onError(int errorCode, String errorMsg) {
                        Toast.makeText(ForgetActivity.this, "失败"+errorMsg.toString()+errorCode, Toast.LENGTH_SHORT).show();
                    }
                });
                break;
        }
    }

/*    private void submit() {

        String phone = forget_phone.getText().toString().trim();
        if (TextUtils.isEmpty(phone)) {
            Toast.makeText(this, "phone不能为空", Toast.LENGTH_SHORT).show();
            return;
        }

        String verification = forget_verification.getText().toString().trim();
        if (TextUtils.isEmpty(verification)) {
            Toast.makeText(this, "verification不能为空", Toast.LENGTH_SHORT).show();
            return;
        }

        String password = forget_password.getText().toString().trim();
        if (TextUtils.isEmpty(password)) {
            Toast.makeText(this, "password不能为空", Toast.LENGTH_SHORT).show();
            return;
        }

        String password1 = forget_password1.getText().toString().trim();
        if (TextUtils.isEmpty(password1)) {
            Toast.makeText(this, "password1不能为空", Toast.LENGTH_SHORT).show();
            return;
        }

        if (password.equals(password1)){
//                                    baobaoapi.ldlchat.com/Home/user/getnewpwd.html
            String strurl="http://baobaoapi.ldlchat.com/Home/user/getnewpwd.html";
            Map<String,String> stringStringMap=new HashMap<>();
            stringStringMap.put("username",phone);
            stringStringMap.put("newpwd",password);
            stringStringMap.put("confirmpwd",password1);
            stringStringMap.put("code",verification);

            OkHttpUtils.getInstance().post(strurl, stringStringMap, new MyNetWorkCallback<ForgetBean>() {
                @Override
                public void onSuccess(ForgetBean forgetBean) throws JSONException {
//                    String username = forgetBean.getUsername();

//                    if (username.equals("")){
                        Toast.makeText(ForgetActivity.this, forgetBean.getInfo(), Toast.LENGTH_SHORT).show();

                        finish();

//                    }else {
//                        Toast.makeText(ForgetActivity.this, forgetBean.getInfo(), Toast.LENGTH_SHORT).show();
//                    }

                }

                @Override
                public void onError(int errorCode, String errorMsg) {

                }
            });
        }else {
            Toast.makeText(this, "输入的密码不一致", Toast.LENGTH_SHORT).show();
        }

    }*/
}
