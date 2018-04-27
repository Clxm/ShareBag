package com.share.bag.ui.pay;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.share.bag.FileUtil;
import com.share.bag.R;
import com.share.bag.SBUrls;
import com.share.bag.response.DetailBuyUserInfo;
import com.share.bag.utils.ImageLoader;
import com.share.bag.utils.okhttp.OkHttpUtils;
import com.share.bag.utils.okhttp.callback.MyNetWorkCallback;

import org.json.JSONException;

import java.util.HashMap;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/*
* 确认买
* */
public class BuyActivity extends AppCompatActivity {

    @BindView(R.id.tv_buy_brand)
    TextView mTvBuyBrand;
    @BindView(R.id.tv_buy_number)
    TextView mTvBuyNumber;
    @BindView(R.id.tv_buy_color)
    TextView mTvBuyColor;
    @BindView(R.id.tv_buy_material)
    TextView mTvBuyMaterial;
    @BindView(R.id.tv_buy_size)
    TextView mTvBuySize;
    @BindView(R.id.buy_return)
    ImageView mBuyReturn;
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

    private String mImgUrl;
    private String mTitle;
    private String mBagBrand;
    private String mNumber;
    private String mColor;
    private String mMaterial;
    private String mBagSize;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_buy);
        ButterKnife.bind(this);
        initView();
        getUserInfo();


        rent_submit_order.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
    }


    //获取用户昵称 地址
    private void getUserInfo() {
        HashMap<String, String> mapParams = new HashMap<>();
        String userId = FileUtil.getUserId(this);
        mapParams.put("userid", userId);
        OkHttpUtils.getInstance().post(SBUrls.DETAIL_GET_USER_INFO, mapParams, new MyNetWorkCallback<DetailBuyUserInfo>() {
            @Override
            public void onSuccess(DetailBuyUserInfo detailUserInfo) throws JSONException {
                if ("1".equals(detailUserInfo.getStatus())) {
                    List<DetailBuyUserInfo.InfoBean> response = detailUserInfo.getInfo();
                    for (int i = 0; i < response.size(); i++) {
                        buy_rent.setText(response.get(i).getUsername());
                        buy_phone.setText(response.get(i).getPhone());
                        buy_address1.setText(response.get(i).getAddress());
                    }
                }
            }

            @Override
            public void onError(int errorCode, String errorMsg) {

            }
        });
    }


    private void initView() {
        if (getIntent() != null) {
            Intent intent = getIntent();
            mImgUrl = intent.getStringExtra("imgUrl");
            mTitle = intent.getStringExtra("title");
            mBagBrand = intent.getStringExtra("bagBrand");
            mNumber = intent.getStringExtra("number");
            mColor = intent.getStringExtra("color");
            mMaterial = intent.getStringExtra("material");
            mBagSize = intent.getStringExtra("bagSize");

        }

//        imageView3 = (ImageView) findViewById(R.id.imageView3);
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
//        buy_freight = (TextView) findViewById(R.id.buy_freight);
        buy_exchange = (TextView) findViewById(R.id.buy_exchange);
        buy_handle = (TextView) findViewById(R.id.buy_handle);
        rent_total_amount = (TextView) findViewById(R.id.rent_total_amount);
        rent_submit_order = (LinearLayout) findViewById(R.id.rent_submit_order);

        setViewData();

    }

    private void setViewData() {
        String imgUrl = SBUrls.URL_HEAD + mImgUrl;
        ImageLoader.LoadLocalImg(buy_commodity_img, this, imgUrl);
        buy_commodity_name.setText(mTitle);
        mTvBuyBrand.setText(mBagBrand);
        mTvBuyNumber.setText(mNumber);
        mTvBuyColor.setText(mColor);
        mTvBuyMaterial.setText(mMaterial);
        mTvBuySize.setText(mBagSize);
    }

    @OnClick(R.id.buy_return)
    public void onClick() {
        finish();
    }
}
