package com.wonpyo.gcmservicechecker.db;

/**
 * Created by wonpyohong on 2016. 2. 11..
 */
public class SqliteScheme {
    public static int DB_VERSION = 1000;

    interface GcmServiceLog {
        String TABLE_NAME = "GcmServiceRunningLog";
        String COLUMN_TIMESTAMP = "timeStamp";
        String COLUMN_IS_RUNNING = "isGcmServiceRunning";

        String CREATE_STATEMENT = "CREATE TABLE "+ TABLE_NAME + "("
                + COLUMN_TIMESTAMP + " DATETIME DEFAULT CURRENT_TIMESTAMP, "
                + COLUMN_IS_RUNNING + " INTEGER DEFAULT 0)";

        String DROP_STATEMENT = "DROP TABLE IF EXISTS " + TABLE_NAME;
    }
}
