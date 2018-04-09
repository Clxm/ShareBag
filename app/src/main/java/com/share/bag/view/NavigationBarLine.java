package com.share.bag.view;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.View;

/**
 * 首页底部导航栏分隔线
 * Created by lxm on 2018/4/3.
 */

public class NavigationBarLine extends View {

    //弧形宽度的比例
    private double mWScale = 0.12;
    //弧形宽高的比例
    private double mWHScale = 2.59;
    private int mScreenWidth;
    //弧线的宽度
    private int mCircleWidth = 0;
    //弧线的高度
    private int mCircleHeight = 34;
    //弧线的颜色
    private String mLineColor = "#D7D7D7";

    public NavigationBarLine(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        Resources resources = context.getResources();
        DisplayMetrics dm = resources.getDisplayMetrics();
        float density = dm.density;
        mScreenWidth = dm.widthPixels;
        mCircleWidth = (int) (mScreenWidth * mWScale);
        mCircleHeight = (int) (mCircleWidth / mWHScale);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        int width = MeasureSpec.getSize(widthMeasureSpec);
        setMeasuredDimension(width, mCircleHeight);
    }

    @Override
    public void draw(Canvas canvas) {
        super.draw(canvas);
        Paint paint = new Paint();
        paint.setColor(Color.parseColor(mLineColor));
        paint.setStrokeWidth(1);
        paint.setAntiAlias(true);
        paint.setStyle(Paint.Style.STROKE);
        int lineWidth = (mScreenWidth - mCircleWidth) / 2;

        //先画第一条线
        canvas.drawLine(0f, mCircleHeight, lineWidth, mCircleHeight, paint);

        //画半圆
        Path path = new Path();
        path.reset();
        path.moveTo(lineWidth, mCircleHeight);
        path.quadTo(mScreenWidth / 2, mCircleHeight - mCircleWidth / 2, lineWidth + mCircleWidth, mCircleHeight);
        paint.setColor(Color.WHITE);
        paint.setStyle(Paint.Style.FILL);
        canvas.drawPath(path, paint);
        paint.setColor(Color.parseColor(mLineColor));
        paint.setStyle(Paint.Style.STROKE);
        canvas.drawPath(path, paint);

        //画第二条线
        canvas.drawLine(lineWidth + mCircleWidth, mCircleHeight, mScreenWidth, mCircleHeight, paint);

    }
}
