package com.share.bag.ui.activitys;

import android.graphics.Color;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.share.bag.R;
import com.share.bag.base.BaseActivity;
import com.share.bag.utils.ToastUtils;
import com.share.bag.utils.okhttp.OkHttpUtils;
import com.share.bag.utils.okhttp.callback.MyNetWorkCallback;

import org.greenrobot.eventbus.EventBus;
import org.json.JSONException;

import java.util.HashMap;

import butterknife.BindView;

/**
 * @Author : TianFB
 * @Date : 2018/4/27
 * @Desrcibe ：
 */

public class WithdrawCashActivity extends BaseActivity implements View.OnClickListener {
    ImageView shipReturn;
    TextView buttonWx;
    TextView buttonZfb;
    EditText edit1;
    EditText edit2;
    TextView conmit;
    private int type = 1;
    private View user_group;

    @Override
    public int initLayout() {
        return R.layout.activity_withrawcash;
    }

    @Override
    public void initView() {
        buttonWx = (TextView) findViewById(R.id.button_wx);
        buttonZfb = (TextView) findViewById(R.id.button_zfb);
        shipReturn = (ImageView) findViewById(R.id.ship_return);
        conmit = (TextView) findViewById(R.id.conmit);
        edit1 = (EditText) findViewById(R.id.edit_1);
        edit2 = (EditText) findViewById(R.id.edit_2);
        user_group = findViewById(R.id.user_group);
    }

    @Override
    protected void initData() {
        buttonWx.setOnClickListener(this);
        buttonZfb.setOnClickListener(this);
        shipReturn.setOnClickListener(this);
        conmit.setOnClickListener(this);
    }

    @Override
    protected boolean hodeWindow() {
        return false;
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.ship_return:
                finish();
                break;
            case R.id.button_wx:
                type = 2;
                buttonWx.setBackgroundColor(Color.parseColor("#ff0000"));
                buttonWx.setTextColor(Color.parseColor("#ffffff"));
                buttonZfb.setBackgroundColor(Color.parseColor("#ffffff"));
                buttonZfb.setTextColor(Color.parseColor("#ff0000"));
                user_group.setVisibility(View.GONE);
                break;
            case R.id.button_zfb:
                buttonZfb.setBackgroundColor(Color.parseColor("#ff0000"));
                buttonZfb.setTextColor(Color.parseColor("#ffffff"));
                buttonWx.setBackgroundColor(Color.parseColor("#ffffff"));
                buttonWx.setTextColor(Color.parseColor("#ff0000"));
                user_group.setVisibility(View.VISIBLE);
                break;
            case R.id.conmit:
                HashMap<String, String> map = new HashMap<>();
                String money = edit1.getText().toString().trim();
                String user = edit2.getText().toString().trim();
                if (TextUtils.isEmpty(money)) {
                    ToastUtils.showTop(WithdrawCashActivity.this, "请输入提现金额");
                    return;
                }
                map.put("amount", money);
                if (type == 1) {
                    if (TextUtils.isEmpty(user)) {
                        ToastUtils.showTop(WithdrawCashActivity.this, "请输入支付宝账号");
                        return;
                    }
                }else {
                    user = "1";
                }
                map.put("account", user);
                map.put("type", type + "");


                OkHttpUtils.getInstance().post("https://baobaoapi.ldlchat.com/Home/wallet/withdraw.html", map, new MyNetWorkCallback<WithdrawBean>() {
                    @Override
                    public void onSuccess(WithdrawBean o) throws JSONException {
                        ToastUtils.showTop(WithdrawCashActivity.this, o.getInfo());
                        EventBus.getDefault().post(o);
                        finish();
                    }

                    @Override
                    public void onError(int errorCode, String errorMsg) {

                    }
                });



                break;
        }
    }
}
