package com.code.first.a06_draw.view;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.RectF;
import android.graphics.Xfermode;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.View;

import com.code.first.a06_draw.R;

public class AvatarView extends View {

    private static final float WIDTH = dp2px(300);
    private static final float PADDING = dp2px(50);
    private static final float EDGE_WIDTH = dp2px(10);
    private Bitmap mAvatar;
    Paint    paint     = new Paint(Paint.ANTI_ALIAS_FLAG);
    RectF    savedArea = new RectF();
    Xfermode xfermode  = new PorterDuffXfermode(PorterDuff.Mode.SRC_IN);
    public AvatarView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }
    {
        mAvatar = getAvatar((int) WIDTH);
    }


    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);
        savedArea.set(PADDING, PADDING, PADDING + WIDTH, PADDING + WIDTH);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.drawOval(PADDING, PADDING, PADDING + WIDTH, PADDING + WIDTH, paint);
        int saved = canvas.saveLayer(savedArea, paint);
        canvas.drawOval(PADDING + EDGE_WIDTH, PADDING + EDGE_WIDTH, PADDING + WIDTH - EDGE_WIDTH, PADDING + WIDTH - EDGE_WIDTH, paint);
        paint.setXfermode(xfermode);
        canvas.drawBitmap(mAvatar, PADDING, PADDING, paint);
        paint.setXfermode(null);
        canvas.restoreToCount(saved);

    }

    private Bitmap getAvatar(int width) {
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inJustDecodeBounds=true;
        BitmapFactory.decodeResource(getResources(), R.mipmap.avatar,options);
        options.inJustDecodeBounds=false;
        options.inDensity=options.outWidth;
        options.inTargetDensity=width;
        return  BitmapFactory.decodeResource(getResources(), R.mipmap.avatar,options);
    }

    public static float dp2px(float dp) {
        return TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, dp, Resources.getSystem().getDisplayMetrics());
    }
}
