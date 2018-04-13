package com.share.bag.ui.activitys.collection;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.graphics.drawable.BitmapDrawable;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v4.content.FileProvider;
import android.support.v7.app.AppCompatActivity;
import android.text.Editable;
import android.text.InputType;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.util.Base64;
import android.util.Log;
import android.view.Gravity;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.Toast;

import com.share.bag.R;
import com.share.bag.SBUrls;
import com.share.bag.entity.ReleaseBagBean;
import com.share.bag.ui.activitys.mine.avatar.PhotoUtils;
import com.share.bag.ui.activitys.mine.avatar.ToastUtils;
import com.share.bag.utils.okhttp.OkHttpUtils;
import com.share.bag.utils.okhttp.callback.MyNetWorkCallback;

import org.json.JSONException;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import okio.Utf8;

import static com.share.bag.ui.activitys.mine.PersonalActivity.hasSdcard;

/*
* 发布包包
* */
public class Release extends AppCompatActivity implements View.OnClickListener {

    private static final int CODE_GALLERY_REQUEST = 0xa0;
    private static final int CODE_CAMERA_REQUEST = 0xa1;
    private static final int CODE_RESULT_REQUEST = 0xa2;
    private static final int CAMERA_PERMISSIONS_REQUEST_CODE = 0x03;
    private static final int STORAGE_PERMISSIONS_REQUEST_CODE = 0x04;
    private ImageView release2_return;
    private EditText release_et_input;
    private ImageView release2_add_photo1;
    private ImageView release2_add_photo2;
    private Button release2_button;
    private File fileCropUri = new File(Environment.getExternalStorageDirectory().getPath() + "/crop_photo.jpg");
    private Uri cropImageUri;
    private Uri imageUri;
    private List<ImageView> mImageViews = new ArrayList<>();
    private Uri mNewUri;
    private PopupWindow mWindow2;
    private String baglist_id;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_release2);
        initView();


//        EditText editText = new EditText(this);
//设置EditText的显示方式为多行文本输入
        release_et_input.setInputType(InputType.TYPE_TEXT_FLAG_MULTI_LINE);
//文本显示的位置在EditText的最上方
        release_et_input.setGravity(Gravity.TOP);
//改变默认的单行模式
        release_et_input.setSingleLine(false);
//水平滚动设置为False
        release_et_input.setHorizontallyScrolling(false);
        release_et_input.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if (s.length() > 140) { //判断EditText中输入的字符数是不是已经大于6
                    release_et_input.setText(s.toString().substring(0, 140)); //设置EditText只显示前面6位字符
                    release_et_input.setSelection(140);//让光标移至末端
                    Toast.makeText(Release.this, "输入字数已达上限", Toast.LENGTH_SHORT).show();
                    return;
                }

                //根据文字是否输入改变按钮的颜色
                if (TextUtils.isEmpty(release_et_input.getText().toString())) {
                    release2_button.setBackgroundColor(Color.parseColor("#E2E2E2"));
                    release2_button.setTextColor(Color.parseColor("#7F7F7F"));
                } else {
                    release2_button.setBackgroundColor(Color.parseColor("#F96662"));
                    release2_button.setTextColor(Color.WHITE);
                }
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

    }

    private void initView() {
        release2_return = (ImageView) findViewById(R.id.release2_return);
        release_et_input = (EditText) findViewById(R.id.release_et_input);
        release2_add_photo1 = (ImageView) findViewById(R.id.release2_add_photo1);
        release2_add_photo2 = (ImageView) findViewById(R.id.release2_add_photo2);
        release2_button = (Button) findViewById(R.id.release2_button);

        release2_button.setOnClickListener(this);
        release2_add_photo1.setOnClickListener(this);
        release2_add_photo2.setOnClickListener(this);
        release2_return.setOnClickListener(this);

        if (getIntent() != null) {
            baglist_id = getIntent().getStringExtra("id");
        }
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.release2_button:
                getsubmit();
                break;
            case R.id.release2_add_photo1:
                release2_add_photo1.setDrawingCacheEnabled(true);
                mImageViews.add(release2_add_photo1);
                getPopupWindow();
                break;
            case R.id.release2_add_photo2:
                release2_add_photo2.setDrawingCacheEnabled(true);
                mImageViews.add(release2_add_photo2);
                getPopupWindow();
                break;
            case R.id.release2_return:
                this.finish();
                break;
        }
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
                    PhotoUtils.cropImageUri(Release.this, imageUri, cropImageUri, 1, 1, OUTPUT_X, OUTPUT_Y, CODE_RESULT_REQUEST);
                    break;
                //访问相册完成回调
                case CODE_GALLERY_REQUEST:
                    if (hasSdcard()) {
                        cropImageUri = Uri.fromFile(fileCropUri);
                        mNewUri = Uri.parse(PhotoUtils.getPath(this, data.getData()));
                        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
                            mNewUri = FileProvider.getUriForFile(this, "com.share.bag.fileprovider", new File(mNewUri.getPath()));
                        }
                        PhotoUtils.cropImageUri(Release.this, mNewUri, cropImageUri, 1, 1, OUTPUT_X, OUTPUT_Y, CODE_RESULT_REQUEST);
                    } else {
                        ToastUtils.showShort(this, "设备没有SD卡！");
                    }
                    break;
                case CODE_RESULT_REQUEST:
                    Bitmap bitmap = PhotoUtils.getBitmapFromUri(cropImageUri, this);
                    if (bitmap != null) {
                        showImages(bitmap);
                        mImageViews.clear();
                    }
                    break;
            }
        }
    }


    private void showImages(Bitmap bitmap) {
//      压缩图片
        ByteArrayOutputStream mOnputStream = new ByteArrayOutputStream();
        bitmap.compress(Bitmap.CompressFormat.JPEG, 100, mOnputStream);
        final byte[] bytes = mOnputStream.toByteArray();

        for (int i = 0; i < mImageViews.size(); i++) {
            mImageViews.get(i).setImageBitmap(bitmap);
        }
    }

    private void autoObtainCameraPermission() {
        if (ContextCompat.checkSelfPermission(this, Manifest.permission.READ_EXTERNAL_STORAGE) != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.READ_EXTERNAL_STORAGE}, STORAGE_PERMISSIONS_REQUEST_CODE);
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
                File fileUri = new File(Environment.getExternalStorageDirectory().getPath() + "/photo.jpg");
                imageUri = Uri.fromFile(fileUri);
                //通过FileProvider创建一个content类型的Uri
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
                    imageUri = FileProvider.getUriForFile(Release.this, "com.zz.fileprovider", fileUri);
                }

                PhotoUtils.takePicture(this, imageUri, CODE_CAMERA_REQUEST);

            } else {
                ToastUtils.showShort(this, "设备没有SD卡！");
            }
        }

    }


    /**
     * 获取图片弹框
     */
    public void getPopupWindow() {

        //设置contentView
        View contentView = LayoutInflater.from(this).inflate(R.layout.popupwindow_avatar1, null);
        mWindow2 = new PopupWindow(contentView, ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT);
        mWindow2.setContentView(contentView);
        //设置各个控件的点击响应
        LinearLayout popupwindow_avatar_shoot1 = contentView.findViewById(R.id.popupwindow_avatar_shoot1);
        LinearLayout popupwindow_avatar_album1 = contentView.findViewById(R.id.popupwindow_avatar_album1);

        //显示PopupWindow
        View rootview = LayoutInflater.from(this).inflate(R.layout.activity_release2, null);

        WindowManager.LayoutParams lp = Release.this.getWindow().getAttributes();
        lp.alpha = 0.5f;
        Release.this.getWindow().addFlags(WindowManager.LayoutParams.FLAG_DIM_BEHIND);
        Release.this.getWindow().setAttributes(lp);
        mWindow2.setTouchable(true);
        mWindow2.setFocusable(true);
        mWindow2.setOutsideTouchable(true);
        mWindow2.setBackgroundDrawable(new BitmapDrawable());
        mWindow2.showAtLocation(rootview, Gravity.CENTER, 0, 0);
        mWindow2.update();
        mWindow2.setOnDismissListener(new PopupWindow.OnDismissListener() {
            @Override
            public void onDismiss() {
                WindowManager.LayoutParams lp = Release.this.getWindow().getAttributes();
                lp.alpha = 1f;
                Release.this.getWindow().addFlags(WindowManager.LayoutParams.FLAG_DIM_BEHIND);
                Release.this.getWindow().setAttributes(lp);
            }
        });
        popupwindow_avatar_shoot1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                //相机
                autoObtainStoragePermission();
                mWindow2.dismiss();
            }
        });
        popupwindow_avatar_album1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //相册
                autoObtainCameraPermission();
                mWindow2.dismiss();
            }
        });

    }

    /**
     * 上传文字和包包图片
     */
    public void getsubmit() {
        String input = release_et_input.getText().toString().trim();
        if (TextUtils.isEmpty(input)) {
            Toast.makeText(this, "请输入内容", Toast.LENGTH_SHORT).show();
            return;
        }
        Map<String, String> map = new HashMap<>();
        map.put("baglist_id", baglist_id);
        map.put("content", input);

        String file1, file2;
        if (release2_add_photo1.getDrawingCache() != null) {
            Bitmap photo1Bm = Bitmap.createBitmap(release2_add_photo1.getDrawingCache());
            file1 = convertIconToString(photo1Bm);
            map.put("file1", file1);
            release2_add_photo1.setDrawingCacheEnabled(false);
        }

        if (release2_add_photo2.getDrawingCache() != null) {
            Bitmap photo2Bm = Bitmap.createBitmap(release2_add_photo2.getDrawingCache());
            file2 = convertIconToString(photo2Bm);
            map.put("file2", file2);
            release2_add_photo2.setDrawingCacheEnabled(false);
        }

        OkHttpUtils.getInstance().post(SBUrls.RELEASE_TEXT_BAG, map, new MyNetWorkCallback<ReleaseBagBean>() {
            @Override
            public void onSuccess(ReleaseBagBean releaseBagBean) throws JSONException {
                Toast.makeText(Release.this, "发布成功", Toast.LENGTH_SHORT).show();
                release_et_input.setText("");
                Release.this.finish();
            }

            @Override
            public void onError(int errorCode, String errorMsg) {

            }
        });
    }

    /**
     * bitmap转String
     */
    public static String convertIconToString(Bitmap bitmap) {
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        bitmap.compress(Bitmap.CompressFormat.PNG, 100, baos);
        byte[] icon = baos.toByteArray();
        return Base64.encodeToString(icon, Base64.DEFAULT);
    }

    /**
     *
     * bitmap转file
     * @param bitmap
     * @return
     */
    public static File convertIconToFile(Bitmap bitmap) {
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        bitmap.compress(Bitmap.CompressFormat.JPEG, 100, baos);
//        byte[] icon = baos.toByteArray();
        int options = 100;
        while (baos.toString().length() / 1024 > 500) { //循环判断如果压缩后图片是否大于500kb,大于继续压缩
            baos.reset(); //重置baos即清空baos
            options -= 10; //每次都减少10
            bitmap.compress(Bitmap.CompressFormat.JPEG, options, baos); //这里压缩options%，把压缩后的数据存放到baos中
            long length = baos.toByteArray().length;
        }
        SimpleDateFormat format = new SimpleDateFormat("yyyyMMddHHmmss");
        Date date = new Date(System.currentTimeMillis());
        String fileName = format.format(date);
        File file = new File(Environment.getExternalStorageDirectory(), fileName + ".png");
        try {
            FileOutputStream fos = new FileOutputStream(file);
            fos.write(baos.toByteArray());
            fos.flush();
            fos.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return file;
    }

    /**
     * 释放bitmap
     * @param bitmaps
     */
    private static void recycleBitmap(Bitmap... bitmaps) {
        if (bitmaps == null) {
            return;
        }
        for (Bitmap bm : bitmaps) {
            if (null != bm && !bm.isRecycled()) {
                bm.recycle();
            }
        }
    }


    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (mWindow2 != null) {
            mWindow2.dismiss();
        }
        return super.onKeyDown(keyCode, event);
    }

    @Override
    protected void onStop() {
        super.onStop();
        if (mWindow2 != null) {
            mWindow2.dismiss();
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (mWindow2 != null) {
            mWindow2.dismiss();
        }

    }
}
