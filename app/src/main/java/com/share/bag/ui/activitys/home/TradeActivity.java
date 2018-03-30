package com.share.bag.ui.activitys.home;

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

public class TradeActivity extends AppCompatActivity {

    private ImageView Trade_return;
    private ImageView Trade_replace;
    private RecyclerView Trade_recycler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_trade2);
        initView();

        getdata();
        Trade_return.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

    }


    public void getdata() {
        Map<String,String> map=new HashMap<>();
        OkHttpUtils.getInstance().post(SBUrls.CHANGE, map, new MyNetWorkCallback<TradeBean>() {
            @Override
            public void onSuccess(TradeBean tradeBean) throws JSONException {
                List<TradeBean.InfoBean> info = tradeBean.getInfo();

                Trade_recycler.setLayoutManager(new StaggeredGridLayoutManager(2,StaggeredGridLayoutManager.VERTICAL));
                Trade1Adapter adapter = new Trade1Adapter(TradeActivity.this, info);
                Trade_recycler.setAdapter(adapter);

            }

            @Override
            public void onError(int errorCode, String errorMsg) {

            }
        });

    }


    private void initView() {
        Trade_return = (ImageView) findViewById(R.id.Trade_return);
        Trade_replace = (ImageView) findViewById(R.id.Trade_replace);
        Trade_recycler = (RecyclerView) findViewById(R.id.Trade_recycler);
    }


}
