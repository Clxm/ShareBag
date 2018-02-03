package com.share.bag.ui.activitys.mine;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.share.bag.R;
import com.share.bag.SBUrls;
import com.share.bag.entity.NaneBean;
import com.share.bag.utils.okhttp.OkHttpUtils;
import com.share.bag.utils.okhttp.callback.MyNetWorkCallback;

import org.json.JSONException;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
* 修改昵称
* */
public class NameActivity extends AppCompatActivity {

    private List<NaneBean> nameList=new ArrayList();
    private ImageView name_return;
    private TextView name_save;
    private EditText name_edit;
    private String edit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_name);
        initView();
        name_return.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

        name_save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                submit();

//                EventBus.getDefault().post(new UserName(edit));
//                Toast.makeText(NameActivity.this, ""+edit, Toast.LENGTH_SHORT).show();
              getname();

            }
        });


        for (int i = 0; i < nameList.size(); i++) {

            String info = nameList.get(i).getInfo();
            Toast.makeText(this, "---"+info, Toast.LENGTH_SHORT).show();





        }


    }


    private void initView() {
        name_return = (ImageView) findViewById(R.id.name_return);
        name_save = (TextView) findViewById(R.id.name_save);
        name_edit = (EditText) findViewById(R.id.name_edit);
    }

    private void submit() {
        // validate
        edit = name_edit.getText().toString().trim();
        if (TextUtils.isEmpty(edit)) {
            Toast.makeText(this, "edit不能为空", Toast.LENGTH_SHORT).show();
            return;
        }

        // TODO validate success, do something


    }

    public void getname() {
        Map<String,String> map=new HashMap<>();
        String trim = name_edit.getText().toString().trim();
        map.put("name",trim);
        OkHttpUtils.getInstance().post(SBUrls.NICKNAME, map, new MyNetWorkCallback<NaneBean>() {
            @Override
            public void onSuccess(NaneBean naneBean) throws JSONException {

            }

            @Override
            public void onError(int errorCode, String errorMsg) {

            }
        }); 
//        OkHttpUtils.getInstance().postByte(SBUrls.NICKNAME, map, new ByteCallBack() {
//            @Override
//            public void onSuccess(String json) {
//                Gson gson=new Gson();
//                List<NaneBean> selectedBeens = gson.fromJson(json, new TypeToken<List<NaneBean>>() {
//                }.getType());
//                Toast.makeText(NameActivity.this, ""+selectedBeens.get(0).getInfo(), Toast.LENGTH_SHORT).show();
////                nameList.addAll(selectedBeens);
//
//
//            }
//
//            @Override
//            public void onError(int errorCode, String errorMsg) {
//
//            }
//        });


//        OkHttpUtils.getInstance().post(SBUrls.NICKNAME, map, new MyNetWorkCallback<NaneBean>() {
//            @Override
//            public void onSuccess(NaneBean naneBean) {
//                Log.e("TAGG","==========="+naneBean.getInfo());
//            }
//
//            @Override
//            public void onError(int errorCode, String errorMsg) {
//
//            }
//        });

    }
}
