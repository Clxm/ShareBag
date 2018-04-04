package com.share.bag.ui.activitys.collection;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.share.bag.R;
import com.share.bag.SBUrls;

import java.util.List;

/**
 * Created by Administrator on 2018/3/23.
 */

public class ReleaseAdapter extends RecyclerView.Adapter<ReleaseAdapter.ViewHolder>{
    private Context context;
    private List<ReleaseBean.InfoBean> list;
    public ReleaseAdapter(Context context, List<ReleaseBean.InfoBean> list) {
        this.context = context;
        this.list = list;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view=View.inflate(context, R.layout.release_item1,null);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, final int position) {

        Glide.with(context).load(SBUrls.HEAD+list.get(position).getImg()).into(holder.release_adapter_img);
        holder.release_adapter_name.setText(list.get(position).getTitle());



        holder.release_adapter_brands.setText(list.get(position).getBagbrand_id());


//        holder.release_adapter_numbering.setText(list.get(position).getTitle());


        holder.release_adapter_materials.setText(list.get(position).getMaterial());
        holder.release_adapter_size.setText(list.get(position).getBagsize_id());

        holder.release_adapter_layout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(context,Release.class);
                intent.putExtra("id",list.get(position).getId()+"");
//                跳转这样写
                context.startActivity(intent);


            }
        });


    }


    public interface AdapterCallback {
        public void callBack(View v, int position);
    }
    private AdapterCallback callback;

    /**通过该方法连接起来**/
    public void setCallback(AdapterCallback callback) {
        this.callback = callback;
    }
    private  OnitemClickedListener onitemlistener;
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
        private final TextView release_adapter_name,release_adapter_brands,
               release_adapter_materials,release_adapter_size;
        private final ImageView release_adapter_img;
        private final LinearLayout release_adapter_layout;
        public ViewHolder(View itemView) {
            super(itemView);

            release_adapter_layout =(LinearLayout)itemView.findViewById(R.id.release_adapter_layout);
            release_adapter_img =  itemView.findViewById(R.id.release_adapter_img);
            release_adapter_name = (TextView) itemView.findViewById(R.id.release_adapter_name);
            release_adapter_brands = (TextView) itemView.findViewById(R.id.release_adapter_brands);
//            release_adapter_numbering = (TextView) itemView.findViewById(R.id.release_adapter_numbering);
            release_adapter_materials = (TextView) itemView.findViewById(R.id.release_adapter_materials);
            release_adapter_size = (TextView) itemView.findViewById(R.id.release_adapter_size);
        }
    }

}
