package com.example.liz.mvpdemo.data.source.local.config.sqlite;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;


public class DBUser extends SQLiteOpenHelper {
    private static final String DATABASE_NAME = "user_list";
    private static final String TABLE_NAME = "user";
    private static final String COLUMN_ID = "id";
    private static final String COLUMN_USERNAME = "username";
    private static final String COLUMN_PASSWORD = "password";
    private static final String COLUMN_EMAIL = "email";
    private static final int VERSION =  1;
    public DBUser(Context context) {
        super(context, DATABASE_NAME, null, VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String sqlQuery = "CREATE TABLE "+TABLE_NAME+"("+
                COLUMN_ID+" INTEGER PRIMARY KEY,"+
                COLUMN_USERNAME+" TEXT,"+
                COLUMN_PASSWORD+" TEXT,"+
                COLUMN_EMAIL+" TEXT)";
        db.execSQL(sqlQuery);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        db.execSQL("DROP TABLE IF EXISTS "+TABLE_NAME);
        onCreate(db);
    }

}
