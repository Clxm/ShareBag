package com.share.bag.ui.activitys.home;

import android.Manifest;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.text.TextUtils;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.share.bag.FileUtil;
import com.share.bag.LikeAdapter;
import com.share.bag.R;
import com.share.bag.SBUrls;
import com.share.bag.entity.AddCommentBean;
import com.share.bag.entity.CollectionBean;
import com.share.bag.entity.CommentBean;
import com.share.bag.entity.DeailsBean;
import com.share.bag.entity.LikeBean;
import com.share.bag.ui.activitys.mine.Login;
import com.share.bag.ui.pay.BuyActivity;
import com.share.bag.ui.pay.RentActivity;
import com.share.bag.utils.ToastUtils;
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

import org.json.JSONException;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
* 包包详情
* */
public class Details extends AppCompatActivity implements View.OnClickListener {

    private ImageView Details_return;
    private ImageView Details_shared;
    private TextView details_details;
    private TextView details_comment;
    private View details_details1;
    private View details_comment1;
    private TextView detalis_Introduction;
    private TextView detalis_brand;
    private TextView detalis_numbering;
    private TextView detalis_colour;
    private TextView detalis_material;
    private TextView detalis_size;
    private ImageView detalis_description_img1;
    private ImageView detalis_description_img2;
    private LinearLayout details_details_layout;
    private LinearLayout details_comment_layout;
    private Button details_button_collection;
    private Button details_button_rent;
    private Button details_button_buy;
    private TextView details__user;
    private PopupWindow window1;
    private String tmp;
    private List<String> heardimg = new ArrayList<>();
    private Banner details_banner;
    private TextView details_comment_number;
    private RecyclerView details_comment_layout_recy;
    private CommentAdapter commentAdapter;
    private TextView details_comment_layout_text;
    private String comment_count1;
    private ImageView details_comment_img;
    private RecyclerView details_like_recycler;
    private PopupWindow pw;
    private EditText et_input_content;
    private String mImgUrl;
    private String mTitle;
    private String mBagBrand;
    private String mNumber;
    private String mColor;
    private String mMaterial;
    private String mBagSize;
    private String mDays_money;
    private String mDays;
    private String mOriginalprice;
    private String mNowprice;
    private String mId;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details3);
        //分享6.0权限适配
//        if (Build.VERSION.SDK_INT >= 23) {
//            String[] mPermissionList = new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE, Manifest.permission.ACCESS_FINE_LOCATION, Manifest.permission.CALL_PHONE, Manifest.permission.READ_LOGS, Manifest.permission.READ_PHONE_STATE, Manifest.permission.READ_EXTERNAL_STORAGE, Manifest.permission.SET_DEBUG_APP, Manifest.permission.SYSTEM_ALERT_WINDOW, Manifest.permission.GET_ACCOUNTS, Manifest.permission.WRITE_APN_SETTINGS};
//            ActivityCompat.requestPermissions(this, mPermissionList, 123);//123是requestcode，可以根据这个code判断，用户是否同意了授权
//        }

        if (getIntent() != null) {
            Intent intent = getIntent();
            tmp = intent.getStringExtra("details");
        }
        initView();
//        details_comment_layout_recy.setNestedScrollingEnabled(false);
        FileUtil.SelectedreadFromPre(Details.this, details__user);
        getinitData();
        getinitData1();

        Details_return.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });


        //详情
        details_details.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                details_details_layout.setVisibility(View.VISIBLE);
                details_details1.setVisibility(View.VISIBLE);
                details_comment_img.setVisibility(View.INVISIBLE);
                details_comment_layout.setVisibility(View.GONE);
                details_comment1.setVisibility(View.INVISIBLE);
            }
        });
        //评论
        details_comment.setOnClickListener(new View.OnClickListener() {


            @Override
            public void onClick(View view) {

                details_details1.setVisibility(View.INVISIBLE);
                details_comment1.setVisibility(View.VISIBLE);
                details_comment_img.setVisibility(View.VISIBLE);
                details_details_layout.setVisibility(View.GONE);
                details_comment_layout.setVisibility(View.VISIBLE);

                if (comment_count1.equals("0")) {
                    details_comment_layout_text.setVisibility(View.VISIBLE);
                } else {
                    getinitdatacomment();
                }
            }
        });
        //评论
        details_comment_img.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setPopupWindows();
            }
        });
        //分享
        Details_shared.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getPopupWindow();
            }
        });
    }

    private void setPopupWindows() {
        View inflate = getLayoutInflater().inflate(R.layout.pinglun, null);
        pw = new PopupWindow(inflate, ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        pw.setFocusable(true);
        pw.setSoftInputMode(PopupWindow.INPUT_METHOD_NEEDED);
        pw.setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_ADJUST_RESIZE);
        //设置空背景
        pw.setBackgroundDrawable(getResources().getDrawable(R.drawable.popupwindow_background));
        //点击外部消失
        pw.setOutsideTouchable(true);
        //底部布局
        pw.showAtLocation(inflate, Gravity.BOTTOM, 0, 0);
        //改变背景颜色
        darkenBackground(0.5f);
        //取消背景颜色
        pw.setOnDismissListener(new PopupWindow.OnDismissListener() {
            @Override
            public void onDismiss() {
                darkenBackground(1f);
            }
        });

        Button send_button = inflate.findViewById(R.id.send_button);
        et_input_content = inflate.findViewById(R.id.et_input_content);
        send_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getpinglun();
            }
        });


    }

    /**
     * 改变背景颜色
     */
    private void darkenBackground(Float bgColor) {
        WindowManager.LayoutParams lp = getWindow().getAttributes();
        lp.alpha = bgColor;
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_DIM_BEHIND);
        getWindow().setAttributes(lp);
    }


    private void initView() {
        details_comment_img = (ImageView) findViewById(R.id.details_comment_img);
        details_comment_layout_text = (TextView) findViewById(R.id.details_comment_layout_text);
        details_comment_layout_recy = (RecyclerView) findViewById(R.id.details_comment_layout_recy);
        details_comment_number = (TextView) findViewById(R.id.details_comment_number);
        details_banner = (Banner) findViewById(R.id.Details_banner);
        Details_return = (ImageView) findViewById(R.id.Details_return);
        Details_shared = (ImageView) findViewById(R.id.Details_shared);
        details_details = (TextView) findViewById(R.id.details_details);
        details_comment = (TextView) findViewById(R.id.details_comment);
        details_details1 = (View) findViewById(R.id.details_details1);
        details_comment1 = (View) findViewById(R.id.details_comment1);
        detalis_Introduction = (TextView) findViewById(R.id.detalis_Introduction);
        detalis_brand = (TextView) findViewById(R.id.detalis_brand);
        detalis_numbering = (TextView) findViewById(R.id.detalis_numbering);
        detalis_colour = (TextView) findViewById(R.id.detalis_colour);
        detalis_material = (TextView) findViewById(R.id.detalis_material);
        detalis_size = (TextView) findViewById(R.id.detalis_size);
        detalis_description_img1 = (ImageView) findViewById(R.id.detalis_description_img1);
        detalis_description_img2 = (ImageView) findViewById(R.id.detalis_description_img2);
        details_details_layout = (LinearLayout) findViewById(R.id.details_details_layout);
//        details_comment_avatar = (ImageView) findViewById(R.id.details_comment_avatar);
//        details_comment_name = (TextView) findViewById(R.id.details_comment_name);
//        details_comment_time = (TextView) findViewById(R.id.details_comment_time);
//        details_comment_signature1 = (TextView) findViewById(R.id.details_comment_signature1);
//        details_comment_signature2 = (TextView) findViewById(R.id.details_comment_signature2);
//        details_comment_signature3 = (TextView) findViewById(R.id.details_comment_signature3);
//        details_comment_signature = (LinearLayout) findViewById(R.id.details_comment_signature);
//        details_comment_content = (TextView) findViewById(R.id.details_comment_content);
        details_comment_layout = (LinearLayout) findViewById(R.id.details_comment_layout);
        details_button_collection = (Button) findViewById(R.id.details_button_collection);
        details_button_rent = (Button) findViewById(R.id.details_button_rent);
        details_button_buy = (Button) findViewById(R.id.details_button_buy);
        details__user = (TextView) findViewById(R.id.details__user);
        details_like_recycler = (RecyclerView) findViewById(R.id.details_like_recycler);
        details_button_collection.setOnClickListener(this);
        details_button_rent.setOnClickListener(this);
        details_button_buy.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.details_button_collection:
                if (details__user.getText().equals("")) {
                    Toast.makeText(this, "请先登录", Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(this, Login.class);
                    startActivity(intent);
                } else {
                    getselect();
                }
                break;
            case R.id.details_button_rent:
                if (details__user.getText().equals("")) {
                    Intent intent = new Intent(Details.this, Login.class);
                    startActivity(intent);
                } else {
                    Intent intent = new Intent(Details.this, RentActivity.class);
                    intent.putExtra("bagId", mId);
                    intent.putExtra("imgUrl", mImgUrl);
                    intent.putExtra("title", mTitle);
                    intent.putExtra("bagBrand", mBagBrand);
                    intent.putExtra("number", mNumber);
                    intent.putExtra("color", mColor);
                    intent.putExtra("material", mMaterial);
                    intent.putExtra("bagSize", mBagSize);
                    intent.putExtra("dayMoney", mDays_money);
                    intent.putExtra("days", mDays);
                    intent.putExtra("originalPrice", mOriginalprice);
                    intent.putExtra("nowPrice", mNowprice);

                    startActivity(intent);
                }

                break;
            case R.id.details_button_buy:
                if (details__user.getText().equals("")) {
                    Intent intent = new Intent(Details.this, Login.class);
                    startActivity(intent);
                } else {
                    Intent intent = new Intent(Details.this, BuyActivity.class);
                    intent.putExtra("imgUrl", mImgUrl);
                    intent.putExtra("title", mTitle);
                    intent.putExtra("bagBrand", mBagBrand);
                    intent.putExtra("number", mNumber);
                    intent.putExtra("color", mColor);
                    intent.putExtra("material", mMaterial);
                    intent.putExtra("bagSize", mBagSize);


                    startActivity(intent);
                }
                break;
        }
    }

    //点击收藏
    public void getselect() {
        final Map<String, String> collection = new HashMap();
        collection.put("baglist_id", tmp);
        OkHttpUtils.getInstance().post(SBUrls.LIKE_COLLECTION, collection, new MyNetWorkCallback<CollectionBean>() {
            @Override
            public void onSuccess(CollectionBean collectionBean) {
                String type = collectionBean.getType();
                if (type.equals("1")) {
                    details_button_collection.setText(R.string.collection_cancel);
                    ToastUtils.showTop(Details.this, "收藏成功");
                } else if (type.equals("2")) {
                    details_button_collection.setText(R.string.collection_put);
                    ToastUtils.showTop(Details.this, "取消收藏");
                }

            }

            @Override
            public void onError(int errorCode, String errorMsg) {

            }
        });

    }

    //分享
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
        LinearLayout details_share_wxfriends = contentView.findViewById(R.id.details_share_wxfriends);
        LinearLayout details_share_wxcircle = contentView.findViewById(R.id.details_share_wxcircle);
        LinearLayout details_share_qqfriends = contentView.findViewById(R.id.details_share_qqfriends);
        LinearLayout details_share_wocircle = contentView.findViewById(R.id.details_share_wocircle);
        LinearLayout details_share_qqcircle = contentView.findViewById(R.id.details_share_qqcircle);
        TextView details_share_cancel = contentView.findViewById(R.id.details_share_cancel);

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
                WXShareWeb(R.drawable.fenxiang1);
                window1.dismiss();

            }
        });
        details_share_wxcircle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                WXpengyouShareWeb(R.drawable.fenxiang1);
                window1.dismiss();

            }
        });


        details_share_qqfriends.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                QQShareWeb(R.drawable.fenxiang1);
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
                QzogShareWeb(R.drawable.fenxiang1);
                window1.dismiss();
            }
        });
    }

    private void QQShareWeb(int thumb_img) {    //qq分享
        UMImage thumb = new UMImage(Details.this, thumb_img);
        UMWeb web = new UMWeb(SBUrls.SHARE_URL);
        web.setThumb(thumb);
        web.setDescription("这是一款包包共享的APP");
        web.setTitle("一位小主");
        new ShareAction(Details.this).withMedia(web).setPlatform(SHARE_MEDIA.QQ).setCallback(shareListener).share();
    }

    private void SinaShareWeb(int thumb_img) {  //新浪微博
        UMImage thumb = new UMImage(Details.this, thumb_img);
        UMWeb web = new UMWeb(SBUrls.SHARE_URL);
        web.setThumb(thumb);
        web.setDescription("这是一款包包共享的APP");
        web.setTitle("一位小主");
        new ShareAction(Details.this).withMedia(web).setPlatform(SHARE_MEDIA.SINA).setCallback(shareListener).share();
    }

    private void WXShareWeb(int thumb_img) {    //微信好友
        UMImage thumb = new UMImage(Details.this, thumb_img);
        UMWeb web = new UMWeb(SBUrls.SHARE_URL);
        web.setThumb(thumb);
        web.setDescription("这是一款包包共享的APP");
        web.setTitle("一位小主");
        new ShareAction(Details.this).withMedia(web).setPlatform(SHARE_MEDIA.WEIXIN).setCallback(shareListener).share();
    }

    private void WXpengyouShareWeb(int thumb_img) { //微信朋友圈
        UMImage thumb = new UMImage(Details.this, thumb_img);
        UMWeb web = new UMWeb(SBUrls.SHARE_URL);
        web.setThumb(thumb);
        web.setDescription("这是一款包包共享的APP");
        web.setTitle("一位小主");
        new ShareAction(Details.this)
                .withMedia(web)
                .setPlatform(SHARE_MEDIA.WEIXIN_CIRCLE)
                .setCallback(shareListener)
                .share();
    }

    private void QzogShareWeb(int thumb_img) {  //qq空间
        UMImage thumb = new UMImage(Details.this, thumb_img);
        UMWeb web = new UMWeb(SBUrls.SHARE_URL);
        web.setThumb(thumb);
        web.setDescription("这是一款包包共享的APP");
        web.setTitle("一位小主");
        new ShareAction(Details.this)
                .withMedia(web)
                .setPlatform(SHARE_MEDIA.QZONE)
                .setCallback(shareListener)
                .share();
    }

    @Override
    protected void onStop() {
        super.onStop();
        if (pw != null) {
            pw.dismiss();
        }
        if (window1 != null) {
            window1.dismiss();
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (pw != null) {
            pw.dismiss();
        }
        if (window1 != null) {
            window1.dismiss();
        }
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
            ToastUtils.showTop(Details.this, "分享成功");
        }

        /**
         * @descrption 分享失败的回调
         * @param platform 平台类型
         * @param t 错误原因
         */
        @Override
        public void onError(SHARE_MEDIA platform, Throwable t) {
            ToastUtils.showTop(Details.this, "分享失败");
        }

        /**
         * @descrption 分享取消的回调
         * @param platform 平台类型
         */
        @Override
        public void onCancel(SHARE_MEDIA platform) {
            ToastUtils.showTop(Details.this, "分享取消");

        }
    };

    // 详情
    public void getinitData() {

        Map<String, String> map = new HashMap<>();
        map.put("id", tmp);

        OkHttpUtils.getInstance().post(SBUrls.DETAILSURL, map, new MyNetWorkCallback<DeailsBean>() {
            @Override
            public void onSuccess(DeailsBean deailsBean) {
                DeailsBean.InfoBean info = deailsBean.getInfo();
                mId = info.getId();
                mTitle = info.getTitle();
                mOriginalprice = info.getOriginalprice();
                mDays = info.getDays();
                mDays_money = info.getDays_money();
                String bagtype_id = info.getBagtype_id();
                String bagsize_id = info.getBagsize_id();
                String bagbrand_id = info.getBagbrand_id();
                String create_time = info.getCreate_time();
                String create_user = info.getCreate_user();
                String update_time = info.getUpdate_time();
                String update_user = info.getUpdate_user();
                String status = info.getStatus();
                String is_buy = info.getIs_buy();
                mMaterial = info.getMaterial();
                String bag_toprice = info.getBag_toprice();
                mNowprice = info.getNowprice();
                String deposit = info.getDeposit();
                mColor = info.getColor();
                String bagpay = info.getBagpay();
                mNumber = info.getNumber();
                Object foruser = info.getForuser();
                DeailsBean.InfoBean.BagTypeBean bagTypeBean = info.getBagType();
                DeailsBean.InfoBean.BagSizeBean bagSizeBean = info.getBagSize();
                DeailsBean.InfoBean.BagBrandBean bagBrandBean = info.getBagBrand();
                mBagBrand = bagBrandBean.getTitle();
                comment_count1 = info.getComment_count();
                List<String> img = info.getImg();
                List<String> contentimg = info.getContentimg();
                List<String> carousel = info.getCarousel();
                mBagSize = bagSizeBean.getTitle();

                for (int i = 0; i < carousel.size(); i++) {
                    String bannerUrl = SBUrls.URL_HEAD + carousel.get(i);
                    heardimg.add(bannerUrl);
                }
                bannerHeaderShow();     //banner
                for (int i = 0; i < img.size(); i++) {
                    mImgUrl = img.get(i);
                }
                detalis_Introduction.setText(mTitle);    //标题
                detalis_brand.setText(mBagBrand);    //品牌
                detalis_numbering.setText(mNumber);  //商品编号
                detalis_colour.setText(mColor);  //颜色
                detalis_material.setText(mMaterial); //材质
                detalis_size.setText(mBagSize);  //尺寸
                String description_1 = SBUrls.URL_HEAD + contentimg.get(0);
                String description_2 = SBUrls.URL_HEAD + contentimg.get(1);
                com.share.bag.utils.ImageLoader.LoadLocalImg(detalis_description_img1, getApplicationContext(), description_1);
                com.share.bag.utils.ImageLoader.LoadLocalImg(detalis_description_img2, getApplicationContext(), description_2);
                details_comment_number.setText("(" + comment_count1 + ")"); //评论数
            }


            private void bannerHeaderShow() {
                details_banner.setImages(heardimg)//添加图片集合或图片url集合
                        .setDelayTime(2000)//设置轮播时间
                        .setBannerStyle(BannerConfig.CIRCLE_INDICATOR)
                        .setImageLoader(new GlideImage())//加载图片
                        .setIndicatorGravity(BannerConfig.CENTER)//设置指示器位置
                        .start();
            }

            @Override
            public void onError(int errorCode, String errorMsg) {
                Toast.makeText(Details.this, "Request unsuccessful", Toast.LENGTH_SHORT).show();
            }
        });
    }

    //展示评论
    public void getinitdatacomment() {
        Map<String, String> map = new HashMap<>();
        map.put("baglist_id", tmp);
        try {
            //请求网络
            OkHttpUtils.getInstance().post(SBUrls.COMMENT, map, new MyNetWorkCallback<CommentBean>() {
                @Override
                public void onSuccess(CommentBean commentBean) throws JSONException {
                    List<CommentBean.InfoBean> data = commentBean.getInfo();

                    details_comment_layout_recy.setLayoutManager(new StaggeredGridLayoutManager(1, StaggeredGridLayoutManager.VERTICAL));
                    commentAdapter = new CommentAdapter(Details.this, data);
                    details_comment_layout_recy.setAdapter(commentAdapter);

                }

                @Override
                public void onError(int errorCode, String errorMsg) {

                }
            });
        } catch (Exception e) {

        }
    }

    //发送评论接口
    public void getpinglun() {
        String butttString = et_input_content.getText().toString().trim();
        if (TextUtils.isEmpty(butttString)) {
            ToastUtils.showTop(this, "请填写评论");
            return;
        }
        Map<String, String> map = new HashMap<>();
        map.put("baglist_id", tmp);
        map.put("content", butttString);
        OkHttpUtils.getInstance().post(SBUrls.PUBLISH_COMMENT, map, new MyNetWorkCallback<AddCommentBean>() {
            @Override
            public void onSuccess(AddCommentBean addComment) throws JSONException {
                pw.dismiss();
                getinitdatacomment();
            }

            @Override
            public void onError(int errorCode, String errorMsg) {

            }
        });

    }

    public void getinitData1() {
        Map<String, String> stringMap = new HashMap<>();
        OkHttpUtils.getInstance().post(SBUrls.LIKE, stringMap, new MyNetWorkCallback<LikeBean>() {
            @Override
            public void onSuccess(LikeBean likeBean) throws JSONException {

                List<LikeBean.InfoBean> info = likeBean.getInfo();
                details_like_recycler.setLayoutManager(new StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL));

                LikeAdapter likeAdapter = new LikeAdapter(Details.this, info);
                details_like_recycler.setAdapter(likeAdapter);
            }

            @Override
            public void onError(int errorCode, String errorMsg) {

            }
        });


    }

    //                      Banner Volder
    public class GlideImage extends ImageLoader {
        @Override
        public void displayImage(Context context, Object path, ImageView imageView) {
            Glide.with(context.getApplicationContext()).load(path).into(imageView);
        }
    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        UMShareAPI.get(this).onActivityResult(requestCode, resultCode, data);

    }


    @Override
    public void onRequestPermissionsResult(int requestCode, String permissions[], int[] grantResults) {
        //123是requestcode，可以根据这个code判断，用户是否同意了授权
    }

}
