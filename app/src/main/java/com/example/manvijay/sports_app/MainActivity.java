package com.example.manvijay.sports_app;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    // Used to load the 'native-lib' library on application startup.
    static {
        System.loadLibrary("native-lib");
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ImageView imageView= findViewById(R.id.imageViewLogo);
        /*Animation animation= AnimationUtils.loadAnimation(getApplicationContext(),R.anim.fade_logo);
        imageView.startAnimation(animation);*/

        Thread thread= new Thread(){

            @Override
            public void run() {

                try {
                    sleep(3000);
                    Intent intent= new Intent(getApplicationContext(),home_page.class);
                    startActivity(intent);
                    finish();
                    super.run();

                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

            }
        };

        thread.start();

    }

    /**
     * A native method that is implemented by the 'native-lib' native library,
     * which is packaged with this application.
     */
    public native String stringFromJNI();
}
