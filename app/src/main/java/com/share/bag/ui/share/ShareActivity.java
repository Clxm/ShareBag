package com.share.bag.ui.share;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.share.bag.R;
import com.umeng.socialize.ShareAction;
import com.umeng.socialize.UMShareListener;
import com.umeng.socialize.bean.SHARE_MEDIA;
import com.umeng.socialize.media.UMImage;
import com.umeng.socialize.media.UMWeb;

/*
* 分享界面
* */
public class ShareActivity extends AppCompatActivity {

    private ImageView Share_return;
    private TextView share_invite;
    private LinearLayout share_wxfriends1;
    private LinearLayout share_wxcircle1;
    private LinearLayout share_qqcircle1;
    private LinearLayout share_xlsina1;
    private LinearLayout share_qqfriends;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_share);
        initView();
    }

    private void initView() {
        Share_return = (ImageView) findViewById(R.id.Share_return);
        share_invite = (TextView) findViewById(R.id.share_invite);
        share_wxfriends1 = (LinearLayout) findViewById(R.id.share_wxfriends1);
        share_wxcircle1 = (LinearLayout) findViewById(R.id.share_wxcircle1);
        share_qqcircle1 = (LinearLayout) findViewById(R.id.share_qqcircle1);
        share_xlsina1 = (LinearLayout) findViewById(R.id.share_xlsina1);
        share_qqfriends = (LinearLayout) findViewById(R.id.share_qqfriends);

        Share_return.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
//        share_invite
        share_wxfriends1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

//                Toast.makeText(ShareActivity.this, "微信好友", Toast.LENGTH_SHORT).show();

                WXShareWeb(R.drawable.fenxiang1);


            }
        });

        share_wxcircle1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                Toast.makeText(ShareActivity.this, "微信朋友圈", Toast.LENGTH_SHORT).show();
                WXpengyouShareWeb(R.drawable.fenxiang1);


            }
        });
        share_qqcircle1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                Toast.makeText(ShareActivity.this, "QQ好友", Toast.LENGTH_SHORT).show();
                QQShareWeb(R.drawable.fenxiang1);

            }
        });

        share_xlsina1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Toast.makeText(ShareActivity.this, "新浪微博", Toast.LENGTH_SHORT).show();


            }
        });



        share_qqfriends.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

//                Toast.makeText(ShareActivity.this, "QQ空间", Toast.LENGTH_SHORT).show();
                QzogShareWeb(R.drawable.fenxiang1);
            }
        });
    }

    private void QQShareWeb(int thumb_img){
        UMImage thumb = new UMImage(ShareActivity.this,thumb_img);
        UMWeb web = new UMWeb("http://ywxz.ldlchat.com/fx/form.html");
        web.setThumb(thumb);
        web.setDescription("这是一款应用共享的APP");
        web.setTitle("一位小主");
        new ShareAction(ShareActivity.this).withMedia(web).setPlatform(SHARE_MEDIA.QQ).setCallback(shareListener).share();
    }



    private void WXShareWeb(int thumb_img){//微信好友
        UMImage thumb = new UMImage(ShareActivity.this,thumb_img);
        UMWeb web = new UMWeb("http://ywxz.ldlchat.com/fx/form.html");
        web.setThumb(thumb);
        web.setDescription("这是一款应用共享的APP");
        web.setTitle("一位小主");
        new ShareAction(ShareActivity.this).withMedia(web).setPlatform(SHARE_MEDIA.WEIXIN).setCallback(shareListener).share();
    }
    private void WXpengyouShareWeb(int thumb_img){
        UMImage thumb = new UMImage(ShareActivity.this,thumb_img);
        UMWeb web = new UMWeb("http://ywxz.ldlchat.com/fx/form.html");
        web.setThumb(thumb);
        web.setDescription("这是一款应用共享的APP");
        web.setTitle("一位小主");
        new ShareAction(ShareActivity.this)
                .withMedia(web)
                .setPlatform(SHARE_MEDIA.WEIXIN_CIRCLE)
                .setCallback(shareListener)
                .share();
    }

    private void QzogShareWeb(int thumb_img){
        UMImage thumb = new UMImage(ShareActivity.this,thumb_img);
        UMWeb web = new UMWeb("http://ywxz.ldlchat.com/fx/form.html");
        web.setThumb(thumb);
        web.setDescription("这是一款应用共享的APP");
        web.setTitle("一位小主");
        new ShareAction(ShareActivity.this)
                .withMedia(web)
                .setPlatform(SHARE_MEDIA.QZONE)
                .setCallback(shareListener)
                .share();
    }


    private UMShareListener shareListener = new UMShareListener() {
        /**
         * @descrption 分享开始的回调
         * @param platform 平台类型
         */
        @Override
        public void onStart(SHARE_MEDIA platform) {

        }

        /**
         * @descrption 分享成功的回调
         * @param platform 平台类型
         */
        @Override
        public void onResult(SHARE_MEDIA platform) {
            Toast.makeText(ShareActivity.this,"成功了",Toast.LENGTH_LONG).show();
        }

        /**
         * @descrption 分享失败的回调
         * @param platform 平台类型
         * @param t 错误原因
         */
        @Override
        public void onError(SHARE_MEDIA platform, Throwable t) {
            Toast.makeText(ShareActivity.this,"失败"+t.getMessage(),Toast.LENGTH_LONG).show();
        }

        /**
         * @descrption 分享取消的回调
         * @param platform 平台类型
         */
        @Override
        public void onCancel(SHARE_MEDIA platform) {
            Toast.makeText(ShareActivity.this,"取消了",Toast.LENGTH_LONG).show();

        }
    };


}
