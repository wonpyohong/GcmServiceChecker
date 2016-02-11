package com.wonpyo.gcmservicechecker.receiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

import com.wonpyo.gcmservicechecker.helper.GcmServiceChecker;
import com.wonpyo.gcmservicechecker.db.LogLocalStore;

/**
 * Created by wonpyohong on 2016. 2. 11..
 */
public class AlarmReceiver extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
        GcmServiceChecker gcmServiceChecker = new GcmServiceChecker(context);

        LogLocalStore logLocalStore = new LogLocalStore(context);
        boolean isRunningGcmService = gcmServiceChecker.isRunningGcmService();
        logLocalStore.appendLog(isRunningGcmService);
    }
}
