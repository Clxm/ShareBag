package com.share.bag.ui.activitys.mine.cabinet;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.View;
import android.widget.ImageView;

import com.share.bag.LikeAdapter;
import com.share.bag.R;
import com.share.bag.SBUrls;
import com.share.bag.entity.LikeBean;
import com.share.bag.utils.okhttp.OkHttpUtils;
import com.share.bag.utils.okhttp.callback.MyNetWorkCallback;

import org.json.JSONException;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
* 我的包柜
* */
public class CabinetActivity extends AppCompatActivity {

    private ImageView cablinet_return;
    private RecyclerView cablinet_recycler1;
    private RecyclerView cablinet_recycler2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cabinet);
        initView();
        getinitData();
        getinitData1();
        cablinet_return.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }

    private void initView() {
        cablinet_return = (ImageView) findViewById(R.id.cablinet_return);
        cablinet_recycler1 = (RecyclerView) findViewById(R.id.cablinet_recycler1);
        cablinet_recycler2 = (RecyclerView) findViewById(R.id.cablinet_recycler2);
    }

    public void getinitData() {
        Map<String,String > stringMap= new HashMap<>();
        OkHttpUtils.getInstance().post(SBUrls.CABINET, stringMap, new MyNetWorkCallback<CabinetBean>() {
            @Override
            public void onSuccess(CabinetBean cabinetBean) throws JSONException {
                List<CabinetBean.InfoBean> info = cabinetBean.getInfo();

                cablinet_recycler1.setLayoutManager(new StaggeredGridLayoutManager(1,StaggeredGridLayoutManager.VERTICAL));

                CabinetAdapter likeAdapter=new CabinetAdapter(CabinetActivity.this,info);
                cablinet_recycler1.setAdapter(likeAdapter);
            }

            @Override
            public void onError(int errorCode, String errorMsg) {

            }
        });

    }


    public void getinitData1() {
        Map<String,String > stringMap= new HashMap<>();

        OkHttpUtils.getInstance().post(SBUrls.LIKE, stringMap, new MyNetWorkCallback<LikeBean>() {
            @Override
            public void onSuccess(LikeBean likeBean) throws JSONException {

                List<LikeBean.InfoBean> info = likeBean.getInfo();
                cablinet_recycler2.setLayoutManager(new StaggeredGridLayoutManager(2,StaggeredGridLayoutManager.VERTICAL));

                LikeAdapter likeAdapter=new LikeAdapter(CabinetActivity.this,info);
                cablinet_recycler2.setAdapter(likeAdapter);

            }

            @Override
            public void onError(int errorCode, String errorMsg) {

            }
        });
    }

}
