package com.share.bag.ui.activitys.mine.shared;

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

public class SharedAdapter extends RecyclerView.Adapter<SharedAdapter.ViewHolder> {
    private Context context;
    private List<SharedBean.InfoBean> list;

    public SharedAdapter(Context context, List<SharedBean.InfoBean> list) {
        this.context = context;
        this.list = list;
    }

    @Override
    public SharedAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = View.inflate(context, R.layout.shared_item1, null);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(SharedAdapter.ViewHolder holder, final int position) {

        String s1 = SBUrls.LOGURL + list.get(position).getImg();
        Glide.with(context).load(s1).into(holder.shared_adapter_img);
        holder.shared_adapter_name.setText(list.get(position).getTitle());
        holder.shared_adapter_brands.setText(list.get(position).getBagbrand_id());
        holder.shared_adapter_size.setText(list.get(position).getBagsize_id());
    }

    public interface AdapterCallback {
        public void callBack(View v, int position);
    }

    private AdapterCallback callback;

    /**
     * 通过该方法连接起来
     **/
    public void setCallback(SharedAdapter.AdapterCallback callback) {
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
        public ImageView shared_adapter_img;
        private final TextView shared_adapter_name;
        private final TextView shared_adapter_brands;
        private final TextView shared_adapter_numbering;
        private final TextView shared_adapter_colour;
        private final TextView shared_adapter_size;
        private final TextView shared_adapter_buyout1;
        private final TextView shared_adapter_buyout2;
        private final TextView shared_adapter_rent;

        public ViewHolder(View itemView) {
            super(itemView);
            shared_adapter_img = (ImageView) itemView.findViewById(R.id.shared_adapter_img);
            shared_adapter_name = (TextView) itemView.findViewById(R.id.shared_adapter_name);
            shared_adapter_brands = (TextView) itemView.findViewById(R.id.shared_adapter_brands);
            shared_adapter_numbering = (TextView) itemView.findViewById(R.id.shared_adapter_numbering);
            shared_adapter_colour = (TextView) itemView.findViewById(R.id.shared_adapter_colour);
            shared_adapter_size = (TextView) itemView.findViewById(R.id.shared_adapter_size);
            shared_adapter_buyout1 = (TextView) itemView.findViewById(R.id.shared_adapter_buyout1);
            shared_adapter_buyout2 = (TextView) itemView.findViewById(R.id.shared_adapter_buyout2);
            shared_adapter_rent = (TextView) itemView.findViewById(R.id.shared_adapter_rent);

        }
    }
}