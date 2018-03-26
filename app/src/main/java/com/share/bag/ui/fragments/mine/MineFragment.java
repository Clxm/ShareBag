package com.share.bag.ui.fragments.mine;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.share.bag.Constant;
import com.share.bag.FileUtil;
import com.share.bag.R;
import com.share.bag.base.BaseFragment;
import com.share.bag.ui.activitys.mine.BusinessActivity;
import com.share.bag.ui.activitys.mine.Login;
import com.share.bag.ui.activitys.mine.MySetActivity;
import com.share.bag.ui.activitys.mine.PersonalActivity;
import com.share.bag.ui.activitys.mine.ProblemActivity;
import com.share.bag.ui.activitys.mine.WalletActivity;
import com.share.bag.ui.activitys.mine.address.HarvestActivity;
import com.share.bag.ui.share.ShareActivity;
import com.share.bag.utils.SharePreUtils;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;

import static android.app.Activity.RESULT_OK;
import static com.share.bag.R.id.mine_cabinets;
import static com.share.bag.R.id.mine_data;

/*
* 我的
* */



/*
*
* <!--1、所有导航栏h：126px，白底；字：46px；#2b2b2b；中等（辅助文字40px，常规）导航栏下方线h:4px;#dedede

 -->
* */
public class MineFragment extends BaseFragment {

    @BindView(R.id.mine_avatar)
    ImageView mineAvatar;
//    @BindView(R.id.textView3)
//    TextView textView3;
    @BindView(R.id.mine_data)
    LinearLayout mineData;
    @BindView(R.id.imageView2)
    ImageView imageView2;
    @BindView(R.id.home_leisurerent0)
    TextView xiuRent1;
    @BindView(R.id.textView)
    TextView textView;
    @BindView(R.id.mine_cabinets)
    RelativeLayout mineCabinets;
    @BindView(R.id.imageView1)
    ImageView imageView1;
    @BindView(R.id.home_leisurename1)
    TextView xiuName1;
    @BindView(R.id.textView4)
    TextView textView4;
    @BindView(R.id.mine_shared)
    RelativeLayout mineShared;
    @BindView(R.id.mine_Pay)
    LinearLayout minePay;
    @BindView(R.id.mine_Sign)
    LinearLayout mineSign;
    @BindView(R.id.mine_ship)
    LinearLayout mineShip;
    @BindView(R.id.mine_return)
    LinearLayout mineReturn;
    @BindView(R.id.textView7)
    TextView textView7;
    @BindView(R.id.mine_wallet)
    RelativeLayout mineWallet;
    @BindView(R.id.text2)
    TextView text2;
    @BindView(R.id.mine_invite)
    RelativeLayout mineInvite;
    @BindView(R.id.text3)
    TextView text3;
    @BindView(R.id.mine_address)
    RelativeLayout mineAddress;
    @BindView(R.id.text4)
    TextView text4;
    @BindView(R.id.mine_contact)
    RelativeLayout mineContact;
    @BindView(R.id.text5)
    TextView text5;
    @BindView(R.id.mine_problem)
    RelativeLayout mineProblem;
    @BindView(R.id.text6)
    TextView text6;
    @BindView(R.id.mine_Complaints)
    RelativeLayout mineComplaints;
    @BindView(R.id.text7)
    TextView text7;
    @BindView(R.id.mine_cooperation)
    RelativeLayout mineCooperation;
    @BindView(R.id.text8)
    TextView text8;
    @BindView(R.id.mine_name)
    TextView mine_name;
    @BindView(R.id.mine_set)
    RelativeLayout mineSet;
    Unbinder unbinder;
    @BindView(R.id.mine_log)
    LinearLayout mine_log;

    private boolean isGetData = false;

    private Intent loginintent;
    private Intent loginintent1;
    private Intent myset;
    private String s;

    @Override
    public int initLayout() {
        return R.layout.china_fragment;

    }

    @Override
    public void initView(View view) {


    }

    @Override
    protected void initData() {

        FileUtil.MinereadFromPre(getActivity(),mine_name,mineAvatar);
        if (mine_name.getText().equals("")){
            Glide.with(getContext()).load(R.drawable.touxiang22).into(mineAvatar);
            mine_name.setText("请登录");
        }

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // TODO: inflate a fragment view
        View rootView = super.onCreateView(inflater, container, savedInstanceState);
        unbinder = ButterKnife.bind(this, rootView);
        return rootView;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode==0&&resultCode==RESULT_OK){
            if (data!=null){
                String name = data.getStringExtra("name");
                String img = data.getStringExtra("img");
                String str = "1234567";
                if(str.indexOf("23") != -1)
                {
                    System.out.println("包含该字符串");
                }

                if (img.indexOf("Uploads")!=-1){
                    Glide.with(getContext()).load("http://baobaoapi.ldlchat.com"+img).into(mineAvatar);

                }else {

                    Glide.with(getContext()).load(img).into(mineAvatar);
                }
                mine_name.setText(name);
            }


        }else if (requestCode==1&&resultCode==RESULT_OK){



        }
    }


    @OnClick({ R.id.mine_data,R.id.mine_cabinets,R.id.mine_wallet,R.id.mine_shared,
            R.id.mine_Pay, R.id.mine_Sign,R.id.mine_ship, R.id.mine_return,
            R.id.mine_invite, R.id.mine_address,R.id.mine_contact, R.id.mine_problem,
            R.id.mine_Complaints,R.id.mine_cooperation, R.id.mine_set,R.id.mine_log})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case mine_data://我的主页
                s = mine_name.getText().toString();
                if (s.toString().equals("请登录")){//登录
                    loginintent = new Intent(getActivity(), Login.class);
                    startActivityForResult(loginintent,0);
                }else {//个人中心
//                    startActivityForResult(PersonalActivity.getIntent(getActivity()),1);
                    startActivity(new Intent(getActivity(),PersonalActivity.class));



                }

                break;
            case mine_cabinets://我的包柜
                Toast.makeText(getActivity(), "我的包柜", Toast.LENGTH_SHORT).show();
                break;
            case R.id.mine_wallet://我的钱包
                if(SharePreUtils.getString(Constant.COOKIE , "").isEmpty()){
                    //登录
                    loginintent1 = new Intent(getActivity(), Login.class);
                }else{
                    //我的钱包
                    loginintent1=new Intent(getActivity(), WalletActivity.class);
                }
                startActivity(loginintent1);
                break;
            case R.id.mine_shared://正在共享
                Toast.makeText(getActivity(), "点击了正在共享", Toast.LENGTH_SHORT).show();
                break;
            case R.id.mine_Pay://代付款
                Toast.makeText(getActivity(), "点击了代付款", Toast.LENGTH_SHORT).show();
                break;
            case R.id.mine_Sign://待签收
                Toast.makeText(getActivity(), "点击了待签收", Toast.LENGTH_SHORT).show();
                break;
            case R.id.mine_ship://代发货
                Toast.makeText(getActivity(), "点击了代发货", Toast.LENGTH_SHORT).show();
                break;
            case R.id.mine_return://代归还

                Toast.makeText(getActivity(), "点击了代归还", Toast.LENGTH_SHORT).show();

                break;
            case R.id.mine_invite://邀请好友

                if (mine_name.getText().equals("请登录")) {//登录
                    Intent intent = new Intent(getActivity(), Login.class);
                    startActivity(intent);
                } else {//分享界面
//
                    Intent rentloginintent = new Intent(getActivity(), ShareActivity.class);
                    startActivity(rentloginintent);
                }
                break;
            case R.id.mine_address://我的地址


                if (mine_name.getText().equals("请登录")) {//登录
                    Intent intent = new Intent(getActivity(), Login.class);
                    startActivity(intent);
                } else {//分享界面
                    Intent intent1=new Intent(getActivity(), HarvestActivity.class);
                    startActivity(intent1);
                }

                break;

            case R.id.mine_contact://联系客服
//                Toast.makeText(getActivity(), "点击了联系客服", Toast.LENGTH_SHORT).show();

                break;

            case R.id.mine_problem://常见问题
                Intent intent3=new Intent(getActivity(), ProblemActivity.class);
                startActivity(intent3);

                break;
            case R.id.mine_Complaints://投诉建议
//                Toast.makeText(getActivity(), "点击了投诉建议", Toast.LENGTH_SHORT).show();

                break;
            case R.id.mine_cooperation://商务合作
                Intent intent1=new Intent(getActivity(), BusinessActivity.class);
                startActivity(intent1);

                break;
            case R.id.mine_set://设置
                if (mine_name.getText().equals("请登录")) {//登录
                    Intent intent = new Intent(getActivity(), Login.class);
                    startActivity(intent);
                } else {//分享界面
//
                    Intent rentloginintent = new Intent(getActivity(), MySetActivity.class);
                    startActivity(rentloginintent);
                }
                break;

            case R.id.mine_log://头像
                if (mine_name.getText().equals("请登录")) {//登录
                    Intent intent = new Intent(getActivity(), Login.class);
                    startActivity(intent);
                } else {
                }
                break;
        }
    }

    @Override
    public void onHiddenChanged(boolean hidden) {
        super.onHiddenChanged(hidden);
        if (!hidden){

        }
    }

    @Override
    public Animation onCreateAnimation(int transit, boolean enter, int nextAnim) {

        //   进入当前Fragment
        if (enter && !isGetData) {
            isGetData = true;
            //   这里可以做网络请求或者需要的数据刷新操作
            FileUtil.MinereadFromPre(getActivity(),mine_name,mineAvatar);

            String wwwwString = mine_name.getText().toString().trim();
            if (TextUtils.isEmpty(wwwwString)) {
                mine_name.setText("请登录");
                Glide.with(getContext()).load(R.drawable.touxiang22).into(mineAvatar);
            }

        } else {
            isGetData = false;
        }
        return super.onCreateAnimation(transit, enter, nextAnim);
    }

    @Override
    public void onResume() {
        super.onResume();
        if (!isGetData) {
            //   这里可以做网络请求或者需要的数据刷新操作
            FileUtil.MinereadFromPre(getActivity(),mine_name,mineAvatar);
            String wwwwString = mine_name.getText().toString().trim();
            if (TextUtils.isEmpty(wwwwString)) {
                mine_name.setText("请登录");
                Glide.with(getContext()).load(R.drawable.touxiang22).into(mineAvatar);

            }
            isGetData = true;
        }
    }

    @Override
    public void onPause() {
        super.onPause();
        isGetData = false;
    }
}