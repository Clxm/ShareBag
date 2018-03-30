package com.share.bag.ui.activitys.mine.wallet;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.share.bag.R;
import com.share.bag.SBUrls;
import com.share.bag.ui.activitys.mine.ChangeBean;
import com.share.bag.ui.activitys.mine.RedEnvelopeAdapter;
import com.share.bag.utils.okhttp.OkHttpUtils;
import com.share.bag.utils.okhttp.callback.MyNetWorkCallback;

import org.json.JSONException;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
* 卡卷
* */
public class MyTradeActivity extends AppCompatActivity {

    private ImageView mydeposit_return;
    private RecyclerView mydeposit_recycler;
    private RedEnvelopeAdapter redEnvelopeAdapter;
    private TextView crade_name;
    private TextView card_Introduce;
    private TextView card_money;
    private ImageView card_use;

    //    private List<> list=new ArrayList();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_trade);
        initView();
        gettadachange();//以旧换新卡卷
        getdata();//红包卷





//        Trade1Adapter tradeAdapter=new Trade1Adapter(this,list);
        card_use.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(MyTradeActivity.this, "点击了以旧换新劵", Toast.LENGTH_SHORT).show();
            }
        });

        mydeposit_return.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }

    private void initView() {
        mydeposit_return = (ImageView) findViewById(R.id.mydeposit_return);

        mydeposit_recycler = (RecyclerView) findViewById(R.id.mydeposit_recycler);

        crade_name = (TextView) findViewById(R.id.crade_name);

        card_Introduce = (TextView) findViewById(R.id.card_Introduce);

        card_money = (TextView) findViewById(R.id.card_money);

        card_use = (ImageView) findViewById(R.id.card_use);
    }

    public void getdata() {
        Map<String, String> stringStringMap = new HashMap<>();
        stringStringMap.put("type", "1" + "");
        OkHttpUtils.getInstance().post(SBUrls.RED, stringStringMap, new MyNetWorkCallback<RedEnvelopeBean>() {


            @Override
            public void onSuccess(RedEnvelopeBean redEnvelopeBean) throws JSONException {
                List<RedEnvelopeBean.InfoBean> info = redEnvelopeBean.getInfo();
                for (int i = 0; i < info.size(); i++) {

                    /*LinearLayoutManager  layoutManager = new LinearLayoutManager (MyTradeActivity.this) {
                        @Override
                        canScrollVertically
                        public boolean canScrollVertically() {
                            // 直接禁止垂直滑动
                            return false;
                        }
                    };*/

                    mydeposit_recycler.setLayoutManager(new StaggeredGridLayoutManager(1, StaggeredGridLayoutManager.VERTICAL));



                    redEnvelopeAdapter = new RedEnvelopeAdapter(MyTradeActivity.this, info);
                    mydeposit_recycler.setAdapter(redEnvelopeAdapter);

                }


            }

            @Override
            public void onError(int errorCode, String errorMsg) {

            }
        });

    }


    public void gettadachange() {
        Map<String, String> stringStringMap = new HashMap<>();
        stringStringMap.put("type", "" + "2");
        OkHttpUtils.getInstance().post(SBUrls.RED, stringStringMap, new MyNetWorkCallback<ChangeBean>() {
            @Override
            public void onSuccess(ChangeBean changeBean) throws JSONException {
//                crade_name.setText(changeBean.getInfo().getTitle());
//                card_Introduce.setText(changeBean.getInfo().getContent());
                card_money.setText(changeBean.getInfo().get_$0().getAmount()+"");
            }

            @Override
            public void onError(int errorCode, String errorMsg) {

            }
        });


    }


}
