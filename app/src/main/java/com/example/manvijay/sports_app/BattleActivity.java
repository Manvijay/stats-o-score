//This Activity is responsible for Displaying Player Attributes and determining the winner in the Battlefield


package com.example.manvijay.sports_app;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.Typeface;
import android.media.Image;
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

//Start the Activity
public class BattleActivity extends AppCompatActivity {

    //String to get values from Search Activity
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
    String Club_left,Club_right;
    String Club_name_left,Club_name_right;
    Typeface tf;

    int leftCount = 0, rightCount = 0;  // Counters to determine the Winner
    
    //Declaring Views for each Attribute to be linked in the Layout
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
    private TextView club_name_left;
    private TextView club_name_right;
    private ImageView profile_Image_left;
    private ImageView profile_Image_right;
    private ImageView profile_Image_Flag_left;
    private ImageView profile_Image_Flag_right;
    private ImageView profile_Image_Club_left;
    private ImageView profile_Image_Club_right;

    private TextView accel;
    private TextView finish;
    private TextView kick;
    private TextView penal;
    private TextView shot;
    private TextView sprint;
    private TextView sta;
    private TextView stren;
    private TextView res;
    private TextView club;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_battlefield);
        tf = Typeface.createFromAsset(getAssets(), "Comfortaa-Regular.ttf");
        //Getting the Values from Search Activity into this Activity
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
        Club_left = getIntent().getExtras().getString("Club_left");
        Club_right = getIntent().getExtras().getString("Club_right");
        Club_name_left = getIntent().getExtras().getString("Club_name_left");
        Club_name_right = getIntent().getExtras().getString("Club_name_right");


        accel = (TextView) findViewById(R.id.acc1);
        finish = (TextView) findViewById(R.id.fin1);
        kick = (TextView) findViewById(R.id.kick1);
        penal = (TextView) findViewById(R.id.penal1);
        shot = (TextView) findViewById(R.id.shot1);
        sprint = (TextView) findViewById(R.id.sprint1);
        sta = (TextView) findViewById(R.id.sta1);
        stren = (TextView) findViewById(R.id.stren1);
        res = (TextView) findViewById(R.id.result2);
        club = (TextView) findViewById(R.id.club_name);

        accel.setTypeface(tf);
        finish.setTypeface(tf);
        kick.setTypeface(tf);
        penal.setTypeface(tf);
        shot.setTypeface(tf);
        sprint.setTypeface(tf);
        sta.setTypeface(tf);
        stren.setTypeface(tf);
        res.setTypeface(tf);
        club.setTypeface(tf);

        //Determining the Winner by comparing all attributes of the players
        if(Integer.parseInt(Accel_left)>Integer.parseInt(Accel_right)){
            leftCount++;
            TextView acc_r_l = (TextView) findViewById(R.id.accel_result_left);
            acc_r_l.setTypeface(tf);
            acc_r_l.setText("Won");
            acc_r_l.setTextColor(Color.parseColor("#009C09"));
            TextView acc_r_r = (TextView) findViewById(R.id.accel_result_right);
            acc_r_r.setTypeface(tf);
            acc_r_r.setText("Lost");
            acc_r_r.setTextColor(Color.parseColor("#ff0000"));
        }
        else if(Integer.parseInt(Accel_left)<Integer.parseInt(Accel_right)) {
            rightCount++;
            TextView acc_r_l = (TextView) findViewById(R.id.accel_result_left);
            acc_r_l.setTypeface(tf);
            acc_r_l.setText("Lost");
            acc_r_l.setTextColor(Color.parseColor("#ff0000"));
            TextView acc_r_r = (TextView) findViewById(R.id.accel_result_right);
            acc_r_l.setTypeface(tf);
            acc_r_r.setText("Won");
            acc_r_r.setTextColor(Color.parseColor("#009C09"));
        }
        else
        {
            TextView acc_r_l = (TextView) findViewById(R.id.accel_result_left);
            acc_r_l.setTypeface(tf);
            acc_r_l.setText("Draw");
            acc_r_l.setTextColor(Color.parseColor("#0000ff"));
            TextView acc_r_r = (TextView) findViewById(R.id.accel_result_right);
            acc_r_r.setTypeface(tf);
            acc_r_r.setText("Draw");
            acc_r_r.setTextColor(Color.parseColor("#0000ff"));
        }
        if(Integer.parseInt(Finish_left)>Integer.parseInt(Finish_right)){
            leftCount++;
            TextView fin_r_l = (TextView) findViewById(R.id.finish_result_left);
            fin_r_l.setTypeface(tf);
            fin_r_l.setText("Won");
            fin_r_l.setTextColor(Color.parseColor("#009C09"));
            TextView fin_r_r = (TextView) findViewById(R.id.finish_result_right);
            fin_r_r.setTypeface(tf);
            fin_r_r.setText("Lost");
            fin_r_r.setTextColor(Color.parseColor("#ff0000"));
        }
        else if(Integer.parseInt(Finish_left)<Integer.parseInt(Finish_right)) {
            TextView fin_r_l = (TextView) findViewById(R.id.finish_result_left);
            fin_r_l.setTypeface(tf);
            fin_r_l.setText("Lost");
            fin_r_l.setTextColor(Color.parseColor("#ff0000"));
            TextView fin_r_r = (TextView) findViewById(R.id.finish_result_right);
            fin_r_r.setTypeface(tf);
            fin_r_r.setText("Won");
            fin_r_r.setTextColor(Color.parseColor("#009C09"));
            rightCount++;
        }
        else
        {
            TextView fin_r_l = (TextView) findViewById(R.id.finish_result_left);
            fin_r_l.setTypeface(tf);
            fin_r_l.setText("Draw");
            fin_r_l.setTextColor(Color.parseColor("#0000ff"));
            TextView fin_r_r = (TextView) findViewById(R.id.finish_result_right);
            fin_r_r.setTypeface(tf);
            fin_r_r.setText("Draw");
            fin_r_r.setTextColor(Color.parseColor("#0000ff"));
        }
        if(Integer.parseInt(Free_left)>Integer.parseInt(Free_right)){
            leftCount++;
            TextView kick_r_l = (TextView) findViewById(R.id.kick_result_left);
            kick_r_l.setTypeface(tf);
            kick_r_l.setText("Won");
            kick_r_l.setTextColor(Color.parseColor("#009C09"));
            TextView kick_r_r = (TextView) findViewById(R.id.kick_result_right);
            kick_r_r.setTypeface(tf);
            kick_r_r.setText("Lost");
            kick_r_r.setTextColor(Color.parseColor("#ff0000"));
        }
        else if(Integer.parseInt(Free_left)<Integer.parseInt(Free_right)) {
            TextView kick_r_l = (TextView) findViewById(R.id.kick_result_left);
            kick_r_l.setTypeface(tf);
            kick_r_l.setText("Lost");
            kick_r_l.setTextColor(Color.parseColor("#ff0000"));
            TextView kick_r_r = (TextView) findViewById(R.id.kick_result_right);
            kick_r_r.setTypeface(tf);
            kick_r_r.setText("Won");
            kick_r_r.setTextColor(Color.parseColor("#009C09"));

            rightCount++;
        }
        else
        {
            TextView kick_r_l = (TextView) findViewById(R.id.kick_result_left);
            kick_r_l.setTypeface(tf);
            kick_r_l.setText("Draw");
            kick_r_l.setTextColor(Color.parseColor("#0000ff"));
            TextView kick_r_r = (TextView) findViewById(R.id.kick_result_right);
            kick_r_r.setTypeface(tf);
            kick_r_r.setText("Draw");
            kick_r_r.setTextColor(Color.parseColor("#0000ff"));
        }
        if(Integer.parseInt(Pen_left)>Integer.parseInt(Pen_right)){
            leftCount++;
            TextView pen_r_l = (TextView) findViewById(R.id.pen_result_left);
            pen_r_l.setTypeface(tf);
            pen_r_l.setText("Won");
            pen_r_l.setTextColor(Color.parseColor("#009C09"));
            TextView pen_r_r = (TextView) findViewById(R.id.pen_result_right);
            pen_r_r.setTypeface(tf);
            pen_r_r.setText("Lost");
            pen_r_r.setTextColor(Color.parseColor("#ff0000"));
        }
        else if(Integer.parseInt(Pen_left)<Integer.parseInt(Pen_right)){
            TextView pen_r_l = (TextView) findViewById(R.id.pen_result_left);
            pen_r_l.setTypeface(tf);
            pen_r_l.setText("Lost");
            pen_r_l.setTextColor(Color.parseColor("#ff0000"));
            TextView pen_r_r = (TextView) findViewById(R.id.pen_result_right);
            pen_r_r.setTypeface(tf);
            pen_r_r.setText("Won");
            pen_r_r.setTextColor(Color.parseColor("#009C09"));
            rightCount++;
        }
        else
        {
            TextView pen_r_l = (TextView) findViewById(R.id.pen_result_left);
            pen_r_l.setTypeface(tf);
            pen_r_l.setText("Draw");
            pen_r_l.setTextColor(Color.parseColor("#0000ff"));
            TextView pen_r_r = (TextView) findViewById(R.id.pen_result_right);
            pen_r_r.setTypeface(tf);
            pen_r_r.setText("Draw");
            pen_r_r.setTextColor(Color.parseColor("#0000ff"));
        }
        if(Integer.parseInt(Pow_left)>Integer.parseInt(Pow_right)){
            leftCount++;
            TextView pow_r_l = (TextView) findViewById(R.id.pow_result_left);
            pow_r_l.setTypeface(tf);
            pow_r_l.setText("Won");
            pow_r_l.setTextColor(Color.parseColor("#009C09"));
            TextView pow_r_r = (TextView) findViewById(R.id.pow_result_right);
            pow_r_r.setTypeface(tf);
            pow_r_r.setText("Lost");
            pow_r_r.setTextColor(Color.parseColor("#ff0000"));
        }
        else if(Integer.parseInt(Pow_left)<Integer.parseInt(Pow_right)) {
            TextView pow_r_l = (TextView) findViewById(R.id.pow_result_left);
            pow_r_l.setTypeface(tf);
            pow_r_l.setText("Lost");
            pow_r_l.setTextColor(Color.parseColor("#ff0000"));
            TextView pow_r_r = (TextView) findViewById(R.id.pow_result_right);
            pow_r_r.setTypeface(tf);
            pow_r_r.setText("Won");
            pow_r_r.setTextColor(Color.parseColor("#009C09"));
            rightCount++;
        }
        else
        {
            TextView pow_r_l = (TextView) findViewById(R.id.pow_result_left);
            pow_r_l.setTypeface(tf);
            pow_r_l.setText("Draw");
            pow_r_l.setTextColor(Color.parseColor("#0000ff"));
            TextView pow_r_r = (TextView) findViewById(R.id.pow_result_right);
            pow_r_r.setTypeface(tf);
            pow_r_r.setText("Draw");
            pow_r_r.setTextColor(Color.parseColor("#0000ff"));
        }
        if(Integer.parseInt(Sprint_left)>Integer.parseInt(Sprint_right)){
            leftCount++;
            TextView speed_r_l = (TextView) findViewById(R.id.speed_result_left);
            speed_r_l.setTypeface(tf);
            speed_r_l.setText("Won");
            speed_r_l.setTextColor(Color.parseColor("#009C09"));
            TextView speed_r_r = (TextView) findViewById(R.id.speed_result_right);
            speed_r_r.setTypeface(tf);
            speed_r_r.setText("Lost");
            speed_r_r.setTextColor(Color.parseColor("#ff0000"));
        }
        else if(Integer.parseInt(Sprint_left)<Integer.parseInt(Sprint_right)){
            TextView speed_r_l = (TextView) findViewById(R.id.speed_result_left);
            speed_r_l.setTypeface(tf);
            speed_r_l.setText("Lost");
            speed_r_l.setTextColor(Color.parseColor("#ff0000"));
            TextView speed_r_r = (TextView) findViewById(R.id.speed_result_right);
            speed_r_r.setTypeface(tf);
            speed_r_r.setText("Won");
            speed_r_r.setTextColor(Color.parseColor("#009C09"));
            rightCount++;
        }
        else
        {
            TextView speed_r_l = (TextView) findViewById(R.id.speed_result_left);
            speed_r_l.setTypeface(tf);
            speed_r_l.setText("Draw");
            speed_r_l.setTextColor(Color.parseColor("#0000ff"));
            TextView speed_r_r = (TextView) findViewById(R.id.speed_result_right);
            speed_r_r.setTypeface(tf);
            speed_r_r.setText("Draw");
            speed_r_r.setTextColor(Color.parseColor("#0000ff"));
        }
        if(Integer.parseInt(Strength_left)>Integer.parseInt(Strength_right)){
            leftCount++;
            TextView strength_r_l = (TextView) findViewById(R.id.strength_result_left);
            strength_r_l.setTypeface(tf);
            strength_r_l.setText("Won");
            strength_r_l.setTextColor(Color.parseColor("#009C09"));
            TextView strength_r_r = (TextView) findViewById(R.id.strength_result_right);
            strength_r_r.setTypeface(tf);
            strength_r_r.setText("Lost");
            strength_r_r.setTextColor(Color.parseColor("#ff0000"));
        }
        else if(Integer.parseInt(Strength_left)<Integer.parseInt(Strength_right)){
            TextView strength_r_l = (TextView) findViewById(R.id.strength_result_left);
            strength_r_l.setTypeface(tf);
            strength_r_l.setText("Lost");
            strength_r_l.setTextColor(Color.parseColor("#ff0000"));
            TextView strength_r_r = (TextView) findViewById(R.id.strength_result_right);
            strength_r_r.setTypeface(tf);
            strength_r_r.setText("Won");
            strength_r_r.setTextColor(Color.parseColor("#009C09"));
            rightCount++;
        }
        else
        {
            TextView strength_r_l = (TextView) findViewById(R.id.strength_result_left);
            strength_r_l.setTypeface(tf);
            strength_r_l.setText("Draw");
            strength_r_l.setTextColor(Color.parseColor("#0000ff"));
            TextView strength_r_r = (TextView) findViewById(R.id.strength_result_right);
            strength_r_r.setTypeface(tf);
            strength_r_r.setText("Draw");
            strength_r_r.setTextColor(Color.parseColor("#0000ff"));
        }
        if(Integer.parseInt(Sta_left)>Integer.parseInt(Sta_right)){
            leftCount++;
            TextView stamina_r_l = (TextView) findViewById(R.id.stamina_result_left);
            stamina_r_l.setTypeface(tf);
            stamina_r_l.setText("Won");
            stamina_r_l.setTextColor(Color.parseColor("#009C09"));
            TextView stamina_r_r = (TextView) findViewById(R.id.stamina_result_right);
            stamina_r_r.setTypeface(tf);
            stamina_r_r.setText("Lost");
            stamina_r_r.setTextColor(Color.parseColor("#ff0000"));
        }
        else if(Integer.parseInt(Sta_left)<Integer.parseInt(Sta_right)) {
            TextView stamina_r_l = (TextView) findViewById(R.id.stamina_result_left);
            stamina_r_l.setTypeface(tf);
            stamina_r_l.setText("Lost");
            stamina_r_l.setTextColor(Color.parseColor("#ff0000"));
            TextView stamina_r_r = (TextView) findViewById(R.id.stamina_result_right);
            stamina_r_r.setTypeface(tf);
            stamina_r_r.setText("Won");
            stamina_r_r.setTextColor(Color.parseColor("#009C09"));
            rightCount++;
        }
        else
        {
            TextView stamina_r_l = (TextView) findViewById(R.id.stamina_result_left);
            stamina_r_l.setTypeface(tf);
            stamina_r_l.setText("Draw");
            stamina_r_l.setTextColor(Color.parseColor("#0000ff"));
            TextView stamina_r_r = (TextView) findViewById(R.id.stamina_result_right);
            stamina_r_r.setTypeface(tf);
            stamina_r_r.setText("Draw");
            stamina_r_r.setTextColor(Color.parseColor("#0000ff"));
        }

        TextView mresult = (TextView) findViewById(R.id.result);
        mresult.setTypeface(tf);
        if(leftCount>rightCount){

            mresult.setText(Name_left.trim());//Display Winner Player1 Name
        }
        else if(leftCount<rightCount)
        {
            mresult.setText(Name_right.trim());//Display Winner Player2 Name
        }
        else
        {
            mresult.setText("Nobody");
        }
        
        //Give Id to each View so that it can link to the Layout
        naam_left = (TextView) findViewById(R.id.name_left);
        naam_right = (TextView) findViewById(R.id.name_right);
        club_name_left = (TextView) findViewById(R.id.club_name_left);
        club_name_right = (TextView) findViewById(R.id.club_name_right);
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
        profile_Image_Club_left = (ImageView) findViewById(R.id.club_left);
        profile_Image_Club_right = (ImageView) findViewById(R.id.club_right);

        naam_left.setTypeface(tf);
        naam_right.setTypeface(tf);
//        club_name_left.setTypeface(tf);
//        club_name_right.setTypeface(tf);
        acc_left.setTypeface(tf);
        acc_right.setTypeface(tf);
        pent_left.setTypeface(tf);
        pent_right.setTypeface(tf);
        pow_left.setTypeface(tf);
        pent_right.setTypeface(tf);
        sprint_left.setTypeface(tf);
        sprint_right.setTypeface(tf);
        stam_left.setTypeface(tf);
        stam_right.setTypeface(tf);
        body_left.setTypeface(tf);
        body_right.setTypeface(tf);


        //Set Values to each Attribute 
        naam_left.setText(Name_left);
        naam_right.setText(Name_right);
        club_name_left.setText(Club_name_left);
        club_name_right.setText(Club_name_right);
        Glide.with(this).load(Image_left).into(profile_Image_left);
        Glide.with(this).load(Image_right).into(profile_Image_right);
        Glide.with(this).load(Flag_left).into(profile_Image_Flag_left);
        Glide.with(this).load(Flag_right).into(profile_Image_Flag_right);
        Glide.with(this).load(Club_left).into(profile_Image_Club_left);
        Glide.with(this).load(Club_right).into(profile_Image_Club_right);
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
    //If back button is pressed, go to Search Activity
    @Override
    public void onBackPressed() {
        Intent intent4 = new Intent(BattleActivity.this, SearchActivity.class);
        startActivity(intent4);
    }




}

