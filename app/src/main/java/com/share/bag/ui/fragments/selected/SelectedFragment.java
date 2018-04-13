package com.share.bag.ui.fragments.selected;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.TextView;
import android.widget.Toast;

import com.share.bag.FileUtil;
import com.share.bag.R;
import com.share.bag.SBUrls;
import com.share.bag.adapter.PopularAdapter;
import com.share.bag.base.BaseFragment;
import com.share.bag.entity.CollectionBean;
import com.share.bag.entity.selected.SelectedBean;
import com.share.bag.ui.activitys.SearchBagDetail;
import com.share.bag.ui.activitys.SearchHotWord;
import com.share.bag.ui.activitys.home.Details;
import com.share.bag.ui.activitys.home.DetailsBean;
import com.share.bag.utils.ToastUtils;
import com.share.bag.utils.okhttp.OkHttpUtils;
import com.share.bag.utils.okhttp.callback.MyNetWorkCallback;
import com.share.bag.view.FlowViewGroup;
import com.share.bag.view.TagFlowAdapter;

import org.greenrobot.eventbus.EventBus;
import org.json.JSONException;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;

import static com.share.bag.R.id.Chongzhi;
import static com.share.bag.R.id.DanJianTherr;
import static com.share.bag.R.id.DanJianTwo;


/**
 * Created by Administrator on 2017/11/14.
 */
//选包
public class SelectedFragment extends BaseFragment implements View.OnClickListener {
    @BindView(R.id.select_user)
    TextView select_user;
    @BindView(R.id.search_et_input)
    EditText searchEtInput;
    @BindView(R.id.selected_recyclerview)
    RecyclerView selectedRecyclerview;

    Unbinder unbinder;
    @BindView(R.id.search_popular)
    LinearLayout searchPopular;
    @BindView(R.id.search_price)
    LinearLayout searchPrice;
    @BindView(R.id.search_filter)
    LinearLayout searchFilter;
    @BindView(R.id.tv_hot)
    TextView mTvHot;
    @BindView(R.id.tv_price)
    TextView mTvPrice;
    @BindView(R.id.iv_price)
    ImageView mIvPrice;
    @BindView(R.id.tv_filter)
    TextView mTvFilter;
    @BindView(R.id.iv_filter)
    ImageView mIvFilter;
    @BindView(R.id.search_clear)
    ImageView searchClear;
    @BindView(R.id.Selected_smartrefreshlayout)
    SwipeRefreshLayout SelectedSmartrefreshlayout;
    private int width;
    private int height;
    private PopularAdapter adapter;
    private Button Digeo, GaoDi, ZuGaoDi, ZuDigao;
    private Button DanJianOne, DanJiantwo, DanJiantherr;
    private Button mPrice_v1, mPrice_v2, mPrice_v3, mPrice_v4;
    private Button ChongZhi, QueDing;
    private List<DetailsBean.InfoBean> mList = new ArrayList();
    private List<SelectedBean> mLists = new ArrayList();
    private PopupWindow window1;
    private View convertView;
    private boolean isGetData = false;
    //当前界面的价格排序方式 默认由低到高 4  高到低 3 租金低到高 2 租金高到低 1
    private int mPriceSelected = 4;
    //顶部页签的位置 0 热门 1 价格  2筛选
    private int tabPosistion = 0;

    //筛选中用于网络请求的参数
    private HashMap<String, String> filterParam = new HashMap();

    private ArrayList<Button> mPriceButtons;
    private Button mSize_xxl, mSize_m, mSize_l, mSize_xl;
    private Button mBrandNike, mBrandLv, mBrandCoco, mBrandDiro;
    private Button mHotAoco, mHotDiro, mHotKate, mHotWomenBag;
    private View mSearchPopGroup;
    private FlowViewGroup mFlowViewGroupa;
    private PopupWindow window;

    @Override
    public int initLayout() {
        return R.layout.live_fragment;
    }

    @Override
    public void initView(View view) {
        mSearchPopGroup = view.findViewById(R.id.search_popgroup);
        mFlowViewGroupa = view.findViewById(R.id.flowViewGroup);
        searchClear.setOnClickListener(this);
        SelectedSmartrefreshlayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                getHttpData();
            }
        });
        searchEtInput.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View view, boolean b) {
                if (b) {
                    getHotWord();
                } else {
                    InputMethodManager imm = (InputMethodManager) searchEtInput.getContext().getSystemService(Context.INPUT_METHOD_SERVICE);
                    if (imm.isActive()) {
                        imm.hideSoftInputFromWindow(searchEtInput.getApplicationWindowToken(), 0);
                    }
                    mSearchPopGroup.setVisibility(View.GONE);
                }
            }
        });
        view.findViewById(R.id.search_out).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                searchEtInput.clearFocus();
            }
        });
        searchEtInput.setOnEditorActionListener(new TextView.OnEditorActionListener() {

            @Override
            public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
                /*判断是否是“GO”键*/
                if (actionId == EditorInfo.IME_ACTION_SEARCH) {
                    searchEtInput.clearFocus();
                    getSearchDetail(searchEtInput.getText().toString());
                    return true;
                }
                return false;
            }
        });
    }

    private static Handler handler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            EventBus.getDefault().postSticky(msg.obj);
        }
    };

    private void getSearchDetail(String name) {
        HashMap<String, String> map = new HashMap<>();
        map.put("name", name);
        OkHttpUtils.getInstance().post(SBUrls.POPULAR, map, new MyNetWorkCallback<DetailsBean>() {
            @Override
            public void onSuccess(DetailsBean detailsBean) throws JSONException {
                List<DetailsBean.InfoBean> info = detailsBean.getInfo();
                if (null != info && info.size() > 0) {
                    Intent intent = new Intent(getActivity(), SearchBagDetail.class);
                    startActivity(intent);
                    Message message = new Message();
                    message.obj = detailsBean;
                    handler.sendMessageDelayed(message, 500);
                } else {
                    ToastUtils.showTop(getContext(), "暂无你查找的包包");
                }
            }

            @Override
            public void onError(int errorCode, String errorMsg) {

            }

        });
    }

    private void getHotWord() {
        HashMap<String, String> map = new HashMap<>();
        OkHttpUtils.getInstance().post(SBUrls.HOTWORD, map, new MyNetWorkCallback<SearchHotWord>() {
            @Override
            public void onSuccess(SearchHotWord searchHotWord) throws JSONException {
                if (null != searchHotWord.getInfo() && searchHotWord.getInfo().size() > 0)
                    mFlowViewGroupa.setAdapter(new MyTagFlowAdapter(searchHotWord.getInfo()));
                mSearchPopGroup.setVisibility(View.VISIBLE);
            }

            @Override
            public void onError(int errorCode, String errorMsg) {

            }
        });
    }

    private class MyTagFlowAdapter extends TagFlowAdapter {
        List<SearchHotWord.InfoBean> mList = new ArrayList<>();

        public MyTagFlowAdapter(List<SearchHotWord.InfoBean> info) {
            mList = info;
            notifyDataSetChanged();
        }

        @Override
        public int getCount() {
            return mList.size();
        }

        @Override
        public Object getItem(int position) {
            return null;
        }

        @Override
        public long getItemId(int position) {
            return 0;
        }

        @Override
        public View getView(final int position) {
            View view = View.inflate(getContext(), R.layout.flowadapter_item, null);
            TextView tv = view.findViewById(R.id.flowitem_tv);
            tv.setText(mList.get(position).getName());
            tv.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    searchEtInput.clearFocus();
                    mSearchPopGroup.setVisibility(View.GONE);
                    getSearchDetail(mList.get(position).getName());
                }
            });
            return view;
        }
    }


    @Override
    protected void initData() {
        selectedRecyclerview.setLayoutManager(new GridLayoutManager(getActivity(), 2));
        adapter = new PopularAdapter(getContext(), mList);
        selectedRecyclerview.setAdapter(adapter);
        FileUtil.SelectedreadFromPre(getActivity(), select_user);
        if (select_user.getText().equals("")) {
            ToastUtils.showTop(getContext(), "请先登录");
        } else {
//           登录成功后网络请求
            getHttpData();
        }

        adapter.setOnitemClickedListener(new PopularAdapter.OnitemClickedListener() {
            @Override
            public void Back(View v, int position) {//详情页
                Intent intent1 = new Intent(getActivity(), Details.class);
                intent1.putExtra("details", position + "");
                intent1.putExtra("details", mList.get(position).getId());
                startActivity(intent1);
            }
        });

    }

    public void getselect(final int position) {

        Map<String, String> collection = new HashMap();
        collection.put("baglist_id", position + "");
        OkHttpUtils.getInstance().post(SBUrls.COLLECTION, collection, new MyNetWorkCallback<CollectionBean>() {
            @Override
            public void onSuccess(CollectionBean collectionBean) {
                String status = collectionBean.getInfo();

                if (status.toString().equals("收藏成功")) {//成功
                    Toast.makeText(getContext(), position + status, Toast.LENGTH_SHORT).show();
                } else {//失败
                    Toast.makeText(getContext(), position + status, Toast.LENGTH_SHORT).show();
                }
                adapter.notifyDataSetChanged();// 刷新

            }

            @Override
            public void onError(int errorCode, String errorMsg) {
//                            Toast.makeText(getActivity(), "----"+errorMsg, Toast.LENGTH_SHORT).show();
            }
        });

    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // TODO: inflate aj fragment view
        View rootView = super.onCreateView(inflater, container, savedInstanceState);
        unbinder = ButterKnife.bind(this, rootView);
        WindowManager wm = (WindowManager) getContext()
                .getSystemService(Context.WINDOW_SERVICE);

        width = wm.getDefaultDisplay().getWidth();
        height = wm.getDefaultDisplay().getHeight();
        return rootView;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }


    public void getHttpData() {
        Map<String, String> map = new HashMap<>();
        switch (tabPosistion) {
            case 0://热门
                map.put("is_hot", "1");
                break;
            case 1://价格
                map.put("is_hot", "2");
                map.put("type", "1");
                map.put("priceType", mPriceSelected + "");
                break;
            case 2://筛选
                map.put("is_hot", "2");
                break;
        }
        OkHttpUtils.getInstance().post(SBUrls.POPULAR, map, new MyNetWorkCallback<DetailsBean>() {
            @Override
            public void onSuccess(DetailsBean detailsBean) throws JSONException {
                List<DetailsBean.InfoBean> info = detailsBean.getInfo();
                if (null != info && info.size() > 0) {
                    mList.clear();
                    mList.addAll(info);
                    adapter.notifyDataSetChanged();
                } else {
                    ToastUtils.showTop(getContext(), "未加载到数据");
                }
                SelectedSmartrefreshlayout.setRefreshing(false);
            }

            @Override
            public void onError(int errorCode, String errorMsg) {

            }
        });
    }

    @OnClick({R.id.search_popular, R.id.search_price, R.id.search_filter})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.search_popular:
                if (tabPosistion == 0)
                    return;
                tabPosistion = 0;
                changeHotState();
                getHttpData();
                break;
            case R.id.search_price:
                if (tabPosistion != 1) {
                    tabPosistion = 1;
                    getHttpData();
                }
                changePriceState();
                getPopupWindow();
                break;
            case R.id.search_filter:
                tabPosistion = 2;
                changeFilterState();
                getPopupWindowTwo();
                break;
        }
    }

    private void changeFilterState() {
        mTvFilter.setTextColor(Color.parseColor("#FC655E"));
        mIvFilter.setImageResource(R.drawable.selectf_filter_red);

        mTvHot.setTextColor(Color.parseColor("#292929"));
        mTvPrice.setTextColor(Color.parseColor("#292929"));
        mIvPrice.setImageResource(R.drawable.jiagexiao);
    }

    private void changePriceState() {
        mTvPrice.setTextColor(Color.parseColor("#FC655E"));
        mIvPrice.setImageResource(R.drawable.selectf_price_red);

        mTvHot.setTextColor(Color.parseColor("#292929"));
        mTvFilter.setTextColor(Color.parseColor("#292929"));
        mIvFilter.setImageResource(R.drawable.shaixuanxiao);
    }

    private void changeHotState() {
        mTvHot.setTextColor(Color.parseColor("#FC655E"));

        mTvPrice.setTextColor(Color.parseColor("#292929"));
        mIvPrice.setImageResource(R.drawable.jiagexiao);
        mTvFilter.setTextColor(Color.parseColor("#292929"));
        mIvFilter.setImageResource(R.drawable.shaixuanxiao);
    }

    //价格
    public void getPopupWindow() {

        View inflate = View.inflate(getContext(), R.layout.popupwindow1, null);
        //控件
        Kongjian(inflate);//inflate
        window1 = new PopupWindow(inflate, width, height);
        window1.setFocusable(true);
        window1.setBackgroundDrawable(new ColorDrawable(1));
        window1.setOutsideTouchable(true);
        window1.showAsDropDown(searchPopular);
        inflate.findViewById(R.id.pop_priceGroup).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                window1.dismiss();
            }
        });

    }

    //获取价格控件
    private void Kongjian(View inflate) {
        Digeo = inflate.findViewById(R.id.DiGao);
        Digeo.setOnClickListener(this);
        GaoDi = inflate.findViewById(R.id.GaoDi);
        GaoDi.setOnClickListener(this);
        ZuDigao = inflate.findViewById(R.id.ZuDiGao);
        ZuDigao.setOnClickListener(this);
        ZuGaoDi = inflate.findViewById(R.id.ZuGaoDi);
        ZuGaoDi.setOnClickListener(this);
        mPriceButtons = new ArrayList<>();
        mPriceButtons.add(Digeo);
        mPriceButtons.add(GaoDi);
        mPriceButtons.add(ZuDigao);
        mPriceButtons.add(ZuGaoDi);
        setPriceButton();
    }

    private void setPriceButton() {
        Button selectButton = null;
        switch (mPriceSelected) {
            case 4:
                selectButton = mPriceButtons.get(0);
                break;
            case 3:
                selectButton = mPriceButtons.get(1);
                break;
            case 2:
                selectButton = mPriceButtons.get(2);
                break;
            case 1:
                selectButton = mPriceButtons.get(3);
                break;
        }
        selectButton.setBackgroundResource(R.drawable.textview3);
        selectButton.setTextColor(Color.parseColor("#FFFFFF"));
    }

    //筛选
    public void getPopupWindowTwo() {
        View inflate = View.inflate(getContext(), R.layout.popupwindowtwo, null);
        ShaixuanKongjain(inflate);//控件
        window = new PopupWindow(inflate, width, height);
        window.setFocusable(true);
        window.setBackgroundDrawable(new ColorDrawable(1));
        window.setOutsideTouchable(true);
        window.showAsDropDown(searchPopular);
        inflate.findViewById(R.id.filter_group).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                window.dismiss();
            }
        });
    }

    //获取筛选控件
    private void ShaixuanKongjain(View inflate) {
        //初始化筛选的请求参数
        filterParam.clear();
        //包包类型
        DanJianOne = inflate.findViewById(R.id.DanJianOne);
        DanJianOne.setOnClickListener(this);
        DanJiantwo = inflate.findViewById(DanJianTwo);
        DanJiantwo.setOnClickListener(this);
        DanJiantherr = inflate.findViewById(DanJianTherr);
        DanJiantherr.setOnClickListener(this);
        //包包的大小
        mSize_xxl = inflate.findViewById(R.id.size_xxl);
        mSize_m = inflate.findViewById(R.id.size_m);
        mSize_l = inflate.findViewById(R.id.size_l);
        mSize_xl = inflate.findViewById(R.id.size_xl);
        mSize_xxl.setOnClickListener(this);
        mSize_m.setOnClickListener(this);
        mSize_l.setOnClickListener(this);
        mSize_xl.setOnClickListener(this);
        //包包牌子
        mBrandNike = inflate.findViewById(R.id.brand_nike);
        mBrandLv = inflate.findViewById(R.id.brand_lv);
        mBrandCoco = inflate.findViewById(R.id.brand_coco);
        mBrandDiro = inflate.findViewById(R.id.brand_diro);
        mBrandNike.setOnClickListener(this);
        mBrandLv.setOnClickListener(this);
        mBrandCoco.setOnClickListener(this);
        mBrandDiro.setOnClickListener(this);
        //包包关键字
        mHotAoco = inflate.findViewById(R.id.hot_aoco);
        mHotKate = inflate.findViewById(R.id.hot_kate);
        mHotDiro = inflate.findViewById(R.id.hot_diro);
        mHotWomenBag = inflate.findViewById(R.id.hot_womenbag);
        mHotAoco.setOnClickListener(this);
        mHotKate.setOnClickListener(this);
        mHotDiro.setOnClickListener(this);
        mHotWomenBag.setOnClickListener(this);
        //包包价钱
        mPrice_v1 = inflate.findViewById(R.id.price_v1);
        mPrice_v1.setOnClickListener(this);
        mPrice_v2 = inflate.findViewById(R.id.price_v2);
        mPrice_v2.setOnClickListener(this);
        mPrice_v3 = inflate.findViewById(R.id.price_v3);
        mPrice_v3.setOnClickListener(this);
        mPrice_v4 = inflate.findViewById(R.id.price_v4);
        mPrice_v4.setOnClickListener(this);
        ChongZhi = inflate.findViewById(Chongzhi);
        ChongZhi.setOnClickListener(this);
        QueDing = inflate.findViewById(R.id.QueDing);
        QueDing.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.search_clear:
                searchEtInput.setText("");
                break;
            //价格从高到低
            case R.id.DiGao:
                mPriceSelected = 4;
                getHttpData();
                window1.dismiss();
                break;
            //价格从高到低
            case R.id.GaoDi:
                mPriceSelected = 3;
                getHttpData();
                window1.dismiss();
                break;
            //租金从低到高
            case R.id.ZuDiGao:
                mPriceSelected = 2;
                getHttpData();
                window1.dismiss();
                break;
            //租金从高到低
            case R.id.ZuGaoDi:
                mPriceSelected = 1;
                getHttpData();
                window1.dismiss();
                break;
            //单肩One
            case R.id.DanJianOne:
                String type = filterParam.get("bagtype_id");
                resetType();
                if (!TextUtils.isEmpty(type) && type.equals("1")) {
                    filterParam.remove("bagtype_id");
                } else {
                    filterParam.put("bagtype_id", "1");
                    DanJianOne.setSelected(true);
                    DanJianOne.setBackground(getResources().getDrawable(R.drawable.red));
                }
                break;
            //单肩Two
            case R.id.DanJianTwo:
                String type2 = filterParam.get("bagtype_id");
                resetType();
                if (!TextUtils.isEmpty(type2) && type2.equals("2")) {
                    filterParam.remove("bagtype_id");
                } else {
                    filterParam.put("bagtype_id", "2");
                    DanJiantwo.setSelected(true);
                    DanJiantwo.setBackground(getResources().getDrawable(R.drawable.red));
                }
                break;
            //单肩Therr
            case R.id.DanJianTherr:
                String type3 = filterParam.get("bagtype_id");
                resetType();
                if (!TextUtils.isEmpty(type3) && type3.equals("3")) {
                    filterParam.remove("bagtype_id");
                } else {
                    filterParam.put("bagtype_id", "3");
                    DanJiantherr.setSelected(true);
                    DanJiantherr.setBackground(getResources().getDrawable(R.drawable.red));
                }
                break;
            case R.id.size_xxl:
                String size_s = filterParam.get("bagsize_id");
                resetSize();
                if (!TextUtils.isEmpty(size_s) && size_s.equals("4")) {
                    filterParam.remove("bagsize_id");
                } else {
                    filterParam.put("bagsize_id", "4");
                    mSize_xxl.setSelected(true);
                    mSize_xxl.setBackground(getResources().getDrawable(R.drawable.red));
                }
                break;
            //中M
            case R.id.size_m:
                String size_m = filterParam.get("bagsize_id");
                resetSize();
                if (!TextUtils.isEmpty(size_m) && size_m.equals("1")) {
                    filterParam.remove("bagsize_id");
                } else {
                    filterParam.put("bagsize_id", "1");
                    mSize_m.setSelected(true);
                    mSize_m.setBackground(getResources().getDrawable(R.drawable.red));
                }
                break;
            //小S
            case R.id.size_l:
                String size_l = filterParam.get("bagsize_id");
                resetSize();
                if (!TextUtils.isEmpty(size_l) && size_l.equals("2")) {
                    filterParam.remove("bagsize_id");
                } else {
                    filterParam.put("bagsize_id", "2");
                    mSize_l.setSelected(true);
                    mSize_l.setBackground(getResources().getDrawable(R.drawable.red));
                }
                break;
            //小S
            case R.id.size_xl:
                String size_xl = filterParam.get("bagsize_id");
                resetSize();
                if (!TextUtils.isEmpty(size_xl) && size_xl.equals("3")) {
                    filterParam.remove("bagsize_id");
                } else {
                    filterParam.put("bagsize_id", "3");
                    mSize_xl.setSelected(true);
                    mSize_xl.setBackground(getResources().getDrawable(R.drawable.red));
                }
                break;
            case R.id.brand_nike:
                resetBrand();
                String brand_nike = filterParam.get("bagbrand_id");
                if (!TextUtils.isEmpty(brand_nike) && brand_nike.equals("2")) {
                    filterParam.remove("bagbrand_id");
                } else {
                    filterParam.put("bagbrand_id", "2");
                    mBrandNike.setSelected(true);
                    mBrandNike.setBackground(getResources().getDrawable(R.drawable.red));
                }
                break;
            case R.id.brand_lv:
                resetBrand();
                String brand_lv = filterParam.get("bagbrand_id");
                if (!TextUtils.isEmpty(brand_lv) && brand_lv.equals("3")) {
                    filterParam.remove("bagbrand_id");
                } else {
                    filterParam.put("bagbrand_id", "3");
                    mBrandLv.setSelected(true);
                    mBrandLv.setBackground(getResources().getDrawable(R.drawable.red));
                }
                break;
            case R.id.brand_coco:
                resetBrand();
                String brand_coco = filterParam.get("bagbrand_id");
                if (!TextUtils.isEmpty(brand_coco) && brand_coco.equals("5")) {
                    filterParam.remove("bagbrand_id");
                } else {
                    filterParam.put("bagbrand_id", "5");
                    mBrandCoco.setSelected(true);
                    mBrandCoco.setBackground(getResources().getDrawable(R.drawable.red));
                }
                break;
            case R.id.brand_diro:
                resetBrand();
                String brand_diro = filterParam.get("bagbrand_id");
                if (!TextUtils.isEmpty(brand_diro) && brand_diro.equals("4")) {
                    filterParam.remove("bagbrand_id");
                } else {
                    filterParam.put("bagbrand_id", "4");
                    mBrandDiro.setSelected(true);
                    mBrandDiro.setBackground(getResources().getDrawable(R.drawable.red));
                }
                break;
            case R.id.hot_aoco:
                resetHot();
                String hot_aoco = filterParam.get("hotwordid");
                if (!TextUtils.isEmpty(hot_aoco) && hot_aoco.equals("1")) {
                    filterParam.remove("hotwordid");
                } else {
                    filterParam.put("hotwordid", "1");
                    mHotAoco.setSelected(true);
                    mHotAoco.setBackground(getResources().getDrawable(R.drawable.red));
                }
                break;
            case R.id.hot_kate:
                resetHot();
                String hot_kate = filterParam.get("hotwordid");
                if (!TextUtils.isEmpty(hot_kate) && hot_kate.equals("3")) {
                    filterParam.remove("hotwordid");
                } else {
                    filterParam.put("hotwordid", "3");
                    mHotKate.setSelected(true);
                    mHotKate.setBackground(getResources().getDrawable(R.drawable.red));
                }
                break;
            case R.id.hot_womenbag:
                resetHot();
                String hot_womenbag = filterParam.get("hotwordid");
                if (!TextUtils.isEmpty(hot_womenbag) && hot_womenbag.equals("6")) {
                    filterParam.remove("hotwordid");
                } else {
                    filterParam.put("hotwordid", "6");
                    mHotWomenBag.setSelected(true);
                    mHotWomenBag.setBackground(getResources().getDrawable(R.drawable.red));
                }
                break;
            case R.id.hot_diro:
                resetHot();
                String hot_diro = filterParam.get("hotwordid");
                if (!TextUtils.isEmpty(hot_diro) && hot_diro.equals("4")) {
                    filterParam.remove("hotwordid");
                } else {
                    filterParam.put("hotwordid", "4");
                    mHotDiro.setSelected(true);
                    mHotDiro.setBackground(getResources().getDrawable(R.drawable.red));
                }
                break;
            //500以下
            case R.id.price_v1:
                resetPrice();
                String price_v1 = filterParam.get("nowprice");
                if (!TextUtils.isEmpty(price_v1) && price_v1.equals("1")) {
                    filterParam.remove("nowprice");
                } else {
                    filterParam.put("nowprice", "1");
                    mPrice_v1.setSelected(true);
                    mPrice_v1.setBackground(getResources().getDrawable(R.drawable.red));
                }
                break;
            //500-1000
            case R.id.price_v2:
                resetPrice();
                String price_v2 = filterParam.get("nowprice");
                if (!TextUtils.isEmpty(price_v2) && price_v2.equals("2")) {
                    filterParam.remove("nowprice");
                } else {
                    filterParam.put("nowprice", "2");
                    mPrice_v2.setSelected(true);
                    mPrice_v2.setBackground(getResources().getDrawable(R.drawable.red));
                }
                break;
            //1000-2000
            case R.id.price_v3:
                resetPrice();
                String price_v3 = filterParam.get("nowprice");
                if (!TextUtils.isEmpty(price_v3) && price_v3.equals("3")) {
                    filterParam.remove("nowprice");
                } else {
                    filterParam.put("nowprice", "3");
                    mPrice_v3.setSelected(true);
                    mPrice_v3.setBackground(getResources().getDrawable(R.drawable.red));
                }
                break;
            //2000以上
            case R.id.price_v4:
                resetPrice();
                String price_v4 = filterParam.get("nowprice");
                if (!TextUtils.isEmpty(price_v4) && price_v4.equals("4")) {
                    filterParam.remove("nowprice");
                } else {
                    filterParam.put("nowprice", "4");
                    mPrice_v4.setSelected(true);
                    mPrice_v4.setBackground(getResources().getDrawable(R.drawable.red));
                }
                break;
            //重置
            case R.id.Chongzhi:
                resetType();
                resetBrand();
                resetHot();
                resetPrice();
                resetSize();
                break;
            case R.id.QueDing:
                filterData();
                window.dismiss();
                break;
        }
    }

    /**
     * 筛选数据
     */
    private void filterData() {
        OkHttpUtils.getInstance().post(SBUrls.FILTERBAG, filterParam, new MyNetWorkCallback<DetailsBean>() {
            @Override
            public void onSuccess(DetailsBean detailsBean) throws JSONException {
                List<DetailsBean.InfoBean> info = detailsBean.getInfo();
                if (null != info && info.size() > 0) {
                    mList.clear();
                    mList.addAll(info);
                    adapter.notifyDataSetChanged();
                } else {
                    ToastUtils.showTop(getContext(), "没有搜寻到相关包包");
                }
            }

            @Override
            public void onError(int errorCode, String errorMsg) {

            }
        });
    }

    /**
     * 重置价钱空间样式
     */
    private void resetPrice() {
        mPrice_v1.setSelected(false);
        mPrice_v1.setBackground(getResources().getDrawable(R.drawable.textview));
        mPrice_v2.setSelected(false);
        mPrice_v2.setBackground(getResources().getDrawable(R.drawable.textview));
        mPrice_v3.setSelected(false);
        mPrice_v3.setBackground(getResources().getDrawable(R.drawable.textview));
        mPrice_v4.setSelected(false);
        mPrice_v4.setBackground(getResources().getDrawable(R.drawable.textview));
    }

    /**
     * 重置关键字控件样式
     */
    private void resetHot() {
        mHotAoco.setSelected(false);
        mHotAoco.setBackground(getResources().getDrawable(R.drawable.textview));
        mHotDiro.setSelected(false);
        mHotDiro.setBackground(getResources().getDrawable(R.drawable.textview));
        mHotKate.setSelected(false);
        mHotKate.setBackground(getResources().getDrawable(R.drawable.textview));
        mHotWomenBag.setSelected(false);
        mHotWomenBag.setBackground(getResources().getDrawable(R.drawable.textview));
    }

    /**
     * 重置所有的热门品牌
     */
    private void resetBrand() {
        mBrandNike.setSelected(false);
        mBrandNike.setBackground(getResources().getDrawable(R.drawable.textview));
        mBrandLv.setSelected(false);
        mBrandLv.setBackground(getResources().getDrawable(R.drawable.textview));
        mBrandCoco.setSelected(false);
        mBrandCoco.setBackground(getResources().getDrawable(R.drawable.textview));
        mBrandDiro.setSelected(false);
        mBrandDiro.setBackground(getResources().getDrawable(R.drawable.textview));
    }

    /**
     * 重置所有的大小控件样式
     */
    private void resetSize() {
        mSize_xxl.setSelected(false);
        mSize_xxl.setBackground(getResources().getDrawable(R.drawable.textview));
        mSize_m.setSelected(false);
        mSize_m.setBackground(getResources().getDrawable(R.drawable.textview));
        mSize_l.setSelected(false);
        mSize_l.setBackground(getResources().getDrawable(R.drawable.textview));
        mSize_xl.setSelected(false);
        mSize_xl.setBackground(getResources().getDrawable(R.drawable.textview));
    }

    /**
     * 重置所以的类型控件样式
     */
    private void resetType() {
        DanJianOne.setSelected(false);
        DanJianOne.setBackground(getResources().getDrawable(R.drawable.textview));
        DanJiantherr.setSelected(false);
        DanJiantherr.setBackground(getResources().getDrawable(R.drawable.textview));
        DanJiantwo.setSelected(false);
        DanJiantwo.setBackground(getResources().getDrawable(R.drawable.textview));
    }


    @Override
    public Animation onCreateAnimation(int transit, boolean enter, int nextAnim) {
        //   进入当前Fragment
        if (enter && !isGetData) {
            isGetData = true;
            //   这里可以做网络请求或者需要的数据刷新操作
            getHttpData();
            adapter.notifyDataSetChanged();

        } else {
            isGetData = false;
        }
        return super.onCreateAnimation(transit, enter, nextAnim);
    }

    @Override
    public void onResume() {
        super.onResume();
//        if (!isGetData) {
//            //   这里可以做网络请求或者需要的数据刷新操作
//            getpopular();
//            adapter.notifyDataSetChanged();
//            isGetData = true;
//        }
    }

    @Override
    public void onPause() {
        super.onPause();
        isGetData = false;
    }


}
