package com.share.bag.ui.activitys.mine;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.share.bag.FileUtil;
import com.share.bag.MainActivity;
import com.share.bag.R;
import com.share.bag.SBUrls;
import com.share.bag.base.BaseActivity;
import com.share.bag.entity.LoginBean;
import com.share.bag.utils.okhttp.OkHttpUtils;
import com.share.bag.utils.okhttp.callback.MyNetWorkCallback;
import com.umeng.socialize.UMAuthListener;
import com.umeng.socialize.UMShareAPI;
import com.umeng.socialize.bean.SHARE_MEDIA;

import java.util.HashMap;
import java.util.Map;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/*
* 登录界面
* */
public class LoginActivity extends BaseActivity {

    @BindView(R.id.imageView6)
    ImageView imageView6;
    @BindView(R.id.login_phone)
    EditText loginPhone;
    @BindView(R.id.linearLayout3)
    LinearLayout linearLayout3;
    @BindView(R.id.login_password)
    EditText loginPassword;
    @BindView(R.id.linearLayout4)
    LinearLayout linearLayout4;
    @BindView(R.id.login_login)
    Button loginLogin;
    @BindView(R.id.login_registered)
    TextView loginRegistered;
    @BindView(R.id.login_forget)
    TextView loginForget;
    @BindView(R.id.linearLayout5)
    LinearLayout linearLayout5;
    @BindView(R.id.login_qq)
    ImageView loginQq;
    @BindView(R.id.login_weixin)
    ImageView loginWeixin;

    @Override
    public int initLayout() {
        return R.layout.activity_login2;

    }

    @Override
    public void initView() {

    }

    @Override
    protected void initData() {

    }

    @Override
    protected boolean hodeWindow() {
        return false;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // TODO: add setContentView(...) invocation
        ButterKnife.bind(this);
    }

    @OnClick({R.id.imageView6, R.id.login_phone, R.id.linearLayout3, R.id.login_password, R.id.linearLayout4, R.id.login_login, R.id.login_registered, R.id.login_forget, R.id.linearLayout5, R.id.login_qq, R.id.login_weixin})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.login_login://登录
               goLogin();
                break;
            case R.id.login_registered://注册
                Intent intent=new Intent(LoginActivity.this,RegisteredActivity.class);
                startActivity(intent);
                break;
            case R.id.login_forget://忘记密码
                break;
            case R.id.login_qq://QQ登录
//                Toast.makeText(this, "QQ登录", Toast.LENGTH_SHORT).show();
                UMShareAPI.get(this).getPlatformInfo(this, SHARE_MEDIA.QQ, authListener);
                break;
            case R.id.login_weixin://微信登录
                UMShareAPI.get(this).getPlatformInfo(this, SHARE_MEDIA.WEIXIN, authListener);
//                Toast.makeText(this, "微信登录", Toast.LENGTH_SHORT).show();
                break;
        }
    }
    UMAuthListener authListener=new UMAuthListener() {
        @Override
        public void onStart(SHARE_MEDIA share_media) {

        }

        @Override
        public void onComplete(SHARE_MEDIA share_media, int i, Map<String, String> map) {
            Toast.makeText(LoginActivity.this, "成功", Toast.LENGTH_SHORT).show();
            String s = map.get("name");
            String s1 = map.get("uid");
            String s2 = map.get("iconurl");
            String s3 = map.get("gender");
            Toast.makeText(LoginActivity.this, s+s2, Toast.LENGTH_SHORT).show();
            Log.e("TAG","---------"+s2);
            Intent intent=new Intent();
            intent.setClass(LoginActivity.this, MainActivity.class);
            intent.putExtra("name",s);
            intent.putExtra("img",s2);
            setResult(0,intent);
            finish();

        }

        @Override
        public void onError(SHARE_MEDIA share_media, int i, Throwable throwable) {

        }

        @Override
        public void onCancel(SHARE_MEDIA share_media, int i) {

        }
    };

    private void goLogin() {
        Map<String, String> map = new HashMap<>();
        map.put("username", loginPhone.getText().toString().trim());
        map.put("password", loginPassword.getText().toString().trim());
        map.put("type", "3");
        OkHttpUtils.getInstance().post(SBUrls.LOGINURL, map, new MyNetWorkCallback<LoginBean>() {
            @Override
            public void onSuccess(LoginBean loginBean) {

                String info = loginBean.getStatus();

                if (info.equals("1")){
                    String username = loginBean.getMsg().getUsername();//用户名
                    String password = loginBean.getMsg().getPassword();//密码
                    String gender = (String) loginBean.getMsg().getGender();//性别
                    String id = loginBean.getMsg().getId();//id
                    String nickname = (String) loginBean.getMsg().getName();//昵称
                    String iconurl = (String) loginBean.getMsg().getIconurl();//头像

                    FileUtil.saveToPre1(LoginActivity.this, username, password,id,gender,nickname,iconurl);

//返回值是：39用户名17801190741密码25f9e794323b453885f5181f1b624d0b性别男图片/Uploads/20180115/5a5c759804236.png昵称5
                    Intent intent=new Intent();
                    intent.setClass(LoginActivity.this, MainActivity.class);
                    String name= (String) loginBean.getMsg().getName();
                    intent.putExtra("name",name);
                    String img= (String) loginBean.getMsg().getIconurl();
                    intent.putExtra("img",img);
                    setResult(0,intent);
                    finish();
//
//                    finish();
                }
                else {
                    Toast.makeText(LoginActivity.this, loginBean.getInfo(), Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onError(int errorCode, String errorMsg) {

            }
        });

    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        UMShareAPI.get(this).onActivityResult(requestCode, resultCode, data);

    }

/*
* 授权回调
* */
    private UMAuthListener umAuthListener = new UMAuthListener() {
        @Override
        public void onStart(SHARE_MEDIA platform) {
            //授权开始的回调
        }
        @Override
        public void onComplete(SHARE_MEDIA platform, int action, Map<String, String> data) {
//            String name = data.get("name");
//            String uid = data.get("uid");
//            String iconurl = data.get("iconurl");
//            String gender = data.get("gender");
//            Toast.makeText(getApplicationContext(),name+uid+gender+iconurl , Toast.LENGTH_SHORT).show();
//            FileUtil.saveToPre1(LoginActivity.this, "","",uid,gender,name,iconurl);








        }

        @Override
        public void onError(SHARE_MEDIA platform, int action, Throwable t) {
            Toast.makeText( getApplicationContext(), "Authorize fail", Toast.LENGTH_SHORT).show();
        }

        @Override
        public void onCancel(SHARE_MEDIA platform, int action) {
            Toast.makeText( getApplicationContext(), "Authorize cancel", Toast.LENGTH_SHORT).show();
        }
    };

}
