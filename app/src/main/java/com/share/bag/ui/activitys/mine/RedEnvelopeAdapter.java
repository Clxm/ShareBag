package com.share.bag.ui.activitys.mine;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.share.bag.DateUtils;
import com.share.bag.R;
import com.share.bag.ui.activitys.mine.wallet.RedEnvelopeBean;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2018/3/21.
 */

public class RedEnvelopeAdapter extends RecyclerView.Adapter<RedEnvelopeAdapter.ViewHoudler> {
    private Context context;
    List<RedEnvelopeBean.InfoBean> list = new ArrayList<>();
    private ViewHoudler houdler;
    private View view;

    public RedEnvelopeAdapter(Context context, List<RedEnvelopeBean.InfoBean> list) {
        this.context = context;
        this.list = list;
    }

    @Override
    public ViewHoudler onCreateViewHolder(ViewGroup parent, int viewType) {
        view = View.inflate(context, R.layout.redenvelope, null);
        houdler = new ViewHoudler(view);

        return houdler;
    }

    @Override
    public void onBindViewHolder(ViewHoudler holder, final int position) {


        holder.redenvelope_voucher.setText( list.get(position).getTitle());
        holder.redenvelope_all.setText( list.get(position).getContent());
        String start_time = list.get(position).getStart_time();
        if (start_time!=null){
            String strTime = DateUtils.getStrTime1(start_time);
            holder.redenvelope_time.setText( strTime);//时间
        }else {

        }

        String remaining1 = (String) list.get(position).getEnd_time();
        if (remaining1!=null){
            String strTime1= DateUtils.getStrTime1(remaining1);
            holder.redenvelope_remaining_time.setText( strTime1);//时间
        }else {
            holder.redenvelope_remaining_time.setVisibility(View.GONE);
        }
        String amount = list.get(position).getAmount();
        String intNumber = amount.substring(0,amount.indexOf("."));
        holder.redenvelope_amount.setText(intNumber);//金额
        holder.redenvelope_use.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(context, "点击了立即使用", Toast.LENGTH_SHORT).show();
            }
});

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    class ViewHoudler extends RecyclerView.ViewHolder {

        private TextView redenvelope_voucher,redenvelope_time,redenvelope_remaining_time,redenvelope_amount,redenvelope_all;
        private ImageView redenvelope_use;
        public ViewHoudler(View itemView) {
            super(itemView);
            redenvelope_voucher = itemView.findViewById(R.id.redenvelope_voucher);
            redenvelope_time = itemView.findViewById(R.id.redenvelope_time);
            redenvelope_remaining_time = itemView.findViewById(R.id.redenvelope_remaining_time);
            redenvelope_amount = itemView.findViewById(R.id.redenvelope_amount);
            redenvelope_all = itemView.findViewById(R.id.redenvelope_all);

            redenvelope_use = itemView.findViewById(R.id.redenvelope_use);
//            details_comment_signature3 = itemView.findViewById(R.id.details_comment_signature3);
//            details_comment_content = itemView.findViewById(R.id.details_comment_content);

        }
    }

    Listener listeners;
    Listener1 listener1;

    public void setonItemClickListener(Listener1 listener1) {
        this.listener1 = listener1;
    }

    public void setonLongItemClickListener(Listener listeners) {
        this.listeners = listeners;
    }

    interface Listener {
        void click(View v, int position);
    }

    interface Listener1 {
        void clicks(View v, int position);
    }
}
