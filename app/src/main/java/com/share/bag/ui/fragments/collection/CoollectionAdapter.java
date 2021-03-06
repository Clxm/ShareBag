package com.share.bag.ui.fragments.collection;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.share.bag.R;
import com.share.bag.SBUrls;

import java.util.List;

/**
 * Created by Administrator on 2018/3/28.
 */

public class CoollectionAdapter extends RecyclerView.Adapter<CoollectionAdapter.ViewHolder> {
    private Context context;
    private List<CollectionLookBean.InfoBean> list;
    private OnItemClickListener mOnItemCickListener = null;

    public CoollectionAdapter(Context context, List<CollectionLookBean.InfoBean> list) {
        this.context = context;
        this.list = list;
    }

    @Override
    public CoollectionAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = View.inflate(context, R.layout.coollection_item1, null);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(CoollectionAdapter.ViewHolder holder, final int position) {
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (mOnItemCickListener != null) {
                    mOnItemCickListener.onItemClick(view, position);
                }
            }
        });

        String imgUrl = SBUrls.LOGURL + list.get(position).getImg();
        Glide.with(context.getApplicationContext()).load(imgUrl).into(holder.collection_adapter_image);
        holder.collection_name.setText(list.get(position).getTitle());
        holder.collection_rent.setText(list.get(position).getDays_money());
        holder.collection_original.setText(list.get(position).getOriginalprice());
        holder.collection_sale.setText(list.get(position).getNowprice());
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        public ImageView collection_adapter_image;
        private final TextView collection_name;
        private final TextView collection_sale;
        private final TextView collection_rent;
        private final TextView collection_original;

        public ViewHolder(View itemView) {
            super(itemView);
            collection_adapter_image = (ImageView) itemView.findViewById(R.id.collection_adapter_image);
            collection_name = (TextView) itemView.findViewById(R.id.collection_name);
            collection_rent = (TextView) itemView.findViewById(R.id.collection_rent);
            collection_sale = (TextView) itemView.findViewById(R.id.collection_sale);
            collection_original = (TextView) itemView.findViewById(R.id.collection_original);
        }
    }

    public void setOnItemClickListener(OnItemClickListener onItemClickListener) {
        this.mOnItemCickListener = onItemClickListener;
    }


    public interface OnItemClickListener {
        void onItemClick(View view, int position);
    }
}
