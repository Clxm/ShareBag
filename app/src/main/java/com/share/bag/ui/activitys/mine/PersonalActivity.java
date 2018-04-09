package com.share.bag.ui.activitys.mine;

import android.Manifest;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v4.content.FileProvider;
import android.text.TextUtils;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.share.bag.GlideCircleTransform;
import com.share.bag.R;
import com.share.bag.SBUrls;
import com.share.bag.base.BaseActivity;
import com.share.bag.entity.UserName;
import com.share.bag.entity.selected.HeadImgBean;
import com.share.bag.ui.activitys.mine.avatar.PhotoUtils;
import com.share.bag.ui.activitys.mine.avatar.ToastUtils;
import com.share.bag.ui.activitys.mine.homepage.HomepageBean;
import com.share.bag.utils.okhttp.OkHttpUtils;
import com.share.bag.utils.okhttp.callback.MyNetWorkCallback;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.json.JSONException;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import butterknife.ButterKnife;
import butterknife.OnClick;

import static com.share.bag.R.id.personal_avatar1;


/*
*
* 个人中心
*
* */
public class PersonalActivity extends BaseActivity {

    private Uri newUri;
    private String ssssssssString=null;

    //    public static Intent getIntent(Context context) {
//        Intent intent = new Intent(context, PersonalActivity.class);
//        return intent;
//    }
    public static void actionStart(Context context, String data1) {
        Intent intent = new Intent(context, PersonalActivity.class);
        intent.putExtra("nickname", data1);
        context.startActivity(intent);
    }

    private int width;
    private int height;
    private PopupWindow window1;

    private static final int CODE_GALLERY_REQUEST = 0xa0;
    private static final int CODE_CAMERA_REQUEST = 0xa1;
    private static final int CODE_RESULT_REQUEST = 0xa2;
    private static final int CAMERA_PERMISSIONS_REQUEST_CODE = 0x03;
    private static final int STORAGE_PERMISSIONS_REQUEST_CODE = 0x04;
    private File fileUri = new File(Environment.getExternalStorageDirectory().getPath() + "/photo.jpg");
    private File fileCropUri = new File(Environment.getExternalStorageDirectory().getPath() + "/crop_photo.jpg");
    private Uri imageUri;
    private Uri cropImageUri;
    private ImageView personal_return;
    private ImageView imageView8;
    private RelativeLayout personal_avatar;
    private TextView personal_number;
    private ImageView imageView9;
    private RelativeLayout personal_phone;
    private TextView personal_name1;
    private ImageView imageView11;
    private RelativeLayout personal_nickname;
    private TextView textView17;
    private TextView textView15;
    private TextView textView16;
    private ImageView imageView12;
    private RelativeLayout personal_signature;
    private ImageView imgview;


    @Override
    public int initLayout() {
        return R.layout.activity_personal2;
    }

    @Override
    public void initView() {

        personal_return = (ImageView) findViewById(R.id.personal_return);
        imgview = (ImageView) findViewById(personal_avatar1);
        imageView8 = (ImageView) findViewById(R.id.imageView8);

        personal_avatar = (RelativeLayout) findViewById(R.id.personal_avatar);

        personal_number = (TextView) findViewById(R.id.personal_number);

        imageView9 = (ImageView) findViewById(R.id.imageView9);

        personal_phone = (RelativeLayout) findViewById(R.id.personal_phone);

        personal_name1 = (TextView) findViewById(R.id.personal_name1);


        imageView11 = (ImageView) findViewById(R.id.imageView11);

        personal_nickname = (RelativeLayout) findViewById(R.id.personal_nickname);

        textView17 = (TextView) findViewById(R.id.textView17);

        textView15 = (TextView) findViewById(R.id.textView15);

        textView16 = (TextView) findViewById(R.id.textView16);

        imageView12 = (ImageView) findViewById(R.id.imageView12);

        personal_signature = (RelativeLayout) findViewById(R.id.personal_signature);
        EventBus.getDefault().register(this);
    }

    @Override
    protected void onResume() {
        super.onResume();

        String url="https://baobaoapi.ldlchat.com/Home/my/getprofile.html";
        Map<String,String> map=new HashMap<>();
//SBUrls.APPID

        OkHttpUtils.getInstance().post(url, map, new MyNetWorkCallback<HomepageBean>() {
            @Override
            public void onSuccess(HomepageBean homepageBean) throws JSONException {

                HomepageBean.InfoBean info = homepageBean.getInfo();

                String iconurl = info.getIconurl();


                if (TextUtils.isEmpty(iconurl)) {

                    Glide.with(PersonalActivity.this)
                            .load("https://om6im9i3r.bkt.clouddn.com/2018-03-31_5abf5e2c3c574.png")
                            //设置圆角图片
//                .transform(new GlideRoundTransform(MainActivity.this, 10))
                            //设置圆形图片
                            .transform(new GlideCircleTransform(PersonalActivity.this))
                            .crossFade()
                            .into(imgview);
//                        return;
                }else {

                    Glide.with(PersonalActivity.this)
                            .load(iconurl)
                            //设置圆角图片
//                .transform(new GlideRoundTransform(MainActivity.this, 10))
                            //设置圆形图片
                            .transform(new GlideCircleTransform(PersonalActivity.this))
                            .crossFade()
                            .into(imgview);
                }
                String username = info.getUsername();
                personal_number.setText(username);
                String name = info.getName();
                personal_name1.setText(name);

                List<String> labels = info.getLabels();


//                for (int i = 0; i < labels.size(); i++) {
//
//                    String s = labels.get(i);
//
//                    personal_avatar1
//
//
//
//                }



            }

            @Override
            public void onError(int errorCode, String errorMsg) {

            }
        });



        Toast.makeText(this, "重新显示", Toast.LENGTH_SHORT).show();
        
//        FileUtil.Homepage(this, personal_name1, imgview, personal_number);
    }

    @Override
    protected void initData() {

    }

    @Override
    protected boolean hodeWindow() {
        return false;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // TODO: add setContentView(...) invocation

//
        ButterKnife.bind(this);
    }

    @OnClick({R.id.personal_return, R.id.personal_avatar, R.id.personal_phone, R.id.personal_nickname, R.id.personal_signature})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.personal_return://返回

                finish();

                break;
            case R.id.personal_avatar://修改头像
                getPopupWindow();
                break;
            case R.id.personal_phone://手机号
                startActivity(new Intent(PersonalActivity.this, PhoneActivity.class));
                break;
            case R.id.personal_nickname://昵称
                startActivityForResult(NameActivity.getIntent(this), 1);
                break;
            case R.id.personal_signature://个性签名

                break;
        }
    }


    public void getPopupWindow() {
        WindowManager wm = (WindowManager) getApplication()
                .getSystemService(Context.WINDOW_SERVICE);

        int width = wm.getDefaultDisplay().getWidth();
        int height = wm.getDefaultDisplay().getHeight();

        //设置contentView
        View contentView = LayoutInflater.from(this).inflate(R.layout.popupwindow_avatar, null);
        window1 = new PopupWindow(contentView,
                width, height);
        window1.setContentView(contentView);
        //设置各个控件的点击响应
        LinearLayout popupwindow_avatar_shoot = (LinearLayout) contentView.findViewById(R.id.popupwindow_avatar_shoot);
        LinearLayout popupwindow_avatar_album = (LinearLayout) contentView.findViewById(R.id.popupwindow_avatar_album);

        //显示PopupWindow
        View rootview = LayoutInflater.from(this).inflate(R.layout.activity_personal2, null);
        window1.showAtLocation(rootview, Gravity.CENTER, 0, 0);
        popupwindow_avatar_shoot.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                autoObtainStoragePermission();
                window1.dismiss();
//                finish();
            }
        });
        popupwindow_avatar_album.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                autoObtainCameraPermission();
                window1.dismiss();


//                finish();
            }
        });

    }

    private static final int OUTPUT_X = 480;
    private static final int OUTPUT_Y = 480;

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == RESULT_OK) {
            switch (requestCode) {
                //拍照完成回调
                case CODE_CAMERA_REQUEST:
                    cropImageUri = Uri.fromFile(fileCropUri);
                    PhotoUtils.cropImageUri(this, imageUri, cropImageUri, 1, 1, OUTPUT_X, OUTPUT_Y, CODE_RESULT_REQUEST);
                    Log.e("WOTAG1", "00000" + cropImageUri);
                    initLogin(cropImageUri);


                    break;
                //访问相册完成回调
                case CODE_GALLERY_REQUEST:
                    if (hasSdcard()) {
                        cropImageUri = Uri.fromFile(fileCropUri);
                        newUri = Uri.parse(PhotoUtils.getPath(this, data.getData()));
                        Log.e("WOTAG1", "22222222222" + newUri);
                        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
                            newUri = FileProvider.getUriForFile(this, "com.zz.fileprovider", new File(newUri.getPath()));
                            initLogin(newUri);
                        }
                        PhotoUtils.cropImageUri(this, newUri, cropImageUri, 1, 1, OUTPUT_X, OUTPUT_Y, CODE_RESULT_REQUEST);

                    } else {
                        ToastUtils.showShort(this, "设备没有SD卡！");
                    }


                    break;
                case CODE_RESULT_REQUEST:
                    Bitmap bitmap = PhotoUtils.getBitmapFromUri(cropImageUri, this);


                    if (bitmap != null) {
                        showImages(bitmap);
                        imgview.setImageBitmap(bitmap);
                    }
                    break;
                case 1:
                    Intent intent = getIntent();
                    String str = data.getStringExtra("username");

//                    String tmp = intent.getStringExtra("username");
                    personal_name1.setText(str);
                    setResult(RESULT_OK, intent);

                    break;
                default:
            }
        }
    }

    private void initLogin(Uri newUri) {
        Map<String,String> stringStringMap =new HashMap<>();

//        OkHttpUtils.getInstance().updataImg(SBUrls.UPDATA_IMG, stringStringMap, new MyNetWorkCallback<HeadImgBean>() {
//            @Override
//            public void onSuccess(HeadImgBean headImgBean) {
//
////                com.share.bag.utils.ToastUtils.show(PersonalActivity.this, bytes.toString() + "" + headImgBean.getInfo() + "-----" + headImgBean.getStatus());
//
////                Log.e("TAG", bytes.toString() + "" + headImgBean.getInfo() + "-----" + headImgBean.getStatus());
//
//
//            }
//
//            @Override
//            public void onError(int errorCode, String errorMsg) {
//                com.share.bag.utils.ToastUtils.show(PersonalActivity.this, "失败" + errorMsg);
//            }
//        });


    }

    //    展示图片 进行网络请求
    private void showImages(Bitmap bitmap) {
        //personal_avatar1.setImageBitmap(bitmap);


//        String url, Map<String, String> params, final ByteCallBack callback) {
//      压缩图片
        ByteArrayOutputStream onputStream = new ByteArrayOutputStream();
        bitmap.compress(Bitmap.CompressFormat.JPEG, 100, onputStream);
        final byte[] bytes = onputStream.toByteArray();

//           final Map<String, String> map = new HashMap<>();
//            final Map<String, String> stringObserverMap=new HashMap<>();
//        stringObserverMap.put("uploadAvatar",""+bytes);

//        OkHttpUtils.getInstance().post(SBUrls.UPDATA_IMG, stringObserverMap, new MyNetWorkCallback<HeadImgBean>() {
//            @Override
//            public void onSuccess(HeadImgBean headImgBean) {
//                Toast.makeText(PersonalActivity.this, "图片的二进制"+bytes.toString(), Toast.LENGTH_SHORT).show();
//
//                Log.e("TAG--------","图片的二进制"+bytes.toString());
//                com.share.bag.utils.ToastUtils.show(PersonalActivity.this , headImgBean.getInfo()+"返回值"+headImgBean.getStatus());
//
//
//            }
//
//            @Override
//            public void onError(int errorCode, String errorMsg) {
//
//            }
//        });
        // s上传头像
        OkHttpUtils.getInstance().updataImg(SBUrls.UPDATA_IMG, bytes, new MyNetWorkCallback<HeadImgBean>() {
            @Override
            public void onSuccess(HeadImgBean headImgBean) {

                com.share.bag.utils.ToastUtils.show(PersonalActivity.this, bytes.toString() + "" + headImgBean.getInfo() + "-----" + headImgBean.getStatus());


                Log.e("TAG11111",  headImgBean.getInfo() + "-----" + headImgBean.getStatus());

            }

            @Override
            public void onError(int errorCode, String errorMsg) {
                com.share.bag.utils.ToastUtils.show(PersonalActivity.this, "失败" + errorMsg);
            }
        });

    }

    private void autoObtainCameraPermission() {
        if (ContextCompat.checkSelfPermission(this, Manifest.permission.READ_EXTERNAL_STORAGE) != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.READ_EXTERNAL_STORAGE}, STORAGE_PERMISSIONS_REQUEST_CODE);
//-----------------------------------
//            Log.e("TAG","-------"+fileUri);
        } else {
            PhotoUtils.openPic(this, CODE_GALLERY_REQUEST);
        }
    }


    private void autoObtainStoragePermission() {

        if (ContextCompat.checkSelfPermission(this, Manifest.permission.CAMERA) != PackageManager.PERMISSION_GRANTED
                || ContextCompat.checkSelfPermission(this, Manifest.permission.READ_EXTERNAL_STORAGE) != PackageManager.PERMISSION_GRANTED) {

            if (ActivityCompat.shouldShowRequestPermissionRationale(this, Manifest.permission.CAMERA)) {
                ToastUtils.showShort(this, "您已经拒绝过一次");
            }
            ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.CAMERA, Manifest.permission.READ_EXTERNAL_STORAGE}, CAMERA_PERMISSIONS_REQUEST_CODE);
        } else {//有权限直接调用系统相机拍照
            if (hasSdcard()) {
                imageUri = Uri.fromFile(fileUri);
                //通过FileProvider创建一个content类型的Uri
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
                    imageUri = FileProvider.getUriForFile(PersonalActivity.this, "com.zz.fileprovider", fileUri);
                }
                PhotoUtils.takePicture(this, imageUri, CODE_CAMERA_REQUEST);
            } else {
                ToastUtils.showShort(this, "设备没有SD卡！");
            }
        }

    }

    /**
     * 检查设备是否存在SDCard的工具方法
     */
    public static boolean hasSdcard() {
        String state = Environment.getExternalStorageState();
        return state.equals(Environment.MEDIA_MOUNTED);
    }


    @Subscribe  //订阅事件
    public void onEventMainThread(UserName event) {
        personal_name1.setText(event.getName());

    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        //取消event注册
        EventBus.getDefault().unregister(this);
        if (window1 != null) {
            window1.dismiss();
        }
    }

    @Override
    protected void onStop() {
        super.onStop();
        if (window1 != null) {
            window1.dismiss();
        }
    }
}
