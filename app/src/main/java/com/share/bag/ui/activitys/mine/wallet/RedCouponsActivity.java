package com.share.bag.ui.activitys.mine.wallet;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.ListView;

import com.share.bag.R;

/*
* 红包卷
* */
public class RedCouponsActivity extends AppCompatActivity {

    private ImageView redcoupons_return;
    private ListView redcoupons_listview;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_red_coupons);
        initView();
        redcoupons_return.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }

    private void initView() {
        redcoupons_return = (ImageView) findViewById(R.id.redcoupons_return);
        redcoupons_listview = (ListView) findViewById(R.id.redcoupons_listview);
    }
}
