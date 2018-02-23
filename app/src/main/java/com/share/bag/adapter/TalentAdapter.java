package com.share.bag.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.share.bag.R;
import com.share.bag.entity.selected.SelectedBean;

import java.util.List;

/**
 * Created by Administrator on 2017/12/29.
 */

public class TalentAdapter extends RecyclerView.Adapter<TalentAdapter.ViewHolder> {
    private Context context;
    private List<SelectedBean> list;

    public TalentAdapter(Context context, List<SelectedBean> list) {
        this.context = context;
        this.list = list;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = View.inflate(context, R.layout.talent, null);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, final int position) {
//        Glide.with(context).load(SBUrls.LOGURL + list.get(position).getImg()).into(holder.recyler_commodity);
//
//        holder.recyler_name.setText(list.get(position).getTitle());
//        holder.recyler_price.setText(list.get(position).getDays_money());
//        holder.recyler_money.setText(list.get(position).getOriginalprice());




    }

    public interface AdapterCallback {
        public void callBack(View v, int position);
    }

    private AdapterCallback callback;

    /**
     * 通过该方法连接起来
     **/
    public void setCallback(AdapterCallback callback) {
        this.callback = callback;
    }

    private OnitemClickedListener onitemlistener;

    public void setOnitemClickedListener(OnitemClickedListener Listener) {
        this.onitemlistener = Listener;

    }

    public interface OnitemClickedListener {
        public void Back(View v, int position);
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public ImageView talent_avatar;
        private final ImageView talent_img1,talent_img2;
        private final TextView talent_name;
        private final TextView talent_time;
        private final TextView talent_dynamic;

        public ViewHolder(View itemView) {
            super(itemView);
            talent_avatar = (ImageView) itemView.findViewById(R.id.talent_avatar);//头像
            talent_name = (TextView) itemView.findViewById(R.id.talent_name);//昵称
            talent_time = (TextView) itemView.findViewById(R.id.talent_time);//时间
            talent_dynamic = (TextView) itemView.findViewById(R.id.talent_dynamic);//发布的东西
            talent_img1 = (ImageView) itemView.findViewById(R.id.talent_img1);
            talent_img2 = (ImageView) itemView.findViewById(R.id.talent_img2);
        }
    }

}
