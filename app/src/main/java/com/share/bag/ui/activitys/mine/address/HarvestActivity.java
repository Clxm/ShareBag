package com.share.bag.ui.activitys.mine.address;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.share.bag.FileUtil;
import com.share.bag.R;
import com.share.bag.SBUrls;
import com.share.bag.adapter.AddressAdapter;
import com.share.bag.entity.AddressBean;
import com.share.bag.ui.activitys.mine.AddBean;
import com.share.bag.ui.activitys.mine.AddressActivity;
import com.share.bag.ui.activitys.mine.Login;
import com.share.bag.utils.okhttp.OkHttpUtils;
import com.share.bag.utils.okhttp.callback.MyNetWorkCallback;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;
import org.json.JSONException;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
* 收货地址
* */
public class HarvestActivity extends AppCompatActivity implements View.OnClickListener {

    private ImageView match_return;
    private RecyclerView harvest_recycler;
    private Button harvest_add;
    private List<AddBean1>list=new ArrayList();
    private TextView yincangpanduan;
    private AddressAdapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EventBus.getDefault().register(this);
        setContentView(R.layout.activity_harvest);
        initView();
        harvest_recycler.setLayoutManager(new LinearLayoutManager(this));
        //适配器
        mAdapter = new AddressAdapter(HarvestActivity.this,list );
        harvest_recycler.setAdapter(mAdapter);
        initdata();
    }
    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onMessageEvent(AddBean bean){
        initdata();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        EventBus.getDefault().unregister(this);
    }
    private void initdata() {

//        String addurl="htmltp://baobaoapi.ldlchat.com/Home/Personalcenter/getUserContent.html";

        Map<String,String> addmap=new HashMap<>();

        OkHttpUtils.getInstance().post(SBUrls.CHECK_RECEIVING, addmap, new MyNetWorkCallback<AddressBean>() {
            @Override
            public void onSuccess(AddressBean addressBean) throws JSONException {
                list.clear();
                List<AddressBean.InfoBean>  info = addressBean.getInfo();
                    for (int i = 0; i < info.size(); i++) {
                        String id = info.get(i).getId();
                        String address = info.get(i).getAddress();
                        String username = info.get(i).getUsername();
                        String phone = info.get(i).getPhone();
                        String is_type = info.get(i).getIs_type();
                        AddBean1 addBean1 = new AddBean1(id, address, username, phone, is_type);
                        list.add(addBean1);
                }
                mAdapter.notifyDataSetChanged();

            }

            @Override
            public void onError(int errorCode, String errorMsg) {

            }
        });

    }

    private void initView() {
        match_return = (ImageView) findViewById(R.id.match_return);
        yincangpanduan = (TextView) findViewById(R.id.yincangpanduan);
        harvest_recycler = (RecyclerView) findViewById(R.id.harvest_recycler);
        harvest_add = (Button) findViewById(R.id.harvest_add);
        harvest_add.setOnClickListener(this);
        match_return.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }


    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.harvest_add:
                startActivityForResult(AddressActivity.getIntent(this),1);
                break;
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode==1&&resultCode==1){
            initdata();
        }
    }



}
