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
import com.share.bag.ui.activitys.mine.AddressActivity;
import com.share.bag.ui.activitys.mine.LoginActivity;
import com.share.bag.utils.okhttp.OkHttpUtils;
import com.share.bag.utils.okhttp.callback.MyNetWorkCallback;

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
    private List<AddressBean.InfoBean>  info=new ArrayList<>();
    private List<AddBean1>list=new ArrayList();
    private TextView yincangpanduan;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_harvest);
        initView();
//        initdata();
        harvest_recycler.setLayoutManager(new LinearLayoutManager(this));
        AddressAdapter adapter = new AddressAdapter(HarvestActivity.this,list );//适配器
        harvest_recycler.setAdapter(adapter);

    }

    private void initdata() {

//        String addurl="http://baobaoapi.ldlchat.com/Home/Personalcenter/getUserContent.html";

        Map<String,String> addmap=new HashMap<>();

        OkHttpUtils.getInstance().post(SBUrls.CHECK_RECEIVING, addmap, new MyNetWorkCallback<AddressBean>() {
            @Override
            public void onSuccess(AddressBean addressBean) throws JSONException {

           info = addressBean.getInfo();
                for (int i = 0; i < info.size(); i++) {
                    String id = info.get(i).getId();
                    String address = info.get(i).getAddress();
                    String username = info.get(i).getUsername();
                    String phone = info.get(i).getPhone();
                    String is_type = info.get(i).getIs_type();
                    AddBean1 addBean1=new AddBean1(id,address,username,phone,is_type);
                    list.add(addBean1);
                }

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


//                Toast.makeText(this, "新增地址", Toast.LENGTH_SHORT).show();
                startActivityForResult(AddressActivity.getIntent(this),1);

                break;
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if(requestCode==1&&resultCode==1){
//            ed.setText(data.getStringExtra("text"));

            initdata();
        }

//        initdata();


    }

    @Override
    protected void onRestart() {
        super.onRestart();
        FileUtil.SelectedreadFromPre(this,yincangpanduan);
        if (yincangpanduan.getText().equals("")) {//登录
            Intent intent = new Intent(this, LoginActivity.class);
            startActivity(intent);
        } else {

            initdata();
        }


    }

    @Override
    protected void onResume() {
        super.onResume();

        initdata();


    }

//    @Override
//    public void onActivityReenter(int resultCode, Intent data) {
//        super.onActivityReenter(resultCode, data);
//
//
//
//
//
//
//    }

    //    @Override
//    protected void onResume() {
//        super.onResume();
//
//        initdata();
//
//
//    }
}
