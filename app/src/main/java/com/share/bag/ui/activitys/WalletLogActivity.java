package com.share.bag.ui.activitys;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.share.bag.R;
import com.share.bag.base.BaseActivity;
import com.share.bag.utils.okhttp.OkHttpUtils;
import com.share.bag.utils.okhttp.callback.MyNetWorkCallback;

import org.json.JSONException;

import java.util.HashMap;

/**
 * @Author : TianFB
 * @Date : 2018/4/27
 * @Desrcibe ：
 */

public class WalletLogActivity extends BaseActivity {

    private RecyclerView recycler;

    @Override
    public int initLayout() {
        return R.layout.activity_walletlog;
    }

    @Override
    public void initView() {
        recycler = (RecyclerView) findViewById(R.id.recycler);
        recycler.setLayoutManager(new LinearLayoutManager(WalletLogActivity.this));
        findViewById(R.id.ship_return).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }


    @Override
    protected void initData() {
        HashMap<String, String> map = new HashMap<>();
        map.put("userid", "51");
        map.put("type", "1");
        OkHttpUtils.getInstance().post("https://baobaoapi.ldlchat.com/Home/userupload/spend.html", map, new MyNetWorkCallback<WalletLogBean>() {
            @Override
            public void onSuccess(WalletLogBean o) throws JSONException {
                if (null != o.getInfo() && o.getInfo().size() > 0) {
                    recycler.setAdapter(new WallwetLogAdapter(WalletLogActivity.this, o.getInfo()));
                }
            }

            @Override
            public void onError(int errorCode, String errorMsg) {

            }
        });
    }

    @Override
    protected boolean hodeWindow() {
        return false;
    }
}
