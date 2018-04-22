package com.example.manvijay.sports_app;

/* Created by Deepak */

import android.app.Fragment;
import android.app.FragmentManager;
import android.content.Intent;
import android.graphics.Typeface;
import android.os.Parcelable;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.io.InputStream;
import java.io.Serializable;
import java.util.List;

public class SearchActivity extends AppCompatActivity  {


    // Declaring all the EditTexts, Button, and ImageViews as private
    private Button startbattle;
    private EditText l_search;
    private EditText r_search;
    private TextView title;
    private ImageView profile_Image_left;
    private ImageView profile_Image_right;
    private ImageView profile_Image_Flag_left;
    private ImageView profile_Image_Flag_right;

    Typeface tf;

    //Declaring the Strings which will be used to set the values of players
    String Name_left, Name_right;
    String Accel_left, Accel_right;
    String Finish_left, Finish_right;
    String Free_left, Free_right;
    String Pen_left, Pen_right;
    String Pow_left, Pow_right;
    String Sprint_left, Sprint_right;
    String Sta_left, Sta_right;
    String Strength_left, Strength_right;
    String Image_left, Image_right;
    String Flag_left, Flag_right;

    //Activity_search layout will be opened in onCreate
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);

        tf = Typeface.createFromAsset(getAssets(), "Comfortaa-Regular.ttf");

        //these variables are referencing to the id's of activity_search.xml layout  
        startbattle = (Button) findViewById(R.id.battle);  // id battle in xml file
        l_search = (EditText) findViewById(R.id.search_left);  // id search_left in xml file
        r_search = (EditText) findViewById(R.id.search_right); // id search_right in xml file
        title = (TextView) findViewById(R.id.textView_search);
        
        l_search.setTypeface(tf);
        r_search.setTypeface(tf);
        title.setTypeface(tf);

        //SetOnClickListener function will call when Button (startbattle) will be clicked
        startbattle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Getting the players data from app/res/raw/complete_dataset.csv
                InputStream inputStream = getResources().openRawResource(R.raw.complete_dataset);
                //InputStream inputS = getResources().openRawResource(R.raw.countries);
                //CSVFile csvF = new CSVFile(inputS);
                CSVFile csvFile = new CSVFile(inputStream);
                //Setting the data of players in List<String[]> format
                List<String[]> mylist = csvFile.read();
                //List<String[]> myClist = csvF.read();
                String left1, right1;
                String ls = null;
                ls=l_search.getText().toString();  // getting the name of player one into ls from the search field in search activity
                String rs = null;
                rs=r_search.getText().toString();  //getting the name of player second into rs from the search field in search activity
                
                //checking the name fields ls and rs are empty
                if(ls.isEmpty() && rs.isEmpty())
                {
                    // if yes then it is calling this same search_activity again and showing the toast "player names required" 
                    Toast.makeText(getApplicationContext(),"Player Names Required ",Toast.LENGTH_SHORT).show();
                    Intent intent2= new Intent(SearchActivity.this, SearchActivity.class);
                    startActivity(intent2); // starting the activity
                }
                // checking first name is empty or name contains spaces at the begining or end
                else if(ls.isEmpty() || ls.trim().length()==0)
                {
                    //if yes then it is calling this same search_activity again and showing the toast "Player 1 name Required"
                    Toast.makeText(getApplicationContext(),"Player 1 Name Required ",Toast.LENGTH_SHORT).show();
                    Intent intent2= new Intent(SearchActivity.this, SearchActivity.class);
                    startActivity(intent2); // starting the activity
                }
                
                //checking the second name is empty or name contains spaces at the  begining or end
                else if(rs.isEmpty() || rs.trim().length()==0) 
                {
                    //if yes then it is calling the same search_activity again and showing the toast "Player 2 name is required"
                    Toast.makeText(getApplicationContext(), "Player 2 Name Required ", Toast.LENGTH_SHORT).show();
                    Intent intent2 = new Intent(SearchActivity.this, SearchActivity.class);
                    startActivity(intent2); //starting the activity
                }
                
                // will enter in this loop if names are in proper format 
                else {
                    int i=0,j=0;
                   for (i = 0; i < mylist.size(); i++) {  // loop will run until name is found in database 

                        String[] left = mylist.get(i);
                        String lower_ls = ls.toLowerCase();   // Changing the name into lowercase
                        String str_left = left[0].toString();  
                        String got_left = str_left.toLowerCase();
                        
                        //if name is found then all the stats will be stored in the variables given below
                        if (got_left.contains(lower_ls)) {
                            Name_left = left[0].toString();
                            Accel_left = left[8].toString();
                            Finish_left = left[9].toString();
                            Free_left = left[10].toString();
                            Pen_left = left[11].toString();
                            Pow_left = left[12].toString();
                            Sprint_left = left[13].toString();
                            Sta_left = left[14].toString();
                            Strength_left = left[15].toString();
                            Image_left = left[1].toString();
                            /*String FL = left[2].toString();
                            for(j=0;j<myClist.size();j++)
                            {
                                String[] CL = myClist.get(j);
                                String toS = CL[0].toString();
                                if(toS.equals(FL))
                                {
                                    Flag_left = CL[5];
                                }
                            }*/
                            Flag_left = left[3].toString();
                            break;
                        }


                    }

                    //loop will run until name is found in database
                    for (j = 0; j < mylist.size(); j++) {
                        String[] right = mylist.get(j);
                        String lower_rs = rs.toLowerCase();  // changing the name into lowercase
                        String str_right = right[0].toString();
                        String got_right = str_right.toLowerCase();
                        
                        //if name is found then all the stats will be stored in the variables given below
                         if (got_right.contains(lower_rs)) {
                            Name_right = right[0].toString();
                            Accel_right = right[8].toString();
                            Finish_right = (right[9].toString());
                            Free_right = (right[10].toString());
                            Pen_right = (right[11].toString());
                            Pow_right = (right[12].toString());
                            Sprint_right = (right[13].toString());
                            Sta_right = (right[14].toString());
                            Strength_right = (right[15].toString());
                            Image_right = right[1].toString();
                            /* String RL = right[2].toString();
                             for(j=0;j<myClist.size();j++)
                             {
                                 String[] CR = myClist.get(j);
                                 String toSs = CR[0].toString();
                                 if(toSs.equals(RL))
                                 {
                                     Flag_right = CR[5];
                                 }
                             }*/
                            Flag_right = right[3].toString();
                            break;
                        }

                    }
                    
                    //if name1 is not found in the database then print the player not found and load the search_activity again
                    if(i>mylist.size()-1)
                    {
                        Toast.makeText(getApplicationContext(),"Player 1 Not Found ",Toast.LENGTH_SHORT).show();
                        Intent intent2= new Intent(SearchActivity.this, SearchActivity.class);
                        startActivity(intent2);
                    }
                    
                    //if name2 is not found in the database then print the player not found and load the search_activity again
                    else if(j>mylist.size()-1)
                    {
                        Toast.makeText(getApplicationContext(),"Player 2 Not Found ",Toast.LENGTH_SHORT).show();
                        Intent intent2= new Intent(SearchActivity.this, SearchActivity.class);
                        startActivity(intent2);
                    }
                    
                    // if name is found then sending all the values to BattleActivity via intent1 object
                    else
                    {
                    Intent intent1 = new Intent(SearchActivity.this, BattleActivity.class);
                    intent1.putExtra("Name_left", Name_left);
                    intent1.putExtra("Accel_left", Accel_left);
                    intent1.putExtra("Finish_left", Finish_left);
                    intent1.putExtra("Free_left", Free_left);
                    intent1.putExtra("Pen_left", Pen_left);
                    intent1.putExtra("Pow_left", Pow_left);
                    intent1.putExtra("Sprint_left", Sprint_left);
                    intent1.putExtra("Sta_left", Sta_left);
                    intent1.putExtra("Strength_left", Strength_left);
                    intent1.putExtra("Name_right", Name_right);
                    intent1.putExtra("Accel_right", Accel_right);
                    intent1.putExtra("Finish_right", Finish_right);
                    intent1.putExtra("Free_right", Free_right);
                    intent1.putExtra("Pen_right", Pen_right);
                    intent1.putExtra("Pow_right", Pow_right);
                    intent1.putExtra("Sprint_right", Sprint_right);
                    intent1.putExtra("Sta_right", Sta_right);
                    intent1.putExtra("Strength_right", Strength_right);
                    intent1.putExtra("Image_left", Image_left);
                    intent1.putExtra("Image_right", Image_right);
                    intent1.putExtra("Flag_left", Flag_left);
                    intent1.putExtra("Flag_right", Flag_right);


                    startActivity(intent1); 

                }}
            }

        });


    }
    //home_page activity is called when back button is pressed
    @Override
    public void onBackPressed() {
        Intent intent4 = new Intent(SearchActivity.this,home_page.class);
        startActivity(intent4);
    }
}
