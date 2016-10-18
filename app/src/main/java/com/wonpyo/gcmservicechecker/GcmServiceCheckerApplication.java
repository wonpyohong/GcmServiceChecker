package com.wonpyo.gcmservicechecker;

import android.app.Application;

import com.facebook.stetho.Stetho;

/**
 * Created by wonpyohong on 2016. 2. 11..
 */
public class GcmServiceCheckerApplication extends Application {
    @Override
    public void onCreate() {
        super.onCreate();

        Stetho.initializeWithDefaults(this);

<<<<<<< HEAD
        int a = 2;
        String string = "test";
=======
        int a = 1;
        String string = "master";
>>>>>>> master
    }
}
