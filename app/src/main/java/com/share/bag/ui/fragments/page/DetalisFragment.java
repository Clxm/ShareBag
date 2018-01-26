package com.share.bag.ui.fragments.page;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.share.bag.R;
import com.share.bag.base.BaseFragment;
import com.share.bag.entity.Student;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;

/**
 * Created by Administrator on 2018/1/4.
 */
/*
* 详情页的详情页
* */
public class DetalisFragment extends BaseFragment {

    private TextView detalis_brand;
    private ImageView detalis_description_img1;
    private ImageView detalis_description_img2;
    private TextView detalis_introduction;
    private TextView detalis_numbering;
    private TextView detalis_colour;
    private TextView detalis_material;
    private TextView detalis_size;

    @Override
    public int initLayout() {
        return R.layout.details_fragment;
    }

    @Override
    public void initView(View view) {

        detalis_introduction = view.findViewById(R.id.detalis_Introduction);
        detalis_brand = view.findViewById(R.id.detalis_brand);
        detalis_numbering = view.findViewById(R.id.detalis_numbering);
        detalis_colour = view.findViewById(R.id.detalis_colour);
        detalis_material = view.findViewById(R.id.detalis_material);

        detalis_size = view.findViewById(R.id.detalis_size);
        detalis_description_img1 = view.findViewById(R.id.detalis_description_img1);
        detalis_description_img2 = view.findViewById(R.id.detalis_description_img2);

    }

    @Override
    protected void initData() {
        EventBus.getDefault().register(this);
    }


    @Subscribe  //订阅事件
    public void onEventMainThread(Student event) {
//        text.setText(event.getName());
//        text1.setText(event.getTitle());
        detalis_introduction.setText(event.getStitle());
        detalis_brand.setText(event.getSbagBrand_title());
        //编号没有
        detalis_colour.setText(event.getSbagBrand_color());
        detalis_material.setText(event.getSmaterial());
        detalis_size.setText(event.getSbagsize_title());
        Glide.with(getActivity()).load(event.getScontentimg()).into(detalis_description_img1);
        Glide.with(getActivity()).load(event.getScontentimg2()).into(detalis_description_img2);


    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        //取消event注册
        EventBus.getDefault().unregister(this);
    }
}
