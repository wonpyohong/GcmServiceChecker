package com.wonpyo.gcmservicechecker;

import android.content.Context;

import com.google.android.gms.gcm.GoogleCloudMessaging;

import java.io.IOException;

/**
 * Created by wonpyohong on 2016. 2. 11..
 */
public class GcmServiceStarterThread extends Thread {
    Context context;

    public GcmServiceStarterThread(Context context) {
        this.context = context;
    }


    @Override
    public void run() {
        try {
            GoogleCloudMessaging.getInstance(context).register("2776479566");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
