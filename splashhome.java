package com.example.savings_target;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

public class splashhome extends AppCompatActivity {
    int SPLASH_SCREEN = 5000;
    Animation topanim,bottomanim;
    TextView t1;
    ImageView imgv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splashhome);
        imgv = (ImageView)findViewById(R.id.i1);
        t1 = (TextView)findViewById(R.id.textView20);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager
                .LayoutParams.FLAG_FULLSCREEN);

        topanim = AnimationUtils.loadAnimation(splashhome.this,R.anim.top_animation);
        bottomanim = AnimationUtils.loadAnimation(splashhome.this,R.anim.bottom_anim);
        imgv.setAnimation(topanim);
        t1.setAnimation(bottomanim);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent in = new Intent(splashhome.this,MainActivity.class);
                startActivity(in);
                finish();
            }
        },SPLASH_SCREEN);
    }
}