package com.example.savings_target;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.ProgressBar;
import android.widget.TextView;

import org.joda.time.PeriodType;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Period;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import java.util.concurrent.TimeUnit;

import static com.example.savings_target.savingsdb.tbl_name;

public class detailed extends AppCompatActivity {

    private static  final String TAG = "detailed";
    TextView datp,dleft,sv,n,sv2,sv3,p;
    Cursor cursor;
    SQLiteDatabase s1;
    savingsdb db;
    ProgressBar pb;



    public DatePickerDialog.OnDateSetListener mDateSetListener;
    @RequiresApi(api = Build.VERSION_CODES.O)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detailed);
        dleft = (TextView)findViewById(R.id.dayleft);
        datp = (TextView)findViewById(R.id.date);
        sv = (TextView)findViewById(R.id.textView31);
        sv2 = (TextView)findViewById(R.id.textView41);
        sv3 = (TextView)findViewById(R.id.textView51);
        n = (TextView)findViewById(R.id.textView2);
        p = (TextView)findViewById(R.id.percent);
        db = new savingsdb(detailed.this);
        pb = (ProgressBar)findViewById(R.id.progress_bar);


        Intent i = getIntent();
        final String gname = i.getStringExtra("name");
        final String atm = i.getStringExtra("amt");

        sv2.setText(atm);
        int amt;
        n.setText(gname);
        s1 = db.getReadableDatabase();
        String qr = "SELECT (SUM(samount))  FROM " + savingsdb.tbl_name + " WHERE " + savingsdb.col_2 + " = \"" + gname + "\"";
        cursor = s1.rawQuery(qr,null);
        if(cursor.moveToFirst())
        {
            amt = cursor.getInt(0);
        }
        else
        {
            amt = -1;
        }
        cursor.close();

        String res = Integer.toString(amt);
        sv.setText(res);

        int n1 = Integer.parseInt(sv2.getText().toString());
        int n2 = Integer.parseInt(sv.getText().toString());
        int n3 = n1 - n2;
        String rr =  (String.valueOf(Integer.valueOf(n3)));
        sv3.setText(rr);



            float val = (float) n2/n1;
            float per = val * 100;
            int rer = (int)per;
            String re = String.valueOf(rer);
            p.setText(re);

            int k = rer;
            if(k<=100)
            {
                pb.setProgress(k);
                
            }


        datp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Calendar cal = Calendar.getInstance();
                int year = cal.get(Calendar.YEAR);
                int month = cal.get(Calendar.MONTH);
                int day = cal.get(Calendar.DAY_OF_MONTH);



                DatePickerDialog dialog = new DatePickerDialog(detailed.this,android.R.style.Theme_Black,mDateSetListener,year,month,day);
                dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));

                dialog.show();


            }
        });

        mDateSetListener = new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                month = month+1;
                Log.d(TAG,"onDateSet: dd/mm/yyyy: " + dayOfMonth + "/" + month + "/" + year);
                final String date = dayOfMonth + "/" + month + "/" + year;
                datp.setText(date);
            }

        };

        dleft.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd-MM-yyyy", Locale.getDefault());
                String dat = simpleDateFormat.format(Calendar.getInstance().getTime());
                String sd = datp.getText().toString();
                try{
                    Date d1 = simpleDateFormat.parse(dat);
                    Date d2 = simpleDateFormat.parse(sd);

                   long diff = Math.abs(d1.getTime() - d2.getTime());
//                   long dfdate = diff / (24*60*60*1000);
                    long dfdate
                            = (diff
                            / (1000 * 60 * 60 * 24))
                            % 365;


                    String res = Long.toString(dfdate);
                   dleft.setText(res + " days are left ");

                } catch (ParseException e) {
                    e.printStackTrace();
                }
            }
        });

    }
}