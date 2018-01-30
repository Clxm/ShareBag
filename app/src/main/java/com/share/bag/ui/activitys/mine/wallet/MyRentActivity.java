package com.share.bag.ui.activitys.mine.wallet;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.share.bag.R;

/*
* 租金
* */
public class MyRentActivity extends AppCompatActivity {

    private ImageView myrent_return;
    private TextView myrent_amount;
    private ListView promotion_listview;
    private LinearLayout myrent_withdraw;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rent2);
        initView();
    }

    private void initView() {
        myrent_return = (ImageView) findViewById(R.id.myrent_return);
        myrent_amount = (TextView) findViewById(R.id.myrent_amount);
        promotion_listview = (ListView) findViewById(R.id.promotion_listview);
        myrent_withdraw = (LinearLayout) findViewById(R.id.myrent_withdraw);
        myrent_return.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
        myrent_withdraw.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(MyRentActivity.this, "租金提现", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
