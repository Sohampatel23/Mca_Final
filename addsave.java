package com.example.savings_target;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;

public class addsave extends AppCompatActivity {
TextView t,t1;
EditText ed1,ed2;
Button b,b1;
savingsdb db;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_addsave);
        t = (TextView)findViewById(R.id.textView7);
        t1 = (TextView)findViewById(R.id.textView9);
        ed1 = (EditText)findViewById(R.id.saving);
        ed2 = (EditText)findViewById(R.id.note);
        b = (Button)findViewById(R.id.sv);
        db = new savingsdb(addsave.this);
        b1 = (Button)findViewById(R.id.check);

        Intent i = getIntent();
        final String gname = i.getStringExtra("gname");
        final String gamount = i.getStringExtra("gamount");

        t.setText(gname);
        t1.setText(gamount);


        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd-MMM-yyyy", Locale.getDefault());
        final String date = simpleDateFormat.format(Calendar.getInstance().getTime());

        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                boolean result = db.insertsave(t.getText().toString(),ed1.getText().toString(),ed2.getText().toString(),date);
                if (result == true) {
                    Toast.makeText(addsave.this, "Your saving is added", Toast.LENGTH_LONG).show();


                } else {
                    Toast.makeText(addsave.this, "saving is not added", Toast.LENGTH_LONG).show();

                }
            }
        });

        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(addsave.this,records.class);
                i.putExtra("sname",gname);
                startActivity(i);
            }
        });
    }
}