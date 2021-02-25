package com.example.savings_target;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.widget.ListView;

public class records extends AppCompatActivity {

    ListView lv1;

    SQLiteDatabase SQLITEDATABASE;
    Cursor cursor;
    radapter radap;
    savingsdb db;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_records);
        lv1 = (ListView)findViewById(R.id.recordlist);
        db = new savingsdb(this);

        radap = new radapter(getApplicationContext(),R.layout.dis);
        lv1.setAdapter(radap);

        SQLITEDATABASE = db.getWritableDatabase();
        Intent i = getIntent();
        final String save = i.getStringExtra("sname");

        String selectQuery = "SELECT * FROM " + db.tbl_name +" WHERE " + db.col_2 + " = \"" + save + "\"";

        cursor = SQLITEDATABASE.rawQuery(selectQuery, null);
        if (cursor.moveToFirst()) {
            do {
                String samount,snotes,date;
                samount = cursor.getString(2);
                snotes = cursor.getString(3);
                date = cursor.getString(4);

                rprovider dataProvider = new rprovider(samount,snotes,date);
                radap.add(dataProvider);


            } while (cursor.moveToNext());
        }
    }
}