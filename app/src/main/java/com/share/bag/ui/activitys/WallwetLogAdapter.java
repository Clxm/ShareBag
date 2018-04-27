package com.share.bag.ui.activitys;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.share.bag.R;

import java.util.List;
import java.util.Objects;

/**
 * @Author : TianFB
 * @Date : 2018/4/27
 * @Desrcibe ：
 */

public class WallwetLogAdapter extends RecyclerView.Adapter {
    public Context context;
    public List<WalletLogBean.InfoBean> mlist;


    public WallwetLogAdapter(Context context, List<WalletLogBean.InfoBean> list) {
        this.context = context;
        mlist = list;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new MyHolder(View.inflate(context, R.layout.walletlog_item, null));
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        MyHolder myHolder = (MyHolder) holder;
        WalletLogBean.InfoBean infoBean = mlist.get(position);
        myHolder.time.setText(infoBean.getCreate_time());
        myHolder.type.setText(infoBean.getContent());
        if ("3".equals(infoBean.getStatus()) || "5".equals(infoBean.getStatus()) || "7".equals(infoBean.getStatus()) || "10".equals(infoBean.getStatus())) {
            myHolder.money.setText("+ ￥" + infoBean.getNum()+".00");
        }else {
            myHolder.money.setText("- ￥" + infoBean.getNum()+".00");
        }
    }

    @Override
    public int getItemCount() {
        return mlist.size();
    }


    public class MyHolder extends RecyclerView.ViewHolder {

        public TextView time;
        public TextView type;
        public TextView money;

        public MyHolder(View itemView) {
            super(itemView);
            time = itemView.findViewById(R.id.time);
            type = itemView.findViewById(R.id.type);
            money = itemView.findViewById(R.id.money);
        }
    }
}