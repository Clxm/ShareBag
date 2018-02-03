package com.share.bag.ui.activitys.mine;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.bigkoo.pickerview.OptionsPickerView;
import com.share.bag.R;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/*
* 收获地址
* */
public class AddressActivity extends AppCompatActivity implements View.OnClickListener {

    private ArrayList<ProvinceBean> options1Items = new ArrayList<>();
    private ArrayList<ArrayList<String>> options2Items = new ArrayList<>();
    private Button btn_selector;
    private String province;
    private String provinceid;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_address);
        initView();
        initNet();
    }

    private void initNet() {
        // TODO: 2018/2/2 网络请求写这
//String dizhiurl="http://baobaoapi.ldlchat.com/Home/Personalcenter/getaddress.html";
//               http://baobaoapi.ldlchat.com/Home/Personalcenter/getaddress.html

        String dizhiurl="http://baobaoapi.ldlchat.com/Home/Personalcenter/getaddress.html ";

        Map<String, String> map = new HashMap<>();
        map.put("type","1");
//        OkHttpUtils.getInstance().postList(dizhiurl, map, new MyNetWorkCallback<String>() {
//
//                @Override
//            public void onSuccess(String provinceBean){
//                                                    //fang
//                    Type type1 = new TypeToken<List<>>(){}.getType();  //
//                province = provinceBean.getProvince();
//                //用于第二个网络请求  这是集合？？？？？？？？
//                provinceid = provinceBean.getProvinceid();
//                Log.e("TAG", "onSuccess: "+provinceid );
//            }
//
//            @Override
//            public void onError(int errorCode, String errorMsg) {
//
//            }
//        });

        }

    private void initView() {
        btn_selector = (Button) findViewById(R.id.btn_selector_address);

        btn_selector.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_selector_address:
                initOptionPicker();
                break;
        }
    }

    private OptionsPickerView optionsPickerView;
    private void initOptionPicker() {

        //如果是三级联动的数据 请参照 JsonDataActivity 类里面的写法。

        optionsPickerView = new OptionsPickerView.Builder(this, new OptionsPickerView.OnOptionsSelectListener() {
            @Override
            public void onOptionsSelect(int options1, int options2, int options3, View v) {
                //返回的分别是三个级别的选中位置
                String tx = options1Items.get(options1).getProvince()
                        + options2Items.get(options1).get(options2);
                ((Button) v).setText(tx);
            }
        })
                .setTitleText("城市选择")
                .setContentTextSize(20)//设置滚轮文字大小
                .setDividerColor(Color.GREEN)//设置分割线的颜色
                .setSelectOptions(0, 1)//默认选中项
                .setBgColor(Color.BLACK)
                .setTitleBgColor(Color.DKGRAY)
                .setTitleColor(Color.LTGRAY)
                .setCancelColor(Color.YELLOW)
                .setSubmitColor(Color.YELLOW)
                .setTextColorCenter(Color.LTGRAY)
                .isCenterLabel(false) //是否只显示中间选中项的label文字，false则每项item全部都带有label。
                .setLabels("省", "市", "区")
                .build();
        /*pvOptions.setPicker(options1Items);//一级选择器*/
        optionsPickerView.setPicker(options1Items, options2Items);//二级选择器
        /*pvOptions.setPicker(options1Items, options2Items,options3Items);//三级选择器*/

    }
}
