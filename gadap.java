package com.example.savings_target;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.SeekBar;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.cardview.widget.CardView;

import java.util.ArrayList;
import java.util.List;

public class gadap extends ArrayAdapter {

    List list = new ArrayList();
    public gadap(@NonNull Context context, int resource) { super(context, resource); }

    static class Layouthandler
    {
        TextView gname, gamount;
        SeekBar seekBar;
        CardView cv;
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
        gadap.Layouthandler layouthandler;
        if (row == null) {
            LayoutInflater layoutInflater = (LayoutInflater) this.getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            row = layoutInflater.inflate(R.layout.display, parent, false);
            layouthandler = new gadap.Layouthandler();


            layouthandler.gname = (TextView) row.findViewById(R.id.gname);
            layouthandler.gamount = (TextView) row.findViewById(R.id.gamount);
            layouthandler.seekBar = (SeekBar) row.findViewById(R.id.seekBar);
            layouthandler.cv = (CardView) row.findViewById(R.id.cvs);
            row.setTag(layouthandler);
        } else {
            layouthandler = (gadap.Layouthandler) row.getTag();
        }
        gprovider adprovider = (gprovider) this.getItem(position);

        layouthandler.gname.setText(adprovider.getGname());
        layouthandler.gamount.setText(adprovider.getGamount());

        final String g1 = layouthandler.gname.getText().toString();
        final String g2 = layouthandler.gamount.getText().toString();
        layouthandler.cv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent in = new Intent(getContext(),actionsave.class);
                in.putExtra("g1",g1);
                in.putExtra("g2",g2);
                getContext().startActivity(in);
            }
        });

        return row;
    }
}
