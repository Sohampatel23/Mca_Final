package com.example.savings_target;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class Targetfragment extends Fragment  {
    EditText t1,t2;
    Button b1;
    targetdb db;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {


        View view = inflater.inflate(R.layout.add_target,container,false);
        t1 = (EditText) view.findViewById(R.id.gname);
        t2 = (EditText) view.findViewById(R.id.gamount);
        b1 = (Button) view.findViewById(R.id.done);
        db = new targetdb(getContext());

        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                boolean result = db.insertdata(t1.getText().toString(),t2.getText().toString());
                if (result == true) {
                    Toast.makeText(getContext(), "Your Goal is added", Toast.LENGTH_LONG).show();


                } else {
                    Toast.makeText(getContext(), "Goal is not added", Toast.LENGTH_LONG).show();

                }
            }
        });
        return view;
    }
}
