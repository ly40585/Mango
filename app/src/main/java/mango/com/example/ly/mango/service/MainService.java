package mango.com.example.ly.mango.service;

import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.os.IBinder;
import android.support.annotation.Nullable;
import android.view.WindowManager;

import mango.com.example.ly.mango.view.TouchView;

/**
 * Created by ly on 2018/8/19.
 */

public class MainService extends Service {
    private WindowManager mWindowManager;
    private TouchView mTouchView;

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override
    public void onCreate() {

        mWindowManager = (WindowManager) getSystemService(Context.WINDOW_SERVICE);
        mTouchView = new TouchView(this);
        mTouchView.show();
    }
}
