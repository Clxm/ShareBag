package com.share.bag.ui.fragments.collection;

import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.View;
import android.widget.TextView;

import com.share.bag.LikeAdapter;
import com.share.bag.R;
import com.share.bag.SBUrls;
import com.share.bag.base.BaseFragment;
import com.share.bag.entity.*;
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

    private TextView collection_management;
    private RecyclerView collection_recycler,collection_recycler2;

    @Override
    public int initLayout() {
        return R.layout.eye_fragment;
    }

    @Override
    public void initView(View view) {

        collection_management = view.findViewById(R.id.collection_management);

        collection_recycler = view.findViewById(R.id.collection_recycler);
        collection_recycler2 = view.findViewById(R.id.collection_recycler2);
    }

    @Override
    protected void initData() {
        getinitData();
        getinitData1();

    }
    public void getinitData() {
        /*
        *    List<LikeBean.InfoBean> info = likeBean.getInfo();
                collection_recycler.setLayoutManager(new StaggeredGridLayoutManager(2,StaggeredGridLayoutManager.VERTICAL));

                LikeAdapter likeAdapter=new LikeAdapter(getContext(),info);
                collection_recycler.setAdapter(likeAdapter);
        * */
        Map<String,String > stringMap= new HashMap<>();

        OkHttpUtils.getInstance().post(SBUrls.COLLECTION, stringMap, new MyNetWorkCallback<CollectionLookBean>() {
            @Override
            public void onSuccess(CollectionLookBean collectionLookBean) throws JSONException {
                List<CollectionLookBean.InfoBean> info = collectionLookBean.getInfo();


                collection_recycler.setLayoutManager(new StaggeredGridLayoutManager(2,StaggeredGridLayoutManager.VERTICAL));


                CoollectionAdapter likeAdapter=new CoollectionAdapter(getContext(),info);
                collection_recycler.setAdapter(likeAdapter);


            }

            @Override
            public void onError(int errorCode, String errorMsg) {

            }
        });
    }


/*
*   猜你喜欢
*
 *  */
    public void getinitData1() {
        Map<String,String > stringMap= new HashMap<>();

        OkHttpUtils.getInstance().post(SBUrls.LIKE, stringMap, new MyNetWorkCallback<LikeBean>() {
            @Override
            public void onSuccess(LikeBean likeBean) throws JSONException {

                List<LikeBean.InfoBean> info = likeBean.getInfo();
                collection_recycler2.setLayoutManager(new StaggeredGridLayoutManager(2,StaggeredGridLayoutManager.VERTICAL));

                LikeAdapter likeAdapter=new LikeAdapter(getContext(),info);
                collection_recycler2.setAdapter(likeAdapter);

            }

            @Override
            public void onError(int errorCode, String errorMsg) {

            }
        });
    }


}
