package com.share.bag.ui.activitys.mine;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.share.bag.R;
import com.share.bag.base.BaseActivity;

/**
 * @Author : TianFB
 * @Date : 2018/4/25
 * @Desrcibe ：
 */

public class PassWordORPhoneActivity extends BaseActivity {


    @Override
    public int initLayout() {
        return R.layout.activity_password_phone;
    }

    public void initView() {
        findViewById(R.id.back).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
        findViewById(R.id.myset_password).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent forget=new Intent(PassWordORPhoneActivity.this,ForgetActivity.class);
                forget.putExtra("title","修改密码");
                startActivity(forget);
            }
        });
        findViewById(R.id.myset_phone).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(PassWordORPhoneActivity.this, PhoneActivity.class));
            }
        });
    }

    @Override
    protected void initData() {

    }

    @Override
    protected boolean hodeWindow() {
        return false;
    }
}
