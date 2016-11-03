package com.rocks.android.animations;

import android.app.Activity;
import android.content.Context;
import android.util.DisplayMetrics;

/**
 * Created by tele on 3/11/16.
 */
public class AppConfig {

    public static int getDeviceHeght(Activity mContext)
    {
        DisplayMetrics metrics=new DisplayMetrics();
        mContext.getWindowManager().getDefaultDisplay().getMetrics(metrics);
        return  metrics.heightPixels;
    }
}
