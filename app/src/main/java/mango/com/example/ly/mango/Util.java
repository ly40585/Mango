package mango.com.example.ly.mango;

import android.content.Context;
import android.content.Intent;

import mango.com.example.ly.mango.service.MainService;

/**
 * Created by ly on 2018/8/19.
 */

public class Util {

    public static void enable(Context context, boolean enable) {
        if (enable) {
            context.startService(new Intent(context, MainService.class));
        } else {
            context.stopService(new Intent(context, MainService.class));
        }
    }

}
