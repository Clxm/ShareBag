package com.share.bag.ui.ship;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.share.bag.R;
import com.share.bag.SBUrls;
import com.share.bag.view.YWXZAlertDialog;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author : TianFB
 * @Date : 2018/4/11
 * @Desrcibe ：
 */

public class ShipAdapter4 extends RecyclerView.Adapter{

    private List<ShipHttpBean4.InfoBean> mList = new ArrayList<>();
    private Context mContext;
    public ShipAdapter4(Context context, List<ShipHttpBean4.InfoBean> info){
        mList.clear();
        mList.addAll(info);
        mContext = context;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new MyHolder(LayoutInflater.from(mContext).inflate(R.layout.ship_item_4, parent, false));
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, final int position) {
        ShipHttpBean4.InfoBean bean = mList.get(position);
        MyHolder myHolder = (MyHolder) holder;
        myHolder.orderid.setText("还剩"+bean.getDay()+"天");
        Glide.with(mContext).load(SBUrls.LOGURL + bean.getImg()).into(myHolder.img);
        myHolder.title.setText(bean.getTitle());
        myHolder.nums.setText(bean.getBiglist_num());
        myHolder.color.setText(bean.getColor());
        myHolder.brands.setText(bean.getBagbrand_id());
        myHolder.size.setText(bean.getBagsize_id());
        myHolder.money.setText("支付金额 ￥"+bean.getNowprice());

    }

    @Override
    public int getItemCount() {
        return mList.size();
    }


    private class MyHolder extends RecyclerView.ViewHolder{
        TextView orderid;
        TextView title;
        TextView brands;
        TextView nums;
        TextView color;
        ImageView img;
        TextView size;
        TextView money;
        TextView button1;
        TextView button2;
        TextView button3;
        public MyHolder(View itemView) {
            super(itemView);
            orderid = itemView.findViewById(R.id.orderid);
            img = itemView.findViewById(R.id.shared_adapter_img);
            title = itemView.findViewById(R.id.shared_adapter_name);
            brands = itemView.findViewById(R.id.shared_adapter_brands);
            nums = itemView.findViewById(R.id.shared_adapter_numbering);
            color = itemView.findViewById(R.id.shared_adapter_colour);
            size = itemView.findViewById(R.id.shared_adapter_size);
            money = itemView.findViewById(R.id.money);
            button1 = itemView.findViewById(R.id.button1);
            button2 = itemView.findViewById(R.id.button2);
            button3 = itemView.findViewById(R.id.button3);
        }
    }

}
