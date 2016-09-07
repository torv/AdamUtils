package com.torv.adam.adamutils;

import android.app.Application;

import com.torv.adam.utils.log.L;

/**
 * Created by AdamLi on 2016/9/7.
 */
public class DemoApp extends Application{

    @Override
    public void onCreate() {
        super.onCreate();

        L.setIsDebug(BuildConfig.DEBUG);
        L.setDefaultTag("DemoApp");
    }
}
