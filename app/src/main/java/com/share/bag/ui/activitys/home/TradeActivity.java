package com.share.bag.ui.activitys.home;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.widget.ImageView;

import com.share.bag.R;

public class TradeActivity extends AppCompatActivity {

    private ImageView Trade_return;
    private ImageView Trade_replace;
    private RecyclerView Trade_recycler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_trade2);
        initView();



    }

    private void initView() {
        Trade_return = (ImageView) findViewById(R.id.Trade_return);
        Trade_replace = (ImageView) findViewById(R.id.Trade_replace);
        Trade_recycler = (RecyclerView) findViewById(R.id.Trade_recycler);
    }
}
