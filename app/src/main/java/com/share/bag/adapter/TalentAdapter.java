package com.share.bag.adapter;

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
import com.share.bag.SBUrls;
import com.share.bag.entity.CollectionBean;
import com.share.bag.entity.TalentBean;
import com.share.bag.utils.okhttp.OkHttpUtils;
import com.share.bag.utils.okhttp.callback.MyNetWorkCallback;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2017/12/29.
 */

public class TalentAdapter extends RecyclerView.Adapter<TalentAdapter.ViewHolder> {
    private Context context;
    private List<TalentBean.InfoBean> list;

    public TalentAdapter(Context context, List<TalentBean.InfoBean> list) {
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

        String time = list.get(position).getTime();
        String strTime = DateUtils.getStrTime(time);
        holder.talent_time.setText(strTime);//时间
        holder.talent_name.setText(list.get(position).getUserinfo().getName());//用户名
        holder.talent_dynamic.setText(list.get(position).getContent());//发布内容

        String strurl="http://baobaoapi.ldlchat.com";
        String iconurl = list.get(position).getUserinfo().getIconurl();

        //头像
        Glide.with(context).load(strurl+iconurl).transform(new GlideCircleTransform(context)).crossFade().into(holder.talent_avatar);
        //发布图片


        String img = list.get(position).getBack().getImg();
        Glide.with(context).load(strurl+img).into(holder.talent_commodity_img);//商品图片
        holder.talent_commodity_name.setText(list.get(position).getBack().getTitle());//商品名称
        holder.talent_commodity_price.setText(list.get(position).getBack().getDays_money());//商品价格
        int collection = list.get(position).getBack().getCollection();




        if ( collection==1) {

            holder.talent_commodity_shoucang_img.setImageResource(R.mipmap.shoucanghong1);


        }else {
            holder.talent_commodity_shoucang_img.setImageResource(R.mipmap.shoucang1);


        }
        holder.talent_commodity_shoucang_img.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Map<String ,String> collection=new HashMap();
                collection.put("baglist_id",position+"");
                OkHttpUtils.getInstance().post(SBUrls.COLLECTION, collection, new MyNetWorkCallback<CollectionBean>() {
                    @Override
                    public void onSuccess(CollectionBean collectionBean) {


                    }

                    @Override
                    public void onError(int errorCode, String errorMsg) {
                    }
                });
                int collection1 = list.get(position).getBack().getCollection();
                if (collection1==1) {
                    list.get(position).getBack().setCollection(0);
                } else {
                    list.get(position).getBack().setCollection(1);
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
        public ImageView talent_avatar,talent_commodity_img;
        private final ImageView talent_img1,talent_img2,talent_commodity_shoucang_img;
        private final TextView talent_name,talent_commodity_name,talent_commodity_price;
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
            //商品图片
            talent_commodity_img = (ImageView) itemView.findViewById(R.id.talent_commodity_img);
            //名称
            talent_commodity_name = (TextView) itemView.findViewById(R.id.talent_commodity_name);
            //价格
            talent_commodity_price = (TextView) itemView.findViewById(R.id.talent_commodity_price);
            //收藏
            talent_commodity_shoucang_img = (ImageView) itemView.findViewById(R.id.talent_commodity_shoucang_img);

        }
    }

}
