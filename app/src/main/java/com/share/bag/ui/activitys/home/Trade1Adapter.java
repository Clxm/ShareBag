package com.share.bag.ui.activitys.home;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.share.bag.R;
import com.share.bag.SBUrls;
import com.share.bag.entity.CollectionBean;
import com.share.bag.utils.okhttp.OkHttpUtils;
import com.share.bag.utils.okhttp.callback.MyNetWorkCallback;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2018/3/29.
 */

public class Trade1Adapter extends RecyclerView.Adapter<Trade1Adapter.ViewHolder> {
    private Context context;
    private List<TradeBean.InfoBean> list;

    public Trade1Adapter(Context context, List<TradeBean.InfoBean> list) {
        this.context = context;
        this.list = list;
    }

    @Override
    public Trade1Adapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = View.inflate(context, R.layout.recy_item1, null);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(Trade1Adapter.ViewHolder holder, final int position) {
        Glide.with(context).load(SBUrls.LOGURL + list.get(position).getImg()).into(holder.recyler_commodity);

        holder.recyler_name.setText(list.get(position).getTitle());
        holder.recyler_price.setText(list.get(position).getOriginalprice());
        holder.recyler_money.setText(list.get(position).getNowprice());
        holder.recyler_commodity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                onitemlistener.Back(view, position);
//                Toast.makeText(context, "我点击了什么"+list.get(position).getId(), Toast.LENGTH_SHORT).show();


                Intent intent_brandid0 = new Intent(context, Details.class);
                intent_brandid0.putExtra("details", list.get(position).getId()+"");
                intent_brandid0.putExtra("oldNew", "oldNew");
                context.startActivity(intent_brandid0);

            }
        });

        if (list.get(position).getIslive().equals("false")) {
            holder.recyler_Collection.setImageResource(R.mipmap.shoucang1);
        } else {
            holder.recyler_Collection.setImageResource(R.mipmap.shoucanghong1);
        }
        holder.recyler_Collection.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String url="http://baobaoapi.ldlchat.com/Home/Backcontent/content.html";
                Map<String ,String> collection=new HashMap();
                collection.put("baglist_id",position+"");
                Map<String ,String> collection1=new HashMap();
                collection1.put("id",position+"");
                OkHttpUtils.getInstance().post(url, collection1, new MyNetWorkCallback<CollectionBean>() {

                    @Override
                    public void onSuccess(CollectionBean collectionBean) {
                    }

                    @Override
                    public void onError(int errorCode, String errorMsg) {
                    }
                });


                if (list.get(position).getIslive().equals("false")) {
                    list.get(position).setIslive("true");
                } else {
                    list.get(position).setIslive("false");
                }
                notifyDataSetChanged();
            }
        });



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
        public ImageView recyler_commodity;
        private final ImageView recyler_Collection;
        private final TextView recyler_name;
        private final TextView recyler_price;
        private final TextView recyler_money;

        public ViewHolder(View itemView) {
            super(itemView);
            recyler_commodity = (ImageView) itemView.findViewById(R.id.recyler_commodity);
            recyler_Collection = (ImageView) itemView.findViewById(R.id.recyler_Collection);
            recyler_name = (TextView) itemView.findViewById(R.id.recyler_name);
            recyler_price = (TextView) itemView.findViewById(R.id.recyler_price);
            recyler_money = (TextView) itemView.findViewById(R.id.recyler_money);

        }
    }

}
