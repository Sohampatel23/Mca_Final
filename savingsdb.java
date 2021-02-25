package com.example.savings_target;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import java.util.Date;

public class savingsdb extends SQLiteOpenHelper {
    public static final String Database_name = "save.db";
    public static final String tbl_name = "saving";
    public static final String col_1 = "id";
    public static final String col_2 = "sname";
    public static final String col_3 = "samount";
    public static final String col_4 = "note";
    public static final String col_5 = "date";

    public savingsdb( Context context) {
        super(context,  Database_name, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table " + tbl_name + " ( id INTEGER PRIMARY KEY , sname text, samount text, note text, date date)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("drop table if exists " + tbl_name);
        onCreate(db);
    }

    public boolean insertsave(String sname, String samount, String note, String date){
        SQLiteDatabase sql = this.getWritableDatabase();
        ContentValues cv = new ContentValues();
        cv.put(col_2, sname);
        cv.put(col_3, samount);
        cv.put(col_4, note);
        cv.put(col_5, date);
        Long res = sql.insert(tbl_name, null, cv);
        if (res == -1)
            return false;
        else
            return true;
    }

    public  int totalsave()
    {
        int amt;
        SQLiteDatabase sq = this.getReadableDatabase();
        String qur = "SELECT (SUM(samount))  FROM " + tbl_name;
        Cursor cursor = sq.rawQuery(qur,null);
        if(cursor.moveToFirst())
        {
            amt = cursor.getInt(0);
        }
        else
        {
            amt = -1;
        }
        cursor.close();
        return amt;

    }
}
