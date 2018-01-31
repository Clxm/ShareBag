package com.share.bag.ui.pay;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.alipay.sdk.app.PayTask;
import com.share.bag.R;
import com.share.bag.SBUrls;
import com.share.bag.alipay.AuthResult;
import com.share.bag.alipay.PayResult;
import com.share.bag.entity.MayBean;
import com.share.bag.entity.MayBean1;
import com.share.bag.utils.okhttp.OkHttpUtils;
import com.share.bag.utils.okhttp.callback.MyNetWorkCallback;
import com.tencent.mm.opensdk.modelpay.PayReq;
import com.tencent.mm.opensdk.openapi.IWXAPI;
import com.tencent.mm.opensdk.openapi.WXAPIFactory;
import com.umeng.socialize.utils.Log;

import java.util.HashMap;
import java.util.Map;

/*
* 确认租
* */
public class RentActivity extends AppCompatActivity {
    private static final int SDK_PAY_FLAG = 1;
    private static final int SDK_AUTH_FLAG = 2;
    //支付
    public static final String PAY ="http://baobaoapi.ldlchat.com/index.php?s=/Home/Pay/alipaystodo.html";
    //APP_ID
    public static final String APPID = "2018010201523821";
    //PID
    public static final String PID = "2088901865907742";

    public static final String RSA2_PRIVATE = "MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEAlkR+whMRcYIybSBl5b1O4Gyv2Y00th/fxn+4tpCRkU1OmGo6l3UESg319yJCXWfIFIHRVCe+11JKiV7OyTYBVX4wC83ekqDVrVwGNBziU0ZrE2gerDRihX66xGGCs0w1TIhQsoawCH1hd61VOz6ABWp3l7yN8WM2KrXkl0OyGC2PVOO01eF9Y8cojPAm3nvOts/056C6X+o5Le9UTZ5m/AGAWOf9u3BBigG8lDrrG1P83+QON6irZcjgI55TJl9QtiNsb9W22xfbJzWVTS1xR4R1EfrkUyE4Cbw2peJSkUqIedZn2vndIN1aQ1G0uXp237rJEQiwRX6vKtm7/RpaeQIDAQAB";
    public static final String RSA_PRIVATE = "";
    public static final String TARGET_ID = "";
//////////////
private IWXAPI api;

    ///////////
    private LinearLayout pay_wx;
    private String content;







    private ImageView rent_return;
    private ImageView imageView3;
    private TextView rent;
    private TextView rent_22;
    private TextView rent_11;
    private RelativeLayout rent_address;
    private TextView rent_rent;
    private TextView rent_time_less;
    private TextView rent_time;
    private TextView rent_time_plus;
    private TextView rent_member;
    private TextView rent_postage;
    private TextView rent_red_package;
    private TextView rent_handle_deposit;
    private TextView rent_paid_deposit;
    private TextView rent_handle_rent;
    private TextView rent_supplement_rent;
    private TextView rent_total_amount;
    private LinearLayout rent_submit_order;

    int number;
    private PopupWindow window1;





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
                    android.util.Log.e("TAG",resultStatus);
                    // 判断resultStatus 为9000则代表支付成功
                    if (TextUtils.equals(resultStatus, "9000")) {
                        // 该笔订单是否真实支付成功，需要依赖服务端的异步通知。
                        Toast.makeText(RentActivity.this, "支付成功", Toast.LENGTH_SHORT).show();
                    } else {
                        // 该笔订单真实的支付结果，需要依赖服务端的异步通知。
                        Toast.makeText(RentActivity.this, "支付失败", Toast.LENGTH_SHORT).show();
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
                        Toast.makeText(RentActivity.this,
                                "授权成功\n" + String.format("authCode:%s", authResult.getAuthCode()), Toast.LENGTH_SHORT)
                                .show();
                    } else {
                        // 其他状态值则为授权失败
                        Toast.makeText(RentActivity.this,
                                "授权失败" + String.format("authCode:%s", authResult.getAuthCode()), Toast.LENGTH_SHORT).show();

                    }
                    break;
                }
                default:
                    break;
            }
        };
    };


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rent);
        initView();//wx38f75c7fdb68b2bf
        api = WXAPIFactory.createWXAPI(this, "wx38f75c7fdb68b2bf");

        String s = rent_time.getText().toString();
        number = Integer.parseInt(s);//string转换int
        rent_time_less.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (number < 8) {
                    Toast.makeText(RentActivity.this, "最少7天", Toast.LENGTH_SHORT).show();
                    rent_time_less.clearFocus();
                    rent_time_less.setFocusable(false);
                } else {
                    rent_time_less.setFocusable(true);
                    rent_time_less.requestFocus();
                    number--;
                    rent_time.setText(number + "");
                }
            }
        });

        rent_time_plus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                rent_time_less.setFocusable(true);
                rent_time_less.requestFocus();
                number++;
                rent_time.setText(number + "");
            }
        });

        rent_submit_order.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getPay();
//                Toast.makeText(MyRentActivity.this, "支付成功", Toast.LENGTH_SHORT).show();
            }
        });


        rent_total_amount.setText("");//总价

    }


    private void initView() {
        rent_return = (ImageView) findViewById(R.id.rent_return);
        imageView3 = (ImageView) findViewById(R.id.imageView3);
        rent = (TextView) findViewById(R.id.buy_rent);
        rent_22 = (TextView) findViewById(R.id.rent_22);
        rent_11 = (TextView) findViewById(R.id.rent_11);
        rent_address = (RelativeLayout) findViewById(R.id.rent_address);
        rent_rent = (TextView) findViewById(R.id.rent_rent);
        rent_time_less = (TextView) findViewById(R.id.rent_time_less);
        rent_time = (TextView) findViewById(R.id.rent_time);
        rent_time_plus = (TextView) findViewById(R.id.rent_time_plus);
        rent_member = (TextView) findViewById(R.id.rent_member);
        rent_postage = (TextView) findViewById(R.id.rent_postage);
        rent_red_package = (TextView) findViewById(R.id.rent_red_package);
        rent_handle_deposit = (TextView) findViewById(R.id.rent_handle_deposit);
        rent_paid_deposit = (TextView) findViewById(R.id.rent_paid_deposit);
        rent_handle_rent = (TextView) findViewById(R.id.rent_handle_rent);
        rent_supplement_rent = (TextView) findViewById(R.id.rent_supplement_rent);
        rent_total_amount = (TextView) findViewById(R.id.rent_total_amount);
        rent_submit_order = (LinearLayout) findViewById(R.id.rent_submit_order);
    }

    public void getPay() {

        WindowManager wm = (WindowManager) getApplication()
                .getSystemService(Context.WINDOW_SERVICE);

        int width = wm.getDefaultDisplay().getWidth();
        int height = wm.getDefaultDisplay().getHeight();

        //设置contentView
        View contentView = LayoutInflater.from(this).inflate(R.layout.popupwindow_pay, null);
        window1 = new PopupWindow(contentView,
                width, height);
        window1.setContentView(contentView);
        //设置各个控件的点击响应
        LinearLayout pay_balance = (LinearLayout) contentView.findViewById(R.id.pay_balance);
        pay_wx = (LinearLayout) contentView.findViewById(R.id.pay_wx);
        LinearLayout pay_zfb = (LinearLayout) contentView.findViewById(R.id.pay_zfb);


        //显示PopupWindow
        View rootview = LayoutInflater.from(this).inflate(R.layout.activity_personal2, null);
        window1.showAtLocation(rootview, Gravity.CENTER, 0, 0);

        pay_balance.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(RentActivity.this, "余额", Toast.LENGTH_SHORT).show();
                window1.dismiss();
            }
        });

        pay_wx.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//微信支付点击事件

                Map<String,String> maymap=new HashMap<String, String>();

                maymap.put("old_price","1");//原定总价  （old_price）（租金总额：没有优惠过的总计）
                maymap.put("new_price","1");//优惠后的价格  （new_price）（租金总额：有优惠过的总计）
                maymap.put("pay_status","2");//支付类型   （pay_status   1-微信   2-钱包   3-支付宝）
                maymap.put("is_order","2");//订单类型    （is_order    1-充值   2-买   3-租）
                maymap.put("deposit_num","1");//押金总和    （deposit_num）（押金）
                //订单详情表
//                maymap.put("baglist_id","1");//包id
//                maymap.put("old_price","10");//一个包的租金
//                maymap.put("new_price","0.01");//优惠后价格 （new_price）（租金-红包劵）
//                maymap.put("discount_price","");//优惠卷价格（discount_price）（）
//                maymap.put("discount_id","");//优惠卷id
//                maymap.put("deposit","0.01");//押金（单个的实际应付押金）

                OkHttpUtils.getInstance().post(SBUrls.ZHFPAY, maymap, new MyNetWorkCallback<MayBean1>() {
                            @Override
                            public void onSuccess(MayBean1 mayBean1)  {

                                     String appid = mayBean1.getInfo().getAppid();
                                        String noncestr = mayBean1.getInfo().getNoncestr();
                                        String packageX = mayBean1.getInfo().getPackageX();
                                        String partnerid = mayBean1.getInfo().getPartnerid();
                                        String prepayid = mayBean1.getInfo().getPrepayid();
                                        String sign = mayBean1.getInfo().getSign();
                                        String timestamp = mayBean1.getInfo().getTimestamp();
                                    Toast.makeText(RentActivity.this, appid+""+noncestr, Toast.LENGTH_SHORT).show();
                                    android.util.Log.e("TAG",appid+""+noncestr);
                                PayReq pay=new PayReq();
                                pay.appId=appid;
                                pay.partnerId= partnerid;
                                    pay.prepayId=prepayid;
                                    pay.nonceStr= noncestr;
                                    pay.timeStamp= timestamp;
                                    pay.packageValue= packageX;
                                    pay.sign= sign;
                                    api.sendReq(pay);

//                                req.extData			= "app data"; // optional
                                    Toast.makeText(RentActivity.this, "正常调起支付", Toast.LENGTH_SHORT).show();
                            }

                            @Override
                            public void onError(int errorCode, String errorMsg) {

                            }
                        }
                   );





                    //微信支付点击事件



//                window1.dismiss();
            }
        });
        pay_zfb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                Toast.makeText(MyRentActivity.this, "支付宝", Toast.LENGTH_SHORT).show();

                Map<String,String> maymap=new HashMap<String, String>();
                
                maymap.put("old_price","0.01");//原定总价  （old_price）（租金总额：没有优惠过的总计）
                maymap.put("new_price","0.01");//优惠后的价格  （new_price）（租金总额：有优惠过的总计）
                maymap.put("pay_status","3");//支付类型   （pay_status   1-微信   2-钱包   3-支付宝）
                maymap.put("is_order","3");//订单类型    （is_order    1-充值   2-买   3-租）
                maymap.put("deposit_num","0.01");//押金总和    （deposit_num）（押金）
                //订单详情表
//                maymap.put("baglist_id","1");//包id
//                maymap.put("old_price","10");//一个包的租金
//                maymap.put("new_price","0.01");//优惠后价格 （new_price）（租金-红包劵）
//                maymap.put("discount_price","");//优惠卷价格（discount_price）（）
//                maymap.put("discount_id","");//优惠卷id
//                maymap.put("deposit","0.01");//押金（单个的实际应付押金）


                String baglist_id1="1";
                String old_price11="10";
                String new_price11="0.01";
                String discount_price11="";
                String discount_id11="";
                String deposit11="0.01";


                String xiangqing="["
                        +"baglist_id"+baglist_id1+","
                        +"old_price1"+old_price11+","

                        +"]";
                maymap.put("",xiangqing);

                OkHttpUtils.getInstance().post(SBUrls.ZHFPAY, maymap, new MyNetWorkCallback<MayBean>() {
                    @Override
                    public void onSuccess(MayBean mayBean) {
                      String  info = mayBean.getInfo();
                        String status = mayBean.getStatus();
                        String s = info.replaceAll("&amp;", "&");
                          payV2(s);

                    }

                    @Override
                    public void onError(int errorCode, String errorMsg) {
                        Toast.makeText(RentActivity.this, "+++++++"+errorMsg, Toast.LENGTH_SHORT).show();
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
                PayTask alipay = new PayTask(RentActivity.this);
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


}
