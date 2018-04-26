package com.share.bag.ui.activitys.collection;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.support.annotation.IdRes;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v4.content.FileProvider;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.RadioGroup;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.share.bag.R;
import com.share.bag.ui.activitys.mine.avatar.PhotoUtils;
import com.share.bag.ui.activitys.mine.avatar.ToastUtils;
import com.share.bag.utils.ImageUploadeUtils;
import com.share.bag.utils.okhttp.OkHttpUtils;
import com.share.bag.utils.okhttp.callback.MyNetWorkCallback;

import org.json.JSONException;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

import static com.share.bag.ui.activitys.mine.PersonalActivity.hasSdcard;

/*
* 上传包包
* */
public class UploadActivity extends AppCompatActivity implements View.OnClickListener {


    @BindView(R.id.iv_bag1)
    ImageView mIvBag1;
    @BindView(R.id.iv_bag2)
    ImageView mIvBag2;
    @BindView(R.id.iv_bag3)
    ImageView mIvBag3;
    @BindView(R.id.upload_return)
    ImageView mUploadReturn;
    @BindView(R.id.upload_submit)
    Button mUploadSubmit;
    @BindView(R.id.et_brand)
    EditText mEtBrand;
    @BindView(R.id.et_original_price)
    EditText mEtOriginalPrice;
    @BindView(R.id.tv_size_m)
    TextView mTvSizeM;
    @BindView(R.id.tv_size_l)
    TextView mTvSizeL;
    @BindView(R.id.tv_size_xl)
    TextView mTvSizeXl;
    @BindView(R.id.tv_day)
    TextView mTvDay;
    @BindView(R.id.tv_month)
    TextView mTvMonth;
    @BindView(R.id.tv_long)
    TextView mTvLong;
    @BindView(R.id.upload_material)
    EditText uploadMaterial;
    @BindView(R.id.upload_sell)
    EditText uploadSell;
    @BindView(R.id.radioGroup)
    RadioGroup radioGroup;

    private String url = "";
    private PopupWindow window2;

    private static final int CODE_GALLERY_REQUEST = 0xa0;
    private static final int CODE_CAMERA_REQUEST = 0xa1;
    private static final int CODE_RESULT_REQUEST = 0xa2;
    private static final int CAMERA_PERMISSIONS_REQUEST_CODE = 0x03;
    private static final int STORAGE_PERMISSIONS_REQUEST_CODE = 0x04;
    private Uri cropImageUri;
    private File fileCropUri = new File(Environment.getExternalStorageDirectory().getPath() + "/crop_photo.jpg");
    private Uri imageUri;
    private File fileUri = new File(Environment.getExternalStorageDirectory().getPath() + "/photo.jpg");
    private ImageView selectImage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_upload);
        ButterKnife.bind(this);
        setViewOnClick();
    }

    private void setViewOnClick() {
        mUploadReturn.setOnClickListener(this);
        mTvSizeM.setOnClickListener(this);
        mTvSizeL.setOnClickListener(this);
        mTvSizeXl.setOnClickListener(this);
        mTvDay.setOnClickListener(this);
        mTvMonth.setOnClickListener(this);
        mTvLong.setOnClickListener(this);
        mIvBag1.setOnClickListener(this);
        mIvBag2.setOnClickListener(this);
        mIvBag3.setOnClickListener(this);
        mUploadSubmit.setOnClickListener(this);
        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, @IdRes int i) {
                if (i == R.id.rb_yes) {
                    is_buy = "1";
                } else {
                    is_buy = "2";
                }
            }
        });
    }

    public void getPopupWindow() {
        //设置contentView
        View contentView = LayoutInflater.from(this).inflate(R.layout.popupwindow_avatar1, null);
        window2 = new PopupWindow(contentView, ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT);
        window2.setContentView(contentView);
        //设置各个控件的点击响应
        LinearLayout popupwindow_avatar_shoot1 = contentView.findViewById(R.id.popupwindow_avatar_shoot1);
        LinearLayout popupwindow_avatar_album1 = contentView.findViewById(R.id.popupwindow_avatar_album1);

        //显示PopupWindow
        View rootview = LayoutInflater.from(this).inflate(R.layout.activity_upload, null);

        WindowManager.LayoutParams lp = UploadActivity.this.getWindow().getAttributes();
        lp.alpha = 0.5f;
        UploadActivity.this.getWindow().addFlags(WindowManager.LayoutParams.FLAG_DIM_BEHIND);
        UploadActivity.this.getWindow().setAttributes(lp);
        window2.setTouchable(true);
        window2.setFocusable(true);
        window2.setOutsideTouchable(true);
        window2.setBackgroundDrawable(new BitmapDrawable());
        window2.showAtLocation(rootview, Gravity.CENTER, 0, 0);
        window2.update();
        window2.setOnDismissListener(new PopupWindow.OnDismissListener() {
            @Override
            public void onDismiss() {
                WindowManager.LayoutParams lp = UploadActivity.this.getWindow().getAttributes();
                lp.alpha = 1f;
                UploadActivity.this.getWindow().addFlags(WindowManager.LayoutParams.FLAG_DIM_BEHIND);
                UploadActivity.this.getWindow().setAttributes(lp);
            }
        });
        popupwindow_avatar_shoot1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                autoObtainStoragePermission();
                window2.dismiss();
            }
        });
        popupwindow_avatar_album1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                autoObtainCameraPermission();
                window2.dismiss();
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
                    break;
                //访问相册完成回调
                case CODE_GALLERY_REQUEST:
                    if (hasSdcard()) {
                        cropImageUri = Uri.fromFile(fileCropUri);
                        Uri newUri = Uri.parse(PhotoUtils.getPath(this, data.getData()));
                        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
                            newUri = FileProvider.getUriForFile(this, "com.zz.fileprovider", new File(newUri.getPath()));
                        }
                        PhotoUtils.cropImageUri(this, newUri, cropImageUri, 1, 1, OUTPUT_X, OUTPUT_Y, CODE_RESULT_REQUEST);
                    } else {
                        ToastUtils.showShort(this, "设备没有SD卡！");
                    }
                    break;
                case CODE_RESULT_REQUEST:
                    Bitmap bitmap = PhotoUtils.getBitmapFromUri(cropImageUri, this);
                    ImageUploadeUtils.upLoadImage(bitmap, new ImageUploadeUtils.UploadImageCallBack() {
                        @Override
                        public void onSuccess(String imageUrl) {
                            if (TextUtils.isEmpty(url)) {
                                url = imageUrl;
                            } else {
                                url = url + "," + imageUrl;
                            }
                            Glide.with(UploadActivity.this).load(imageUrl).into(selectImage);
                        }

                        @Override
                        public void onFail() {
                            com.share.bag.utils.ToastUtils.showTop(UploadActivity.this, "请重新上传图片");
                        }
                    });
                    break;
                case 1:
                    Intent intent = getIntent();
                    String str = data.getStringExtra("username");
//                    String tmp = intent.getStringExtra("username");
//                    mUpladAdding1Name.setText(str);
                    setResult(RESULT_OK, intent);

                    break;
                default:
            }
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
                    imageUri = FileProvider.getUriForFile(UploadActivity.this, "com.zz.fileprovider", fileUri);
                }
                PhotoUtils.takePicture(this, imageUri, CODE_CAMERA_REQUEST);

            } else {
                ToastUtils.showShort(this, "设备没有SD卡！");
            }
        }

    }

    private void autoObtainCameraPermission() {
        if (ContextCompat.checkSelfPermission(this, Manifest.permission.READ_EXTERNAL_STORAGE) != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.READ_EXTERNAL_STORAGE}, STORAGE_PERMISSIONS_REQUEST_CODE);
        } else {
            PhotoUtils.openPic(this, CODE_GALLERY_REQUEST);
        }
    }


    private String bage_size = "";
    private String bage_day = "";
    private String is_buy = "2";

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.upload_return:
                finish();
                break;
            case R.id.tv_size_m:
                bage_size = "1";
                mTvSizeM.setBackgroundColor(getResources().getColor(R.color.main_color));
                mTvSizeL.setBackgroundDrawable(getResources().getDrawable(R.drawable.textview_border));
                mTvSizeXl.setBackgroundDrawable(getResources().getDrawable(R.drawable.textview_border));
                break;
            case R.id.tv_size_l:
                bage_size = "2";
                mTvSizeM.setBackgroundDrawable(getResources().getDrawable(R.drawable.textview_border));
                mTvSizeL.setBackgroundColor(getResources().getColor(R.color.main_color));
                mTvSizeXl.setBackgroundDrawable(getResources().getDrawable(R.drawable.textview_border));
                break;
            case R.id.tv_size_xl:
                bage_size = "3";
                mTvSizeM.setBackgroundDrawable(getResources().getDrawable(R.drawable.textview_border));
                mTvSizeL.setBackgroundDrawable(getResources().getDrawable(R.drawable.textview_border));
                mTvSizeXl.setBackgroundColor(getResources().getColor(R.color.main_color));
                break;
            case R.id.tv_day:
                bage_day = "1";
                mTvDay.setBackgroundColor(getResources().getColor(R.color.main_color));
                mTvMonth.setBackgroundDrawable(getResources().getDrawable(R.drawable.textview_border));
                mTvLong.setBackgroundDrawable(getResources().getDrawable(R.drawable.textview_border));
                break;
            case R.id.tv_month:
                bage_day = "2";
                mTvDay.setBackgroundDrawable(getResources().getDrawable(R.drawable.textview_border));
                mTvMonth.setBackgroundColor(getResources().getColor(R.color.main_color));
                mTvLong.setBackgroundDrawable(getResources().getDrawable(R.drawable.textview_border));
                break;
            case R.id.tv_long:
                bage_day = "3";
                mTvMonth.setBackgroundDrawable(getResources().getDrawable(R.drawable.textview_border));
                mTvDay.setBackgroundDrawable(getResources().getDrawable(R.drawable.textview_border));
                mTvLong.setBackgroundColor(getResources().getColor(R.color.main_color));
                break;
            case R.id.iv_bag1:
                mIvBag1.setDrawingCacheEnabled(true);
                selectImage = mIvBag1;
                getPopupWindow();
                break;
            case R.id.iv_bag2:
                mIvBag2.setDrawingCacheEnabled(true);
                selectImage = mIvBag2;
                getPopupWindow();
                break;
            case R.id.iv_bag3:
                mIvBag3.setDrawingCacheEnabled(true);
                selectImage = mIvBag3;
                getPopupWindow();
                break;
            case R.id.upload_submit:
                String brand = mEtBrand.getText().toString().trim();//品牌
                String originalPrice = mEtOriginalPrice.getText().toString().trim();//原价
                String material = uploadMaterial.getText().toString().toString().trim();//材质
                String sell = uploadSell.getText().toString().trim();//出售价格

                if(TextUtils.isEmpty(brand)){
                    com.share.bag.utils.ToastUtils.showTop(UploadActivity.this,"包包品牌不能为空");
                    return;
                }
                if(TextUtils.isEmpty(originalPrice)){
                    com.share.bag.utils.ToastUtils.showTop(UploadActivity.this,"包包原价不能为空");
                    return;
                }
                if(TextUtils.isEmpty(bage_size)){
                    com.share.bag.utils.ToastUtils.showTop(UploadActivity.this,"包包尺码不能为空");
                    return;
                }
                if(TextUtils.isEmpty(material)){
                    com.share.bag.utils.ToastUtils.showTop(UploadActivity.this,"包包材质不能为空");
                    return;
                }
                if(TextUtils.isEmpty(bage_day)){
                    com.share.bag.utils.ToastUtils.showTop(UploadActivity.this,"包包出租时间不能为空");
                    return;
                }
                if("1".equals(is_buy)){
                    if(TextUtils.isEmpty(sell)){
                        com.share.bag.utils.ToastUtils.showTop(UploadActivity.this,"包包售价不能为空");
                        return;
                    }
                }

                if(TextUtils.isEmpty(url)){
                    com.share.bag.utils.ToastUtils.showTop(UploadActivity.this,"包包图片不能为空");
                    return;
                }
                HashMap<String,String> map = new HashMap<>();
                map.put("bagbrand",brand);
                map.put("bagsize_id",bage_size);
                map.put("bag_toprice",bage_day);
                map.put("backtype_id","1");
                map.put("originalprice",originalPrice);
                map.put("material",material);
                map.put("nowprice",sell);
                map.put("is_buy",is_buy);
                map.put("url",url);
                OkHttpUtils.getInstance().post("https://baobaoapi.ldlchat.com/Home/Backlist/getuserbag.html", map, new MyNetWorkCallback<Object>() {
                    @Override
                    public void onSuccess(Object o) throws JSONException {
                        com.share.bag.utils.ToastUtils.showTop(UploadActivity.this,"上传成功，等待审核");
                        finish();
                    }

                    @Override
                    public void onError(int errorCode, String errorMsg) {

                    }
                });


                break;
        }
    }
}
