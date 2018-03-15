package com.share.bag.ui.activitys.collection;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.View;
import android.widget.ImageView;

import com.share.bag.R;
import com.share.bag.adapter.TalentAdapter;
import com.share.bag.entity.TalentBean;
import com.share.bag.utils.okhttp.OkHttpUtils;
import com.share.bag.utils.okhttp.callback.MyNetWorkCallback;

import org.json.JSONException;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
* 包包达人
* */
public class TalentActivity extends AppCompatActivity {

    private ImageView talent_return;
    private RecyclerView talent_listview;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_talent);
        initView();
        initdata();

    }

    private void initdata() {

            String  str="http://baobaoapi.ldlchat.com/Home/Cabinet/masterlist.html";
            Map<String, String> map = new HashMap<>();
            try {
                //请求网络
                OkHttpUtils.getInstance().post(str, map, new MyNetWorkCallback<TalentBean>() {
                    @Override
                    public void onSuccess(TalentBean talentBean) throws JSONException {
                        List<TalentBean.InfoBean> info = talentBean.getInfo();
                        
                        talent_listview.setLayoutManager(new StaggeredGridLayoutManager(1,StaggeredGridLayoutManager.VERTICAL));

                        TalentAdapter adapter = new TalentAdapter(TalentActivity.this,info);

                        talent_listview.setAdapter(adapter);

                    }

                    @Override
                    public void onError(int errorCode, String errorMsg) {

                    }
                });
            }catch (Exception e){

            }






    }

    private void initView() {
        talent_return = (ImageView) findViewById(R.id.talent_return);
        talent_listview = (RecyclerView) findViewById(R.id.talent_recycler);

        talent_return.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }

}













/*
//
//
//    @Override
//    public int initLayout() {
//        return R.layout.activity_talent;
//    }
//
//    @Override
//    public void initView() {
//
//    }
//
//    @Override
//    protected void initData() {
//
//    }
//
//    @Override
//    protected boolean hodeWindow() {
//        return false;
//    }*/