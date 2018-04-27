package com.share.bag.ui.activitys;

import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;

import com.share.bag.R;
import com.share.bag.base.BaseActivity;
import com.share.bag.utils.ToastUtils;
import com.share.bag.utils.okhttp.OkHttpUtils;
import com.share.bag.utils.okhttp.callback.MyNetWorkCallback;

import org.json.JSONException;

import java.util.HashMap;

/**
 * @Author : TianFB
 * @Date : 2018/4/27
 * @Desrcibe ：
 */

public class BackActivity extends BaseActivity {

    private String id;
    private EditText edit1;
    private EditText edit2;

    @Override
    public int initLayout() {
        return R.layout.activity_back;
    }

    @Override
    public void initView() {
        edit1 = (EditText) findViewById(R.id.edit1);
        edit2 = (EditText) findViewById(R.id.edit2);
        findViewById(R.id.conmit).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String str1 = edit1.getText().toString().trim();
                String str2 = edit1.getText().toString().trim();
                if(TextUtils.isEmpty(str1)){
                    ToastUtils.showTop(BackActivity.this,"请填写快递公司名称");
                    return;
                }
                if(TextUtils.isEmpty(str2)){
                    ToastUtils.showTop(BackActivity.this,"请填写快递单号");
                    return;
                }
                HashMap<String,String> map  = new HashMap<String, String>();
                map.put("company",str1);
                map.put("billnumber",str2);
                map.put("baglist_id",id);
                OkHttpUtils.getInstance().post("https://baobaoapi.ldlchat.com/Home/Order/bagreturnadd.html", map, new MyNetWorkCallback<Object>() {
                    @Override
                    public void onSuccess(Object o) throws JSONException {
                        ToastUtils.showTop(BackActivity.this,"已提交");
                        finish();
                    }

                    @Override
                    public void onError(int errorCode, String errorMsg) {

                    }
                });


            }
        });
        findViewById(R.id.ship_return).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }

    @Override
    protected void initData() {
        id = getIntent().getStringExtra("id");
    }

    @Override
    protected boolean hodeWindow() {
        return false;
    }
}
