package com.share.bag.ui.fragments.home;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.share.bag.DateUtils;
import com.share.bag.FileUtil;
import com.share.bag.GlideCircleTransform;
import com.share.bag.R;
import com.share.bag.SBUrls;
import com.share.bag.base.BaseFragment;
import com.share.bag.entity.HomeFragmentBean;
import com.share.bag.ui.activitys.collection.TalentActivity;
import com.share.bag.ui.activitys.home.Details;
import com.share.bag.ui.activitys.home.TradeActivity;
import com.share.bag.ui.share.ShareActivity;
import com.share.bag.utils.okhttp.OkHttpUtils;
import com.share.bag.utils.okhttp.callback.MyNetWorkCallback;
import com.zhouwei.mzbanner.MZBannerView;
import com.zhouwei.mzbanner.holder.MZHolderCreator;
import com.zhouwei.mzbanner.holder.MZViewHolder;

import org.json.JSONException;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;

import static com.share.bag.R.id.home_brandimg1;

//import static com.share.bag.R.id.brand_img1;

/**
 * Created by Administrator on 2017/11/14.
 */
/*
* 首页
* */
public class HomeFragment extends BaseFragment {


    Unbinder unbinder;

    @BindView(R.id.refreshlayout)
    SmartRefreshLayout refreshlayout;

    //品牌专区
    @BindView(home_brandimg1)
    ImageView homeBrandimg1;
    @BindView(R.id.home_brandimg2)
    ImageView homeBrandimg2;
    @BindView(R.id.home_brandimg3)
    ImageView homeBrandimg3;

    //以旧换新
    @BindView(R.id.home_trade_in)
    ImageView home_trade_in;

    //每日精选——休闲度假
    @BindView(R.id.Relaxation1)
    TextView Relaxation1;
    @BindView(R.id.home_leisureimg1)
    ImageView homeLeisureimg1;
    @BindView(R.id.home_leisureimg2)
    ImageView homeLeisureimg2;
    @BindView(R.id.home_leisureimg3)
    ImageView homeLeisureimg3;

    //每日精选——宴会轻奢
    @BindView(R.id.mFestname)
    TextView mFestname;
    @BindView(R.id.home_banquet_img0)
    ImageView home_banquet_img0;
    @BindView(R.id.home_banquet_img1)
    ImageView home_banquet_img1;
    @BindView(R.id.home_banquet_img2)
    ImageView home_banquet_img2;
    @BindView(R.id.home_banquet_img3)
    ImageView home_banquet_img3;

    //每日精选——商务办公
    @BindView(R.id.mBusinessname)
    TextView mBusinessname;
    @BindView(R.id.home_business_img1)
    ImageView home_business_img1;
    @BindView(R.id.home_business_img2)
    ImageView home_business_img2;
    @BindView(R.id.home_business_img3)
    ImageView home_business_img3;
    @BindView(R.id.home_business_img4)
    ImageView home_business_img4;
    @BindView(R.id.shouye)
    TextView shouye;

    //包包达人
//    @BindView(R.id.mLinearBaoBao)
//    LinearLayout mLinearBaoBao;

    //包包达人
    @BindView(R.id.home_dynamic)
    TextView home_dynamic;

    @BindView(R.id.home_avatar)
    ImageView  home_avatar;

    @BindView(R.id.home_name)
    TextView  home_name;

    @BindView(R.id.home_time)
    TextView  home_time;
    //分享图片
    @BindView(R.id.home_share)
    ImageView homeShare;

    private Context context;

    private MZBannerView mzBannerView;

    private List<HomeFragmentBean.HeaderimgBean> headerimg;

    private String brandid0;
    private String brandid1;
    private String brandid2;
    private String leisureid0;
    private String leisureid1;
    private String leisureid2;
    private String banquetid0;
    private String banquetid1;
    private String banquetid2;
    private String banquetid3;
    private String businessid0;
    private String businessid1;
    private String businessid2;
    private String businessid3;

    @Override
    public int initLayout() {
        return R.layout.home_fragment;
    }

    @Override
    public void initView(View view) {
        context = getActivity().getApplicationContext();

        mzBannerView = view.findViewById(R.id.first_vp);

    }



        @Override
    protected void initData() {

            home_dynamic.setEllipsize(TextUtils.TruncateAt.END);//收缩
            home_dynamic.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {

//                    talent_dynamic.setEllipsize(null);//展开

                }
            });

//            baobaoapi.ldlchat.com/Home/Cabinet/falsemasterlist.html
        Map<String,String> stringMap=new HashMap<>();
            String strurl="http://baobaoapi.ldlchat.com/Home/Cabinet/falsemasterlist.html";
            OkHttpUtils.getInstance().post(strurl, stringMap, new MyNetWorkCallback<HomeTalentBean>() {
                @Override
                public void onSuccess(HomeTalentBean homeTalentBean) throws JSONException {

                    List<HomeTalentBean.InfoBean> info = homeTalentBean.getInfo();

                    for (int i = 0; i < info.size(); i++) {

                        String iconurl = info.get(i).getUserinfo().getIconurl();
                        Glide.with(context)
                                .load(iconurl)
                                //设置圆角图片
//                .transform(new GlideRoundTransform(MainActivity.this, 10))
                                //设置圆形图片
                                .transform(new GlideCircleTransform(context))
                                .crossFade()
                                .into(home_avatar);

                        home_name.setText(info.get(i).getUserinfo().getName());

                        String strTime = DateUtils.getStrTime1(info.get(i).getTime());
                        home_time.setText(strTime);
                        home_dynamic.setText(info.get(i).getContent());
                    }
                }

                @Override
                public void onError(int errorCode, String errorMsg) {

                }
            });

        headerimg = new ArrayList<>();
        final Map<String, String> map = new HashMap<>();
        OkHttpUtils.getInstance().post(SBUrls.HOMEURL, map, new MyNetWorkCallback<HomeFragmentBean>() {
            @Override
            public void onSuccess(HomeFragmentBean homeFragmentBean) {

                headerimg.addAll(homeFragmentBean.getHeaderimg());

                for (int i = 0; i < homeFragmentBean.getList().size(); i++) {

                    HomeFragmentBean.ListBean listBean = homeFragmentBean.getList().get(i);

                    if (listBean != null) {
                        forEashs(homeFragmentBean, i, listBean);
                    }

                }

                //                  轮播图赋值
                mzBannerView.setPages(headerimg, new MZHolderCreator<BannerViewHolder>() {
                    @Override
                    public BannerViewHolder createViewHolder() {
                        return new BannerViewHolder();
                    }
                });

                //邀请好友
                List<HomeFragmentBean.AdButtomBean> ad_buttom = homeFragmentBean.getAd_buttom();

                for (int i = 0; i < ad_buttom.size(); i++) {

                    String imgyao = ad_buttom.get(i).getImg();

                    Glide.with(context).load(imgyao).into(homeShare);

                }

                //                以旧换新
                List<HomeFragmentBean.AdOldnewBean> ad_oldnew = homeFragmentBean.getAd_oldnew();

                for (int i = 0; i < ad_oldnew.size(); i++) {
                    String imghuan = ad_oldnew.get(i).getImg();
                    Glide.with(context).load(imghuan).into(home_trade_in);
                }



                List<HomeFragmentBean.ListBean.ChildBean> child = homeFragmentBean.getList().get(1).get_child();

                for (int i = 0; i < child.size(); i++) {
//                      休闲假日
//                     休闲假日文字
                    String title = child.get(0).getTitle();
//                     宴会轻奢文字
                    String title2 = child.get(1).getTitle();

                    Relaxation1.setText(title);
                    mFestname.setText(title2);
                    //每日精选-休闲度假
                    List<HomeFragmentBean.ListBean.ChildBean.BagthinksBeanX> bagthinks = child.get(0).getBagthinks();
                    for (int j = 0; j < bagthinks.size(); j++) {
                        String img1 = bagthinks.get(0).getImg();
                        String img2 = bagthinks.get(1).getImg();
                        String img3 = bagthinks.get(2).getImg();

                        leisureid0 = bagthinks.get(0).getId();
                        leisureid1 = bagthinks.get(1).getId();
                        leisureid2 = bagthinks.get(2).getId();

                        Glide.with(context).load(img1).into(homeLeisureimg1);
                        Glide.with(context).load(img2).into(homeLeisureimg2);
                        Glide.with(context).load(img3).into(homeLeisureimg3);

                    }


                    //每日精选-宴会轻奢
                    List<HomeFragmentBean.ListBean.ChildBean.BagthinksBeanX> bagthinks1 = child.get(1).getBagthinks();
                    for (int j = 0; j < bagthinks1.size(); j++) {

                        String img = bagthinks1.get(0).getImg();
                        String img1 = bagthinks1.get(1).getImg();
                        String img2 = bagthinks1.get(2).getImg();
                        String img3 = bagthinks1.get(3).getImg();

                        banquetid0 = bagthinks1.get(0).getId();
                        banquetid1 = bagthinks1.get(1).getId();
                        banquetid2 = bagthinks1.get(2).getId();
                        banquetid3 = bagthinks1.get(3).getId();

                        Glide.with(context).load(img).into(home_banquet_img0);
                        Glide.with(context).load(img1).into(home_banquet_img1);
                        Glide.with(context).load(img2).into(home_banquet_img2);
                        Glide.with(context).load(img3).into(home_banquet_img3);

                    }
                    //每日精选-商务办公
                    String title1 = child.get(2).getTitle();
                    mBusinessname.setText(title1);
                    List<HomeFragmentBean.ListBean.ChildBean.BagthinksBeanX> bagthinks2 = child.get(2).getBagthinks();
                    for (int j = 0; j < bagthinks2.size(); j++) {

                        String img = bagthinks2.get(0).getImg();
                        String img1 = bagthinks2.get(1).getImg();
                        String img2 = bagthinks2.get(2).getImg();
                        String img3 = bagthinks2.get(3).getImg();

                        businessid0 = bagthinks2.get(0).getId();
                        businessid1 = bagthinks2.get(1).getId();
                        businessid2 = bagthinks2.get(2).getId();
                        businessid3 = bagthinks2.get(3).getId();

                        Glide.with(context).load(img).into(home_business_img1);
                        Glide.with(context).load(img1).into(home_business_img2);
                        Glide.with(context).load(img2).into(home_business_img3);
                        Glide.with(context).load(img3).into(home_business_img4);

                    }
                }
//
//                homeBrandimg1id1 = homeFragmentBean.getList().get(0).getBagthinks().get(0).getId();
//
//                homeBrandimg1id2 = homeFragmentBean.getList().get(0).getBagthinks().get(1).getId();
//
//                homeBrandimg1id3 = homeFragmentBean.getList().get(0).getBagthinks().get(2).getId();

            }

            @Override
            public void onError(int errorCode, String errorMsg) {
                Toast.makeText(context, "请求失败", Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void forEashs(HomeFragmentBean homeFragmentBean, int i, HomeFragmentBean.ListBean listBean) {

        for (int j = 0; j < listBean.getBagthinks().size(); j++) {
            List<HomeFragmentBean.ListBean.BagthinksBean> bagthinks = listBean.getBagthinks();

            String img1 = bagthinks.get(0).getImg();
            String img2 = bagthinks.get(1).getImg();
            String img3 = bagthinks.get(2).getImg();

            brandid0 = bagthinks.get(0).getId();
            brandid1 = bagthinks.get(1).getId();
            brandid2 = bagthinks.get(2).getId();

            Glide.with(HomeFragment.this).load(img1).into(homeBrandimg1);//品牌专区1
            Glide.with(HomeFragment.this).load(img2).into(homeBrandimg2);//品牌专区2
            Glide.with(HomeFragment.this).load(img3).into(homeBrandimg3);//品牌专区3

        }
    }

    @Override
    protected void initListener() {
        super.initListener();
        //设置banner
        mzBannerView.setBannerPageClickListener(new MZBannerView.BannerPageClickListener() {
            @Override
            public void onPageClick(View view, int position) {
//             轮播图 监听
//                ToastUtils.show(APP.context, "wo是" + position);
            }
        });
    }

    @Override
    public void onResume() {
        super.onResume();
        mzBannerView.start();
    }

    @Override
    public void onPause() {
        super.onPause();
        mzBannerView.pause();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // TODO: inflate a fragment view
        View rootView = super.onCreateView(inflater, container, savedInstanceState);
        unbinder = ButterKnife.bind(this, rootView);
        return rootView;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }


    @OnClick({home_brandimg1, R.id.home_brandimg2, R.id.home_brandimg3,R.id.home_leisureimg1,R.id.home_leisureimg2,R.id.home_leisureimg3,
            R.id.home_banquet_img0,R.id.home_banquet_img1,R.id.home_banquet_img2,R.id.home_banquet_img3,
            R.id.home_business_img1,R.id.home_business_img2,R.id.home_business_img3,R.id.home_business_img4,
            R.id.home_trade_in
    })
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.home_brandimg1://品牌专区图片1
                FileUtil.SelectedreadFromPre(getActivity(),shouye);

                if (shouye.getText().equals("")){
                    Toast.makeText(getActivity(), "请先登录", Toast.LENGTH_SHORT).show();
                }else {
                    Intent intent_brandid0 = new Intent(context, Details.class);
                    intent_brandid0.putExtra("details", brandid0);
                    startActivity(intent_brandid0);
                }

                break;
            case R.id.home_brandimg2://品牌专区图片2

                FileUtil.SelectedreadFromPre(getActivity(),shouye);

                if (shouye.getText().equals("")){
                    Toast.makeText(getActivity(), "请先登录", Toast.LENGTH_SHORT).show();
                }else {
                    Intent intent_brandid1 = new Intent(context, Details.class);
                    intent_brandid1.putExtra("details", brandid1);
                    startActivity(intent_brandid1);
                }

                break;
            case R.id.home_brandimg3://品牌专区图片3
                FileUtil.SelectedreadFromPre(getActivity(),shouye);

                if (shouye.getText().equals("")){
                    Toast.makeText(getActivity(), "请先登录", Toast.LENGTH_SHORT).show();
                }else {
                    Intent intent_brandid2 = new Intent(context, Details.class);
                    intent_brandid2.putExtra("details", brandid2);
                    startActivity(intent_brandid2);
                }

                break;

//           每日精选——休闲度假
            case R.id.home_leisureimg1://休闲度假1

                FileUtil.SelectedreadFromPre(getActivity(),shouye);

                if (shouye.getText().equals("")){
                    Toast.makeText(getActivity(), "请先登录", Toast.LENGTH_SHORT).show();
                }else {
                    Intent intent_leisure0 = new Intent(context, Details.class);
                    intent_leisure0.putExtra("details", leisureid0);
                    startActivity(intent_leisure0);
                }

                break;
//           每日精选——休闲度假
            case R.id.home_leisureimg2://休闲度假2

                FileUtil.SelectedreadFromPre(getActivity(),shouye);

                if (shouye.getText().equals("")){
                    Toast.makeText(getActivity(), "请先登录", Toast.LENGTH_SHORT).show();
                }else {
                    Intent intent_leisure1 = new Intent(context, Details.class);
                    intent_leisure1.putExtra("details", leisureid1);
                    startActivity(intent_leisure1);
                }

                break;
//           每日精选——休闲度假
            case R.id.home_leisureimg3://休闲度假3

                FileUtil.SelectedreadFromPre(getActivity(),shouye);

                if (shouye.getText().equals("")){
                    Toast.makeText(getActivity(), "请先登录", Toast.LENGTH_SHORT).show();
                }else {
                    Intent intent_leisure2 = new Intent(context, Details.class);
                    intent_leisure2.putExtra("details", leisureid2);
                    startActivity(intent_leisure2);
                }

                break;
//           每日精选——宴会轻奢
            case R.id.home_banquet_img0://宴会轻奢1

                FileUtil.SelectedreadFromPre(getActivity(),shouye);

                if (shouye.getText().equals("")){
                    Toast.makeText(getActivity(), "请先登录", Toast.LENGTH_SHORT).show();
                }else {
                    Intent intent_banquetid0 = new Intent(context, Details.class);
                    intent_banquetid0.putExtra("details", banquetid0);
                    startActivity(intent_banquetid0);
                }

                break;
//           每日精选——宴会轻奢
            case R.id.home_banquet_img1://宴会轻奢2

                FileUtil.SelectedreadFromPre(getActivity(),shouye);

                if (shouye.getText().equals("")){
                    Toast.makeText(getActivity(), "请先登录", Toast.LENGTH_SHORT).show();
                }else {
                    Intent intent_banquetid1 = new Intent(context, Details.class);
                    intent_banquetid1.putExtra("details", banquetid1);
                    startActivity(intent_banquetid1);
                }

                break;
//           每日精选——宴会轻奢
            case R.id.home_banquet_img2://宴会轻奢3

                FileUtil.SelectedreadFromPre(getActivity(),shouye);

                if (shouye.getText().equals("")){
                    Toast.makeText(getActivity(), "请先登录", Toast.LENGTH_SHORT).show();
                }else {
                    Intent intent_banquetid2 = new Intent(context, Details.class);
                    intent_banquetid2.putExtra("details", banquetid2);
                    startActivity(intent_banquetid2);
                }

                break;
//           每日精选——宴会轻奢
            case R.id.home_banquet_img3://宴会轻奢4

                FileUtil.SelectedreadFromPre(getActivity(),shouye);

                if (shouye.getText().equals("")){
                    Toast.makeText(getActivity(), "请先登录", Toast.LENGTH_SHORT).show();
                }else {
                    Intent intent_banquetid3 = new Intent(context, Details.class);
                    intent_banquetid3.putExtra("details", banquetid3);
                    startActivity(intent_banquetid3);
                }

                break;
//            每日精选——商务办公
            case R.id.home_business_img1://商务办公1

                FileUtil.SelectedreadFromPre(getActivity(),shouye);

                if (shouye.getText().equals("")){
                    Toast.makeText(getActivity(), "请先登录", Toast.LENGTH_SHORT).show();
                }else {
                    Intent intent_businessid1 = new Intent(context, Details.class);
                    intent_businessid1.putExtra("details", businessid0);
                    startActivity(intent_businessid1);
                }

                break;
//            每日精选——商务办公
            case R.id.home_business_img2://商务办公2

                FileUtil.SelectedreadFromPre(getActivity(),shouye);

                if (shouye.getText().equals("")){
                    Toast.makeText(getActivity(), "请先登录", Toast.LENGTH_SHORT).show();
                }else {
                    Intent intent_businessid2 = new Intent(context, Details.class);
                    intent_businessid2.putExtra("details", businessid1);
                    startActivity(intent_businessid2);
                }

                break;
//            每日精选——商务办公
            case R.id.home_business_img3://商务办公3

                FileUtil.SelectedreadFromPre(getActivity(),shouye);

                if (shouye.getText().equals("")){
                    Toast.makeText(getActivity(), "请先登录", Toast.LENGTH_SHORT).show();
                }else {
                    Intent intent_businessid3 = new Intent(context, Details.class);
                    intent_businessid3.putExtra("details", businessid2);
                    startActivity(intent_businessid3);
                }

                break;
//            每日精选——商务办公
            case R.id.home_business_img4://商务办公4

                FileUtil.SelectedreadFromPre(getActivity(),shouye);

                if (shouye.getText().equals("")){
                    Toast.makeText(getActivity(), "请先登录", Toast.LENGTH_SHORT).show();
                }else {
                    Intent intent_businessid4 = new Intent(context, Details.class);
                    intent_businessid4.putExtra("details", businessid3);
                    startActivity(intent_businessid4);
                }

                break;

            case R.id.home_trade_in://以旧换新
                Intent intent_home_trade_in = new Intent(context,TradeActivity.class);
                startActivity(intent_home_trade_in);
                break;

        }
    }

    @OnClick(R.id.home_share)//分享好友
    public void onViewClicked() {
        Intent rentloginintent = new Intent(getActivity(), ShareActivity.class);
        startActivity(rentloginintent);
    }

    @OnClick(R.id.mLinearBaoBao)
    public void onViewLinear() {

//        Toast.makeText(context, "点击了包包达人", Toast.LENGTH_SHORT).show();
        
        Intent intent = new Intent(context, TalentActivity.class);
        startActivity(intent);//TalentActivity
    }


    //    轮播图 ViewHolder         实体类 FreshGoodThingDean.ResultBean.PictureBean
    public class BannerViewHolder implements MZViewHolder<HomeFragmentBean.HeaderimgBean> {
        private ImageView mImageView;

        @Override
        public View createView(Context context) {
            // 返回页面布局
            View view = LayoutInflater.from(context).inflate(R.layout.item_banner, null);
            mImageView = (ImageView) view.findViewById(R.id.banner_image);
            return view;
        }

        @Override
        public void onBind(Context context, int i, HomeFragmentBean.HeaderimgBean headerimgBean) {
            // 数据绑定
            Glide.with(context).load(headerimg.get(i).getImg()).into(mImageView);
        }
    }
}

