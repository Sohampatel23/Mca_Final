package com.example.savings_target;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        BottomNavigationView bottomnav = findViewById(R.id.btm);
        bottomnav.setOnNavigationItemSelectedListener(nav);


    }



    public BottomNavigationView.OnNavigationItemSelectedListener nav =
            new BottomNavigationView.OnNavigationItemSelectedListener() {
                @Override
                public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                    Fragment selectfrag = null;

                    switch (item.getItemId()){
                        case R.id.nav_dash:
                            selectfrag = new dashboardfragment();
                            break;

                        case R.id.nav_add:
                            selectfrag = new Targetfragment();
                            break;
                    }
                    getSupportFragmentManager().beginTransaction().replace(R.id.frm, selectfrag).commit();
                    return true;
                }
            };
}