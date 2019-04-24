package com.code.first.a06_draw.view;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Paint;
import android.graphics.Path;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.View;

public class Dashboard
        extends View
{
    private static final int ANGLE = 120;
    private static final float RADIUS = dp2px(150);
    private static final float LENGTH = dp2px(100);
    private final Paint mPaint;
    private final Path mDash;

    public Dashboard(Context context, @Nullable AttributeSet attrs)
    {
        super(context, attrs);
        mPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
        mPaint.setStyle(Paint.Style.STROKE);
        mPaint.setStrokeWidth(dp2px(2));
        mDash = new Path();
        mDash.addRect(0, 0, dp2px(2), dp2px(10), Path.Direction.CW);
        Path arc = new Path();
        arc.addArc(getWidth()/2-RADIUS,getHeight()/2-RADIUS,getWidth()/2+RADIUS,getHeight()/2+RADIUS,180,ANGLE);
    }


    public static float dp2px(float dp) {
        return TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, dp, Resources.getSystem().getDisplayMetrics());
    }
}
