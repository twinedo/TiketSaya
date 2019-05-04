package com.example.tiketsaya;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class SuccessRegisterAct extends AppCompatActivity {

    Button button_explore;
    ImageView icon_success;
    TextView success_reg_title, success_reg_subtitle;
    Animation app_splash, btt, ttb;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_success_register);

        icon_success = findViewById(R.id.icon_success);
        success_reg_title = findViewById(R.id.success_reg_title);
        success_reg_subtitle = findViewById(R.id.success_reg_subtitle);

        button_explore = findViewById(R.id.button_explore);
        button_explore.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent gotoHome = new Intent(SuccessRegisterAct.this, HomeActivity.class);
                startActivity(gotoHome);
                finish();
            }
        });

        //load anim
        app_splash = AnimationUtils.loadAnimation(this, R.anim.app_splash);
        btt = AnimationUtils.loadAnimation(this, R.anim.btt);
        ttb = AnimationUtils.loadAnimation(this, R.anim.ttb);

        //run anim
        button_explore.startAnimation(btt);
        icon_success.startAnimation(app_splash);
        success_reg_title.startAnimation(ttb);
        success_reg_subtitle.startAnimation(ttb);

    }

    @Override
    public void onBackPressed() {

    }
}
