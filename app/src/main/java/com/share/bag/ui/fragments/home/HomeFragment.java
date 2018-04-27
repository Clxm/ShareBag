package com.share.bag.ui.fragments.home;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.widget.SwipeRefreshLayout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
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
import com.share.bag.utils.ImageLoader;
import com.share.bag.utils.okhttp.OkHttpUtils;
import com.share.bag.utils.okhttp.callback.MyNetWorkCallback;
import com.share.bag.webview.PublicWebView;
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

/**
 * Created by Administrator on 2017/11/14.
 */
/*
* 首页
* */
public class HomeFragment extends BaseFragment {

    Unbinder unbinder;

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
    ImageView home_avatar;

    @BindView(R.id.home_name)
    TextView home_name;

    @BindView(R.id.home_time)
    TextView home_time;
    //分享图片
    @BindView(R.id.home_share)
    ImageView homeShare;
    @BindView(R.id.tv_label1)
    TextView mTvLabel1;
    @BindView(R.id.tv_label2)
    TextView mTvLabel2;
    @BindView(R.id.tv_label3)
    TextView mTvLabel3;
    @BindView(R.id.talent_img1)
    ImageView mTalentImg1;
    @BindView(R.id.talent_img2)
    ImageView mTalentImg2;
    @BindView(R.id.tv_comment_num)
    TextView mTvCommentNum;
    @BindView(R.id.tv_brand)
    TextView mTvBrand;
    @BindView(R.id.tv_handPick)
    TextView mTvHandPick;
    @BindView(R.id.tv_expert)
    TextView mTvExpert;
    @BindView(R.id.refresh)
    SwipeRefreshLayout mRefresh;

    private Context context;
    private MZBannerView mzBannerView;
    private List<HomeFragmentBean.HeaderimgBean> headerimg;
    private String mBrandBagId1;
    private String mBrandBagId2;
    private String mBrandBagId3;
    private String mLifeBagId1;
    private String mLifeBagId2;
    private String mLifeBagId3;
    private String mFeastBagId1;
    private String mFeastBagId2;
    private String mFeastBagId3;
    private String mFeastBagId4;
    private String mBusinessBagId1;
    private String mBusinessBagId2;
    private String mBusinessBagId3;
    private String mBusinessBagId4;

    @Override
    public int initLayout() {
        return R.layout.home_fragment;
    }

    @Override
    public void initView(View view) {
        context = getActivity().getApplicationContext();
        mzBannerView = view.findViewById(R.id.first_vp);
        initRefresh();
    }

    @Override
    protected void initData() {
        getData();
    }

    private void initRefresh() {
        mRefresh.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                getData();
            }
        });
    }

    private void getData() {
        final Map<String, String> stringMap = new HashMap<>();
        String strurl = "https://baobaoapi.ldlchat.com/Home/Cabinet/falsemasterlist.html";
        OkHttpUtils.getInstance().post(strurl, stringMap, new MyNetWorkCallback<HomeTalentBean>() {
            @Override
            public void onSuccess(HomeTalentBean homeTalentBean) throws JSONException {
                mRefresh.setRefreshing(false);
                HomeTalentBean.InfoBean info = homeTalentBean.getInfo();
                String iconurl = info.getUserinfo().getIconurl();
                Glide.with(context).load(iconurl)
                        //设置圆形图片
                        .transform(new GlideCircleTransform(context))
                        .crossFade()
                        .into(home_avatar);

                String contentImg = info.getBack().getContentimg();
                if (!"".equals(contentImg)) {
                    String[] imgs = contentImg.split(",");
                    if (imgs.length >= 1) {
                        if (!"".equals(imgs[0])) {
                            mTalentImg1.setVisibility(View.VISIBLE);
                            String img1 = SBUrls.LOGURL + imgs[0];
                            Glide.with(context).load(img1).into(mTalentImg1);
                        } else {
                            mTalentImg1.setVisibility(View.GONE);
                        }
                        if (!"".equals(imgs[1])) {
                            mTalentImg2.setVisibility(View.VISIBLE);
                            String img2 = SBUrls.LOGURL + imgs[1];
                            Glide.with(context).load(img2).into(mTalentImg2);
                        } else {
                            mTalentImg2.setVisibility(View.GONE);
                        }
                    }
                }

                String contentLabel = info.getUserinfo().getLabel();
                if (!contentLabel.equals("")) {
                    String[] labels = contentLabel.split(",");
                    if (labels.length >= 1) {
                        if (!"".equals(labels[0])) {
                            mTvLabel1.setVisibility(View.VISIBLE);
                            mTvLabel1.setText(labels[0]);
                        } else {
                            mTvLabel1.setVisibility(View.GONE);
                        }
                        if (!"".equals(labels[1])) {
                            mTvLabel2.setVisibility(View.VISIBLE);
                            mTvLabel2.setText(labels[1]);
                        } else {
                            mTvLabel2.setVisibility(View.GONE);
                        }
                        if (!"".equals(labels[2])) {
                            mTvLabel3.setVisibility(View.VISIBLE);
                            mTvLabel3.setText(labels[2]);
                        } else {
                            mTvLabel3.setVisibility(View.GONE);
                        }
                    }
                }
                mTvCommentNum.setText(info.getBack().getCollection() + "");
                String name = info.getUserinfo().getName();
                home_name.setText(name);
                String time = info.getTime();
                String strTime = DateUtils.getStrTime1(time);
                home_time.setText(strTime);
                home_dynamic.setText(info.getContent());
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
                mRefresh.setRefreshing(false);

                headerimg.addAll(homeFragmentBean.getHeaderimg());
                //轮播图赋值
                mzBannerView.setPages(headerimg, new MZHolderCreator<BannerViewHolder>() {
                    @Override
                    public BannerViewHolder createViewHolder() {
                        return new BannerViewHolder();
                    }
                });
                List<HomeFragmentBean.ListBean> imgList = homeFragmentBean.getList();
                for (int i = 0; i < imgList.size(); i++) {
                    String id = imgList.get(i).getId();
                    switch (id) {
                        case "1":   //品牌专区
                            String brandTitle = imgList.get(i).getTitle();
                            mTvBrand.setText(brandTitle);
                            List<HomeFragmentBean.ListBean.BagthinksBean> brandList = imgList.get(i).getBagthinks();
                            for (int i1 = 0; i1 < brandList.size(); i1++) {
                                String brandId = brandList.get(i1).getId();
                                switch (brandId) {
                                    case "1":
                                        mBrandBagId1 = brandList.get(i1).getBaglist_id();
                                        String brandImg1 = brandList.get(i1).getImg();
                                        ImageLoader.LoadLocalImg(homeBrandimg1, context, brandImg1);
                                        break;
                                    case "2":
                                        mBrandBagId2 = brandList.get(i1).getBaglist_id();
                                        String brandImg2 = brandList.get(i1).getImg();
                                        ImageLoader.LoadLocalImg(homeBrandimg2, context, brandImg2);
                                        break;
                                    case "3":
                                        mBrandBagId3 = brandList.get(i1).getBaglist_id();
                                        String brandImg3 = brandList.get(i1).getImg();
                                        ImageLoader.LoadLocalImg(homeBrandimg3, context, brandImg3);
                                        break;
                                }
                            }
                            break;
                        case "2":   //每日精选
                            String handPickTitle = imgList.get(i).getTitle();
                            mTvHandPick.setText(handPickTitle);
                            List<HomeFragmentBean.ListBean.ChildBean> childBeanList = imgList.get(i).get_child();
                            for (int childI = 0; childI < childBeanList.size(); childI++) {
                                String childId = childBeanList.get(childI).getId();
                                switch (childId) {
                                    case "4":   //休闲度假
                                        String lifeTitle = childBeanList.get(childI).getTitle();
                                        Relaxation1.setText(lifeTitle);
                                        List<HomeFragmentBean.ListBean.ChildBean.BagthinksBeanX> lifeList = childBeanList.get(childI).getBagthinks();
                                        for (int i2 = 0; i2 < lifeList.size(); i2++) {
                                            String lifeId = lifeList.get(i2).getId();
                                            switch (lifeId) {
                                                case "1":
                                                    mLifeBagId1 = lifeList.get(i2).getBaglist_id();
                                                    String lifeImg1 = lifeList.get(i2).getImg();
                                                    ImageLoader.LoadLocalImg(homeLeisureimg2, context, lifeImg1);
                                                    break;
                                                case "2":
                                                    mLifeBagId2 = lifeList.get(i2).getBaglist_id();
                                                    String lifeImg2 = lifeList.get(i2).getImg();
                                                    ImageLoader.LoadLocalImg(homeLeisureimg3, context, lifeImg2);
                                                    break;
                                                case "3":   //大图home_leisureimg1
                                                    mLifeBagId3 = lifeList.get(i2).getBaglist_id();
                                                    String lifeImg3 = lifeList.get(i2).getImg();
                                                    ImageLoader.LoadLocalImg(homeLeisureimg1, context, lifeImg3);
                                                    break;
                                            }
                                        }
                                        break;
                                    case "5":   //宴会轻奢
                                        String feastTitle = childBeanList.get(childI).getTitle();
                                        mFestname.setText(feastTitle);
                                        List<HomeFragmentBean.ListBean.ChildBean.BagthinksBeanX> feastList = childBeanList.get(childI).getBagthinks();
                                        for (int i2 = 0; i2 < feastList.size(); i2++) {
                                            String feastId = feastList.get(i2).getId();
                                            switch (feastId) {
                                                case "8":   //横图
                                                    mFeastBagId1 = feastList.get(i2).getBaglist_id();
                                                    String feastImg1 = feastList.get(i2).getImg();
                                                    ImageLoader.LoadLocalImg(home_banquet_img3, context, feastImg1);
                                                    break;
                                                case "9":   //竖图
                                                    mFeastBagId2 = feastList.get(i2).getBaglist_id();
                                                    String feastImg2 = feastList.get(i2).getImg();
                                                    ImageLoader.LoadLocalImg(home_banquet_img0, context, feastImg2);
                                                    break;
                                                case "10":
                                                    mFeastBagId3 = feastList.get(i2).getBaglist_id();
                                                    String feastImg3 = feastList.get(i2).getImg();
                                                    ImageLoader.LoadLocalImg(home_banquet_img1, context, feastImg3);
                                                    break;
                                                case "11":
                                                    mFeastBagId4 = feastList.get(i2).getBaglist_id();
                                                    String feastImg4 = feastList.get(i2).getImg();
                                                    ImageLoader.LoadLocalImg(home_banquet_img2, context, feastImg4);
                                                    break;
                                            }
                                        }
                                        break;
                                    case "6":   //商务办公
                                        String businessTitle = childBeanList.get(childI).getTitle();
                                        mBusinessname.setText(businessTitle);
                                        List<HomeFragmentBean.ListBean.ChildBean.BagthinksBeanX> businessList = childBeanList.get(childI).getBagthinks();
                                        for (int i1 = 0; i1 < businessList.size(); i1++) {
                                            String businessId = businessList.get(i1).getId();
                                            switch (businessId) {
                                                case "4":   //竖图
                                                    mBusinessBagId1 = businessList.get(i1).getBaglist_id();
                                                    String businessImg1 = businessList.get(i1).getImg();
                                                    ImageLoader.LoadLocalImg(home_business_img4, context, businessImg1);
                                                    break;
                                                case "5":   //横图
                                                    mBusinessBagId2 = businessList.get(i1).getBaglist_id();
                                                    String businessImg2 = businessList.get(i1).getImg();
                                                    ImageLoader.LoadLocalImg(home_business_img3, context, businessImg2);
                                                    break;
                                                case "6":
                                                    mBusinessBagId3 = businessList.get(i1).getBaglist_id();
                                                    String businessImg3 = businessList.get(i1).getImg();
                                                    ImageLoader.LoadLocalImg(home_business_img1, context, businessImg3);
                                                    break;
                                                case "7":
                                                    mBusinessBagId4 = businessList.get(i1).getBaglist_id();
                                                    String businessImg4 = businessList.get(i1).getImg();
                                                    ImageLoader.LoadLocalImg(home_business_img2, context, businessImg4);
                                                    break;
                                            }
                                        }
                                        break;
                                }
                            }

                            break;
                        case "3":   //包包达人
                            String expertTitle = imgList.get(i).getTitle();
                            mTvExpert.setText(expertTitle);
//                            List<HomeFragmentBean.ListBean.BagthinksBean> expertList = imgList.get(i).getBagthinks();

                            break;
                    }
                }
                //以旧换新
                List<HomeFragmentBean.AdOldnewBean> oldNewList = homeFragmentBean.getAd_oldnew();
                for (int i = 0; i < oldNewList.size(); i++) {
                    String oldNewImg = oldNewList.get(i).getImg();
                    ImageLoader.LoadLocalImg(home_trade_in, context, oldNewImg);
                }
                //邀请好友
                List<HomeFragmentBean.AdButtomBean> inviteFriendList = homeFragmentBean.getAd_buttom();
                if (null != inviteFriendList && inviteFriendList.size() > 0) {
                    String inviteImg = inviteFriendList.get(0).getImg();
                    ImageLoader.LoadLocalImg(homeShare, context, inviteImg);
                }
            }

            @Override
            public void onError(int errorCode, String errorMsg) {
                Toast.makeText(context, "请求失败", Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    protected void initListener() {
        super.initListener();
        //设置banner 轮播图 监听
        mzBannerView.setBannerPageClickListener(new MZBannerView.BannerPageClickListener() {
            @Override
            public void onPageClick(View view, int position) {
                String bannerUrl = headerimg.get(position).getUrl();
                Intent intent = new Intent(getActivity(), PublicWebView.class);
                intent.putExtra("publicUrl", bannerUrl);
                startActivity(intent);
            }
        });
    }

    @Override
    public void onResume() {
        super.onResume();
        if (mzBannerView != null) {
            mzBannerView.start();
        }
    }

    @Override
    public void onPause() {
        super.onPause();
        if (mzBannerView != null) {
            mzBannerView.pause();
        }
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


    @OnClick({home_brandimg1, R.id.home_brandimg2, R.id.home_brandimg3, R.id.home_leisureimg1, R.id.home_leisureimg2, R.id.home_leisureimg3,
            R.id.home_banquet_img0, R.id.home_banquet_img1, R.id.home_banquet_img2, R.id.home_banquet_img3,
            R.id.home_business_img1, R.id.home_business_img2, R.id.home_business_img3, R.id.home_business_img4,
            R.id.home_trade_in
    })
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.home_brandimg1://品牌专区图片1
                FileUtil.SelectedreadFromPre(getActivity(), shouye);
                if (shouye.getText().equals("")) {
                    Toast.makeText(getActivity(), "请先登录", Toast.LENGTH_SHORT).show();
                } else {
                    Intent intent_brandid0 = new Intent(context, Details.class);
                    intent_brandid0.putExtra("details", mBrandBagId1);
                    startActivity(intent_brandid0);
                }
                break;
            case R.id.home_brandimg2://品牌专区图片2
                FileUtil.SelectedreadFromPre(getActivity(), shouye);
                if (shouye.getText().equals("")) {
                    Toast.makeText(getActivity(), "请先登录", Toast.LENGTH_SHORT).show();
                } else {
                    Intent intent_brandid1 = new Intent(context, Details.class);
                    intent_brandid1.putExtra("details", mBrandBagId2);
                    startActivity(intent_brandid1);
                }
                break;
            case R.id.home_brandimg3://品牌专区图片3
                FileUtil.SelectedreadFromPre(getActivity(), shouye);
                if (shouye.getText().equals("")) {
                    Toast.makeText(getActivity(), "请先登录", Toast.LENGTH_SHORT).show();
                } else {
                    Intent intent_brandid2 = new Intent(context, Details.class);
                    intent_brandid2.putExtra("details", mBrandBagId3);
                    startActivity(intent_brandid2);
                }
                break;
//           每日精选——休闲度假
            case R.id.home_leisureimg1://休闲度假1
                FileUtil.SelectedreadFromPre(getActivity(), shouye);
                if (shouye.getText().equals("")) {
                    Toast.makeText(getActivity(), "请先登录", Toast.LENGTH_SHORT).show();
                } else {
                    Intent intent_leisure0 = new Intent(context, Details.class);
                    intent_leisure0.putExtra("details", mLifeBagId3);
                    startActivity(intent_leisure0);
                }
                break;
//           每日精选——休闲度假
            case R.id.home_leisureimg2://休闲度假2
                FileUtil.SelectedreadFromPre(getActivity(), shouye);
                if (shouye.getText().equals("")) {
                    Toast.makeText(getActivity(), "请先登录", Toast.LENGTH_SHORT).show();
                } else {
                    Intent intent_leisure1 = new Intent(context, Details.class);
                    intent_leisure1.putExtra("details", mLifeBagId1);
                    startActivity(intent_leisure1);
                }
                break;
//           每日精选——休闲度假
            case R.id.home_leisureimg3://休闲度假3
                FileUtil.SelectedreadFromPre(getActivity(), shouye);
                if (shouye.getText().equals("")) {
                    Toast.makeText(getActivity(), "请先登录", Toast.LENGTH_SHORT).show();
                } else {
                    Intent intent_leisure2 = new Intent(context, Details.class);
                    intent_leisure2.putExtra("details", mLifeBagId2);
                    startActivity(intent_leisure2);
                }
                break;
//           每日精选——宴会轻奢
            case R.id.home_banquet_img0://宴会轻奢1
                FileUtil.SelectedreadFromPre(getActivity(), shouye);
                if (shouye.getText().equals("")) {
                    Toast.makeText(getActivity(), "请先登录", Toast.LENGTH_SHORT).show();
                } else {
                    Intent intent_banquetid0 = new Intent(context, Details.class);
                    intent_banquetid0.putExtra("details", mFeastBagId2);
                    startActivity(intent_banquetid0);
                }
                break;
//           每日精选——宴会轻奢
            case R.id.home_banquet_img1://宴会轻奢2
                FileUtil.SelectedreadFromPre(getActivity(), shouye);
                if (shouye.getText().equals("")) {
                    Toast.makeText(getActivity(), "请先登录", Toast.LENGTH_SHORT).show();
                } else {
                    Intent intent_banquetid1 = new Intent(context, Details.class);
                    intent_banquetid1.putExtra("details", mFeastBagId3);
                    startActivity(intent_banquetid1);
                }
                break;
//           每日精选——宴会轻奢
            case R.id.home_banquet_img2://宴会轻奢3
                FileUtil.SelectedreadFromPre(getActivity(), shouye);
                if (shouye.getText().equals("")) {
                    Toast.makeText(getActivity(), "请先登录", Toast.LENGTH_SHORT).show();
                } else {
                    Intent intent_banquetid2 = new Intent(context, Details.class);
                    intent_banquetid2.putExtra("details", mFeastBagId4);
                    startActivity(intent_banquetid2);
                }
                break;
//           每日精选——宴会轻奢
            case R.id.home_banquet_img3://宴会轻奢4
                FileUtil.SelectedreadFromPre(getActivity(), shouye);
                if (shouye.getText().equals("")) {
                    Toast.makeText(getActivity(), "请先登录", Toast.LENGTH_SHORT).show();
                } else {
                    Intent intent_banquetid3 = new Intent(context, Details.class);
                    intent_banquetid3.putExtra("details", mFeastBagId1);
                    startActivity(intent_banquetid3);
                }
                break;
//            每日精选——商务办公
            case R.id.home_business_img1://商务办公1
                FileUtil.SelectedreadFromPre(getActivity(), shouye);
                if (shouye.getText().equals("")) {
                    Toast.makeText(getActivity(), "请先登录", Toast.LENGTH_SHORT).show();
                } else {
                    Intent intent_businessid1 = new Intent(context, Details.class);
                    intent_businessid1.putExtra("details", mBusinessBagId3);
                    startActivity(intent_businessid1);
                }
                break;
//            每日精选——商务办公
            case R.id.home_business_img2://商务办公2
                FileUtil.SelectedreadFromPre(getActivity(), shouye);
                if (shouye.getText().equals("")) {
                    Toast.makeText(getActivity(), "请先登录", Toast.LENGTH_SHORT).show();
                } else {
                    Intent intent_businessid2 = new Intent(context, Details.class);
                    intent_businessid2.putExtra("details", mBusinessBagId4);
                    startActivity(intent_businessid2);
                }
                break;
//            每日精选——商务办公
            case R.id.home_business_img3://商务办公3
                FileUtil.SelectedreadFromPre(getActivity(), shouye);
                if (shouye.getText().equals("")) {
                    Toast.makeText(getActivity(), "请先登录", Toast.LENGTH_SHORT).show();
                } else {
                    Intent intent_businessid3 = new Intent(context, Details.class);
                    intent_businessid3.putExtra("details", mBusinessBagId2);
                    startActivity(intent_businessid3);
                }
                break;
//            每日精选——商务办公
            case R.id.home_business_img4://商务办公4
                FileUtil.SelectedreadFromPre(getActivity(), shouye);
                if (shouye.getText().equals("")) {
                    Toast.makeText(getActivity(), "请先登录", Toast.LENGTH_SHORT).show();
                } else {
                    Intent intent_businessid4 = new Intent(context, Details.class);
                    intent_businessid4.putExtra("details", mBusinessBagId1);
                    startActivity(intent_businessid4);
                }
                break;
            case R.id.home_trade_in://以旧换新
                Intent intent_home_trade_in = new Intent(context, TradeActivity.class);
                startActivity(intent_home_trade_in);
                break;
        }
    }

    @OnClick(R.id.home_share)//分享好友
    public void onViewClicked() {
        Intent rentloginintent = new Intent(getActivity(), ShareActivity.class);
        startActivity(rentloginintent);
    }

    @OnClick(R.id.mLinearBaoBao)//点击包包达人
    public void onViewLinear() {
        Intent intent = new Intent(context, TalentActivity.class);
        startActivity(intent);
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

