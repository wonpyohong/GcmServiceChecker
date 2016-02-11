package com.wonpyo.gcmservicechecker;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;

/**
 * Created by wonpyohong on 2016. 2. 11..
 */
public class AlarmReceiver extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
        GcmServiceChecker gcmServiceChecker = new GcmServiceChecker(context);
        Log.d("HWP", "isRunning: " + gcmServiceChecker.isRunningGcmService());
    }
}
