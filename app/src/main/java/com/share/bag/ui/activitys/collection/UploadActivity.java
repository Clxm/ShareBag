package com.share.bag.ui.activitys.collection;

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
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.share.bag.R;
import com.share.bag.ui.activitys.mine.avatar.PhotoUtils;
import com.share.bag.ui.activitys.mine.avatar.ToastUtils;

import java.io.ByteArrayOutputStream;
import java.io.File;

import static com.share.bag.ui.activitys.mine.PersonalActivity.hasSdcard;

/*
* 上传包包
* */
public class UploadActivity extends AppCompatActivity implements View.OnClickListener {

    private ImageView upload_return;
    private TextView textView7;
    private EditText uplad_brand;
    private RelativeLayout uplad_brand_relative1;
    private TextView text2;
    private EditText upload_original;
    private TextView text3;
    private TextView uplad_size;
    private RelativeLayout uplad_brand_relative3;
    private TextView text4;
    private EditText upload_material;
    private RelativeLayout uplad_brand_relative4;
    private TextView text5;
    private TextView textView2;
    private TextView textView9;
    private RelativeLayout uplad_brand_relative5;
    private TextView text6;
    private RadioButton java;
    private RadioButton dotNet;
    private RadioGroup radioGroup;
    private RelativeLayout uplad_brand_relative6;
    private TextView text7;
    private EditText upload_sell;
    private TextView text8;
    private Button upload_submit;
    private LinearLayout uplad_add1;
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
    private TextView uplad_adding1_name;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_upload);
        initView();


    }

    private void initView() {
        upload_return = (ImageView) findViewById(R.id.upload_return);
        textView7 = (TextView) findViewById(R.id.textView7);
        uplad_brand = (EditText) findViewById(R.id.uplad_brand);
        uplad_brand_relative1 = (RelativeLayout) findViewById(R.id.uplad_brand_relative1);
        text2 = (TextView) findViewById(R.id.text2);
        upload_original = (EditText) findViewById(R.id.upload_original);
        text3 = (TextView) findViewById(R.id.text3);
        uplad_size = (TextView) findViewById(R.id.uplad_size);
        uplad_brand_relative3 = (RelativeLayout) findViewById(R.id.uplad_brand_relative3);
        text4 = (TextView) findViewById(R.id.text4);
        upload_material = (EditText) findViewById(R.id.upload_material);
        uplad_brand_relative4 = (RelativeLayout) findViewById(R.id.uplad_brand_relative4);
        text5 = (TextView) findViewById(R.id.text5);
        textView2 = (TextView) findViewById(R.id.textView2);
        textView9 = (TextView) findViewById(R.id.textView9);
        uplad_brand_relative5 = (RelativeLayout) findViewById(R.id.uplad_brand_relative5);
        text6 = (TextView) findViewById(R.id.text6);
        java = (RadioButton) findViewById(R.id.java);
        dotNet = (RadioButton) findViewById(R.id.dotNet);
        radioGroup = (RadioGroup) findViewById(R.id.radioGroup);
        uplad_brand_relative6 = (RelativeLayout) findViewById(R.id.uplad_brand_relative6);
        text7 = (TextView) findViewById(R.id.text7);
        upload_sell = (EditText) findViewById(R.id.upload_sell);
        text8 = (TextView) findViewById(R.id.text8);
        upload_submit = (Button) findViewById(R.id.upload_submit);

        uplad_add1 = (LinearLayout) findViewById(R.id.uplad_add1);
        uplad_adding1_name = (TextView) findViewById(R.id.uplad_adding1_name);


        upload_return.setOnClickListener(this);
        uplad_add1.setOnClickListener(this);
        upload_submit.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.upload_return:
                finish();
                break;
            case R.id.uplad_add1:
                getPopupWindow();
                break;
            case R.id.upload_submit:
                submit1();
                break;
        }
    }

    private void submit1() {

        String uplad_brand1 = uplad_brand.getText().toString().trim();
        String upload_original1 = upload_original.getText().toString().trim();
        String uplad_size1 = uplad_size.getText().toString().trim();
        String upload_material1 = upload_material.getText().toString().trim();


        if (TextUtils.isEmpty(uplad_brand1)||TextUtils.isEmpty(upload_original1)||TextUtils.isEmpty(uplad_size1)||TextUtils.isEmpty(upload_material1)) {
            Toast.makeText(this, "请补全内容", Toast.LENGTH_SHORT).show();
        }else {






        }




    }

    private void submit() {
        // validate
        String brand = uplad_brand.getText().toString().trim();
        if (TextUtils.isEmpty(brand)) {
            Toast.makeText(this, "brand不能为空", Toast.LENGTH_SHORT).show();
            return;
        }

        String original = upload_original.getText().toString().trim();
        if (TextUtils.isEmpty(original)) {
            Toast.makeText(this, "请输入原价", Toast.LENGTH_SHORT).show();
            return;
        }

        String material = upload_material.getText().toString().trim();
        if (TextUtils.isEmpty(material)) {
            Toast.makeText(this, "请输入材质", Toast.LENGTH_SHORT).show();
            return;
        }

        String sell = upload_sell.getText().toString().trim();
        if (TextUtils.isEmpty(sell)) {
            Toast.makeText(this, "出售价格", Toast.LENGTH_SHORT).show();
            return;
        }


    }


    public void getPopupWindow() {
        WindowManager wm = (WindowManager) getApplication()
                .getSystemService(Context.WINDOW_SERVICE);

        int width = wm.getDefaultDisplay().getWidth();
        int height = wm.getDefaultDisplay().getHeight();

        //设置contentView
        View contentView = LayoutInflater.from(this).inflate(R.layout.popupwindow_avatar, null);
        window2 = new PopupWindow(contentView,
                width, height);
        window2.setContentView(contentView);
        //设置各个控件的点击响应
        LinearLayout popupwindow_avatar_shoot = (LinearLayout) contentView.findViewById(R.id.popupwindow_avatar_shoot);
        LinearLayout popupwindow_avatar_album = (LinearLayout) contentView.findViewById(R.id.popupwindow_avatar_album);

        //显示PopupWindow
        View rootview = LayoutInflater.from(this).inflate(R.layout.activity_personal2, null);
        window2.showAtLocation(rootview, Gravity.CENTER, 0, 0);
        popupwindow_avatar_shoot.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                autoObtainStoragePermission();
                window2.dismiss();
//                finish();
            }
        });
        popupwindow_avatar_album.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                autoObtainCameraPermission();
                window2.dismiss();


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
                    if (bitmap != null) {
                        showImages(bitmap);
                    }
                    break;
                case 1:
                    Intent intent=getIntent();
                    String str=data.getStringExtra("username");
//                    String tmp = intent.getStringExtra("username");
                    uplad_adding1_name.setText(str);
                    setResult(RESULT_OK,intent);

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
//-----------------------------------
//            Log.e("TAG","-------"+fileUri);
        } else {
            PhotoUtils.openPic(this, CODE_GALLERY_REQUEST);
        }
    }

    //    展示图片 进行网络请求
    private void showImages(Bitmap bitmap) {
//      压缩图片
        ByteArrayOutputStream onputStream = new ByteArrayOutputStream();
        bitmap.compress(Bitmap.CompressFormat.JPEG, 100, onputStream);
        final byte[] bytes = onputStream.toByteArray();

        Toast.makeText(this,bytes+"====="+bytes.toString(), Toast.LENGTH_SHORT).show();
        Log.e("TAGGGGG",""+bytes);


    }


}
