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
import com.share.bag.SBUrls;
import com.share.bag.ui.activitys.mine.wallet.MyTradeActivity;
import com.share.bag.utils.okhttp.OkHttpUtils;
import com.share.bag.utils.okhttp.callback.MyNetWorkCallback;

import org.json.JSONException;

import java.util.HashMap;
import java.util.Map;

/*
* 我的钱包
* */
public class WalletActivity extends AppCompatActivity implements View.OnClickListener {


    private ImageView wallet_return;
    private TextView wallet_amount;
    private TextView wallet_deposit;
    private LinearLayout wallet_voucher;
//    private LinearLayout wallet_promotion;
    private LinearLayout wallet_monthly_card;
    private LinearLayout wallet_bill;
    private LinearLayout wallet_withdraw;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_wallet);
        initView();

        getdata();

    }

    private void initView() {
        wallet_return = (ImageView) findViewById(R.id.wallet_return);
        wallet_amount = (TextView) findViewById(R.id.wallet_amount);//金额
        wallet_deposit = (TextView) findViewById(R.id.wallet_deposit);//押金
        wallet_voucher = (LinearLayout) findViewById(R.id.wallet_voucher);
//        wallet_promotion = (LinearLayout) findViewById(R.id.wallet_promotion);
        wallet_monthly_card = (LinearLayout) findViewById(R.id.wallet_monthly_card);
        wallet_bill = (LinearLayout) findViewById(R.id.wallet_bill);
        wallet_withdraw = (LinearLayout) findViewById(R.id.wallet_withdraw);

        wallet_return.setOnClickListener(this);
        wallet_voucher.setOnClickListener(this);
//        wallet_promotion.setOnClickListener(this);
        wallet_monthly_card.setOnClickListener(this);
        wallet_bill.setOnClickListener(this);
        wallet_withdraw.setOnClickListener(this);
    }

   @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.wallet_return:
                finish();
                break;
            case R.id.wallet_voucher://卡卷
                Intent intent4=new Intent(WalletActivity.this, MyTradeActivity.class);
                startActivity(intent4);
//                Toast.makeText(this, "卡卷", Toast.LENGTH_SHORT).show();
                break;
//            case R.id.wallet_promotion:
//                //推广佣金
//                Intent intent1=new Intent(WalletActivity.this, PromotionActivity.class);
//                startActivity(intent1);
//                break;
            case R.id.wallet_monthly_card://月卡办理

                Toast.makeText(this, "暂缓开通,敬请谅解", Toast.LENGTH_SHORT).show();


//                Intent intent=new Intent(WalletActivity.this, CardActivity.class);
//
//                intent.putExtra("","");
//                intent.putExtra("","");
//                intent.putExtra("","");
//                intent.putExtra("","");
//                intent.putExtra("","");
//
//                startActivity(intent);

                break;
            case R.id.wallet_bill://账单

                Toast.makeText(this, "账单", Toast.LENGTH_SHORT).show();
                break;
            case R.id.wallet_withdraw://提现

                Toast.makeText(this, "提现", Toast.LENGTH_SHORT).show();
                break;

//            case R.id.wallet_coupons:
//                Intent intent5=new Intent(WalletActivity.this, RedCouponsActivity.class);
//                startActivity(intent5);
//                break;
//
//            case R.id.wallet_renewed://以旧换新
//                Intent intent4=new Intent(WalletActivity.this, MyTradeActivity.class);
//                startActivity(intent4);
//
//                break;
//            case R.id.wallet_deposit://押金
//                Intent intent3=new Intent(WalletActivity.this, MyDepositActivity.class);
//                startActivity(intent3);
//
//                break;
//            case R.id.wallet_rent:
////                租金
//                Intent intent2=new Intent(WalletActivity.this, MyRentActivity.class);
//                startActivity(intent2);
//
//                break;
        }
    }

    public void getdata() {

        Map<String ,String>map=new HashMap<>();

        OkHttpUtils.getInstance().post(SBUrls.WALLET, map, new MyNetWorkCallback<WalletBean>() {
            @Override
            public void onSuccess(WalletBean walletBean) throws JSONException {
                WalletBean.InfoBean info = walletBean.getInfo();

                String balance = info.getBalance();
                String foregift = info.getForegift();
                wallet_amount.setText(balance);
                wallet_deposit.setText(foregift);
            }

            @Override
            public void onError(int errorCode, String errorMsg) {

            }
        });
        
        
    }
}
