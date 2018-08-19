package mango.com.example.ly.mango.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.PixelFormat;
import android.graphics.Point;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.View;
import android.view.WindowManager;

/**
 * Created by ly on 2018/8/19.
 */

public class TouchView extends View {
    private final WindowManager mWindowManager;
    private final WindowManager.LayoutParams mLayoutParams;

    public TouchView(Context context) {
        this(context, null);
    }

    public TouchView(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public TouchView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        this(context, attrs, defStyleAttr, 0);
    }

    public TouchView(Context context, @Nullable AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        mWindowManager = (WindowManager) getContext().getSystemService(Context.WINDOW_SERVICE);
        mLayoutParams = new WindowManager.LayoutParams();
        initLayoutParams();
    }

    private void initLayoutParams() {
        Display display = mWindowManager.getDefaultDisplay();
        Point p = new Point();
        display.getRealSize(p);
        mLayoutParams.width = p.x;
        mLayoutParams.height = 20;
        mLayoutParams.x = 0;
        mLayoutParams.y = p.y - mLayoutParams.height;
        mLayoutParams.format = PixelFormat.TRANSLUCENT;
        mLayoutParams.type = WindowManager.LayoutParams.TYPE_APPLICATION_OVERLAY;
        mLayoutParams.flags = WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON;

    }

    public void show() {
        mWindowManager.addView(this, mLayoutParams);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        canvas.drawColor(Color.parseColor("#ff0000"));
    }
}
