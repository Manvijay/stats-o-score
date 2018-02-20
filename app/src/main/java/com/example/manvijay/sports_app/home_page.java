package com.example.manvijay.sports_app;

import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.support.annotation.NonNull;
import android.support.design.internal.BottomNavigationItemView;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;

public class home_page extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_page);

        BottomNavigationView bottomNB= (BottomNavigationView) findViewById(R.id.bottom_navigation_bar);
        bottomNB.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                android.support.v4.app.FragmentManager fragmentManager= getSupportFragmentManager();
                android.support.v4.app.FragmentTransaction transaction = fragmentManager.beginTransaction();
                switch(item.getItemId()){
                    case R.id.current_matches_item:
                        transaction.replace(R.id.frame_layout, Current_Matches.newInstance());
                        transaction.commit();
                        break;
                    case R.id.rankings_item:
                        transaction.replace(R.id.frame_layout, Rankings.newInstance());
                        transaction.commit();
                        break;
                    case R.id.battlefield_item:
                        transaction.replace(R.id.frame_layout, Battlefield.newInstance());
                        transaction.commit();
                        break;
                }
                return true;

            }
        });

        android.support.v4.app.FragmentManager fragmentManager= getSupportFragmentManager();
        android.support.v4.app.FragmentTransaction transaction = fragmentManager.beginTransaction();
        transaction.replace(R.id.frame_layout, Current_Matches.newInstance());
        transaction.commit();
    }

}
