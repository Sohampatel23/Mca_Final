package com.example.savings_target;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class actionsave extends AppCompatActivity {
CardView c1,c2;
TextView t;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_actionsave);
        t = (TextView)findViewById(R.id.textView6);
        c1 = (CardView)findViewById(R.id.add);
        c2 = (CardView)findViewById(R.id.report);

        Intent i = getIntent();
        final String name = i.getStringExtra("g1");
        final String amount = i.getStringExtra("g2");

        t.setText(name);

        c1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(actionsave.this,addsave.class);
                i.putExtra("gname",name);
                i.putExtra("gamount",amount);
                startActivity(i);
            }
        });

        c2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent in = new Intent(actionsave.this,detailed.class);
                in.putExtra("name",name);
                in.putExtra("amt",amount);
                startActivity(in);
            }
        });
    }
}