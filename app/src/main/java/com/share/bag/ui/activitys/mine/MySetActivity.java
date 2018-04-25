package com.share.bag.ui.activitys.mine;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import com.share.bag.FileUtil;
import com.share.bag.R;
import com.share.bag.base.BaseActivity;
import com.share.bag.utils.ToastUtils;
import com.share.bag.view.YWXZAlertDialog;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/*
* 设置
* */
public class MySetActivity extends BaseActivity {
    @BindView(R.id.myset_return)
    ImageView mysetReturn;
    @BindView(R.id.myset_safety)
    RelativeLayout mysetSafety;
    @BindView(R.id.myset_updated)
    RelativeLayout mysetUpdated;
    @BindView(R.id.myset_clear)
    RelativeLayout mysetClear;
    @BindView(R.id.myset_on)
    RelativeLayout mysetOn;
    @BindView(R.id.myset_dropout)
    Button mysetDropout;

    @Override
    public int initLayout() {
        return R.layout.activity_my_set;
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

    @OnClick({R.id.myset_return,  R.id.myset_safety, R.id.myset_updated, R.id.myset_clear, R.id.myset_on, R.id.myset_dropout})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.myset_return:
                finish();
                break;
            case R.id.myset_safety:
                startActivity(new Intent(MySetActivity.this,PassWordORPhoneActivity.class));
                break;
            case R.id.myset_updated:
                ToastUtils.showTop(MySetActivity.this, "当前是最新版本");
                break;
            case R.id.myset_clear:
               ToastUtils.showTop(MySetActivity.this, "缓存已清除");
                break;
            case R.id.myset_on:
                ToastUtils.showTop(MySetActivity.this, "关于共享");
                break;
            case R.id.myset_dropout:

                final YWXZAlertDialog dialog = new YWXZAlertDialog(MySetActivity.this,"确定退出登录吗?");
                dialog.setCancelBtnGone(true);
                dialog.show();
                dialog.setOnAlertDialogOnClick(new YWXZAlertDialog.AlertDialogOnClickListener() {
                    @Override
                    public void onYes() {
                        FileUtil.shanchu(MySetActivity.this);//清空
                        dialog.dismiss();
                        finish();

                    }

                    @Override
                    public void onNo() {
                        dialog.dismiss();
                    }

                    @Override
                    public void onCancel() {

                    }
                });



                break;
        }
    }

}
