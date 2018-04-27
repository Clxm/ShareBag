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

        SharedBean.InfoBean infoBean = list.get(position);
        String s1 = SBUrls.LOGURL + infoBean.getImg();
        Glide.with(context).load(s1).into(holder.shared_adapter_img);
        holder.shared_adapter_name.setText(infoBean.getTitle());
        holder.shared_adapter_brands.setText(infoBean.getBagbrand_id());
        holder.shared_adapter_size.setText(infoBean.getBagsize_id());
        holder.shared_adapter_colour.setText(infoBean.getColor());
        holder.shared_adapter_numbering.setText(infoBean.getId());
        holder.time.setText(infoBean.getCreate_time());
        if(infoBean.getType() == 1){//审核中
            holder.stutas.setText("审核中");
            holder.shared_adapter_rent.setVisibility(View.GONE);
        }else  if(infoBean.getType() == 2){//审核通过
            holder.stutas.setText("审核通过");
            holder.shared_adapter_rent.setVisibility(View.GONE);
        }else  if(infoBean.getType() == 3){//审核失败
            holder.stutas.setText("审核失败");
            holder.shared_adapter_rent.setVisibility(View.GONE);
        }else  if(infoBean.getType() == 4){//已出租
            holder.stutas.setText("已出租");
            holder.shared_adapter_rent.setVisibility(View.VISIBLE);
            holder.shared_adapter_rent.setText(infoBean.getDays_money()+"元/天");
        }else  if(infoBean.getType() == 5){//被买断
            holder.stutas.setText("被买断");
            holder.shared_adapter_rent.setVisibility(View.VISIBLE);
            holder.shared_adapter_rent.setText(infoBean.getNowprice()+"元");
        }else  if(infoBean.getType() == 6){//待出租
            holder.stutas.setText("待出租");
            holder.shared_adapter_rent.setVisibility(View.VISIBLE);
            holder.shared_adapter_rent.setText(infoBean.getDays_money()+"元/天");
        }
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
        private final TextView stutas;
        private final TextView time;

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
            time = (TextView) itemView.findViewById(R.id.shared_adapter_time);
            stutas = (TextView) itemView.findViewById(R.id.stutas);

        }
    }
}