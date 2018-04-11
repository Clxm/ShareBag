package com.share.bag.ui.activitys;


import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.share.bag.R;
import com.share.bag.adapter.PopularAdapter;
import com.share.bag.base.BaseActivity;
import com.share.bag.ui.activitys.home.DetailsBean;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author : TianFB
 * @Date : 2018/4/10
 * @Desrcibe ：
 */

public class SearchBagDetail extends BaseActivity {

    private RecyclerView mRcycler;
    List<DetailsBean.InfoBean> mList = new ArrayList<>();
    private PopularAdapter mAdapter;

    @Override
    protected void onStart() {
        super.onStart();
        EventBus.getDefault().register(this);
    }

    @Override
    protected void onStop() {
        super.onStop();
        EventBus.getDefault().unregister(this);
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onEvent(DetailsBean bean) {
        mList.addAll(bean.getInfo());
        mAdapter.notifyDataSetChanged();
    }

    @Override
    public int initLayout() {
        return R.layout.activity_searchbagdetail;
    }

    @Override
    public void initView() {
        mRcycler = (RecyclerView) findViewById(R.id.searchbagdetail_recyclerview);
        findViewById(R.id.searchDetails_return).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
        mRcycler.setLayoutManager(new GridLayoutManager(this,2));
        mAdapter = new PopularAdapter(this, mList);
        mRcycler.setAdapter(mAdapter);
    }

    @Override
    protected void initData() {
    }

    @Override
    protected boolean hodeWindow() {
        return false;
    }
}
