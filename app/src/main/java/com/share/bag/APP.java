package com.share.bag;

import android.app.Application;
import android.content.Context;
import android.support.multidex.MultiDex;
import android.support.multidex.MultiDexApplication;
import android.support.v7.app.AppCompatActivity;

import com.umeng.socialize.Config;
import com.umeng.socialize.PlatformConfig;
import com.umeng.socialize.UMShareAPI;

/**
 * Created by Administrator on 2017/12/23.
 */

public class APP extends MultiDexApplication{
    //提交测试1
    public static AppCompatActivity context;

    {//wx38f75c7fdb68b2bf
        //应用签名 8dcedec6e7e935e0ca0e18d4811b1d7f
        PlatformConfig.setWeixin("wx38f75c7fdb68b2bf", "f0e2269b7387a00fa1148a4ee448cff7");
        PlatformConfig.setQQZone("1106593131", "aTkZwsKLliMcSv7v");
//        String key, String secret, String redirectUrl) {
        PlatformConfig.setSinaWeibo("590644690", "94ad600e3963153d4d4a0970cc9727df", "https://www.pgyer.com/R6iM");
    }
//    @Override
    public void onCreate() {
        super.onCreate();
        Config.DEBUG = true;
        // Ument初始化
       UMShareAPI.get(this);
    }


    @Override
    protected void attachBaseContext(Context base) {
        super.attachBaseContext(base);
        MultiDex.install(this);
    }
}
