package com.share.bag.ui.activitys.mine.wallet;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import com.share.bag.R;

/*
* 月卡办理
* */
public class CardActivity extends AppCompatActivity {

    private ImageView card_buy;
    private ImageView card_return;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_card);
        initView();
        card_return.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
        card_buy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(CardActivity.this, "点击了图片", Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void initView() {
        card_buy = (ImageView) findViewById(R.id.card_buy);
        card_return = (ImageView) findViewById(R.id.card_return);
    }
}
