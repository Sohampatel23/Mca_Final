package com.example.savings_target;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.SeekBar;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;

public class dashboardfragment extends Fragment {

    ListView lv1;

    SQLiteDatabase sql1;
    Cursor c1;
    gadap gadap;
    targetdb db1;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.dashboard, container, false);
        lv1 = (ListView) view.findViewById(R.id.lsv1);
        db1 = new targetdb(getContext());
        gadap = new gadap(getContext(), R.layout.display);
        lv1.setAdapter(gadap);
        sql1 = db1.getReadableDatabase();

        String selectquery = "SELECT * FROM " + targetdb.tbl_name;
        c1 = sql1.rawQuery(selectquery, null);
        if (c1.moveToFirst()) {
            do {

                String gname, gamount;
                gname = c1.getString(1);
                gamount = c1.getString(2);
                gprovider disprovider = new gprovider(gname, gamount);
                gadap.add(disprovider);
            } while (c1.moveToNext());

        }
        return view;
    }
}
