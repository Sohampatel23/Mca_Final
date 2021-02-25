package com.example.savings_target;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class targetdb extends SQLiteOpenHelper {
    public static final String Database_name = "target.db";
    public static final String tbl_name = "goals";
    public static final String col_1 = "id";
    public static final String col_2 = "gname";
    public static final String col_3 = "gamount";

    public targetdb(@Nullable Context context) {
        super(context, Database_name, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table " + tbl_name + " ( id INTEGER PRIMARY KEY , gname text, gamount text)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("drop table if exists " + tbl_name);
        onCreate(db);
    }

    public boolean insertdata(String gname,String gamount){
        SQLiteDatabase sql = this.getWritableDatabase();
        ContentValues cv = new ContentValues();
        cv.put(col_2, gname);
        cv.put(col_3, gamount);
        Long res = sql.insert(tbl_name, null, cv);
        if (res == -1)
            return false;
        else
            return true;
    }
}
