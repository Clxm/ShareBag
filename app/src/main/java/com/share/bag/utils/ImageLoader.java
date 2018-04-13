package com.share.bag.utils;

import android.content.Context;
import android.widget.ImageView;

import com.bumptech.glide.Glide;

/**
 * Created by lxm on 2018/4/13.
 * 不要再非主线程里面使用Glide加载图片，如果真的使用了，请把context参数换成getApplicationContext
 */

public class ImageLoader {
    public static void LoadLocalImg(ImageView aoView , Context aoContext, String astrPath){
        Glide.with(aoContext)
                .load(astrPath)
//                .placeholder(R.drawable.image_normal)
                .into(aoView);
    }

    public static void LoadLocalImgNoAnimation(ImageView aoView , Context aoContext, String astrPath){
        Glide.with(aoContext)
                .load(astrPath)
                .dontAnimate()
//                .placeholder(R.drawable.image_normal)
                .into(aoView);
    }
}
