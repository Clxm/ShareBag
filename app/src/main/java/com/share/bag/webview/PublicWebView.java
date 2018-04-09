package com.share.bag.webview;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.KeyEvent;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ImageView;

import com.share.bag.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by lxm on 2018/4/8.
 */

public class PublicWebView extends AppCompatActivity {
    @BindView(R.id.iv_return)
    ImageView mIvReturn;
    @BindView(R.id.webView)
    WebView mWebView;
    private String mPublicUrl;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_public_webview);
        ButterKnife.bind(this);
        initWebView();
    }

    private void initWebView() {
        if (getIntent() != null) {
            mPublicUrl = getIntent().getStringExtra("publicUrl");
        }

        mWebView.getSettings().setJavaScriptEnabled(true);//支持javascript
        //缩放操作
        mWebView.getSettings().setSupportZoom(true);// 设置可以支持缩放
        mWebView.getSettings().setBuiltInZoomControls(true);//设置内置的缩放控件
        mWebView.getSettings().setDisplayZoomControls(false);//隐藏原生的缩放控件
        //设置自适应屏幕，两者合用
        mWebView.getSettings().setUseWideViewPort(true);//将图片调整到适合webView的大小
        mWebView.getSettings().setLoadWithOverviewMode(true);//缩放至屏幕的大小

        mWebView.getSettings().setDomStorageEnabled(true);
        mWebView.setWebViewClient(new WebViewClient());
        mWebView.setWebChromeClient(new WebChromeClient());

        //"http://ywxz.ldlchat.com"
        mWebView.loadUrl(mPublicUrl);
    }

    @OnClick(R.id.iv_return)
    public void onClick() {
        finish();
    }

    @Override
    protected void onDestroy() {
        if (mWebView != null) {
            mWebView.stopLoading();
            mWebView.destroy();
        }
        super.onDestroy();
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_BACK) {
            if (mWebView.canGoBack()) {
                if (mWebView.getUrl().equals(mPublicUrl)) {
                    finish();
                } else {
                    mWebView.goBack();
                }
            } else {
                finish();
            }
            return true;
        }
        return super.onKeyDown(keyCode, event);
    }
}
