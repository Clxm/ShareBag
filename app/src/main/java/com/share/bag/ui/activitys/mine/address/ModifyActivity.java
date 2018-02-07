package com.share.bag.ui.activitys.mine.address;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.bigkoo.pickerview.OptionsPickerView;
import com.google.gson.Gson;
import com.share.bag.R;
import com.share.bag.ui.activitys.area.JsonBean;
import com.share.bag.ui.activitys.area.JsonFileReader;
import com.share.bag.ui.activitys.mine.AddBean;
import com.share.bag.utils.okhttp.OkHttpUtils;
import com.share.bag.utils.okhttp.callback.MyNetWorkCallback;

import org.json.JSONArray;
import org.json.JSONException;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class ModifyActivity extends AppCompatActivity implements View.OnClickListener {

    private ImageView modify_return;
    private TextView modify_title;
    private TextView modify_save;
    private EditText modify_name;
    private EditText modify_phone;
    private TextView modify_city;
    private LinearLayout modify_layout_city;
    private EditText modify_address;
    private ArrayList<JsonBean> options1Items = new ArrayList<>();
    private ArrayList<ArrayList<String>> options2Items = new ArrayList<>();
    private ArrayList<ArrayList<ArrayList<String>>> options3Items = new ArrayList<>();
    private String address1;
    private String address2;
    private String address3;
    private String tmp;

    //    public static Intent getIntent(Context context) {
//        Intent intent = new Intent(context, ModifyActivity.class);
//        return intent;
//    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_modify);

         Intent intent=getIntent();

        tmp = intent.getStringExtra("id");



        initView();
        initJsonData();
    }

    private void initView() {
        modify_return = (ImageView) findViewById(R.id.modify_return);
        modify_title = (TextView) findViewById(R.id.modify_title);
        modify_save = (TextView) findViewById(R.id.modify_save);
        modify_name = (EditText) findViewById(R.id.modify_name);
        modify_phone = (EditText) findViewById(R.id.modify_phone);
        modify_city = (TextView) findViewById(R.id.modify_city);
        modify_layout_city = (LinearLayout) findViewById(R.id.modify_layout_city);
        modify_address = (EditText) findViewById(R.id.modify_address);


        modify_return.setOnClickListener(this);
        modify_save.setOnClickListener(this);
        modify_layout_city.setOnClickListener(this);

    }

    private void submit() {

        String name = modify_name.getText().toString().trim();
        String phone = modify_phone.getText().toString().trim();
        String address = modify_address.getText().toString().trim();
        if (TextUtils.isEmpty(name)||TextUtils.isEmpty(phone)||TextUtils.isEmpty(address)) {
            Toast.makeText(this, "信息不完整，请补充", Toast.LENGTH_SHORT).show();

        }else {//修改
            String addurl="http://baobaoapi.ldlchat.com/Home/Personalcenter/updateaddress.html";

            Map<String,String> map=new HashMap<>();
            map.put("id",tmp);//ID
            map.put("province",address1);//省
            map.put("city",address2);//市
            map.put("area",address3);//区
            map.put("content",address);//详细地址
            map.put("username",name);//姓名
            map.put("phone",phone);//手机号
            OkHttpUtils.getInstance().post(addurl,map, new MyNetWorkCallback<AddBean>() {
                @Override
                public void onSuccess(AddBean addBean) throws JSONException {

//                    Toast.makeText(ModifyActivity.this, "===="+addBean.getInfo(), Toast.LENGTH_SHORT).show();
                    finish();
                }

                @Override
                public void onError(int errorCode, String errorMsg) {

                }
            });

        }

    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.modify_return:

                finish();
                break;
            case R.id.modify_save:
                submit();
                break;

            case R.id.modify_layout_city:
                showPickerView();
                Toast.makeText(this, "点击那里领", Toast.LENGTH_SHORT).show();

                break;
        }
    }

    private void showPickerView() {
        OptionsPickerView pvOptions=new OptionsPickerView.Builder(this, new OptionsPickerView.OnOptionsSelectListener() {
            @Override
            public void onOptionsSelect(int options1, int options2, int options3, View v) {
                //返回的分别是三个级别的选中位置
                String text = options1Items.get(options1).getPickerViewText() +
                        options2Items.get(options1).get(options2) +
                        options3Items.get(options1).get(options2).get(options3);

                address1 = options1Items.get(options1).getPickerViewText();
                address2 = options2Items.get(options1).get(options2);

                address3 = options3Items.get(options1).get(options2).get(options3);

                modify_city.setText(address1 + address2 + address3);//赋值
            }
        }).setTitleText("")
                .setDividerColor(Color.GRAY)
                .setTextColorCenter(Color.GRAY)
                .setContentTextSize(13)
                .setOutSideCancelable(false)
                .build();
          /*pvOptions.setPicker(options1Items);//一级选择器
        pvOptions.setPicker(options1Items, options2Items);//二级选择器*/
        pvOptions.setPicker(options1Items, options2Items, options3Items);//三级选择器
        pvOptions.show();
    }



    private void initJsonData() {   //解析数据

        /**
         * 注意：assets 目录下的Json文件仅供参考，实际使用可自行替换文件
         * 关键逻辑在于循环体
         *
         * */
        //  获取json数据
        String JsonData = JsonFileReader.getJson(this,"province_data.json");
        ArrayList<JsonBean> jsonBean = parseData(JsonData);//用Gson 转成实体

        /**
         * 添加省份数据
         *
         * 注意：如果是添加的JavaBean实体，则实体类需要实现 IPickerViewData 接口，
         * PickerView会通过getPickerViewText方法获取字符串显示出来。
         */
        options1Items = jsonBean;

        for (int i = 0; i < jsonBean.size(); i++) {//遍历省份
            ArrayList<String> CityList = new ArrayList<>();//该省的城市列表（第二级）
            ArrayList<ArrayList<String>> Province_AreaList = new ArrayList<>();//该省的所有地区列表（第三极）

            for (int c = 0; c < jsonBean.get(i).getCityList().size(); c++) {//遍历该省份的所有城市
                String CityName = jsonBean.get(i).getCityList().get(c).getName();
                CityList.add(CityName);//添加城市

                ArrayList<String> City_AreaList = new ArrayList<>();//该城市的所有地区列表

                //如果无地区数据，建议添加空字符串，防止数据为null 导致三个选项长度不匹配造成崩溃
                if (jsonBean.get(i).getCityList().get(c).getArea() == null
                        || jsonBean.get(i).getCityList().get(c).getArea().size() == 0) {
                    City_AreaList.add("");
                } else {

                    for (int d = 0; d < jsonBean.get(i).getCityList().get(c).getArea().size(); d++) {//该城市对应地区所有数据
                        String AreaName = jsonBean.get(i).getCityList().get(c).getArea().get(d);

                        City_AreaList.add(AreaName);//添加该城市所有地区数据
                    }
                }
                Province_AreaList.add(City_AreaList);//添加该省所有地区数据
            }

            /**
             * 添加城市数据
             */
            options2Items.add(CityList);

            /**
             * 添加地区数据
             */
            options3Items.add(Province_AreaList);
        }
    }

    public ArrayList<JsonBean> parseData(String result) {//Gson 解析
        ArrayList<JsonBean> detail = new ArrayList<>();
        try {
            JSONArray data = new JSONArray(result);
            Gson gson = new Gson();
            for (int i = 0; i < data.length(); i++) {
                JsonBean entity = gson.fromJson(data.optJSONObject(i).toString(), JsonBean.class);
                detail.add(entity);
            }
        } catch (Exception e) {
            e.printStackTrace();
            // mHandler.sendEmptyMessage(MSG_LOAD_FAILED);
        }
        return detail;
    }




}
