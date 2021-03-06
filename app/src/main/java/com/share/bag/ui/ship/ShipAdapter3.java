package com.share.bag.ui.ship;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.share.bag.R;
import com.share.bag.SBUrls;
import com.share.bag.utils.ToastUtils;
import com.share.bag.utils.okhttp.OkHttpUtils;
import com.share.bag.utils.okhttp.callback.MyNetWorkCallback;
import com.share.bag.view.YWXZAlertDialog;

import org.json.JSONException;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * @Author : TianFB
 * @Date : 2018/4/11
 * @Desrcibe ：
 */

public class ShipAdapter3 extends RecyclerView.Adapter{

    private List<ShipHttpBean3.InfoBean> mList = new ArrayList<>();
    private Context mContext;
    public ShipAdapter3(Context context, List<ShipHttpBean3.InfoBean> info){
        mList.clear();
        mList.addAll(info);
        mContext = context;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new MyHolder(LayoutInflater.from(mContext).inflate(R.layout.ship_item_3, parent, false));
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, final int position) {
        ShipHttpBean3.InfoBean bean = mList.get(position);
        MyHolder myHolder = (MyHolder) holder;
        myHolder.orderid.setText("订单编号: " +bean.getOrdernumber());
        Glide.with(mContext).load(SBUrls.LOGURL + bean.getImg()).into(myHolder.img);
        myHolder.title.setText(bean.getTitle());
        myHolder.nums.setText(bean.getNumber());
        myHolder.color.setText(bean.getColor());
        myHolder.brands.setText(bean.getBagbrand_id());
        myHolder.size.setText(bean.getBagsize_id());
        myHolder.money.setText("支付金额 ￥"+bean.getNowprice());
        myHolder.pay_order.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final YWXZAlertDialog dialog = new YWXZAlertDialog(mContext, "是否签收该商品？");
                dialog.setCancelBtnGone(true);
                dialog.setOnAlertDialogOnClick(new YWXZAlertDialog.AlertDialogOnClickListener() {
                    @Override
                    public void onYes() {
                        String url = "https://baobaoapi.ldlchat.com/Home/order/buttonsign.html";
                        HashMap<String,String> map = new HashMap<String, String>();
                        map.put("orderid",mList.get(position).getOrderid());
                        OkHttpUtils.getInstance().post(url, map, new MyNetWorkCallback<Object>() {
                            @Override
                            public void onSuccess(Object o) throws JSONException {
                                mList.remove(position);
                                notifyDataSetChanged();
                            }

                            @Override
                            public void onError(int errorCode, String errorMsg) {

                            }
                        });
                        dialog.dismiss();
                    }

                    @Override
                    public void onNo() {
                        dialog.dismiss();
                    }

                    @Override
                    public void onCancel() {

                    }
                });
                dialog.show();
            }
        });
        myHolder.cancle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(mContext, TransportLog.class);
                intent.putExtra("order_id",mList.get(position).getId());
                mContext.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return mList.size();
    }


    private class MyHolder extends RecyclerView.ViewHolder{
        TextView orderid;
        TextView title;
        TextView brands;
        TextView nums;
        TextView color;
        ImageView img;
        TextView size;
        TextView money;
        TextView cancle;
        TextView pay_order;
        public MyHolder(View itemView) {
            super(itemView);
            orderid = itemView.findViewById(R.id.orderid);
            img = itemView.findViewById(R.id.shared_adapter_img);
            title = itemView.findViewById(R.id.shared_adapter_name);
            brands = itemView.findViewById(R.id.shared_adapter_brands);
            nums = itemView.findViewById(R.id.shared_adapter_numbering);
            color = itemView.findViewById(R.id.shared_adapter_colour);
            size = itemView.findViewById(R.id.shared_adapter_size);
            money = itemView.findViewById(R.id.money);
            cancle = itemView.findViewById(R.id.cancle);
            pay_order = itemView.findViewById(R.id.pay_order);
        }
    }

}
