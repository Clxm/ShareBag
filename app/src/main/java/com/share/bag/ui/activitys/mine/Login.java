package com.share.bag.ui.activitys.mine;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.InputType;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.share.bag.FileUtil;
import com.share.bag.MainActivity;
import com.share.bag.R;
import com.share.bag.SBUrls;
import com.share.bag.entity.LoginBean;
import com.share.bag.utils.ToastUtils;
import com.share.bag.utils.okhttp.OkHttpUtils;
import com.share.bag.utils.okhttp.callback.MyNetWorkCallback;
import com.umeng.socialize.UMAuthListener;
import com.umeng.socialize.UMShareAPI;
import com.umeng.socialize.bean.SHARE_MEDIA;

import java.util.HashMap;
import java.util.Map;

public class Login extends AppCompatActivity implements View.OnClickListener {

    private EditText login_phone;
    private EditText login_password;
    private Button login_login;
    private TextView login_registered;
    private TextView login_forget;
    private ImageView login_qq;
    private ImageView login_weixin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login3);
        initView();
        login_password.setInputType(InputType.TYPE_CLASS_TEXT | InputType.TYPE_TEXT_VARIATION_PASSWORD);

    }

    private void initView() {
        login_phone = (EditText) findViewById(R.id.login_phone);
        login_password = (EditText) findViewById(R.id.login_password);
        login_login = (Button) findViewById(R.id.login_login);
        login_registered = (TextView) findViewById(R.id.login_registered);
        login_forget = (TextView) findViewById(R.id.login_forget);
        login_qq = (ImageView) findViewById(R.id.login_qq);
        login_weixin = (ImageView) findViewById(R.id.login_weixin);

        login_login.setOnClickListener(this);
        login_registered.setOnClickListener(this);
        login_forget.setOnClickListener(this);
        login_qq.setOnClickListener(this);
        login_weixin.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.login_login:
                Map<String, String> map = new HashMap<>();
                map.put("username", login_phone.getText().toString().trim());
                map.put("password", login_password.getText().toString().trim());
                map.put("type", "3");
                goLogin(map);
                break;
            case R.id.login_registered://用户注册
                Intent intent=new Intent(Login.this,Registered.class);
                startActivity(intent);

                break;
            case R.id.login_forget:

//                Toast.makeText(this, "忘记密码", Toast.LENGTH_SHORT).show();

                Intent forget=new Intent(Login.this,ForgetActivity.class);
                startActivity(forget);
                break;

            case R.id.login_qq:
                UMShareAPI.get(this).getPlatformInfo(this, SHARE_MEDIA.QQ, authListener1);

                break;
            case R.id.login_weixin:

                UMShareAPI.get(this).getPlatformInfo(this, SHARE_MEDIA.WEIXIN,authListener );//    authListener

                break;
        }
    }

/*
*登录
* */
    private void goLogin(Map<String, String> map) {
        OkHttpUtils.getInstance().post(SBUrls.LOGINURL, map, new MyNetWorkCallback<LoginBean>() {
            @Override
            public void onSuccess(LoginBean loginBean) {
                if(null != loginBean) {
                    String info = loginBean.getStatus();
                    if (info.equals("1")) {
                        String nickname = loginBean.getUser().getName();//昵称
                        String username = loginBean.getUser().getUsernameX();//用户名
                        String password = loginBean.getUser().getPasswordX();//密码
                        String gender = loginBean.getUser().getGender();//性别
                        String strtou = loginBean.getUser().getIconurl();//头像
                        String id = loginBean.getUser().getId();//id
                        FileUtil.saveToPre1(Login.this, username, password, id, gender, nickname, strtou);
////返回值是：39用户名17801190741密码25f9e794323b453885f5181f1b624d0b性别男图片/Uploads/20180115/5a5c759804236.png昵称5
                        Intent intent = new Intent();
                        intent.setClass(Login.this, MainActivity.class);
                        String name = username;
                        intent.putExtra("name", name);
                        String img = strtou;
                        intent.putExtra("img", img);
                        setResult(0, intent);
                        finish();
                      ToastUtils.showTop(Login.this,loginBean.getInfo());
                    } else {
                        ToastUtils.showTop(Login.this, loginBean.getInfo());
                    }
                }else {
                    ToastUtils.showTop(Login.this,"登陆失败");
                }
            }

            @Override
            public void onError(int errorCode, String errorMsg) {

            }
        });

    }
    UMAuthListener authListener1 = new UMAuthListener() {
        /**
         * @desc 授权开始的回调
         * @param platform 平台名称
         */
        @Override
        public void onStart(SHARE_MEDIA platform) {

        }

        /**
         * @desc 授权成功的回调
         * @param platform 平台名称
         * @param action 行为序号，开发者用不上
         * @param data 用户资料返回
         */
        @Override
        public void onComplete(SHARE_MEDIA platform, int action, Map<String, String> data) {
            Map<String, String> map = new HashMap<>();
                if (platform == SHARE_MEDIA.QQ){
                    map.put("nickname", data.get("screen_name"));
                    map.put("uid", data.get("uid"));
                    map.put("gender", data.get("gender"));
                    map.put("HeadUrl", data.get("profile_image_url"));
                    map.put("type", "1");
                }
            goLogin(map);
        }

        /**
         * @desc 授权失败的回调
         * @param platform 平台名称
         * @param action 行为序号，开发者用不上
         * @param t 错误原因
         */
        @Override
        public void onError(SHARE_MEDIA platform, int action, Throwable t) {

            Toast.makeText(Login.this, "失败：" + t.getMessage(), Toast.LENGTH_LONG).show();
        }

        /**
         * @desc 授权取消的回调
         * @param platform 平台名称
         * @param action 行为序号，开发者用不上
         */
        @Override
        public void onCancel(SHARE_MEDIA platform, int action) {

            Toast.makeText(Login.this, "取消了", Toast.LENGTH_LONG).show();
        }
    };


    UMAuthListener authListener=new UMAuthListener() {
        @Override
        public void onStart(SHARE_MEDIA share_media) {

        }

        @Override
        public void onComplete(SHARE_MEDIA share_media, int i, Map<String, String> map) {

            Map<String, String> params = new HashMap<>();
            if (share_media == SHARE_MEDIA.WEIXIN){
                params.put("nickname", map.get("name"));
                params.put("uid", map.get("uid"));
                params.put("gender", map.get("gender"));
                params.put("HeadUrl", map.get("profile_image_url"));
                params.put("type", "2");
            }
            goLogin(params);

        }

        @Override
        public void onError(SHARE_MEDIA share_media, int i, Throwable throwable) {

        }

        @Override
        public void onCancel(SHARE_MEDIA share_media, int i) {

        }
    };
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        UMShareAPI.get(this).onActivityResult(requestCode,resultCode,data);//完成回调
    }
}
