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

public class GetStarted extends AppCompatActivity {

    Button btn_signin, btn_new_acc_create;
    Animation ttb, btt;
    ImageView emblem_app;
    TextView intro_app;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_get_started);


        ttb = AnimationUtils.loadAnimation(this, R.anim.ttb);
        btt = AnimationUtils.loadAnimation(this, R.anim.btt);

        btn_signin = findViewById(R.id.button_signin);
        btn_signin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent gotoSignin = new Intent(GetStarted.this, SignInActivity.class);
                startActivity(gotoSignin);
            }
        });

        btn_new_acc_create = findViewById(R.id.btn_new_acc_create);
        btn_new_acc_create.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent gotoRegisterOne = new Intent(GetStarted.this, RegisterOneAct.class);
                startActivity(gotoRegisterOne);
            }
        });

        emblem_app = findViewById(R.id.emblem_app);
        intro_app = findViewById(R.id.intro_app);

        //run anim
        emblem_app.startAnimation(ttb);
        intro_app.startAnimation(ttb);
        btn_signin.startAnimation(btt);
        btn_new_acc_create.startAnimation(btt);


    }
}
