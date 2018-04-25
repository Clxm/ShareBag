package com.share.bag.ui.activitys.mine;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.share.bag.R;
import com.share.bag.SBUrls;
import com.share.bag.base.BaseActivity;
import com.share.bag.entity.SMSBean;
import com.share.bag.utils.ToastUtils;
import com.share.bag.utils.okhttp.OkHttpUtils;
import com.share.bag.utils.okhttp.callback.MyNetWorkCallback;

import org.json.JSONException;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

/*
* 修改手机号
* */
public class PhoneActivity extends BaseActivity implements View.OnClickListener {

    @BindView(R.id.phone_return)
    ImageView phoneReturn;
    @BindView(R.id.phone_phone)
    EditText phonePhone;
    @BindView(R.id.forget_verification)
    EditText forgetVerification;
    @BindView(R.id.forget_obtain)
    TextView forgetObtain;
    @BindView(R.id.phone_confirm)
    Button phoneConfirm;
    private Disposable mDisposable;

    @Override
    public int initLayout() {
        return R.layout.activity_phone;
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

    private boolean isClick = true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ButterKnife.bind(this);
        phoneReturn.setOnClickListener(this);
        forgetObtain.setOnClickListener(this);
        phoneConfirm.setOnClickListener(this);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if(null != mDisposable)
        mDisposable.dispose();
    }


    private void submit_phone() {
        // validate
        String edittextString = phonePhone.getText().toString().trim();
        if (TextUtils.isEmpty(edittextString)) {
            ToastUtils.showTop(PhoneActivity.this,"手机号不能为空");
            return;
        }
        String verification = forgetVerification.getText().toString().trim();
        if (TextUtils.isEmpty(verification)) {
           ToastUtils.showTop(PhoneActivity.this,"验证码不能为空");
            return;
        }
        String url ="https://baobaoapi.ldlchat.com/Home/My/getcode.html";
        HashMap<String,String> map = new HashMap<>();
        map.put("username",edittextString);
        map.put("code",verification);
        OkHttpUtils.getInstance().post(url, map, new MyNetWorkCallback<Object>() {
            @Override
            public void onSuccess(Object o) throws JSONException {
                ToastUtils.showTop(PhoneActivity.this,"修改成功");
                finish();
            }

            @Override
            public void onError(int errorCode, String errorMsg) {

            }
        });
    }



    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.phone_return:
                finish();
                break;
            case R.id.phone_confirm://确认
                submit_phone();
                break;
            case R.id.forget_obtain:
                if (isClick) {
                    isClick = false;
                    String num = phonePhone.getText().toString().trim();
                    if (!TextUtils.isEmpty(num) && num.length() == 11) {
                        Map<String, String> map = new HashMap<>();
                        map.put("username", num);
                        forgetObtain.setText("60");
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
                                        forgetObtain.setText(60 - 1 - aLong + "");
                                    }

                                    @Override
                                    public void onError(Throwable e) {

                                    }

                                    @Override
                                    public void onComplete() {
                                        isClick = true;
                                        forgetObtain.setText("获取验证码");
                                    }
                                });
                        OkHttpUtils.getInstance().post(SBUrls.SMSURL, map, new MyNetWorkCallback<SMSBean>() {
                            @Override
                            public void onSuccess(SMSBean loginBean) {
                                ToastUtils.showTop(PhoneActivity.this, "已发送验证码");
                            }

                            @Override
                            public void onError(int errorCode, String errorMsg) {
                                ToastUtils.showTop(PhoneActivity.this, "获取验证码失败");
                            }
                        });
                    }
                }
                break;
        }
    }
}
