package com.share.bag.ui.ship;

import android.net.http.SslError;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.View;
import android.webkit.SslErrorHandler;
import android.webkit.WebChromeClient;
import android.webkit.WebResourceRequest;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.TextView;

import com.share.bag.R;
import com.share.bag.utils.okhttp.OkHttpUtils;
import com.share.bag.utils.okhttp.callback.MyNetWorkCallback;

import org.json.JSONException;

import java.util.HashMap;

/**
 * @Author : TianFB
 * @Date : 2018/4/25
 * @Desrcibe ：
 */

public class TransportLog extends AppCompatActivity {

    private WebView mWebView;
    private TextView notice;
    private String order_id;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_transportlog);
        order_id = getIntent().getStringExtra("order_id");
        initView();
        initData();
    }
    private void initData() {
        String url = "https://baobaoapi.ldlchat.com/Home/Order/delivery.html";
        HashMap<String,String> map = new HashMap<>();
        map.put("order_id",order_id);
        OkHttpUtils.getInstance().post(url, map, new MyNetWorkCallback<TransportLogBean>() {
            @Override
            public void onSuccess(TransportLogBean transportLogBean) throws JSONException {
              if(!TextUtils.isEmpty(transportLogBean.getInfo()) && transportLogBean.getInfo().indexOf("http")>-1){
                  mWebView.loadUrl(transportLogBean.getInfo());
              }else{
                    notice.setText("该商品没有相关物流信息");
              }
            }

            @Override
            public void onError(int errorCode, String errorMsg) {

            }
        });
    }

    private void initView() {
        mWebView = (WebView) findViewById(R.id.webView);
        notice = (TextView) findViewById(R.id.notice);
        // android 5.0之后原生webview同时用https和http加载HTML不加载图片解决方案
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            mWebView.getSettings().setMixedContentMode(WebSettings.MIXED_CONTENT_ALWAYS_ALLOW);
        }
        WebSettings setting = mWebView.getSettings();
        setting.setJavaScriptEnabled(true);//支持js
        mWebView.setWebChromeClient(new WebChromeClient());
        mWebView.setWebViewClient(new WebViewClient() {

            @Override
            public void onReceivedSslError(WebView view, SslErrorHandler handler, SslError error) {
                // 接受证书
                handler.proceed();
            }

            //不跳转到浏览器
            @Override
            public boolean shouldOverrideUrlLoading(WebView view, WebResourceRequest request) {
                return false;
            }
        });

    }
}
