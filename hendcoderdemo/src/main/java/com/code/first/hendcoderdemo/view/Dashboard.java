package com.code.first.hendcoderdemo.view;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PathDashPathEffect;
import android.graphics.PathMeasure;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.View;

public class Dashboard extends View{
    private static final int ANGLE = 120;
    private static final float RADIUS = dp2px(150);
    private static final float LENGTH = dp2px(100);
    private  Paint mPaint;
    private  Path  mDash;
    private  PathDashPathEffect mEffect;

    public Dashboard(Context context, @Nullable AttributeSet attrs)
    {
        super(context, attrs);
        mPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
        mPaint.setStyle(Paint.Style.STROKE);
        mPaint.setStrokeWidth(dp2px(2));
        mDash = new Path();
        mDash.addRect(0, 0, dp2px(2), dp2px(10), Path.Direction.CW);
        Path arc = new Path();
        arc.addArc(getWidth()/2-RADIUS,getHeight()/2-RADIUS,getWidth()/2+RADIUS,getHeight()/2+RADIUS,90+ANGLE/2,360-ANGLE);

        PathMeasure pathMeasure = new PathMeasure(arc, false);
        mEffect = new PathDashPathEffect(mDash,
                                         (pathMeasure.getLength() - dp2px(
                                                                               2)) / 20,
                                         0,
                                         PathDashPathEffect.Style.ROTATE);
    }


    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        //画弧度
        canvas.drawArc(getWidth() / 2 - RADIUS,
                       getHeight() / 2 - RADIUS,
                       getWidth() / 2 + RADIUS,
                       getHeight() / 2 + RADIUS,90+ANGLE/2,360-ANGLE,false,mPaint);

        //划刻度
        mPaint.setPathEffect(mEffect);
        canvas.drawArc(getWidth() / 2 - RADIUS, getHeight() / 2 - RADIUS, getWidth() / 2 + RADIUS , getHeight() / 2 + RADIUS, 90 + ANGLE / 2, 360 - ANGLE, false, mPaint);
        mPaint.setPathEffect(null);

        // 画指针
        canvas.drawLine(getWidth() / 2, getHeight() / 2,
                        (float) Math.cos(Math.toRadians(getAngleFromMark(5))) * LENGTH + getWidth() / 2,
                        (float) Math.sin(Math.toRadians(getAngleFromMark(5))) * LENGTH + getHeight() / 2,
                        mPaint);
//        canvas.translate(getWidth() / 2, getHeight() / 2);          // 平移坐标系
//
//        Path path = new Path();                                     // 创建Path并添加了一个矩形
//        path.addRect(-200, -200, 200, 200, Path.Direction.CW);
//
//        Path dst = new Path();                                      // 创建用于存储截取后内容的 Path
//        dst.lineTo(-300, -300);                                     // <--- 在 dst 中添加一条线段
//
//        PathMeasure measure = new PathMeasure(path, false);         // 将 Path 与 PathMeasure 关联
//
//        measure.getSegment(200, 600, dst, false);                   // 截取一部分 并使用 moveTo 保持截取得到的 Path 第一个点的位置不变
//
//        canvas.drawPath(dst, mPaint);                        // 绘制 Path
    }

    public static float dp2px(float dp) {
        return TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, dp, Resources.getSystem().getDisplayMetrics());
    }

    int getAngleFromMark(int mark) {
        return (int) (90 + (float) ANGLE / 2 + (360 - (float) ANGLE) / 20 * mark);
    }
}
