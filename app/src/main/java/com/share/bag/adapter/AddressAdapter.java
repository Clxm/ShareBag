package com.share.bag.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.TextView;
import android.widget.Toast;

import com.share.bag.R;
import com.share.bag.entity.AddressAdapterBean;
import com.share.bag.ui.activitys.mine.address.AddBean1;
import com.share.bag.utils.okhttp.OkHttpUtils;
import com.share.bag.utils.okhttp.callback.MyNetWorkCallback;

import org.json.JSONException;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2017/12/29.
 */
/*
*
* */
public class AddressAdapter extends RecyclerView.Adapter<AddressAdapter.ViewHolder>{
    private Context context;
    private List<AddBean1> list;
    public AddressAdapter(Context context, List<AddBean1> list) {
        this.context = context;
        this.list = list;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view=View.inflate(context, R.layout.harvest_item1,null);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, final int position) {


        holder.add_name.setText(list.get(position).getUsername());
        holder.add_dizhi.setText(list.get(position).getAddress());
        holder.add_shoujihao.setText(list.get(position).getPhone());
        holder.add_add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(context, "点击了修改", Toast.LENGTH_SHORT).show();






            }
        });

        holder.add_shanchu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String shanchuurl="http://baobaoapi.ldlchat.com/Home/Personalcenter/del.html";
                   Map<String ,String > stringString=new HashMap<String, String>();
                   stringString.put("id",""+position);
                   OkHttpUtils.getInstance().post(shanchuurl, stringString, new MyNetWorkCallback<AddressAdapterBean>() {
                       @Override
                       public void onSuccess(AddressAdapterBean addressAdapterBean) throws JSONException {
                       }
                       @Override
                       public void onError(int errorCode, String errorMsg) {
                       }
                   });
                        list.remove(position);
                        notifyDataSetChanged();
            }
        });
/*/*
通过checkbox.isChecked();是判断后是否选中，

checkbox.setChecked(true)选中。

checkbox.setChecked(false)未选中。
* */
//        if (list.get(position).getIs_type().equals("0")) {
//            holder.add_checkbox1.setChecked(false);
//
//        } else {
//
//            holder.add_checkbox1.setChecked(true);
//        }

       holder.add_checkbox1.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View view) {
               Toast.makeText(context, "设置为默认网址", Toast.LENGTH_SHORT).show();
//                   String shoucangurl="http://baobaoapi.ldlchat.com/Home/Personalcenter/fortype.html";
//                   Map<String ,String > stringStringMap=new HashMap<String, String>();
//                   stringStringMap.put("id",""+position);
//                   OkHttpUtils.getInstance().post(shoucangurl, stringStringMap, new MyNetWorkCallback<AddressAdapterBean>() {
//                       @Override
//                       public void onSuccess(AddressAdapterBean addressAdapterBean) throws JSONException {
//                       }
//
//                       @Override
//                       public void onError(int errorCode, String errorMsg) {
//
//                       }
//                   });
////               if (list.get(position).getIs_type().equals("1")) {
////                   list.get(position).setIs_type("0");
//////                   list.get(position).setIs_type("1");
////               } else {
////                   list.get(position).setIs_type("1");
//////                   list.get(position).setIs_type("0");
////               }
//                notifyDataSetChanged();
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
        private final TextView add_dizhi,add_name,add_shoujihao,add_add,add_shanchu;
        private final CheckBox add_checkbox1;
        public ViewHolder(View itemView) {
            super(itemView);
            add_dizhi = (TextView) itemView.findViewById(R.id.add_dizhi);
            add_name = (TextView) itemView.findViewById(R.id.add_name);
            add_shoujihao = (TextView) itemView.findViewById(R.id.add_shoujihao);
            add_add = (TextView) itemView.findViewById(R.id.add_add);
            add_shanchu = (TextView) itemView.findViewById(R.id.add_shanchu);
            add_checkbox1 = (CheckBox) itemView.findViewById(R.id.add_checkbox1);
        }
    }

}
