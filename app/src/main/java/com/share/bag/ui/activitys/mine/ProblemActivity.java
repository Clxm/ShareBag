package com.share.bag.ui.activitys.mine;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.KeyEvent;
import android.view.View;
import android.view.WindowManager;
import android.webkit.JavascriptInterface;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ImageView;

import com.share.bag.R;
/*
* 常见问题
*
* */
public class ProblemActivity extends AppCompatActivity {

    private static final String URL ="http://ywxz.ldlchat.com/fx/Commonproblem.html";

    private WebView webView;

    private Context mContext;
    private ImageView problem_return;


    @SuppressLint("JavascriptInterface")


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_problem);

        mContext = this;
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        webView = (WebView) this.findViewById(R.id.problem_wv);
        problem_return = (ImageView) this.findViewById(R.id.problem_return);

        problem_return.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

        webView.loadUrl(URL);
        webView.getSettings().setJavaScriptEnabled(true);
        webView.addJavascriptInterface(new JSHook(), "hello");
        webView.setWebViewClient(new WebViewClient() {
            @Override
            public boolean shouldOverrideUrlLoading(WebView view, String url) {
//                Log.d(tag, " url:"+url);
                view.loadUrl(url);// 当打开新链接时，使用当前的 WebView，不会使用系统其他浏览器
                return true;
            }
        });
    }

    public class JSHook{
        @JavascriptInterface
        public void javaMethod(String p){
//            Log.d(tag , "JSHook.JavaMethod() called! + "+p);
        }
        @JavascriptInterface
        public void showAndroid(){
            final String info = "来自手机内的内容！！！";
            ProblemActivity.this.runOnUiThread(new Runnable(){
                @Override
                public void run() {
                    webView.loadUrl("javascript:show('"+info+"')");
                }
            });
        }
        public String getInfo(){
            return "获取手机内的信息！！";
        }
    }
    @Override
    //设置回退
    //覆盖Activity类的onKeyDown(int keyCoder,KeyEvent event)方法
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if ((keyCode == KeyEvent.KEYCODE_BACK) && webView.canGoBack()) {
            webView.goBack(); //goBack()表示返回WebView的上一页面
            this.finish();
            return true;
        }
        return false;  }
}