package com.wonpyo.gcmservicechecker.db;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by wonpyohong on 2016. 2. 11..
 */
public class SqliteHelper extends SQLiteOpenHelper {
    public SqliteHelper(Context context, String name) {
        super(context, name + ".db", null, SqliteScheme.DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(SqliteScheme.GcmServiceLog.CREATE_STATEMENT);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL(SqliteScheme.GcmServiceLog.DROP_STATEMENT);

        db.execSQL(SqliteScheme.GcmServiceLog.CREATE_STATEMENT);
    }
}
