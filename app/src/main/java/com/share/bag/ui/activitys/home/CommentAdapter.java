package com.share.bag.ui.activitys.home;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.share.bag.DateUtils;
import com.share.bag.GlideCircleTransform;
import com.share.bag.R;
import com.share.bag.entity.CommentBean;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by admin on 2017/5/26.
 */

class CommentAdapter extends RecyclerView.Adapter<CommentAdapter.ViewHoudler> {
    private Context context;
    List<CommentBean.DataBean> list = new ArrayList<>();
    private ViewHoudler houdler;
    private View view;

    public CommentAdapter(Context context, List<CommentBean.DataBean> list) {
        this.context = context;
        this.list = list;
    }

    @Override
    public ViewHoudler onCreateViewHolder(ViewGroup parent, int viewType) {
        view = View.inflate(context, R.layout.comment, null);
        houdler = new ViewHoudler(view);

        return houdler;
    }

    @Override
    public void onBindViewHolder(ViewHoudler holder, final int position) {

        String iconurl = list.get(position).getUser().getIconurl();
        String name = list.get(position).getUser().getName();
        String create_time = list.get(position).getUser().getCreate_time();
        String content = list.get(position).getContent();
        String strTime = DateUtils.getStrTime(create_time);

        List<String> labels = list.get(position).getUser().getLabels();
        String s0 = labels.get(0);

        try {
            String s1 = labels.get(1);
        holder.details_comment_signature2.setText(s1);
        }catch (Exception e){

        }
        try {
            String s2 = labels.get(2);
            holder.details_comment_signature3.setText(s2);
        }catch (Exception e){

        }
        holder.details_comment_signature1.setText(s0);
        Glide.with(context)
                .load(iconurl)
                //设置圆角图片
//                .transform(new GlideRoundTransform(MainActivity.this, 10))
                //设置圆形图片
                .transform(new GlideCircleTransform(context))
                .crossFade()
                .into(holder.details_comment_avatar);
//        Glide.with(context).load(iconurl).into(holder.details_comment_avatar);
        holder.details_comment_name.setText(name);
        holder.details_comment_time.setText(strTime);

        holder.details_comment_content.setText(content);

        holder.itemView.setTag(position);
        holder.itemView.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                listeners.click(v, position);
                return false;
            }
        });
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                listener1.clicks(v, position);
            }
        });

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    class ViewHoudler extends RecyclerView.ViewHolder {
        private final ImageView details_comment_avatar;
                private TextView details_comment_name,details_comment_time,
                        details_comment_signature1,details_comment_signature2,details_comment_signature3,
                        details_comment_content;

        public ViewHoudler(View itemView) {
            super(itemView);
            details_comment_avatar = itemView.findViewById(R.id.details_comment_avatar);
            details_comment_name = itemView.findViewById(R.id.details_comment_name);
            details_comment_time = itemView.findViewById(R.id.details_comment_time);
            details_comment_signature1 = itemView.findViewById(R.id.details_comment_signature1);
            details_comment_signature2 = itemView.findViewById(R.id.details_comment_signature2);
            details_comment_signature3 = itemView.findViewById(R.id.details_comment_signature3);
            details_comment_content = itemView.findViewById(R.id.details_comment_content);

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
