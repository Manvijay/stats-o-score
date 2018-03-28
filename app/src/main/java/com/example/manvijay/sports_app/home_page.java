
package com.example.manvijay.sports_app;

/**
 * Created by Deepak on 25-03-2018.
 */

import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Intent;
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
                        //Calling the Current_matches fragment
                    case R.id.current_matches_item:
                        transaction.replace(R.id.frame_layout, Current_Matches.newInstance());
                        transaction.commit();
                        break;
                        
                        //Calling the Rankings Fragment
                    case R.id.rankings_item:
                        transaction.replace(R.id.frame_layout, Rankings.newInstance());
                        transaction.commit();
                        break;
                        
                        //Calling the Search Acticity
                    case R.id.battlefield_item:
                        Intent intent = new Intent(home_page.this , SearchActivity.class);
                        startActivity(intent);
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

    //Exiting the app when clicking the back button
    @Override
    public void onBackPressed() {
        Intent intent = new Intent(Intent.ACTION_MAIN);
        intent.addCategory(Intent.CATEGORY_HOME);
        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);//***Change Here***
        startActivity(intent);
        finish();
        System.exit(0);
    }


}
