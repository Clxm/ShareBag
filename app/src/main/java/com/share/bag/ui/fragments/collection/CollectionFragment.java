package com.share.bag.ui.fragments.collection;

import android.content.Intent;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.View;
import android.widget.TextView;

import com.share.bag.LikeAdapter;
import com.share.bag.R;
import com.share.bag.SBUrls;
import com.share.bag.base.BaseFragment;
import com.share.bag.entity.LikeBean;
import com.share.bag.ui.activitys.home.Details;
import com.share.bag.utils.okhttp.OkHttpUtils;
import com.share.bag.utils.okhttp.callback.MyNetWorkCallback;

import org.json.JSONException;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
* 收藏
* */
public class CollectionFragment extends BaseFragment {

    private RecyclerView collection_recycler, collection_recycler2;
    private CoollectionAdapter likeAdapter;

    @Override
    public int initLayout() {
        return R.layout.eye_fragment;
    }

    @Override
    public void initView(View view) {
        collection_recycler = view.findViewById(R.id.collection_recycler);
        collection_recycler2 = view.findViewById(R.id.collection_recycler2);
    }

    @Override
    protected void initData() {
        getinitData();
        getinitData1();
    }

    public void getinitData() {
        Map<String, String> stringMap = new HashMap<>();
        OkHttpUtils.getInstance().post(SBUrls.COLLECTION, stringMap, new MyNetWorkCallback<CollectionLookBean>() {
            @Override
            public void onSuccess(CollectionLookBean collectionLookBean) throws JSONException {
                final List<CollectionLookBean.InfoBean> info = collectionLookBean.getInfo();
                if (info != null && info.size() != 0) {
                    collection_recycler.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false));
                    collection_recycler.setNestedScrollingEnabled(false);
                    collection_recycler.addItemDecoration(new DividerItemDecoration(getContext(), DividerItemDecoration.VERTICAL));
                    likeAdapter = new CoollectionAdapter(getContext(), info);

                    likeAdapter.setOnItemClickListener(new CoollectionAdapter.OnItemClickListener() {
                        @Override
                        public void onItemClick(View view, int position) {
                            String id = info.get(position).getId();
                            Intent intent = new Intent(getContext(), Details.class);
                            intent.putExtra("details", id);
                            startActivity(intent);
                        }
                    });
                    collection_recycler.setAdapter(likeAdapter);
                }
            }

            @Override
            public void onError(int errorCode, String errorMsg) {

            }
        });
    }


    //猜你喜欢
    public void getinitData1() {
        Map<String, String> stringMap = new HashMap<>();

        OkHttpUtils.getInstance().post(SBUrls.LIKE, stringMap, new MyNetWorkCallback<LikeBean>() {
            @Override
            public void onSuccess(LikeBean likeBean) throws JSONException {

                List<LikeBean.InfoBean> info = likeBean.getInfo();
                if (info != null && info.size() != 0) {
                    collection_recycler2.setLayoutManager(new GridLayoutManager(getContext(), 2, GridLayoutManager.VERTICAL, false));
                    collection_recycler2.setNestedScrollingEnabled(false);
                    LikeAdapter likeAdapter = new LikeAdapter(getContext(), info);
                    collection_recycler2.setAdapter(likeAdapter);
                }

            }

            @Override
            public void onError(int errorCode, String errorMsg) {

            }
        });
    }


}
