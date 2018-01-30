package com.share.bag.ui.activitys.mine.wallet;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.ListView;

import com.share.bag.R;

/*
* 以旧换新
* */
public class MyTradeActivity extends AppCompatActivity {

    private ImageView mydeposit_return;
    private ListView mydeposit_listview;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_trade);
        initView();
        mydeposit_return.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }

    private void initView() {
        mydeposit_return = (ImageView) findViewById(R.id.mydeposit_return);
        mydeposit_listview = (ListView) findViewById(R.id.mydeposit_listview);
    }
}
