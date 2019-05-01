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

public class SuccessBuyTicketAct extends AppCompatActivity {

    Button btn_my_dashboard, button_view_ticket;
    Animation app_splash, btt, ttb;
    ImageView icon_success_ticket;
    TextView text_success_ticket, text_success_ticket2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_success_buy_ticket);


        //load id element;
        icon_success_ticket = findViewById(R.id.icon_success_ticket);
        text_success_ticket = findViewById(R.id.text_success_ticket);
        text_success_ticket2 = findViewById(R.id.text_success_ticket2);
        button_view_ticket = findViewById(R.id.button_view_ticket);
        btn_my_dashboard = findViewById(R.id.btn_my_dashboard);

        //load anim
        app_splash = AnimationUtils.loadAnimation(this, R.anim.app_splash);
        btt = AnimationUtils.loadAnimation(this, R.anim.btt);
        ttb = AnimationUtils.loadAnimation(this, R.anim.ttb);

        //run anim
        icon_success_ticket.startAnimation(app_splash);
        text_success_ticket.startAnimation(ttb);
        text_success_ticket2.startAnimation(ttb);
        button_view_ticket.startAnimation(btt);
        btn_my_dashboard.startAnimation(btt);

        button_view_ticket.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent gotoprofile = new Intent(SuccessBuyTicketAct.this, MyProfileAct.class);
                startActivity(gotoprofile);
            }
        });
        btn_my_dashboard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent gotodashboard = new Intent(SuccessBuyTicketAct.this, HomeActivity.class);
                startActivity(gotodashboard);
            }
        });

    }
}
