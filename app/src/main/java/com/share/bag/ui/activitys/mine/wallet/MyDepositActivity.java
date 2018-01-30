package com.share.bag.ui.activitys.mine.wallet;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.share.bag.R;

/*
* 押金
* */
public class MyDepositActivity extends AppCompatActivity implements View.OnClickListener {

    private ImageView myrent_return;
    private TextView myrent_total;
    private Button myrent_charge;
    private Button myrent_retreat;
    private Button myrent_freeze;
    private TextView myrent_history;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_deposit);
        initView();


        myrent_freeze.setText("冻结押金￥"+"100.00");
        myrent_total.setText("￥"+"100.00");
    }

    private void initView() {
        myrent_return = (ImageView) findViewById(R.id.myrent_return);
        myrent_total = (TextView) findViewById(R.id.myrent_total);
        myrent_charge = (Button) findViewById(R.id.myrent_charge);
        myrent_retreat = (Button) findViewById(R.id.myrent_retreat);
        myrent_freeze = (Button) findViewById(R.id.myrent_freeze);
        myrent_history = (TextView) findViewById(R.id.myrent_history);
        myrent_return.setOnClickListener(this);
        myrent_charge.setOnClickListener(this);
        myrent_retreat.setOnClickListener(this);
        myrent_history.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.myrent_return:
             finish();
                break;
            case R.id.myrent_charge:
                Toast.makeText(this, "充值", Toast.LENGTH_SHORT).show();
                break;
            case R.id.myrent_retreat:
                Toast.makeText(this, "提现", Toast.LENGTH_SHORT).show();
                break;
            case R.id.myrent_history:
                Toast.makeText(this, "历史记录", Toast.LENGTH_SHORT).show();
                break;
        }
    }
}
