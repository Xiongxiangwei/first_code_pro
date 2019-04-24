package com.code.first.hendcoderdemo.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.CornerPathEffect;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PathDashPathEffect;
import android.graphics.PathEffect;
import android.graphics.PathMeasure;
import android.graphics.RectF;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;

public class CornerPathEffectTestView
        extends View
{
    Paint      mPaint      = new Paint();
    PathEffect mPathEffect = new CornerPathEffect(200);
    Path       mPath       = new Path();

    public CornerPathEffectTestView(Context context, @Nullable AttributeSet attrs)
    {
        super(context, attrs);
        mPaint.setStrokeWidth(20);
        mPaint.setStyle(Paint.Style.STROKE);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        switch (event.getActionMasked()) {
            case MotionEvent.ACTION_DOWN:
                mPath.reset();
                mPath.moveTo(event.getX(), event.getY());
                break;
            case MotionEvent.ACTION_MOVE:
                mPath.lineTo(event.getX(), event.getY());
                break;
            case MotionEvent.ACTION_CANCEL:
            case MotionEvent.ACTION_UP:
                break;
        }
        postInvalidate();
        return true;
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        // 绘制原始路径
//        canvas.save();
//        mPaint.setColor(Color.BLACK);
//        mPaint.setPathEffect(null);
//        canvas.drawPath(mPath, mPaint);
//        canvas.restore();
//
//        // 绘制带有效果的路径
//        canvas.save();
//        canvas.translate(0, canvas.getHeight() / 2);
//        mPaint.setColor(Color.RED);
//        mPaint.setPathEffect(mPathEffect);
//        canvas.drawPath(mPath, mPaint);
//        canvas.restore();
//        Path path_dash = new Path();
//        path_dash.lineTo(0, 1720);
//
//        canvas.save();
//        canvas.translate(980, 100);
//        mPaint.setPathEffect(new DashPathEffect(new float[]{200, 100}, 0));
//        canvas.drawPath(path_dash, mPaint);
//        canvas.restore();
//
//        canvas.save();
//        canvas.translate(400, 100);
//        mPaint.setPathEffect(new DashPathEffect(new float[]{200, 100}, 100));
//        canvas.drawPath(path_dash, mPaint);
//        canvas.restore();

        // 画笔初始设置
        Paint paint = new Paint();
        paint.setStyle(Paint.Style.STROKE);
        paint.setAntiAlias(true);

        RectF rectF = new RectF(0, 0, 50, 50);

        // 方形
        Path rectPath = new Path();
        rectPath.addRect(rectF, Path.Direction.CW);

        // 圆形 椭圆
        Path ovalPath = new Path();
        ovalPath.addOval(rectF, Path.Direction.CW);

        // 子弹形状
        Path bulletPath = new Path();
        bulletPath.lineTo(rectF.centerX(), rectF.top);
        bulletPath.addArc(rectF, -90, 180);
        bulletPath.lineTo(rectF.left, rectF.bottom);
        bulletPath.lineTo(rectF.left, rectF.top);

        // 星星形状
        PathMeasure pathMeasure = new PathMeasure(ovalPath, false);
        float       length      = pathMeasure.getLength();
        float       split       = length / 5;
        float[]     starPos     = new float[10];
        float[]     pos         = new float[2];
        float[]     tan         = new float[2];
        for (int i = 0; i < 5; i++) {
            pathMeasure.getPosTan(split * i, pos, tan);
            starPos[i * 2 + 0] = pos[0];
            starPos[i * 2 + 1] = pos[1];
        }
        Path starPath = new Path();
        starPath.moveTo(starPos[0], starPos[1]);
        starPath.lineTo(starPos[4], starPos[5]);
        starPath.lineTo(starPos[8], starPos[9]);
        starPath.lineTo(starPos[2], starPos[3]);
        starPath.lineTo(starPos[6], starPos[7]);
        starPath.lineTo(starPos[0], starPos[1]);
        Matrix matrix = new Matrix();
        matrix.postRotate(-90, rectF.centerX(), rectF.centerY());
        starPath.transform(matrix);


        canvas.translate(360, 100);
        // 绘制分割线 - 方形
        canvas.translate(0, 100);
        paint.setPathEffect(new PathDashPathEffect(rectPath, rectF.width() * 1.5f, 0, PathDashPathEffect.Style.TRANSLATE));
        canvas.drawLine(0, 0, 1200, 0, paint);

        // 绘制分割线 - 圆形
        canvas.translate(0, 100);
        paint.setPathEffect(new PathDashPathEffect(ovalPath, rectF.width() * 1.5f, 0, PathDashPathEffect.Style.TRANSLATE));
        canvas.drawLine(0, 0, 1200, 0, paint);

        // 绘制分割线 - 子弹型
        canvas.translate(0, 100);
        paint.setPathEffect(new PathDashPathEffect(bulletPath, rectF.width() * 1.5f, 0, PathDashPathEffect.Style.TRANSLATE));
        canvas.drawLine(0, 0, 1200, 0, paint);

        // 绘制分割线 - 星型
        canvas.translate(0, 100);
        paint.setPathEffect(new PathDashPathEffect(starPath, rectF.width() * 1.5f, 0, PathDashPathEffect.Style.TRANSLATE));
        canvas.drawLine(0, 0, 1200, 0, paint);
    }
}
