package com.share.bag.ui.activitys.mine;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.share.bag.FileUtil;
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

    private String trim;
    public static void actionStart(Context context, String data1) {
        Intent intent = new Intent(context, NameActivity.class);
        intent.putExtra("nickname", data1);
        context.startActivity(intent);
    }
    public static Intent getIntent(Context context){
        Intent intent=new Intent(context,NameActivity.class);
        return intent;
    }
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


    }

    public void getname() {
        submit();


        edit = name_edit.getText().toString().trim();
        if (TextUtils.isEmpty(edit)) {
            Toast.makeText(this, "昵称不能为空", Toast.LENGTH_SHORT).show();
        } else {
        Map<String, String> map = new HashMap<>();

        map.put("nickname", edit);
        OkHttpUtils.getInstance().post(SBUrls.NICKNAME, map, new MyNetWorkCallback<NaneBean>() {
            @Override
            public void onSuccess(NaneBean naneBean) throws JSONException {
                String info = naneBean.getInfo();
//                Toast.makeText(NameActivity.this,info, Toast.LENGTH_SHORT).show();
//                Intent intent = getIntent();
//                intent.putExtra("username", trim);
//                setResult(RESULT_OK, intent);
                FileUtil.saveName(NameActivity.this,edit);
//                PersonalActivity.actionStart(NameActivity.this,trim );

                finish();
            }

            @Override
            public void onError(int errorCode, String errorMsg) {

            }
        });
    }

    }
}
