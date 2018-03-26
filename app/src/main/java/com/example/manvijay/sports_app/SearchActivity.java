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

                String ls = l_search.getText().toString();
                String rs = r_search.getText().toString();
                InputStream inputStream = getResources().openRawResource(R.raw.complete_dataset);
                CSVFile csvFile = new CSVFile(inputStream);
                List<String[]> mylist = csvFile.read();
                for(int i=0;i<mylist.size();i++)
                {
                    String[] left=mylist.get(i);
                    if(left[0].contains(ls))
                    {
                        Name_left = left[0].toString();
                        Accel_left=left[8].toString();
                        //Toast.makeText(getApplicationContext(),m.getAccel_left(),Toast.LENGTH_SHORT).show();
                        Finish_left = left[9].toString();
                        Free_left= left[10].toString();
                        Pen_left = left[11].toString();
                        Pow_left = left[12].toString();
                        Sprint_left = left[13].toString();
                        Sta_left = left[14].toString();
                        Strength_left = left[15].toString();
                        Image_left = left[1].toString();
                        break;
                    }


                }
                for(int i=0;i<mylist.size();i++)
                {
                    String[] right=mylist.get(i);
                    if(right[0].contains(rs))
                    {
                        Name_right = right[0].toString();
                        Accel_right = right[8].toString();
                        Finish_right=(right[9].toString());
                        Free_right=(right[10].toString());
                        Pen_right=(right[11].toString());
                        Pow_right=(right[12].toString());
                        Sprint_right=(right[13].toString());
                        Sta_right=(right[14].toString());
                        Strength_right=(right[15].toString());
                        Image_right = right[1].toString();
                        break;
                    }
                }

                Intent intent1 = new Intent(SearchActivity.this , BattleActivity.class);
                intent1.putExtra("Name_left", Name_left );
                intent1.putExtra("Accel_left", Accel_left );
                intent1.putExtra("Finish_left", Finish_left );
                intent1.putExtra("Free_left", Free_left );
                intent1.putExtra("Pen_left",  Pen_left );
                intent1.putExtra("Pow_left", Pow_left );
                intent1.putExtra("Sprint_left", Sprint_left );
                intent1.putExtra("Sta_left",Sta_left );
                intent1.putExtra("Strength_left", Strength_left );
                intent1.putExtra("Name_right", Name_right );
                intent1.putExtra("Accel_right", Accel_right );
                intent1.putExtra("Finish_right", Finish_right );
                intent1.putExtra("Free_right", Free_right );
                intent1.putExtra("Pen_right", Pen_right );
                intent1.putExtra("Pow_right", Pow_right );
                intent1.putExtra("Sprint_right", Sprint_right );
                intent1.putExtra("Sta_right", Sta_right );
                intent1.putExtra("Strength_right", Strength_right );
                intent1.putExtra("Image_left", Image_left );
                intent1.putExtra("Image_right", Image_right );
                startActivity(intent1);
            }
        });


    }
}
