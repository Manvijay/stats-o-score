package com.example.manvijay.sports_app;

/**
 * Created by Deepak on 25-03-2018.
 */

import android.content.Intent;
import android.os.Parcelable;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

public class BattleActivity extends AppCompatActivity {


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
    String Flag_left,Flag_right;

    int leftCount = 0, rightCount = 0;

    private TextView acc_left;
    private TextView acc_right;
    private TextView fin_left;
    private TextView fin_right;
    private TextView kick_left;
    private TextView kick_right;
    private TextView pent_left;
    private TextView pent_right;
    private TextView pow_left;
    private TextView pow_right;
    private TextView sprint_left;
    private TextView sprint_right;
    private TextView stam_left;
    private TextView stam_right;
    private TextView body_left;
    private TextView body_right;
    private TextView naam_left;
    private TextView naam_right;
    private ImageView profile_Image_left;
    private ImageView profile_Image_right;
    private ImageView profile_Image_Flag_left;
    private ImageView profile_Image_Flag_right;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_battlefield);

        Name_left = getIntent().getExtras().getString("Name_left");
        Name_right = getIntent().getExtras().getString("Name_right");
        Accel_left = getIntent().getExtras().getString("Accel_left");
        Accel_right = getIntent().getExtras().getString("Accel_right");
        Finish_left = getIntent().getExtras().getString("Finish_left");
        Finish_right = getIntent().getExtras().getString("Finish_right");
        Free_left = getIntent().getExtras().getString("Free_left");
        Free_right = getIntent().getExtras().getString("Free_right");
        Pen_left = getIntent().getExtras().getString("Pen_left");
        Pen_right = getIntent().getExtras().getString("Pen_right");
        Pow_left = getIntent().getExtras().getString("Pow_left");
        Pow_right = getIntent().getExtras().getString("Pow_right");
        Sprint_left = getIntent().getExtras().getString("Sprint_left");
        Sprint_right = getIntent().getExtras().getString("Sprint_right");
        Sta_left = getIntent().getExtras().getString("Sta_left");
        Sta_right = getIntent().getExtras().getString("Sta_right");
        Strength_left = getIntent().getExtras().getString("Strength_left");
        Strength_right = getIntent().getExtras().getString("Strength_right");
        Image_left = getIntent().getExtras().getString("Image_left");
        Image_right = getIntent().getExtras().getString("Image_right");
        Flag_left = getIntent().getExtras().getString("Flag_left");
        Flag_right = getIntent().getExtras().getString("Flag_right");


        if(Integer.parseInt(Accel_left)>Integer.parseInt(Accel_right)){
            leftCount++;
        }
        else rightCount++;
        if(Integer.parseInt(Finish_left)>Integer.parseInt(Finish_right)){
            leftCount++;
        }
        else rightCount++;
        if(Integer.parseInt(Free_left)>Integer.parseInt(Free_right)){
            leftCount++;
        }
        else rightCount++;
        if(Integer.parseInt(Pen_left)>Integer.parseInt(Pen_right)){
            leftCount++;
        }
        else rightCount++;
        if(Integer.parseInt(Pow_left)>Integer.parseInt(Pow_right)){
            leftCount++;
        }
        else rightCount++;
        if(Integer.parseInt(Sprint_left)>Integer.parseInt(Sprint_right)){
            leftCount++;
        }
        else rightCount++;
        if(Integer.parseInt(Strength_left)>Integer.parseInt(Strength_right)){
            leftCount++;
        }
        else rightCount++;
        if(Integer.parseInt(Sta_left)>Integer.parseInt(Strength_right)){
            leftCount++;
        }
        else rightCount++;

        TextView mresult = (TextView) findViewById(R.id.result);
        if(leftCount>rightCount){

            mresult.setText(Name_left.trim());
        }
        else
        {
            mresult.setText(Name_right.trim());
        }

        naam_left = (TextView) findViewById(R.id.name_left);
        naam_right = (TextView) findViewById(R.id.name_right);
        acc_left = (TextView) findViewById(R.id.acceleration_left);
        acc_right = (TextView) findViewById(R.id.acceleration_right);
        fin_left = (TextView) findViewById(R.id.finishing_left);
        fin_right = (TextView) findViewById(R.id.finishing_right);
        kick_left = (TextView) findViewById(R.id.freekick_left);
        kick_right = (TextView) findViewById(R.id.freekick_right);
        pent_left = (TextView) findViewById(R.id.penalties_left);
        pent_right = (TextView) findViewById(R.id.penalties_right);
        pow_left = (TextView) findViewById(R.id.shotpower_left);
        pow_right = (TextView) findViewById(R.id.shotpower_right);
        sprint_left = (TextView) findViewById(R.id.sprintspeed_left);
        sprint_right = (TextView) findViewById(R.id.sprintspeed_right);
        stam_left = (TextView) findViewById(R.id.stamina_left);
        stam_right = (TextView) findViewById(R.id.stamina_right);
        body_left = (TextView) findViewById(R.id.strength_left);
        body_right = (TextView) findViewById(R.id.strength_right);
        profile_Image_left = (ImageView) findViewById(R.id.imageViewLeft);
        profile_Image_right = (ImageView) findViewById(R.id.imageViewRight);
        profile_Image_Flag_left = (ImageView) findViewById(R.id.imageViewFlagLeft);
        profile_Image_Flag_right = (ImageView) findViewById(R.id.imageViewFlagRight);

        //Toast.makeText(getApplicationContext(),model.getNam_right(),Toast.LENGTH_SHORT).show();

        naam_left.setText(Name_left);
        naam_right.setText(Name_right);
        Glide.with(this).load(Image_left).into(profile_Image_left);
        Glide.with(this).load(Image_right).into(profile_Image_right);
        Glide.with(this).load(Flag_left).into(profile_Image_Flag_left);
        Glide.with(this).load(Flag_right).into(profile_Image_Flag_right);
        acc_left.setText(Accel_left);
        acc_right.setText(Accel_right);
        fin_left.setText(Finish_left);
        fin_right.setText(Finish_right);
        kick_left.setText(Free_left);
        kick_right.setText(Free_right);
        pent_left.setText(Pen_left);
        pent_right.setText(Pen_right);
        pow_left.setText(Pow_left);
        pow_right.setText(Pow_right);
        sprint_left.setText(Sprint_left);
        sprint_right.setText(Sprint_right);
        stam_left.setText(Sta_left);
        stam_right.setText(Sta_right);
        body_left.setText(Strength_left);
        body_right.setText(Strength_right);



    }
    @Override
    public void onBackPressed() {
        Intent intent4 = new Intent(BattleActivity.this, SearchActivity.class);
        startActivity(intent4);
    }




}

