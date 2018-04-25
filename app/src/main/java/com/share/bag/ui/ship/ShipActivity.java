package com.share.bag.ui.ship;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.share.bag.FileUtil;
import com.share.bag.R;
import com.share.bag.SBUrls;
import com.share.bag.utils.okhttp.OkHttpUtils;
import com.share.bag.utils.okhttp.callback.MyNetWorkCallback;

import org.json.JSONException;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
* 代付款
* 代发货
* 代签收
* 待归还
* */
public class ShipActivity extends AppCompatActivity implements View.OnClickListener {

    private ImageView ship_return;
    private TextView ship_name;
    private TabLayout ship_tabs;
    private ViewPager ship_vp_view;


    private LayoutInflater mInflater;
    private List<String> mTitleList = new ArrayList<>();//页卡标题集合
    private View view1, view2, view3, view4;
    private List<View> mViewList = new ArrayList<>();//页卡视图集合
    private RecyclerView ship_recycler2;
    private RecyclerView ship_recycler1;
    private RecyclerView ship_recycler3;
    private RecyclerView ship_recycler4;
    private LinearLayoutManager mlinearLayoutManager1;
    private LinearLayoutManager mlinearLayoutManager2;
    private LinearLayoutManager mlinearLayoutManager3;
    private LinearLayoutManager mlinearLayoutManager4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ship);
        initView();
        String ship = getIntent().getStringExtra("ship");
        mInflater = LayoutInflater.from(this);
        view1 = mInflater.inflate(R.layout.activity_ship1, null);
        view2 = mInflater.inflate(R.layout.activity_ship2, null);
        view3 = mInflater.inflate(R.layout.activity_ship3, null);
        view4 = mInflater.inflate(R.layout.activity_ship4, null);
        ship_recycler1 =  view1.findViewById(R.id.recycler);
        ship_recycler2 =  view2.findViewById(R.id.recycler);
        ship_recycler3 =  view3.findViewById(R.id.recycler);
        ship_recycler4 =  view4.findViewById(R.id.recycler);
        mlinearLayoutManager1 = new LinearLayoutManager(this);
        mlinearLayoutManager2 = new LinearLayoutManager(this);
        mlinearLayoutManager3 = new LinearLayoutManager(this);
        mlinearLayoutManager4 = new LinearLayoutManager(this);
        ship_recycler1.setLayoutManager(mlinearLayoutManager1);
        ship_recycler2.setLayoutManager(mlinearLayoutManager2);
        ship_recycler3.setLayoutManager(mlinearLayoutManager3);
        ship_recycler4.setLayoutManager(mlinearLayoutManager4);
        //添加页卡视图
        mViewList.add(view1);
        mViewList.add(view2);
        mViewList.add(view3);
        mViewList.add(view4);

        //添加页卡标题
        mTitleList.add("待付款");
        mTitleList.add("待发货");
        mTitleList.add("待验收");
        mTitleList.add("待归还");


        ship_tabs.setTabMode(TabLayout.MODE_FIXED);
        ship_tabs.addTab(ship_tabs.newTab().setText(mTitleList.get(0)));
        ship_tabs.addTab(ship_tabs.newTab().setText(mTitleList.get(1)));
        ship_tabs.addTab(ship_tabs.newTab().setText(mTitleList.get(2)));
        ship_tabs.addTab(ship_tabs.newTab().setText(mTitleList.get(3)));


        MyPagerAdapter mAdapter = new MyPagerAdapter(mViewList);
        ship_vp_view.setAdapter(mAdapter);
        ship_tabs.setupWithViewPager(ship_vp_view);
        ship_tabs.setTabsFromPagerAdapter(mAdapter);

        gettitle();
        //待付款
        getdata1();
        //待发货
        getdata2();
        //待验收
        getdata3();
      //  待归还
        getdata4();
        ship_vp_view.setCurrentItem(Integer.parseInt(ship), false);
    }

    //待付款 1
    public void getdata1() {
        Map<String, String> map = new HashMap<>();
        map.put("type", "1");
//        map.put("userid", FileUtil.getUserId(ShipActivity.this));
        map.put("userid", "51");
        OkHttpUtils.getInstance().post(SBUrls.ORDERTSTATUS, map, new MyNetWorkCallback<ShipHttpBean1>() {
            @Override
            public void onSuccess(ShipHttpBean1 bean) throws JSONException {
                if(null != bean.getInfo() && bean.getInfo().size() > 0){
                    ship_recycler1.setAdapter(new ShipAdapter1(ShipActivity.this,bean.getInfo()));
                }
            }

            @Override
            public void onError(int errorCode, String errorMsg) {

            }
        });

    }

    //待发货 2
    public void getdata2() {
        Map<String, String> map = new HashMap<>();
        map.put("type", "2");
//        map.put("userid", FileUtil.getUserId(ShipActivity.this));
        map.put("userid", "51");
        OkHttpUtils.getInstance().post(SBUrls.ORDERTSTATUS, map, new MyNetWorkCallback<ShipHttpBean2>() {
            @Override
            public void onSuccess(ShipHttpBean2 bean) throws JSONException {
                if(null != bean.getInfo() && bean.getInfo().size() > 0){
                    ship_recycler2.setAdapter(new ShipAdapter2(ShipActivity.this,bean.getInfo()));
                }
            }

            @Override
            public void onError(int errorCode, String errorMsg) {

            }
        });
    }

    //待验收 4
    public void getdata3() {
        Map<String, String> map = new HashMap<>();
        map.put("type", "4");
//        map.put("userid", FileUtil.getUserId(ShipActivity.this));
        map.put("userid", "51");
        OkHttpUtils.getInstance().post(SBUrls.ORDERTSTATUS, map, new MyNetWorkCallback<ShipHttpBean3>() {
            @Override
            public void onSuccess(ShipHttpBean3 bean) throws JSONException {
                if(null != bean.getInfo() && bean.getInfo().size() > 0){
                    ship_recycler3.setAdapter(new ShipAdapter3(ShipActivity.this,bean.getInfo()));
                }
            }

            @Override
            public void onError(int errorCode, String errorMsg) {

            }
        });
    }

    //待归还 7
    public void getdata4() {
        Map<String, String> map = new HashMap<>();
        map.put("type", "7");
//        map.put("userid", FileUtil.getUserId(ShipActivity.this));
        map.put("userid", "51");
        OkHttpUtils.getInstance().post(SBUrls.ORDERTSTATUS, map, new MyNetWorkCallback<ShipHttpBean4>() {
            @Override
            public void onSuccess(ShipHttpBean4 bean) throws JSONException {
                if(null != bean.getInfo() && bean.getInfo().size() > 0){
                    ship_recycler4.setAdapter(new ShipAdapter4(ShipActivity.this,bean.getInfo()));
                }
            }

            @Override
            public void onError(int errorCode, String errorMsg) {

            }
        });
    }

    private void initView() {
        ship_return = (ImageView) findViewById(R.id.ship_return);
        ship_name = (TextView) findViewById(R.id.ship_name);
        ship_tabs = (TabLayout) findViewById(R.id.ship_tabs);
        ship_vp_view = (ViewPager) findViewById(R.id.ship_vp_view);

        ship_return.setOnClickListener(this);
        ship_vp_view.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                if (0 == position) {
                    ship_name.setText("待付款");
                } else if (1 == position) {
                    ship_name.setText("待发货");
                } else if (2 == position) {
                    ship_name.setText("待验收");
                } else if (3 == position) {
                    ship_name.setText("待归还");
                }
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
    }


    public void gettitle() {
        ship_return.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.ship_return:
                finish();
                break;
        }
    }


    //ViewPager适配器
    class MyPagerAdapter extends PagerAdapter {
        private List<View> mViewList;

        public MyPagerAdapter(List<View> mViewList) {
            this.mViewList = mViewList;
        }

        @Override
        public int getCount() {
            return mViewList.size();
        }

        @Override
        public boolean isViewFromObject(View view, Object object) {
            return view == object;
        }

        @Override
        public Object instantiateItem(ViewGroup container, int position) {
            container.addView(mViewList.get(position));
            return mViewList.get(position);
        }

        @Override
        public void destroyItem(ViewGroup container, int position, Object object) {
            container.removeView(mViewList.get(position));
        }

        @Override
        public CharSequence getPageTitle(int position) {
            return mTitleList.get(position);
        }

    }

}
