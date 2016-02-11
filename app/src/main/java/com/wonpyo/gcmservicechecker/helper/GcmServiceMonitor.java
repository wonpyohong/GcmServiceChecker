package com.wonpyo.gcmservicechecker.helper;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.SystemClock;
import android.support.annotation.NonNull;
import android.util.Log;

import com.wonpyo.gcmservicechecker.receiver.AlarmReceiver;

/**
 * Created by wonpyohong on 2016. 2. 11..
 */
public class GcmServiceMonitor {
    Context context;
    AlarmManager alarmManager;

    public static String ACTION_CHECK = "com.wonpyo.gcmservicechecker.ACTION_CHECK";

    public GcmServiceMonitor(Context context) {
        this.context = context;
        alarmManager = (AlarmManager) context.getSystemService(Context.ALARM_SERVICE);
    }

    @NonNull
    private Intent createIntent() {
        Intent intent = new Intent(context, AlarmReceiver.class);
        intent.setAction(ACTION_CHECK);
        return intent;
    }

    public void startMonitoring() {
        Log.d("HWP", "startMonitoring() called");
        PendingIntent pendingIntent = PendingIntent.getBroadcast(context, 0, createIntent(), PendingIntent.FLAG_CANCEL_CURRENT);
        alarmManager.cancel(pendingIntent);
        alarmManager.setInexactRepeating(AlarmManager.ELAPSED_REALTIME, SystemClock.elapsedRealtime(), 5 * 60 * 1000, pendingIntent);
    }

    public void stopMonitoring() {
        Log.d("HWP", "stopMonitoring() called");

        PendingIntent pendingIntent = PendingIntent.getBroadcast(context, 0, createIntent(), PendingIntent.FLAG_CANCEL_CURRENT);
        if (pendingIntent != null) {
            alarmManager.cancel(pendingIntent);
        }
    }
}
