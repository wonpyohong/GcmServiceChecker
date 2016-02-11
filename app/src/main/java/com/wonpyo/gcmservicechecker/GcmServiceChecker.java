package com.wonpyo.gcmservicechecker;

import android.app.ActivityManager;
import android.content.Context;
import android.util.Log;

import java.util.List;

/**
 * Created by wonpyohong on 2016. 2. 11..
 */
public class GcmServiceChecker {
    Context context;
    ActivityManager activityManager;

    String PKG_NAME_OF_GCM_SERVICE = "com.google.android.gms.gcm.GcmService";

    public GcmServiceChecker(Context context) {
        this.context = context;
        activityManager = (ActivityManager) context.getSystemService(Context.ACTIVITY_SERVICE);
    }

    public String getClassNameOfGcmService() {
        return PKG_NAME_OF_GCM_SERVICE;
    }

    public boolean isRunningGcmService() {
        List<ActivityManager.RunningServiceInfo> runningServiceList = activityManager.getRunningServices(Integer.MAX_VALUE);

        for (ActivityManager.RunningServiceInfo runningServiceInfo : runningServiceList) {
            String packageName = runningServiceInfo.service.getClassName();

            Log.d("HWP", "packageName: " + packageName);

            if (packageName.equals(PKG_NAME_OF_GCM_SERVICE)) {
                return true;
            }
        }
        return false;
    }
}
