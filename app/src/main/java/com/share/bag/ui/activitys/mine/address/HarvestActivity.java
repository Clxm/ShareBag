package com.share.bag.ui.activitys.mine.address;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.share.bag.R;
import com.share.bag.adapter.AddressAdapter;
import com.share.bag.entity.AddressBean;
import com.share.bag.ui.activitys.mine.AddressActivity;
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
    //    private TextView match_save;
    private RecyclerView harvest_recycler;
    private Button harvest_add;
    private List<AddressBean.InfoBean>  info=new ArrayList<>();
private List<AddBean1>list=new ArrayList();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_harvest);
        initView();
        initdata();


//        GridLayoutManager manager = ;
        harvest_recycler.setLayoutManager(new LinearLayoutManager(this));

//        harvest_recycler.setLayoutManager(new GridLayoutManager(getContext(), 1));
        AddressAdapter adapter = new AddressAdapter(HarvestActivity.this,list );//适配器
        harvest_recycler.setAdapter(adapter);

//        Toast.makeText(this, "走完了", Toast.LENGTH_SHORT).show();
    }

    private void initdata() {

        String addurl="http://baobaoapi.ldlchat.com/Home/Personalcenter/getUserContent.html";

        Map<String,String> addmap=new HashMap<>();

        OkHttpUtils.getInstance().post(addurl, addmap, new MyNetWorkCallback<AddressBean>() {
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
        }




    }
}
