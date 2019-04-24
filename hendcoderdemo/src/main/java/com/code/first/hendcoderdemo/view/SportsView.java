package com.code.first.hendcoderdemo.view;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.View;

public class SportsView
        extends View
{

    private static final int CIRCLE_COLOR = Color.parseColor("#90A4AE");
    private static final int HIGHLIGHT_COLOR = Color.parseColor("#FF4081");
    private  Paint mPaint;
    private static final float RADIUS = dp2px(150);
    Paint.FontMetrics fontMetrics = new Paint.FontMetrics();

    public SportsView(Context context, @Nullable AttributeSet attrs)
    {
        super(context, attrs);
        mPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
        mPaint.setStyle(Paint.Style.STROKE);
        mPaint.setStrokeWidth(20);
        mPaint.setColor(CIRCLE_COLOR);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        //移动坐标系到中心
        canvas.translate(getWidth()/2,getHeight()/2);
        RectF rectF = new RectF(-RADIUS, -RADIUS, RADIUS, RADIUS);
        //绘制圆环
        canvas.drawCircle(0,0,RADIUS,mPaint);

        mPaint.setColor(HIGHLIGHT_COLOR);
        canvas.drawArc(rectF,-90,270,false,mPaint);

        // 绘制文字
        mPaint.setTextSize(dp2px(100));
        mPaint.setStyle(Paint.Style.FILL);
        mPaint.setTextAlign(Paint.Align.CENTER);
        //        paint.getTextBounds("abab", 0, "abab".length(), rect);
        float offset = (fontMetrics.ascent + fontMetrics.descent) / 2;
        canvas.drawText("abab", 0, offset*5, mPaint);
    }


    public static float dp2px(float dp) {
        return TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, dp, Resources.getSystem().getDisplayMetrics());
    }

}
