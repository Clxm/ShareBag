package com.share.bag.ui.ship;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.share.bag.R;
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
public class ShipActivity extends AppCompatActivity {

    private ImageView ship_return;
    private TextView ship_name;
    private TabLayout ship_tabs;
    private ViewPager ship_vp_view;


    private LayoutInflater mInflater;
    private List<String> mTitleList = new ArrayList<>();//页卡标题集合
    private View view1, view2, view3, view4;
    private List<View> mViewList = new ArrayList<>();//页卡视图集合
    private RecyclerView ship_recycler2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ship);
        initView();

//        Intent intent = getIntent();
//        intent.get
        String ship = getIntent().getStringExtra("ship");
        ship_name.setText(ship);


        mInflater = LayoutInflater.from(this);
        view1 = mInflater.inflate(R.layout.activity_ship1, null);
        view2 = mInflater.inflate(R.layout.activity_ship2, null);
        view3 = mInflater.inflate(R.layout.activity_ship3, null);
        view4 = mInflater.inflate(R.layout.activity_ship4, null);
//        view5 = mInflater.inflate(R.layout.activity_main5, null);

        //添加页卡视图
        mViewList.add(view1);
        mViewList.add(view2);
        mViewList.add(view3);
        mViewList.add(view4);

        //添加页卡标题
        mTitleList.add("代付款");
        mTitleList.add("代发货");
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
        getdata1();
        getdata2();
        getdata3();
        getdata4();
    }

    public void getdata1() {


    }

    public void getdata2() {


        String url2="http://baobaoapi.ldlchat.com/Home/Order/wait.html";

        Map<String,String> map=new HashMap<>();
        map.put("type",""+1);
/*
        for(String in:map.keySet()){

            String str = map.get(in);//得到每个key多对用value的值
            Toast.makeText(this, "======="+ str, Toast.LENGTH_SHORT).show();
            Log.e("TTT","------"+str);
        }*/

        OkHttpUtils.getInstance().get(url2, map, new MyNetWorkCallback<Object>() {
            @Override
            public void onSuccess(Object o) throws JSONException {

                Log.e("TTT","------"+o);

            }

            @Override
            public void onError(int errorCode, String errorMsg) {

            }
        });
//        OkHttpUtils.getInstance().get(url2, map, new MyNetWorkCallback<ShipBean2>() {
//
//
//            @Override
//            public void onSuccess(ShipBean2 shipBean2) throws JSONException {
////                List<ShipBean2.InfoBean> info = shipBean2.getInfo();
////
////                String id = info.get(0).getId();
//                Toast.makeText(ShipActivity.this, "-------", Toast.LENGTH_SHORT).show();
//
//
//            }
//
//            @Override
//            public void onError(int errorCode, String errorMsg) {
//
//            }
//        });



    }

    public void getdata3() {

    }

    public void getdata4() {

    }

    private void initView() {
        ship_return = (ImageView) findViewById(R.id.ship_return);
        ship_name = (TextView) findViewById(R.id.ship_name);
        ship_tabs = (TabLayout) findViewById(R.id.ship_tabs);
        ship_vp_view = (ViewPager) findViewById(R.id.ship_vp_view);
//        ship_recycler1 = (RecyclerView) findViewById(R.id.ship_recycler1);
        ship_recycler2 = (RecyclerView) findViewById(R.id.ship_recycler2);
//        ship_recycler3 = (RecyclerView) findViewById(R.id.ship_recycler3);
//        ship_recycler4 = (RecyclerView) findViewById(R.id.ship_recycler4);
    }


    public void gettitle() {
        ship_return.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
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
