package com.share.bag.ui.activitys.collection;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.share.bag.R;
import com.share.bag.utils.okhttp.OkHttpUtils;
import com.share.bag.utils.okhttp.callback.MyNetWorkCallback;

import org.json.JSONException;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ReleaseActivity extends AppCompatActivity {

    private ImageView release_return;
    private EditText release_et_input;
    private RecyclerView release_recycler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_release);
        initView();
        getdata();
        release_return.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });



    }

    private void initView() {
        release_return = (ImageView) findViewById(R.id.release_return);
        release_et_input = (EditText) findViewById(R.id.release_et_input);
        release_recycler = (RecyclerView) findViewById(R.id.release_recycler);
    }

    private void submit() {
        // validate
        String input = release_et_input.getText().toString().trim();
        if (TextUtils.isEmpty(input)) {
            Toast.makeText(this, "请输入关键字", Toast.LENGTH_SHORT).show();
            return;
        }

        // TODO validate success, do something


    }

    public void getdata() {
        
        String strurl="http://baobaoapi.ldlchat.com/Home/Cabinet/getBagList.html";
        Map<String,String> map=new HashMap<>();

        OkHttpUtils.getInstance().post(strurl, map, new MyNetWorkCallback<ReleaseBean>() {
            @Override
            public void onSuccess(ReleaseBean releaseBean) throws JSONException {

                List<ReleaseBean.InfoBean> info = releaseBean.getInfo();


//                ReleaseAdapter releaseAdapter=new ReleaseAdapter()；

            }

            @Override
            public void onError(int errorCode, String errorMsg) {

            }
        });






    }
}
