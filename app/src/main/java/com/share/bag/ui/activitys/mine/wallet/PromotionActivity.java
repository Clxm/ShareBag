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
* 月卡办理
* */
public class PromotionActivity extends AppCompatActivity {

    private ImageView promotion_return;
    private TextView promotion_amount;
    private ListView promotion_listview;
    private LinearLayout promotion_withdraw;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_promotion);
        initView();
    }

    private void initView() {
        promotion_return = (ImageView) findViewById(R.id.promotion_return);
        promotion_amount = (TextView) findViewById(R.id.promotion_amount);
        promotion_listview = (ListView) findViewById(R.id.promotion_listview);
        promotion_withdraw = (LinearLayout) findViewById(R.id.promotion_withdraw);

        promotion_return.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
        promotion_withdraw.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(PromotionActivity.this, "提现", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
