package com.share.bag.ui.pay;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.alipay.sdk.app.PayTask;
import com.share.bag.FileUtil;
import com.share.bag.R;
import com.share.bag.SBUrls;
import com.share.bag.alipay.AuthResult;
import com.share.bag.alipay.PayResult;
import com.share.bag.entity.MayBean;
import com.share.bag.entity.MayBean1;
import com.share.bag.response.DetailBuyUserInfo;
import com.share.bag.ui.activitys.mine.address.HarvestActivity;
import com.share.bag.utils.ImageLoader;
import com.share.bag.utils.ToastUtils;
import com.share.bag.utils.okhttp.OkHttpUtils;
import com.share.bag.utils.okhttp.callback.MyNetWorkCallback;
import com.tencent.mm.opensdk.modelpay.PayReq;
import com.tencent.mm.opensdk.openapi.IWXAPI;
import com.tencent.mm.opensdk.openapi.WXAPIFactory;
import com.umeng.socialize.utils.Log;

import org.json.JSONException;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import butterknife.BindView;
import butterknife.ButterKnife;

/*
* 确认买
* */
public class BuyActivity extends AppCompatActivity implements View.OnClickListener {

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
    @BindView(R.id.tv_buy_original_price)
    TextView mTvBuyOriginalPrice;
    @BindView(R.id.tv_buy_now_price)
    TextView mTvBuyNowPrice;
    @BindView(R.id.tv_buy_total_price)
    TextView mTvBuyTotalPrice;
    @BindView(R.id.btn_add_address)
    Button mBtnAddAddress;
    @BindView(R.id.rl_add_address)
    RelativeLayout mRlAddAddress;
    @BindView(R.id.iv_buy_change)
    ImageView mIvBuyChange;
    @BindView(R.id.tv_old_new_price)
    TextView mTvOldNewPrice;

    @BindView(R.id.tv_subtract)
    TextView mTvSubtract;
    @BindView(R.id.tv_add)
    TextView mTvAdd;
    @BindView(R.id.rl_old_new)
    RelativeLayout mRlOldNew;
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
    private String mOriginalPrice;
    private String mNowPrice;
    private PopupWindow window1;
    private LinearLayout pay_wx;
    private IWXAPI api;
    private String mBagId;
    private String mImgUrl1;
    private static final int SDK_PAY_FLAG = 1;
    private static final int SDK_AUTH_FLAG = 2;
    private String mAddress;
    private String mBalance;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_buy);
        ButterKnife.bind(this);
        api = WXAPIFactory.createWXAPI(this, "wx38f75c7fdb68b2bf");
        initView();
        getUserInfo();
    }

    //获取用户昵称 地址
    private void getUserInfo() {
        HashMap<String, String> mapParams = new HashMap<>();
        String userId = FileUtil.getUserId(this);
        mapParams.put("userid", userId);
        OkHttpUtils.getInstance().post(SBUrls.DETAIL_GET_USER_INFO, mapParams, new MyNetWorkCallback<DetailBuyUserInfo>() {
            @Override
            public void onSuccess(DetailBuyUserInfo detailUserInfo) throws JSONException {
                List<DetailBuyUserInfo.InfoBean> response = detailUserInfo.getInfo();
                if (null != response && response.size() > 0) {
                    buy_address.setVisibility(View.VISIBLE);
                    mRlAddAddress.setVisibility(View.GONE);
                    for (int i = 0; i < response.size(); i++) {
                        mAddress = response.get(i).getAddress();
                        buy_rent.setText(response.get(i).getUsername());
                        buy_phone.setText(response.get(i).getPhone());
                        buy_address1.setText(response.get(i).getAddress());
                    }
                } else {
                    buy_address.setVisibility(View.GONE);
                    mRlAddAddress.setVisibility(View.VISIBLE);
                }
            }

            @Override
            public void onError(int errorCode, String errorMsg) {

            }
        });
    }

    private String mOldNew = "";

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
            mOriginalPrice = intent.getStringExtra("originalPrice");
            mNowPrice = intent.getStringExtra("nowPrice");
            mBagId = intent.getStringExtra("bagId");
            mOldNew = intent.getStringExtra("oldNew");
            mBalance = intent.getStringExtra("balance");


        }

        if ("oldNew".equals(mOldNew)) {
            mRlOldNew.setVisibility(View.VISIBLE);
            mTvOldNewPrice.setText(mBalance);
        } else {
            mRlOldNew.setVisibility(View.GONE);
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
//        buy_price = (TextView) findViewById(R.id.buy_price);
////        buy_freight = (TextView) findViewById(R.id.buy_freight);
//        buy_exchange = (TextView) findViewById(R.id.buy_exchange);
//        buy_handle = (TextView) findViewById(R.id.buy_handle);
//        rent_total_amount = (TextView) findViewById(R.id.rent_total_amount);
        rent_submit_order = (LinearLayout) findViewById(R.id.rent_submit_order);
        setViewData();
        setViewOnClick();
    }

    private void setViewOnClick() {
        mBuyReturn.setOnClickListener(this);
        rent_submit_order.setOnClickListener(this);
        mBtnAddAddress.setOnClickListener(this);
        mIvBuyChange.setOnClickListener(this);
        mTvSubtract.setOnClickListener(this);
        mTvAdd.setOnClickListener(this);
    }

    private void setViewData() {
        //https://baobaoapi.ldlchat.com
        if (mImgUrl.indexOf("baobaoapi.ldlchat.com") < 0) {
            mImgUrl1 = SBUrls.LOGURL + mImgUrl;
        } else if (mImgUrl.indexOf("https://") < 0) {
            mImgUrl1 = SBUrls.URL_HEAD + mImgUrl;
        }
        ImageLoader.LoadLocalImg(buy_commodity_img, this, mImgUrl1);
        buy_commodity_name.setText(mTitle);
        mTvBuyBrand.setText(mBagBrand);
        mTvBuyNumber.setText(mNumber);
        mTvBuyColor.setText(mColor);
        mTvBuyMaterial.setText(mMaterial);
        mTvBuySize.setText(mBagSize);
        mTvBuyOriginalPrice.setText(mOriginalPrice);
        mTvBuyNowPrice.setText(mNowPrice);
        if ("".equals(mBalance)) {
            mTvBuyTotalPrice.setText(mNowPrice);
        } else {
            int nowPrice = Integer.parseInt(mNowPrice);
            int balance = Integer.parseInt(mBalance);
            mTvBuyTotalPrice.setText((nowPrice - balance) + "");
        }
    }

    @Override
    public void onClick(View view) {
        String balance = mTvOldNewPrice.getText().toString();
        int temp = Integer.parseInt(balance);
//        String totalPrice = mTvBuyTotalPrice.getText().toString();
        int totalPriceTemp = Integer.parseInt(mNowPrice);
        switch (view.getId()) {
            case R.id.buy_return:
                finish();
                break;
            case R.id.rent_submit_order:
                showPayWindow();
                break;
            case R.id.btn_add_address:
                Intent intent = new Intent(this, HarvestActivity.class);
                intent.putExtra("add", "add");
                startActivityForResult(intent, 101);
                break;
            case R.id.iv_buy_change:
                Intent intentC = new Intent(this, HarvestActivity.class);
                intentC.putExtra("add", "add");
                startActivityForResult(intentC, 101);
                break;
            case R.id.tv_subtract:
                if (temp <= 0) {
                    ToastUtils.showTop(BuyActivity.this, "最低可优惠0元");
                    mTvSubtract.clearFocus();
                    mTvSubtract.setFocusable(false);
//                    mTvBuyTotalPrice.setText(mNowPrice);
                } else {
                    mTvSubtract.setFocusable(true);
                    mTvSubtract.requestFocus();
                    temp--;
                    totalPriceTemp -= temp;
                    mTvOldNewPrice.setText(temp + "");
                    mTvBuyTotalPrice.setText(totalPriceTemp + "");
                }
                break;
            case R.id.tv_add:
                if (temp >= Integer.parseInt(mBalance)) {
                    ToastUtils.showTop(BuyActivity.this, "最高可优惠" + mBalance + "元");
                    mTvAdd.clearFocus();
                    mTvAdd.setFocusable(false);

                    int nowPrice2 = Integer.parseInt(mNowPrice);
                    int balance2 = Integer.parseInt(mBalance);
                    mTvBuyTotalPrice.setText((nowPrice2 - balance2) + "");
                } else {
                    mTvAdd.setFocusable(true);
                    mTvAdd.requestFocus();
                    temp++;
                    totalPriceTemp -= temp;
                    mTvOldNewPrice.setText(temp + "");
                    mTvBuyTotalPrice.setText(totalPriceTemp + "");
                }
                break;

        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 101 && resultCode == 102) {
            buy_address.setVisibility(View.VISIBLE);
            mBtnAddAddress.setVisibility(View.GONE);
            String userName = data.getStringExtra("userName");
            String phone = data.getStringExtra("phone");
            String address = data.getStringExtra("address");
            buy_rent.setText(userName);
            buy_phone.setText(phone);
            buy_address1.setText(address);
        }
    }

    private void showPayWindow() {
        WindowManager wm = (WindowManager) getApplication()
                .getSystemService(Context.WINDOW_SERVICE);

        final int width = wm.getDefaultDisplay().getWidth();
        int height = wm.getDefaultDisplay().getHeight();

        //设置contentView
        View contentView = LayoutInflater.from(this).inflate(R.layout.popupwindow_pay, null);
        window1 = new PopupWindow(contentView, width, height);
        window1.setContentView(contentView);
        //设置各个控件的点击响应
        LinearLayout pay_balance = (LinearLayout) contentView.findViewById(R.id.pay_balance);
        pay_wx = (LinearLayout) contentView.findViewById(R.id.pay_wx);
        LinearLayout pay_zfb = (LinearLayout) contentView.findViewById(R.id.pay_zfb);
        ImageView ivClose = contentView.findViewById(R.id.iv_close);
        ivClose.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (window1 != null)
                    window1.dismiss();
            }
        });

        //显示PopupWindow
        View rootview = LayoutInflater.from(this).inflate(R.layout.activity_buy, null);
        window1.showAtLocation(rootview, Gravity.CENTER, 0, 0);

        pay_balance.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(BuyActivity.this, "余额", Toast.LENGTH_SHORT).show();
                window1.dismiss();
            }
        });

        //微信支付
        pay_wx.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Map<String, String> maymap = new HashMap<String, String>();

                maymap.put("bagid", mBagId);
                maymap.put("pay_status", "2");
                maymap.put("new_price", mNowPrice);
                maymap.put("old_price", mOriginalPrice);
                maymap.put("is_order", "2");
                maymap.put("day", "");
                maymap.put("divide", "1");
                maymap.put("address_id", mAddress);

                OkHttpUtils.getInstance().post(SBUrls.ZHFPAY, maymap, new MyNetWorkCallback<MayBean1>() {
                            @Override
                            public void onSuccess(MayBean1 mayBean1) {

                                String appid = mayBean1.getInfo().getAppid();
                                String noncestr = mayBean1.getInfo().getNoncestr();
                                String packageX = mayBean1.getInfo().getPackageX();
                                String partnerid = mayBean1.getInfo().getPartnerid();
                                String prepayid = mayBean1.getInfo().getPrepayid();
                                String sign = mayBean1.getInfo().getSign();
                                String timestamp = mayBean1.getInfo().getTimestamp();
                                Log.e("", noncestr + "" + packageX + "" + partnerid + "" + prepayid + "" + sign + "" + timestamp);
                                PayReq pay = new PayReq();
                                pay.appId = appid;
                                pay.partnerId = partnerid;
                                pay.prepayId = prepayid;
                                pay.nonceStr = noncestr;
                                pay.timeStamp = timestamp;
                                pay.packageValue = packageX;
                                pay.sign = sign;
                                api.sendReq(pay);
                            }

                            @Override
                            public void onError(int errorCode, String errorMsg) {

                            }
                        }
                );
                window1.dismiss();
            }
        });

        //支付宝
        pay_zfb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Map<String, String> maymap = new HashMap<String, String>();
                maymap.put("bagid", mBagId);
                maymap.put("pay_status", "3");
                maymap.put("new_price", mNowPrice);
                maymap.put("old_price", mOriginalPrice);
                maymap.put("is_order", "2");
                maymap.put("day", "");
                maymap.put("divide", "1");
                maymap.put("address_id", mAddress);

                OkHttpUtils.getInstance().post(SBUrls.ZHFPAY, maymap, new MyNetWorkCallback<MayBean>() {
                    @Override
                    public void onSuccess(MayBean mayBean) {
                        String info = mayBean.getInfo();
                        Log.e("TAG", info);
                        String status = mayBean.getStatus();
                        String s = info.replaceAll("&amp;", "&");
                        payV2(s);

                    }

                    @Override
                    public void onError(int errorCode, String errorMsg) {
                        ToastUtils.showTop(BuyActivity.this, "" + errorMsg);
                    }
                });
                window1.dismiss();
            }
        });
    }

    public void payV2(final String str) {
        /**
         * 这里只是为了方便直接向商户展示支付宝的整个支付流程；所以Demo中加签过程直接放在客户端完成；
         * 真实App里，privateKey等数据严禁放在客户端，加签过程务必要放在服务端完成；
         * 防止商户私密数据泄露，造成不必要的资金损失，及面临各种安全风险；
         *
         * orderInfo的获取必须来自服务端；
         */
        Runnable payRunnable = new Runnable() {

            @Override
            public void run() {
                PayTask alipay = new PayTask(BuyActivity.this);
                Map<String, String> result = alipay.payV2(str, true);//orderInfo
                Log.i("msp", result.toString());

                Message msg = new Message();
                msg.what = SDK_PAY_FLAG;
                msg.obj = result;
                mHandler.sendMessage(msg);
            }
        };

        Thread payThread = new Thread(payRunnable);
        payThread.start();
    }

    @SuppressLint("HandlerLeak")
    private Handler mHandler = new Handler() {
        @SuppressWarnings("unused")
        public void handleMessage(Message msg) {
            switch (msg.what) {
                case SDK_PAY_FLAG: {
                    @SuppressWarnings("unchecked")
                    PayResult payResult = new PayResult((Map<String, String>) msg.obj);
                    /**
                     对于支付结果，请商户依赖服务端的异步通知结果。同步通知结果，仅作为支付结束的通知。
                     */
                    String resultInfo = payResult.getResult();// 同步返回需要验证的信息
                    String resultStatus = payResult.getResultStatus();
                    android.util.Log.e("TAG", resultStatus);
                    // 判断resultStatus 为9000则代表支付成功
                    if (TextUtils.equals(resultStatus, "9000")) {
                        // 该笔订单是否真实支付成功，需要依赖服务端的异步通知。
                        Toast.makeText(BuyActivity.this, "支付成功", Toast.LENGTH_SHORT).show();
                    } else {
                        // 该笔订单真实的支付结果，需要依赖服务端的异步通知。
                        Toast.makeText(BuyActivity.this, "支付失败", Toast.LENGTH_SHORT).show();
                    }
                    break;
                }
                case SDK_AUTH_FLAG: {
                    @SuppressWarnings("unchecked")
                    AuthResult authResult = new AuthResult((Map<String, String>) msg.obj, true);
                    String resultStatus = authResult.getResultStatus();

                    // 判断resultStatus 为“9000”且result_code
                    // 为“200”则代表授权成功，具体状态码代表含义可参考授权接口文档
                    if (TextUtils.equals(resultStatus, "9000") && TextUtils.equals(authResult.getResultCode(), "200")) {
                        // 获取alipay_open_id，调支付时作为参数extern_token 的value
                        // 传入，则支付账户为该授权账户
                        Toast.makeText(BuyActivity.this,
                                "授权成功\n" + String.format("authCode:%s", authResult.getAuthCode()), Toast.LENGTH_SHORT)
                                .show();
                    } else {
                        // 其他状态值则为授权失败
                        Toast.makeText(BuyActivity.this,
                                "授权失败" + String.format("authCode:%s", authResult.getAuthCode()), Toast.LENGTH_SHORT).show();

                    }
                    break;
                }
                default:
                    break;
            }
        }
    };
}
