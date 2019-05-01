package com.example.tiketsaya;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

public class SplashScreen extends AppCompatActivity {

    Animation app_splash, btt;
    ImageView app_logo;
    TextView app_title;


    String USERNAME_KEY = "usernamekey";
    String username_key = "";
    String username_key_new ="";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        getUsernameLocal();

        //load anim
        app_splash = AnimationUtils.loadAnimation(this, R.anim.app_splash);
        btt = AnimationUtils.loadAnimation(this, R.anim.btt);

        //load id
        app_logo = findViewById(R.id.app_logo);
        app_title = findViewById(R.id.app_title);

        app_logo.startAnimation(app_splash);
        app_title.startAnimation(btt);

    }

    public void getUsernameLocal(){
        SharedPreferences sharedPreferences = getSharedPreferences(USERNAME_KEY, MODE_PRIVATE);
        username_key_new = sharedPreferences.getString(username_key, "");
        if (username_key_new.isEmpty()){
            //handler timer splashscreen 2 detik
            Handler handler = new Handler();
            handler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    Intent gogetStarted = new Intent(SplashScreen.this, GetStarted.class);
                    startActivity(gogetStarted);
                    finish();
                }
            }, 2000);
        }else {
            //handler timer splashscreen 2 detik
            Handler handler = new Handler();
            handler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    Intent gotohome = new Intent(SplashScreen.this, HomeActivity.class);
                    startActivity(gotohome);
                    finish();
                }
            }, 2000);
        }
    }
}
