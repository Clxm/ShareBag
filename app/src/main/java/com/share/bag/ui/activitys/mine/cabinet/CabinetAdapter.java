package com.share.bag.ui.activitys.mine.cabinet;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.share.bag.R;
import com.share.bag.SBUrls;
import com.share.bag.ui.pay.BuyActivity;

import java.util.List;

/**
 * Created by Administrator on 2018/3/27.
 */

public class CabinetAdapter extends RecyclerView.Adapter<CabinetAdapter.ViewHolder> {
    private Context context;
    private List<CabinetBean.InfoBean> list;

    public CabinetAdapter(Context context, List<CabinetBean.InfoBean> list) {
        this.context = context;
        this.list = list;
    }

    @Override
    public CabinetAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = View.inflate(context, R.layout.adapter_cabinet, null);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(CabinetAdapter.ViewHolder holder, final int position) {

        Glide.with(context).load(SBUrls.LOGURL + list.get(position).getImg()).into(holder.cablinet_adapter_img);

        final CabinetBean.InfoBean bean = list.get(position);
        holder.cablinet_adapter_name.setText(bean.getTitle());
        holder.cablinet_adapter_brands.setText(list.get(position).getBagbrand_id());
        holder.cablinet_adapter_size.setText(list.get(position).getBagsize_id());
        holder.cablinet_adapter_status.setText(list.get(position).getBagpay());
        holder.cablinet_adapter_colour.setText(bean.getColor());
        holder.cablinet_adapter_materials.setText(bean.getMaterial());
        holder.cablinet_adapter_numbering.setText(bean.getNumber());
        if (bean.getBagpay().equals("1")) {//已买断
            holder.cablinet_adapter_status.setText("已买断");
            holder.cablinet_adapter_rent_day.setVisibility(View.GONE);
            holder.cablinet_adapter_rent_day1.setVisibility(View.GONE);
            holder.cablinet_adapter_rent.setVisibility(View.GONE);
            holder.cablinet_adapter_buyout.setVisibility(View.GONE);
        } else if (bean.getBagpay().equals("2")) {
            holder.cablinet_adapter_status.setText("正在租");
            holder.cablinet_adapter_rent_day.setVisibility(View.VISIBLE);
            holder.cablinet_adapter_rent_day1.setVisibility(View.VISIBLE);
            holder.cablinet_adapter_rent.setVisibility(View.VISIBLE);
            holder.cablinet_adapter_buyout.setVisibility(View.VISIBLE);
            holder.cablinet_adapter_rent_day.setText(bean.getDay() + "天");
        } else if (bean.getBagpay().equals("3")) {
            holder.cablinet_adapter_rent_day.setText(bean.getDay() + "天");
            holder.cablinet_adapter_status.setText("已出租");
            holder.cablinet_adapter_rent_day.setVisibility(View.GONE);
            holder.cablinet_adapter_rent_day1.setVisibility(View.GONE);
            holder.cablinet_adapter_rent.setVisibility(View.GONE);
            holder.cablinet_adapter_buyout.setVisibility(View.GONE);
        }
        holder.cablinet_adapter_rent.setVisibility(View.GONE);
        holder.cablinet_adapter_share.setVisibility(View.GONE);
        holder.cablinet_adapter_rent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
        holder.cablinet_adapter_buyout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context, BuyActivity.class);
                intent.putExtra("imgUrl", bean.getImg());
                intent.putExtra("title", bean.getTitle());
                intent.putExtra("bagBrand", bean.getBagbrand_id());
                intent.putExtra("number", bean.getNumber());
                intent.putExtra("color", bean.getColor());
                intent.putExtra("material", bean.getMaterial());
                intent.putExtra("bagSize", bean.getBagsize_id());
                intent.putExtra("originalPrice", bean.getOld_price());
                intent.putExtra("nowPrice", bean.getNew_price());
                context.startActivity(intent);
            }
        });
        holder.cablinet_adapter_share.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });


     /*
        holder.recyler_name.setText(list.get(position).getTitle());
        holder.recyler_price.setText(list.get(position).getDays_money());
        holder.recyler_money.setText(list.get(position).getOriginalprice());
        holder.recyler_commodity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onitemlistener.Back(view, position);
            }
        });

        holder.recyler_Collection.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Map<String ,String> collection=new HashMap();
                collection.put("baglist_id",position+"");
                OkHttpUtils.getInstance().post(SBUrls.COLLECTION, collection, new MyNetWorkCallback<CollectionLookBean>() {
                    @Override
                    public void onSuccess(CollectionLookBean collectionBean) {
                    }

                    @Override
                    public void onError(int errorCode, String errorMsg) {
                    }
                });


                notifyDataSetChanged();
            }
        });

*/

    }

    public interface AdapterCallback {
        public void callBack(View v, int position);
    }

    private AdapterCallback callback;

    /**
     * 通过该方法连接起来
     **/
    public void setCallback(CabinetAdapter.AdapterCallback callback) {
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
        public ImageView cablinet_adapter_img, cablinet_adapter_share;

        private final TextView cablinet_adapter_name, cablinet_adapter_brands, cablinet_adapter_numbering,
                cablinet_adapter_colour, cablinet_adapter_materials, cablinet_adapter_size,
                cablinet_adapter_status1, cablinet_adapter_status, cablinet_adapter_rent_day1, cablinet_adapter_rent_day,
                cablinet_adapter_rent, cablinet_adapter_buyout;


        public ViewHolder(View itemView) {
            super(itemView);
            cablinet_adapter_img = (ImageView) itemView.findViewById(R.id.cablinet_adapter_img);
            cablinet_adapter_name = (TextView) itemView.findViewById(R.id.cablinet_adapter_name);//名字
            cablinet_adapter_brands = (TextView) itemView.findViewById(R.id.cablinet_adapter_brands);//品牌
            cablinet_adapter_numbering = (TextView) itemView.findViewById(R.id.cablinet_adapter_numbering);//编号


            cablinet_adapter_colour = (TextView) itemView.findViewById(R.id.cablinet_adapter_colour);//颜色
            cablinet_adapter_materials = (TextView) itemView.findViewById(R.id.cablinet_adapter_materials);//材质
            cablinet_adapter_size = (TextView) itemView.findViewById(R.id.cablinet_adapter_size);//尺寸


            cablinet_adapter_status1 = (TextView) itemView.findViewById(R.id.cablinet_adapter_status1);//状态
            cablinet_adapter_status = (TextView) itemView.findViewById(R.id.cablinet_adapter_status);//状态
            cablinet_adapter_rent_day1 = (TextView) itemView.findViewById(R.id.cablinet_adapter_rent_day1);//已租
            cablinet_adapter_rent_day = (TextView) itemView.findViewById(R.id.cablinet_adapter_rent_day);//已租


            cablinet_adapter_rent = (TextView) itemView.findViewById(R.id.cablinet_adapter_rent);//一键续租
            cablinet_adapter_buyout = (TextView) itemView.findViewById(R.id.cablinet_adapter_buyout);//立即买断
            cablinet_adapter_share = (ImageView) itemView.findViewById(R.id.cablinet_adapter_share);//分享

        }
    }

}
