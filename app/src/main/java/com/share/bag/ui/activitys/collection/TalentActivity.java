package com.share.bag.ui.activitys.collection;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.View;
import android.widget.ImageView;

import com.share.bag.R;

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
        talent_listview.setLayoutManager(new StaggeredGridLayoutManager(1,StaggeredGridLayoutManager.VERTICAL));

//        TalentAdapter adapter = new TalentAdapter(TalentActivity.this,list);

//        talent_listview.setAdapter(adapter);

    }

    private void initdata() {

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