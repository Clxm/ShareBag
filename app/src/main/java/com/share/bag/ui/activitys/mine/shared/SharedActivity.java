package com.share.bag.ui.activitys.mine.shared;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.View;
import android.widget.ImageView;

import com.share.bag.R;
import com.share.bag.SBUrls;
import com.share.bag.utils.okhttp.OkHttpUtils;
import com.share.bag.utils.okhttp.callback.MyNetWorkCallback;

import org.json.JSONException;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
/*
* 正在共享
* */
public class SharedActivity extends AppCompatActivity {

    private ImageView shared_return;
    private RecyclerView shared_recycler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shared);
        initView();
        getdata();
        shared_return.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }

    public void getdata() {
        Map<String,String>map=new HashMap<>();
        OkHttpUtils.getInstance().post(SBUrls.SHARED, map, new MyNetWorkCallback<SharedBean>() {
            @Override
            public void onSuccess(SharedBean sharedBean) throws JSONException {
                List<SharedBean.InfoBean> info = sharedBean.getInfo();
                shared_recycler.setLayoutManager(new StaggeredGridLayoutManager(1,StaggeredGridLayoutManager.VERTICAL));

                SharedAdapter sharedAdapter=new SharedAdapter(SharedActivity.this,info);
                shared_recycler.setAdapter(sharedAdapter);

            }

            @Override
            public void onError(int errorCode, String errorMsg) {

            }
        });

    }

    private void initView() {
        shared_return = (ImageView) findViewById(R.id.shared_return);
        shared_recycler = (RecyclerView) findViewById(R.id.shared_recycler);
    }
}
