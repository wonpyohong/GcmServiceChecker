package com.wonpyo.gcmservicechecker.db;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

/**
 * Created by wonpyohong on 2016. 2. 11..
 */
public class LogLocalStore {
    private SqliteHelper sqliteHelper;

    public LogLocalStore(Context context) {
        sqliteHelper = new SqliteHelper(context, "gcm_service_log");
    }

    public void appendLog(boolean isRunningGcmService) {
        ContentValues contentValues = new ContentValues();
        contentValues.put(SqliteScheme.GcmServiceLog.COLUMN_IS_RUNNING, isRunningGcmService ? 1 : 0);

        SQLiteDatabase db = sqliteHelper.getWritableDatabase();
        db.insert(SqliteScheme.GcmServiceLog.TABLE_NAME, null, contentValues);

        Log.d("HWP", "isRunningGcmService: " + isRunningGcmService);
    }
}
