package com.share.bag.ui.activitys.home;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.share.bag.FileUtil;
import com.share.bag.R;
import com.share.bag.SBUrls;
import com.share.bag.adapter.CosTomPageAdapter;
import com.share.bag.base.BaseActivity;
import com.share.bag.entity.CollectionBean;
import com.share.bag.entity.DeailsBean;
import com.share.bag.entity.Student;
import com.share.bag.ui.activitys.mine.LoginActivity;
import com.share.bag.ui.fragments.page.CommentsFragment;
import com.share.bag.ui.fragments.page.DetalisFragment;
import com.share.bag.ui.pay.BuyActivity;
import com.share.bag.ui.pay.RentActivity;
import com.share.bag.utils.okhttp.OkHttpUtils;
import com.share.bag.utils.okhttp.callback.MyNetWorkCallback;
import com.umeng.socialize.ShareAction;
import com.umeng.socialize.UMShareAPI;
import com.umeng.socialize.UMShareListener;
import com.umeng.socialize.bean.SHARE_MEDIA;
import com.umeng.socialize.media.UMImage;
import com.umeng.socialize.media.UMWeb;
import com.youth.banner.Banner;
import com.youth.banner.BannerConfig;
import com.youth.banner.loader.ImageLoader;
import com.zhouwei.mzbanner.CustomViewPager;

import org.greenrobot.eventbus.EventBus;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class DetailsActivity extends BaseActivity {

    @BindView(R.id.Details_return)
    ImageView DetailsReturn;
    @BindView(R.id.tab)
    TabLayout tab;

    @BindView(R.id.Details_banner)
    Banner DetailsBanner;
    @BindView(R.id.pager)
    CustomViewPager pager;
    @BindView(R.id.details_button_collection)
    Button detailsButtonCollection;
    @BindView(R.id.details_button_rent)
    Button detailsButtonRent;
    @BindView(R.id.details_button_buy)
    Button detailsButtonBuy;
    @BindView(R.id.details__user)
    TextView details__user;

    private PopupWindow window1;

    private String tmp;
    private List<String> heardimg = new ArrayList<>();
    int NUM = 0;

    private List<Fragment> fragmentList = new ArrayList<>();
    private List<String> stringList = new ArrayList<>();

    private String DETAILS = "详情";
    private String COMMENTS = "评论";

    private CosTomPageAdapter mCosTomPageAdapter;

    private FragmentManager fragmentManager;
    private ImageView Details_shared;
    private String description_1;

    List<String> img1;
    private List<String> img2;

    @Override
    public int initLayout() {
        return R.layout.activity_details;
    }

    @Override
    public void initView() {

        Intent intent = getIntent();
        //      得到传过来的ID  通过id来取值
        tmp = intent.getStringExtra("details");
//        Log.e("sss", "initView: " + tmp);
        fragmentManager = getSupportFragmentManager();
        Details_shared = (ImageView) findViewById(R.id.Details_shared);
        Details_shared.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                getPopupWindow();

//                if (details__user.getText().equals("")) {
//                    Intent intent = new Intent(DetailsActivity.this, LoginActivity.class);
//                    startActivity(intent);
//                } else {
//                    Intent rentloginintent = new Intent(DetailsActivity.this, ShareActivity.class);
//                    startActivity(rentloginintent);
//                }
            }
        });
    }

    @Override
    protected void initData() {

        Map<String, String> map = new HashMap<>();
        map.put("id", tmp);
        //请求网络
        OkHttpUtils.getInstance().post(SBUrls.DETAILSURL, map, new MyNetWorkCallback<DeailsBean>() {
            @Override
            public void onSuccess(DeailsBean deailsBean) {
                img2 = deailsBean.getImg();


                List<String> img = deailsBean.getCarousel();//carousel

                for (int i = 0; i < img.size(); i++) {
                    String s = "http://" + img.get(i);//轮播图的网址

                    heardimg.add(s);
                }

                //         BannerHeader Show
                bannerHeaderShow();
                TabPageShow();

                img1 = deailsBean.getImg();


                String title = deailsBean.getTitle();//简介
//                String deposit = deailsBean.getDeposit();//原价
//                String nowprice = deailsBean.getNowprice();//租金
                String title1 = deailsBean.getTitle();//品牌
                String color = deailsBean.getColor();//颜色
                String material = deailsBean.getMaterial();//材质
                String title2 = deailsBean.getBagSize().getTitle();//尺寸

                List<String> contentimg = deailsBean.getContentimg();
                description_1 = "http://" +contentimg.get(0);
                String description_2 = "http://" +contentimg.get(1);
                EventBus.getDefault().post(new Student(title,title1,color,material,title2, description_1,description_2));

            }

            private void TabPageShow() {

                //           Voluation  Tab
                tab.addTab(tab.newTab().setText(DETAILS));
                tab.addTab(tab.newTab().setText(COMMENTS + "(+" + NUM + "+)"));

                stringList.add(DETAILS);
                stringList.add(COMMENTS);


                //     Add  Fragment  to fragmentList.
                fragmentList.add(new DetalisFragment());
                fragmentList.add(new CommentsFragment());

                //     Associate ViewPage and Fragment


                tab.setupWithViewPager(pager);

                //        Show  Adapter
                mCosTomPageAdapter = new CosTomPageAdapter(fragmentManager, stringList, fragmentList);
                pager.setAdapter(mCosTomPageAdapter);
                pager.setCurrentItem(0);
                pager.setCurrentItem(1);

            }

            private void bannerHeaderShow() {

                DetailsBanner.setImages(heardimg)//添加图片集合或图片url集合
                        .setDelayTime(2000)//设置轮播时间
                        .setBannerStyle(BannerConfig.CIRCLE_INDICATOR)
                        .setImageLoader(new GlideImage())//加载图片
                        .setIndicatorGravity(BannerConfig.CENTER)//设置指示器位置
                        .start();
            }

            @Override
            public void onError(int errorCode, String errorMsg) {
                Toast.makeText(DetailsActivity.this, "Request unsuccessful", Toast.LENGTH_SHORT).show();
            }
        });

    }

    @Override
    protected boolean hodeWindow() {
        return false;
    }

    @OnClick(R.id.Details_return)
    public void onViewClicked() {
        finish();
    }


    @OnClick({R.id.details_button_collection, R.id.details_button_rent, R.id.details_button_buy})
    public void onViewClicked(View view) {
        FileUtil.SelectedreadFromPre(DetailsActivity.this, details__user);
        switch (view.getId()) {
            case R.id.details_button_collection:
                if (details__user.getText().equals("")) {
                    Toast.makeText(DetailsActivity.this, "请先登录", Toast.LENGTH_SHORT).show();

                    Intent intent = new Intent(DetailsActivity.this, LoginActivity.class);
                    startActivity(intent);
                } else {
                    getselect();
                }
                break;
            case R.id.details_button_rent://租下
                if (details__user.getText().equals("")) {
                    Intent intent = new Intent(DetailsActivity.this, LoginActivity.class);
                    startActivity(intent);
                } else {

                    Toast.makeText(this, ""+description_1, Toast.LENGTH_SHORT).show();

                    Intent rentloginintent = new Intent(DetailsActivity.this, RentActivity.class);
                    rentloginintent.putExtra("","");
                    rentloginintent.putExtra("","");
                    rentloginintent.putExtra("","");
                    rentloginintent.putExtra("","");
                    rentloginintent.putExtra("","");
                    rentloginintent.putExtra("","");
                    rentloginintent.putExtra("","");



                    startActivity(rentloginintent);
                }
                break;
            case R.id.details_button_buy://确认买
                if (details__user.getText().equals("")) {
                    Intent intent = new Intent(DetailsActivity.this, LoginActivity.class);
                    startActivity(intent);
                } else {
                    Intent rentloginintent = new Intent(DetailsActivity.this, BuyActivity.class);
                    startActivity(rentloginintent);
                }
                break;
        }
    }

    public void getPopupWindow() {
        WindowManager wm = (WindowManager) getApplication()
                .getSystemService(Context.WINDOW_SERVICE);

        int width = wm.getDefaultDisplay().getWidth();
        int height = wm.getDefaultDisplay().getHeight();

        //设置contentView
        View contentView = LayoutInflater.from(this).inflate(R.layout.popupwindow_share, null);
        window1 = new PopupWindow(contentView,
                width, height);
        window1.setContentView(contentView);
        //设置各个控件的点击响应
        LinearLayout details_share_wxfriends = (LinearLayout) contentView.findViewById(R.id.details_share_wxfriends);
        LinearLayout details_share_wxcircle = (LinearLayout) contentView.findViewById(R.id.details_share_wxcircle);
        LinearLayout details_share_qqfriends = (LinearLayout) contentView.findViewById(R.id.details_share_qqfriends);
        LinearLayout details_share_wocircle = (LinearLayout) contentView.findViewById(R.id.details_share_wocircle);
        LinearLayout details_share_qqcircle = (LinearLayout) contentView.findViewById(R.id.details_share_qqcircle);
        TextView details_share_cancel = (TextView) contentView.findViewById(R.id.details_share_cancel);

        //显示PopupWindow
        View rootview = LayoutInflater.from(this).inflate(R.layout.activity_personal2, null);
        window1.showAtLocation(rootview, Gravity.CENTER, 0, 0);

        details_share_cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                window1.dismiss();

            }
        });




        details_share_wxfriends.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {//微信好友

                for (int i = 0; i < img2.size(); i++) {

                    String s = img2.get(i);


                }


                Toast.makeText(DetailsActivity.this, ""+img2.get(0), Toast.LENGTH_SHORT).show();
                Log.e("TAGBV",""+img2.get(0));
                WXShareWeb(""+img2.get(0));
                window1.dismiss();

            }
        });
        details_share_wxcircle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                WXpengyouShareWeb(R.drawable.fenxiang1);
//                Toast.makeText(DetailsActivity.this, "微信朋友圈", Toast.LENGTH_SHORT).show();
                window1.dismiss();

            }
        });


        details_share_qqfriends.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {



                QQShareWeb(R.drawable.fenxiang1);
//                Toast.makeText(DetailsActivity.this, "QQ好友", Toast.LENGTH_SHORT).show();
                window1.dismiss();

            }
        });

        details_share_wocircle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SinaShareWeb(R.drawable.fenxiang1);
                window1.dismiss();

            }
        });


        details_share_qqcircle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                Toast.makeText(DetailsActivity.this, "QQ空间", Toast.LENGTH_SHORT).show();

                QzogShareWeb(R.drawable.fenxiang1);

                window1.dismiss();
            }
        });
    }


    //点击收藏
    public void getselect() {

        Map<String, String> collection = new HashMap();
        collection.put("baglist_id", "1");
        OkHttpUtils.getInstance().post(SBUrls.COLLECTION, collection, new MyNetWorkCallback<CollectionBean>() {
            @Override
            public void onSuccess(CollectionBean collectionBean) {
                String status = collectionBean.getInfo();
                if (status.toString().equals("收藏成功")) {

                    Toast.makeText(DetailsActivity.this, "" + status, Toast.LENGTH_SHORT).show();

                } else {
                    Toast.makeText(DetailsActivity.this, "" + status, Toast.LENGTH_SHORT).show();
                }


            }

            @Override
            public void onError(int errorCode, String errorMsg) {

            }
        });

    }



    private void QQShareWeb(int thumb_img){
        UMImage thumb = new UMImage(DetailsActivity.this,thumb_img);
        UMWeb web = new UMWeb("http://ywxz.ldlchat.com/fx/shop.html");
        web.setThumb(thumb);
        web.setDescription("这是一款应用共享的APP");
        web.setTitle("一位小主");
        new ShareAction(DetailsActivity.this).withMedia(web).setPlatform(SHARE_MEDIA.QQ).setCallback(shareListener).share();
    }

    private void SinaShareWeb(int thumb_img){
        UMImage thumb = new UMImage(DetailsActivity.this,thumb_img);
        UMWeb web = new UMWeb("http://ywxz.ldlchat.com/fx/shop.html");
        web.setThumb(thumb);
        web.setDescription("这是一款应用共享的APP");
        web.setTitle("一位小主");
        new ShareAction(DetailsActivity.this).withMedia(web).setPlatform(SHARE_MEDIA.SINA).setCallback(shareListener).share();
    }

    private void WXShareWeb(String thumb_img){//微信好友
        UMImage thumb = new UMImage(DetailsActivity.this,thumb_img);
        UMWeb web = new UMWeb("http://ywxz.ldlchat.com/fx/shop.html");
        web.setThumb(thumb);
        web.setDescription("");
        web.setTitle("一位小主");
        new ShareAction(DetailsActivity.this).withMedia(web).setPlatform(SHARE_MEDIA.WEIXIN).setCallback(shareListener).share();
    }

    private void WXpengyouShareWeb(int thumb_img){
        UMImage thumb = new UMImage(DetailsActivity.this,thumb_img);
        UMWeb web = new UMWeb("http://ywxz.ldlchat.com/fx/shop.html");
        web.setThumb(thumb);
        web.setDescription("这是一款应用共享的APP");
        web.setTitle("一位小主");
        new ShareAction(DetailsActivity.this)
                .withMedia(web)
                .setPlatform(SHARE_MEDIA.WEIXIN_CIRCLE)
                .setCallback(shareListener)
                .share();




    }
    private void QzogShareWeb(int thumb_img){
        UMImage thumb = new UMImage(DetailsActivity.this,thumb_img);
        UMWeb web = new UMWeb("http://ywxz.ldlchat.com/fx/shop.html");
        web.setThumb(thumb);
        web.setDescription("这是一款应用共享的APP");
        web.setTitle("一位小主");
        new ShareAction(DetailsActivity.this)
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
            Toast.makeText(DetailsActivity.this,"成功了",Toast.LENGTH_LONG).show();
        }

        /**
         * @descrption 分享失败的回调
         * @param platform 平台类型
         * @param t 错误原因
         */
        @Override
        public void onError(SHARE_MEDIA platform, Throwable t) {
            Toast.makeText(DetailsActivity.this,"失败"+t.getMessage(),Toast.LENGTH_LONG).show();
        }

        /**
         * @descrption 分享取消的回调
         * @param platform 平台类型
         */
        @Override
        public void onCancel(SHARE_MEDIA platform) {
            Toast.makeText(DetailsActivity.this,"取消了",Toast.LENGTH_LONG).show();

        }
    };


    //                      Banner Volder
    public class GlideImage extends ImageLoader {
        @Override
        public void displayImage(Context context, Object path, ImageView imageView) {
            Glide.with(context.getApplicationContext()).load(path).into(imageView);
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // TODO: add setContentView(...) invocation
        ButterKnife.bind(this);
    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        UMShareAPI.get(this).onActivityResult(requestCode, resultCode, data);


    }
}

