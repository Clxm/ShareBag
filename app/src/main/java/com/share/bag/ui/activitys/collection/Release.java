package com.share.bag.ui.activitys.collection;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.Editable;
import android.text.InputType;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.share.bag.R;
/*
* 发布包包
* */
public class Release extends AppCompatActivity implements View.OnClickListener {


    private ImageView release2_return;
    private EditText release_et_input;
    private ImageView release2_add_photo1;
    private ImageView release2_add_photo2;
    private Button release2_button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_release2);
        initView();


//        EditText editText = new EditText(this);
//设置EditText的显示方式为多行文本输入
        release_et_input.setInputType(InputType.TYPE_TEXT_FLAG_MULTI_LINE);
//文本显示的位置在EditText的最上方
        release_et_input.setGravity(Gravity.TOP);
//改变默认的单行模式
        release_et_input.setSingleLine(false);
//水平滚动设置为False
        release_et_input.setHorizontallyScrolling(false);
        release_et_input.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if (s.length() > 140){ //判断EditText中输入的字符数是不是已经大于6
                    release_et_input.setText(s.toString().substring(0,140)); //设置EditText只显示前面6位字符
                    release_et_input.setSelection(140);//让光标移至末端
                    Toast.makeText(Release.this, "输入字数已达上限", Toast.LENGTH_SHORT).show();
                    return;
                }
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

    }

    private void initView() {
        release2_return = (ImageView) findViewById(R.id.release2_return);
        release_et_input = (EditText) findViewById(R.id.release_et_input);
        release2_add_photo1 = (ImageView) findViewById(R.id.release2_add_photo1);
        release2_add_photo2 = (ImageView) findViewById(R.id.release2_add_photo2);
        release2_button = (Button) findViewById(R.id.release2_button);

        release2_button.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.release2_button:

                getsubmit();


                break;
        }
    }

    private void submit() {
        // validate
        String input = release_et_input.getText().toString().trim();
        if (TextUtils.isEmpty(input)) {
            Toast.makeText(this, "最多可输入140字", Toast.LENGTH_SHORT).show();
            return;
        }

        // TODO validate success, do something


    }

    public void getsubmit() {

        Toast.makeText(this, "上传失败", Toast.LENGTH_SHORT).show();
        
        
    }
}
