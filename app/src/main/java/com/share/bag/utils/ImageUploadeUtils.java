package com.share.bag.utils;

import android.graphics.Bitmap;

import com.qiniu.android.http.ResponseInfo;
import com.qiniu.android.storage.UpCompletionHandler;
import com.qiniu.android.storage.UploadManager;
import com.share.bag.SBUrls;
import com.share.bag.response.QiNiuToken;
import com.share.bag.utils.okhttp.OkHttpUtils;
import com.share.bag.utils.okhttp.callback.MyNetWorkCallback;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.ByteArrayOutputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

/**
 * @Author : TianFB
 * @Date : 2018/4/26
 * @Desrcibe ：图片上传工具类
 */

public class ImageUploadeUtils {


    private static String BASEURL = "http://om6im9i3r.bkt.clouddn.com/";


    public static void upLoadImage(final Bitmap bitmap, final UploadImageCallBack callBack) {

        Map<String, String> map = new HashMap<>();
        OkHttpUtils.getInstance().post(SBUrls.GET_QINIU_TOKEN, map, new MyNetWorkCallback<QiNiuToken>() {

            @Override
            public void onSuccess(QiNiuToken qiNiuToken) throws JSONException {
                String token = qiNiuToken.getInfo();
                if (null != token) {
                    UploadManager uploadManager = new UploadManager();
                    final String url = creatFileName()+".jpg";
                    uploadManager.put(convertIconToByte(bitmap), url, token,
                            new UpCompletionHandler() {
                                @Override
                                public void complete(String key, ResponseInfo info, JSONObject response) {
                                    if (info.isOK()) {
                                        callBack.onSuccess(BASEURL+url);
                                    } else {
                                        callBack.onFail();
                                    }
                                }
                            }, null);
                } else {
                    callBack.onFail();
                }
            }

            @Override
            public void onError(int errorCode, String errorMsg) {

            }
        });
    }

    /**
     * bitmap转byte[]
     */
    private static byte[] convertIconToByte(Bitmap bitmap) {
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        bitmap.compress(Bitmap.CompressFormat.PNG, 100, baos);
        byte[] icon = baos.toByteArray();
        return icon;
    }


    public interface UploadImageCallBack {
        void onSuccess(String imageUrl);

        void onFail();
    }

    private static String creatFileName() {
        Random random = new Random();
        //文件夹名字的长度
        int length = 10;//default
//      for(int i = 0; i <30; i++){
//          int a  = random.nextInt(10);
//          System.out.println(a);
        String numstr = "123456789";
        String chastr_b = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        String chastr_s = "abcdefghijklmnopqrstuvwxyz";
        String specil = "_";
        String base = numstr + chastr_b + chastr_s + specil;
        //文件夹名的规范文件夹不能包含以下字符：
        //井号 (#)；百分号 (%)；“&”；星号 (*)；竖线 (|)；反斜杠 (\)；冒号(:)；
        //双引号 (")；小于号 (<)；大于号 (>)；问号 (?)；斜杠 (/)；前导或尾随空格 (' ')；这样的空格将被去除；
        //需求是将文件名的大写开头，数字结尾
        StringBuffer sb = new StringBuffer();

        sb.append(chastr_b.charAt(random.nextInt(chastr_b.length())));
        for (int i = 0; i < length - 2; i++) {
            int num = random.nextInt(base.length());
            sb.append(base.charAt(num));
        }
        //追加最后一个数字
        sb.append(numstr.charAt(random.nextInt(numstr.length())));
        //System.out.println(sb.toString());
        return sb.toString();
    }

}
