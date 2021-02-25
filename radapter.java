package com.example.savings_target;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.SeekBar;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.cardview.widget.CardView;

import java.util.ArrayList;
import java.util.List;

public class radapter extends ArrayAdapter {
    List list = new ArrayList();
    public radapter(@NonNull Context context, int resource) { super(context, resource); }

    static class Layouthandler
    {
        TextView samount, snotes, date;
    }

    public void add(@Nullable Object object) {
        super.add(object);
        list.add(object);
    }

    public int getCount() {
        return list.size();
    }

    @Nullable
    @Override
    public Object getItem(int position) {
        return list.get(position);
    }

    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View row = convertView;
        radapter.Layouthandler layouthandler;
        if (row == null) {
            LayoutInflater layoutInflater = (LayoutInflater) this.getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            row = layoutInflater.inflate(R.layout.dis, parent, false);
            layouthandler = new radapter.Layouthandler();


            layouthandler.samount = (TextView) row.findViewById(R.id.samount);
            layouthandler.snotes = (TextView) row.findViewById(R.id.snotes);
            layouthandler.date = (TextView) row.findViewById(R.id.dates);

            row.setTag(layouthandler);
        } else {
            layouthandler = (radapter.Layouthandler) row.getTag();
        }
        rprovider adprovider = (rprovider) this.getItem(position);

        layouthandler.samount.setText(adprovider.getsamount());
        layouthandler.snotes.setText(adprovider.getsnotes());
        layouthandler.date.setText(adprovider.getDate());

//        final String g1 = layouthandler.gname.getText().toString();
//        final String g2 = layouthandler.gamount.getText().toString();
//        layouthandler.cv.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent in = new Intent(getContext(),actionsave.class);
//                in.putExtra("g1",g1);
//                in.putExtra("g2",g2);
//                getContext().startActivity(in);
//            }
//        });

        return row;
    }
}
