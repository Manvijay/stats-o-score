package com.example.manvijay.sports_app;

/* Created by Deepak */

import android.content.Intent;
import android.os.Parcelable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
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

    private Button startbattle;
    private EditText l_search;
    private EditText r_search;
    private ImageView profile_Image_left;
    private ImageView profile_Image_right;
    private ImageView profile_Image_Flag_left;
    private ImageView profile_Image_Flag_right;

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


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);

        startbattle = (Button) findViewById(R.id.battle);
        l_search = (EditText) findViewById(R.id.search_left);
        r_search = (EditText) findViewById(R.id.search_right);


        /*profile_Image_left = (ImageView) findViewById(R.id.imageViewLeft);
        profile_Image_right = (ImageView) findViewById(R.id.imageViewRight);
*/
        startbattle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                InputStream inputStream = getResources().openRawResource(R.raw.complete_dataset);
                CSVFile csvFile = new CSVFile(inputStream);
                List<String[]> mylist = csvFile.read();
                String left1, right1;
                String ls = null;
                ls=l_search.getText().toString();
                String rs = null;
                rs=r_search.getText().toString();
                if(ls.isEmpty() && rs.isEmpty())
                {
                    Toast.makeText(getApplicationContext(),"Player Names Required ",Toast.LENGTH_SHORT).show();
                    Intent intent2= new Intent(SearchActivity.this, SearchActivity.class);
                    startActivity(intent2);
                }
                else if(ls.isEmpty() || ls.trim().length()==0)
                {
                    Toast.makeText(getApplicationContext(),"Player 1 Name Required ",Toast.LENGTH_SHORT).show();
                    Intent intent2= new Intent(SearchActivity.this, SearchActivity.class);
                    startActivity(intent2);
                }
                else if(rs.isEmpty() || rs.trim().length()==0) {
                    Toast.makeText(getApplicationContext(), "Player 2 Name Required ", Toast.LENGTH_SHORT).show();
                    Intent intent2 = new Intent(SearchActivity.this, SearchActivity.class);
                    startActivity(intent2);
                }
                else {
                    int i=0,j=0;
                   for (i = 0; i < mylist.size(); i++) {

                        String[] left = mylist.get(i);
                        // left1 = left[0].toLowerCase();
                        String lower_ls = ls.toLowerCase();
                        String str_left = left[0].toString();
                        String got_left = str_left.toLowerCase();

                        if (got_left.contains(lower_ls)) {
                            Name_left = left[0].toString();
                            Accel_left = left[8].toString();
                            //Toast.makeText(getApplicationContext(),m.getAccel_left(),Toast.LENGTH_SHORT).show();
                            Finish_left = left[9].toString();
                            Free_left = left[10].toString();
                            Pen_left = left[11].toString();
                            Pow_left = left[12].toString();
                            Sprint_left = left[13].toString();
                            Sta_left = left[14].toString();
                            Strength_left = left[15].toString();
                            Image_left = left[1].toString();
                            Flag_left = left[3].toString();
                            break;
                        }


                    }





                    for (j = 0; j < mylist.size(); j++) {
                        String[] right = mylist.get(j);
                        String lower_rs = rs.toLowerCase();
                        String str_right = right[0].toString();
                        String got_right = str_right.toLowerCase();
                        //right1 = right[0].toLowerCase();
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
                            Flag_right = right[3].toString();
                            break;
                        }

                       /* if(i==1798)
                        {
                            Toast.makeText(getApplicationContext(),"Player 2 Not Found ",Toast.LENGTH_SHORT).show();
                            Intent intent2= new Intent(SearchActivity.this, SearchActivity.class);
                            startActivity(intent2);
                        }*/


                    }


                    if(i>mylist.size()-1)
                    {
                        Toast.makeText(getApplicationContext(),"Player 1 Not Found ",Toast.LENGTH_SHORT).show();
                        Intent intent2= new Intent(SearchActivity.this, SearchActivity.class);
                        startActivity(intent2);
                    }
                    else if(j>mylist.size()-1)
                    {
                        Toast.makeText(getApplicationContext(),"Player 2 Not Found ",Toast.LENGTH_SHORT).show();
                        Intent intent2= new Intent(SearchActivity.this, SearchActivity.class);
                        startActivity(intent2);
                    }
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
    @Override
    public void onBackPressed() {
        Intent intent4 = new Intent(SearchActivity.this,home_page.class);
        startActivity(intent4);
    }
}
