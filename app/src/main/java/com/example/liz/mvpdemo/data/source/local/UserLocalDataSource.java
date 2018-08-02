package com.example.liz.mvpdemo.data.source.local;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.liz.mvpdemo.data.model.User;
import com.example.liz.mvpdemo.data.source.UserDataSource;
import com.example.liz.mvpdemo.data.source.local.config.sqlite.DBUser;

import java.util.ArrayList;
import java.util.List;

public class UserLocalDataSource implements UserDataSource.LocalDataSource {
    private DBUser mDBUser;
    private static final String TABLE_NAME = "user";
    private static final String COLUMN_USERNAME = "username";
    private static final String COLUMN_PASSWORD = "password";
    private static final String COLUMN_EMAIL = "email";

    public UserLocalDataSource(DBUser DBUser) {
        mDBUser = DBUser;
    }

    @Override
    public void addUser(User user){
        SQLiteDatabase db = mDBUser.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(COLUMN_USERNAME,user.getUsername());
        values.put(COLUMN_PASSWORD,user.getPassword());
        values.put(COLUMN_EMAIL,user.getEmail());
        db.insert(TABLE_NAME,null,values);
        db.close();
    }

    @Override
    public List<User> getAllUser(){
        List<User> userList = new ArrayList<>();
        String selectQuery = "SELECT * FROM "+TABLE_NAME;
        SQLiteDatabase db = mDBUser.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery,null);
        cursor.moveToFirst();
        do{
            User user = new User();
            user.setUsername(cursor.getString(1));
            user.setPassword(cursor.getString(2));
            user.setEmail(cursor.getString(3));
        }while (cursor.moveToNext());
        cursor.close();
        db.close();
        return userList;
    }

    @Override
    public boolean checkUserPassword(String username, String password) {
        boolean STATE = false;
        String selectQuery = "SELECT * FROM "+TABLE_NAME;
        SQLiteDatabase db = mDBUser.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery,null);
        cursor.moveToFirst();
        do{
            String name = cursor.getString(1);
            String pass = cursor.getString(2);
            if(name.equals(username) & pass.equals(password)){
                STATE = true;
            }
        }while (cursor.moveToNext());
        cursor.close();
        db.close();
        return STATE;
    }

    @Override
    public boolean checkUserExists(String username) {
        boolean STATE = false;
        String selectQuery = "SELECT * FROM "+TABLE_NAME;
        SQLiteDatabase db = mDBUser.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery,null);
        cursor.moveToFirst();
        do{
            String name = cursor.getString(1);
            if(name.equals(username)){
                STATE = true;
            }
        }while (cursor.moveToNext());
        cursor.close();
        db.close();
        return STATE;
    }
}
