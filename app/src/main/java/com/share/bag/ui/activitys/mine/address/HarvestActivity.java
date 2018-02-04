package com.share.bag.ui.activitys.mine.address;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.widget.ImageView;

import com.share.bag.R;

public class HarvestActivity extends AppCompatActivity {

    private ImageView match_return;
//    private TextView match_save;
    private RecyclerView harvest_recycler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_harvest);
        initView();
        initdata();
    }

    private void initdata() {


    }

    private void initView() {
        match_return = (ImageView) findViewById(R.id.match_return);
//        match_save = (TextView) findViewById(R.id.match_save);
        harvest_recycler = (RecyclerView) findViewById(R.id.harvest_recycler);
    }



}
