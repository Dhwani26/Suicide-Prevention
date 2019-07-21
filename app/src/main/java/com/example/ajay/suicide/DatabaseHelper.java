package com.example.ajay.suicide;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.support.annotation.Nullable;

public class DatabaseHelper extends SQLiteOpenHelper {

    public static final String DATABASE_NAME = "suicide_prevention.db";
    public static final String TABLE1_NAME = "places";
    public static final String TABLE2_NAME = "reasons";
    public static final String COL_1 = "ID";
    public static final String COL_2 = "CONTENT";

    public DatabaseHelper(@Nullable Context context) {
        super(context,DATABASE_NAME, null, 1);

    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table "+ TABLE1_NAME + " (ID INTEGER PRIMARY KEY AUTOINCREMENT , CONTENT TEXT)");
        db.execSQL("create table "+ TABLE2_NAME + " (ID INTEGER PRIMARY KEY AUTOINCREMENT , CONTENT TEXT)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS "+ TABLE1_NAME);
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS "+ TABLE2_NAME);
        onCreate(sqLiteDatabase);
    }

    public boolean insertPlace(String data){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(COL_2, data);
        long result = db.insert(TABLE1_NAME, null, contentValues);
        if(result == -1)
            return false;
        else
            return true ;
    }

    public boolean insertReason(String data){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(COL_2, data);
        long result = db.insert(TABLE2_NAME, null, contentValues);
        if(result == -1)
            return false;
        else
            return true ;
    }

    public Cursor getAllPLaces(){
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor res = db.rawQuery("select * from "+ TABLE1_NAME, null);
        return res;
    }

    public Cursor getAllReasons(){
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor res = db.rawQuery("select * from "+ TABLE2_NAME, null);
        return res;
    }
}
