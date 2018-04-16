package com.share.bag;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.share.bag.entity.CollectionBean;
import com.share.bag.entity.LikeBean;
import com.share.bag.ui.activitys.home.Details;
import com.share.bag.utils.ImageLoader;
import com.share.bag.utils.okhttp.OkHttpUtils;
import com.share.bag.utils.okhttp.callback.MyNetWorkCallback;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2018/3/15.
 */
public class LikeAdapter extends RecyclerView.Adapter<LikeAdapter.ViewHolder> {
    private Context context;
    private List<LikeBean.InfoBean> list;
    private boolean collectionType = false;

    public LikeAdapter(Context context, List<LikeBean.InfoBean> list) {
        this.context = context;
        this.list = list;
    }

    @Override
    public LikeAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = View.inflate(context, R.layout.recy_item1, null);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final LikeAdapter.ViewHolder holder, final int position) {
        String imageUrl = SBUrls.LOGURL + list.get(position).getImg();
        ImageLoader.LoadLocalImg(holder.recyler_commodity, context.getApplicationContext(), imageUrl);

        holder.recyler_name.setText(list.get(position).getTitle());
        holder.recyler_price.setText(list.get(position).getDays_money());
        holder.recyler_money.setText(list.get(position).getOriginalprice());
        holder.recyler_Collection.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final Map<String, String> collection = new HashMap();
                String id = list.get(position).getId();
                collection.put("baglist_id", id);
                OkHttpUtils.getInstance().post(SBUrls.LIKE_COLLECTION, collection, new MyNetWorkCallback<CollectionBean>() {
                    @Override
                    public void onSuccess(CollectionBean collectionBean) {
                        String type = collectionBean.getType();
                        if (type.equals("1")) {
                            holder.recyler_Collection.setImageResource(R.mipmap.shoucanghong1);
                        } else if (type.equals("2")){
                            holder.recyler_Collection.setImageResource(R.mipmap.shoucang1);
                        }
                    }

                    @Override
                    public void onError(int errorCode, String errorMsg) {
                    }
                });
                notifyDataSetChanged();
            }
        });

        //点击图片
        holder.recyler_commodity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context, Details.class);
                intent.putExtra("details", list.get(position).getId());
                context.startActivity(intent);
            }
        });


    }

    public interface AdapterCallback {
        void callBack(View v, int position);
    }

    private AdapterCallback callback;

    /**
     * 通过该方法连接起来
     **/
    public void setCallback(LikeAdapter.AdapterCallback callback) {
        this.callback = callback;
    }

    private OnitemClickedListener onitemlistener;

    public void setOnitemClickedListener(OnitemClickedListener Listener) {
        this.onitemlistener = Listener;

    }

    public interface OnitemClickedListener {
        void Back(View v, int position);
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
