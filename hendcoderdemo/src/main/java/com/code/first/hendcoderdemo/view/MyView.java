package com.code.first.hendcoderdemo.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

public class MyView extends View {

    Paint mPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
    private int mWidth;
    private int mHeight;

    public MyView(Context context, @Nullable AttributeSet attrs)
    {
        super(context, attrs);
        initPaint();
    }

    private void initPaint() {
        mPaint.setColor(Color.RED);
        mPaint.setStrokeWidth(8);
        mPaint.setStyle(Paint.Style.STROKE);
    }


    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        mWidth = getMeasuredWidth();
        mHeight = getMeasuredHeight();
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
//        mPaint.setColor(Color.RED);
//        canvas.drawLine(300,300,500,600,mPaint);    // 在坐标(300,300)(500,600)之间绘制一条直线
//        mPaint.setColor(Color.BLUE);
//        canvas.drawLines(new float[]{               // 绘制一组线 每四数字(两个点的坐标)确定一条线
//                                                    100,200,200,200,
//                                                    100,300,200,300
//        },mPaint);
//        mPaint.setColor(Color.GREEN);
//        canvas.drawLine(100,100,200,200,mPaint);
//
//        mPaint.setColor(Color.BLACK);
//        canvas.translate(400,400);
//        canvas.drawCircle(0,0,100,mPaint);
//
//        // 在坐标原点绘制一个蓝色圆形
//        mPaint.setColor(Color.BLUE);
//        canvas.translate(200,200);
//        canvas.drawCircle(0,0,100,mPaint);

        // 将坐标系原点移动到画布正中心
//        canvas.translate(mWidth / 2, mHeight / 2);
//
//        RectF rect = new RectF(0, -400, 400, 0);   // 矩形区域
//
//        mPaint.setColor(Color.BLACK);           // 绘制黑色矩形
//        canvas.drawRect(rect,mPaint);
//
//
//        canvas.scale(-0.5f,-0.5f,200,0);          // 画布缩放  <-- 缩放中心向右偏移了200个单位
//
//        mPaint.setColor(Color.BLUE);            // 绘制蓝色矩形
//        canvas.drawRect(rect,mPaint);

        // 将坐标系原点移动到画布正中心
//        canvas.translate(mWidth / 2, mHeight / 2);
//
//        RectF rect = new RectF(-400, -400, 400, 400);   // 矩形区域
//
//        for (int i=0; i<=20; i++)
//        {
//            canvas.scale(0.9f,0.9f);
//            canvas.drawRect(rect,mPaint);
//        }
        // 将坐标系原点移动到画布正中心
//        canvas.translate(mWidth / 2, mHeight / 2);
//
//        canvas.drawCircle(0,0,400,mPaint);          // 绘制两个圆形
//        canvas.drawCircle(0,0,380,mPaint);
//
//        for (int i=0; i<=360; i+=10){               // 绘制圆形之间的连接线
//            canvas.drawLine(0,380,0,400,mPaint);
//            canvas.rotate(10);
//        }
//        String str = "SLOOP";
//        Paint textPaint = new Paint();          // 创建画笔
//        textPaint.setColor(Color.BLACK);        // 设置颜色
//        textPaint.setStyle(Paint.Style.FILL);   // 设置样式
//        textPaint.setTextSize(50);              // 设置字体大小
//        canvas.drawPosText(str,new float[]{
//                100,100,    // 第一个字符位置
//                200,200,    // 第二个字符位置
//                300,300,    // ...
//                400,400,
//                500,500
//        },textPaint);
        RectF rectF2 = new RectF(100, 700, 600, 1200);
        // 绘制背景矩形
        mPaint.setColor(Color.BLUE);
        canvas.drawRect(rectF2,mPaint);

        // 绘制圆弧
        mPaint.setColor(Color.BLUE);
        canvas.drawArc(rectF2,180,90,true,mPaint);
    }
}
