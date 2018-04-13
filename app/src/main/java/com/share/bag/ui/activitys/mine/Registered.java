package com.share.bag.ui.activitys.mine;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.InputType;
import android.text.TextUtils;
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
import com.share.bag.ui.activitys.mine.registered.RegisteredBean;
import com.share.bag.utils.okhttp.OkHttpUtils;
import com.share.bag.utils.okhttp.callback.MyNetWorkCallback;

import org.json.JSONException;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Function;
import io.reactivex.schedulers.Schedulers;

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
    private Disposable mDisposable;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registered3);
        initView();
        registered_password.setInputType(InputType.TYPE_CLASS_TEXT | InputType.TYPE_TEXT_VARIATION_PASSWORD);
        registered_password1.setInputType(InputType.TYPE_CLASS_TEXT | InputType.TYPE_TEXT_VARIATION_PASSWORD);

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

    // 获取验证码
    private void goSMS() {
        Map<String, String> map = new HashMap<>();
        String phoneNumber = registered_phone.getText().toString().trim();
        if (phoneNumber!=null&&phoneNumber.length()>0&&phoneNumber.length()<=11){
            registered_obtain.setText("60");
            Observable
                    .interval(1, TimeUnit.SECONDS)
                    .take(60)
                    .subscribeOn(Schedulers.newThread())
                    .observeOn(AndroidSchedulers.mainThread())
                    .subscribe(new Observer<Long>() {
                    @Override
                    public void onSubscribe(Disposable d) {
                        mDisposable = d;
                    }

                    @Override
                    public void onNext(Long aLong) {
                            registered_obtain.setText(60 - 1-aLong + "");
                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onComplete() {
                        registered_obtain.setText("获取验证码");
                    }
            });
            map.put("username", registered_phone.getText().toString().trim());
            try {
                OkHttpUtils.getInstance().post(SBUrls.SMSURL, map, new MyNetWorkCallback<SMSBean>() {
                    @Override
                    public void onSuccess(SMSBean loginBean) {
                        Toast.makeText(Registered.this, loginBean.getInfo(), Toast.LENGTH_SHORT).show();
                    }
                    @Override
                    public void onError(int errorCode, String errorMsg) {
                        Toast.makeText(Registered.this, "失败"+errorMsg.toString()+errorCode, Toast.LENGTH_SHORT).show();
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

        String password1 = registered_password1.getText().toString().trim();//重新输入密码
        if (TextUtils.isEmpty(password1)) {
            Toast.makeText(this, "phone不能为空", Toast.LENGTH_SHORT).show();
            return;
        }

        String verification = registered_verification.getText().toString().trim();
        if (TextUtils.isEmpty(verification)) {
            Toast.makeText(this, "verification不能为空", Toast.LENGTH_SHORT).show();
            return;
        }

        String password = registered_password.getText().toString().trim();//输入密码
        if (TextUtils.isEmpty(password)) {
            Toast.makeText(this, "password不能为空", Toast.LENGTH_SHORT).show();
            return;
        }

        String invite = registered_invite.getText().toString().trim();

        Map<String, String> map = new HashMap<>();
        map.put("username", registered_phone.getText().toString().trim());//手机号
        map.put("code", registered_verification.getText().toString().trim());//验证码
        map.put("password", registered_password.getText().toString().trim());//密码
        map.put("alipay",invite+"");//邀请码
        map.put("type",3+"");
        if (password.equals(password1)){

//        username   用户名    password 密码     code手机验证码
            OkHttpUtils.getInstance().post(SBUrls.REGISTEREDURL, map, new MyNetWorkCallback<RegisteredBean>() {
                @Override
                public void onSuccess(RegisteredBean registeredBean) throws JSONException {
                    String info = registeredBean.getInfo();
                    if (info.equals("注册成功")){
                        finish();
                    }else {
                        Toast.makeText(Registered.this, info, Toast.LENGTH_SHORT).show();
                    }
                }

                @Override
                public void onError(int errorCode, String errorMsg) {
                }
            });

        }else {
            Toast.makeText(this, "两次输入的密码不一致", Toast.LENGTH_SHORT).show();
        }

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mDisposable.dispose();
    }
}
