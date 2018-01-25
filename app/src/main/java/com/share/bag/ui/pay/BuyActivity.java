package com.share.bag.ui.pay;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.share.bag.R;

/*
* 确认买
* */
public class BuyActivity extends AppCompatActivity {

    private ImageView buy_return;
    private ImageView imageView3;
    private TextView buy_rent;
    private TextView buy_phone;
    private TextView buy_address1;
    private RelativeLayout buy_address;
    private ImageView buy_commodity_img;
    private TextView buy_commodity_name;
    private TextView buy_commodity_brand;
    private TextView buy_commodity_numbering;
    private TextView buy_commodity_color;
    private TextView buy_commodity_material;
    private TextView buy_commodity_size;
    private TextView buy_price;
    private TextView buy_freight;
    private TextView buy_exchange;
    private TextView buy_handle;
    private TextView rent_total_amount;
    private LinearLayout rent_submit_order;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_buy);
        initView();



        rent_submit_order.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
    }

    private void initView() {
        buy_return = (ImageView) findViewById(R.id.buy_return);
        imageView3 = (ImageView) findViewById(R.id.imageView3);
        buy_rent = (TextView) findViewById(R.id.buy_rent);
        buy_phone = (TextView) findViewById(R.id.buy_phone);
        buy_address1 = (TextView) findViewById(R.id.buy_address1);
        buy_address = (RelativeLayout) findViewById(R.id.buy_address);
        buy_commodity_img = (ImageView) findViewById(R.id.buy_commodity_img);
        buy_commodity_name = (TextView) findViewById(R.id.buy_commodity_name);
        buy_commodity_brand = (TextView) findViewById(R.id.buy_commodity_brand);
        buy_commodity_numbering = (TextView) findViewById(R.id.buy_commodity_numbering);
        buy_commodity_color = (TextView) findViewById(R.id.buy_commodity_color);
        buy_commodity_material = (TextView) findViewById(R.id.buy_commodity_material);
        buy_commodity_size = (TextView) findViewById(R.id.buy_commodity_size);
        buy_price = (TextView) findViewById(R.id.buy_price);
        buy_freight = (TextView) findViewById(R.id.buy_freight);
        buy_exchange = (TextView) findViewById(R.id.buy_exchange);
        buy_handle = (TextView) findViewById(R.id.buy_handle);
        rent_total_amount = (TextView) findViewById(R.id.rent_total_amount);
        rent_submit_order = (LinearLayout) findViewById(R.id.rent_submit_order);







    }
}
