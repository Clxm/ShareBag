package com.share.bag.ui.activitys.mine;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.share.bag.R;
import com.share.bag.ui.activitys.mine.wallet.CardActivity;
import com.share.bag.ui.activitys.mine.wallet.MyRentActivity;
import com.share.bag.ui.activitys.mine.wallet.PromotionActivity;

/*
* 我的钱包
* */
public class WalletActivity extends AppCompatActivity implements View.OnClickListener {

    private ImageView wallet_return;
    private TextView wallet_amount;
    private TextView wallet_recharge;
    private LinearLayout wallet_coupons;
    private LinearLayout wallet_renewed;
    private LinearLayout wallet_deposit;
    private LinearLayout wallet_rent;
    private LinearLayout wallet_commission;
    private LinearLayout wallet_card;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_wallet);
        initView();



        /**/

    }

    private void initView() {
        wallet_return = (ImageView) findViewById(R.id.wallet_return);
        wallet_amount = (TextView) findViewById(R.id.wallet_amount);
        wallet_recharge = (TextView) findViewById(R.id.wallet_recharge);
        wallet_coupons = (LinearLayout) findViewById(R.id.wallet_coupons);
        wallet_renewed = (LinearLayout) findViewById(R.id.wallet_renewed);
        wallet_deposit = (LinearLayout) findViewById(R.id.wallet_deposit);
        wallet_rent = (LinearLayout) findViewById(R.id.wallet_rent);
        wallet_commission = (LinearLayout) findViewById(R.id.wallet_commission);
        wallet_card = (LinearLayout) findViewById(R.id.wallet_card);
        wallet_return.setOnClickListener( this);

        wallet_recharge.setOnClickListener(this);
        wallet_coupons.setOnClickListener(this);
        wallet_renewed.setOnClickListener(this);
        wallet_deposit.setOnClickListener(this);
        wallet_rent.setOnClickListener(this);
        wallet_commission.setOnClickListener(this);
        wallet_card.setOnClickListener(this);
        wallet_amount.setText("100.00");

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.wallet_return:
                finish();
                break;

            case R.id.wallet_recharge://充值

                Toast.makeText(this, "充值", Toast.LENGTH_SHORT).show();
                break;
            case R.id.wallet_coupons:

                Toast.makeText(this, "eeeeeeeeeee", Toast.LENGTH_SHORT).show();
                break;

            case R.id.wallet_renewed:

                Toast.makeText(this, "eeeeeeeeeee", Toast.LENGTH_SHORT).show();
                break;
            case R.id.wallet_deposit:
                Intent intent3=new Intent(WalletActivity.this, MyRentActivity.class);


                startActivity(intent3);
                Toast.makeText(this, "eeeeeeeeeee", Toast.LENGTH_SHORT).show();
                break;
            case R.id.wallet_rent:
//                租金
                Intent intent2=new Intent(WalletActivity.this, MyRentActivity.class);


                startActivity(intent2);

                break;
            case R.id.wallet_commission:
                //推广佣金
                Intent intent1=new Intent(WalletActivity.this, PromotionActivity.class);


                startActivity(intent1);
                break;
            case R.id.wallet_card://月卡办理
//                月卡办理
                Intent intent=new Intent(WalletActivity.this, CardActivity.class);

                intent.putExtra("","");
                intent.putExtra("","");
                intent.putExtra("","");
                intent.putExtra("","");
                intent.putExtra("","");

                startActivity(intent);

                break;


        }
    }


}
