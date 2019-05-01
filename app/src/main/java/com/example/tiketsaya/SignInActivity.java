package com.example.tiketsaya;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class SignInActivity extends AppCompatActivity {


    TextView btn_new_acc;
    Button button_signin;
    EditText usernamex, passwordx;

    DatabaseReference reference;

    String USERNAME_KEY = "usernamekey";
    String username_key = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signin);


        //id
        usernamex = findViewById(R.id.usernamex);
        passwordx= findViewById(R.id.passwordx);


        btn_new_acc = findViewById(R.id.btn_new_acc);
        btn_new_acc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent gotoRegisterOne = new Intent(SignInActivity.this, RegisterOneAct.class);
                startActivity(gotoRegisterOne);
            }
        });

        button_signin = findViewById(R.id.button_signin);
        button_signin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                button_signin.setEnabled(false);
                button_signin.setText("Loading...");

                String username = usernamex.getText().toString();
                final String password = passwordx.getText().toString();

                if (username.isEmpty() && password.isEmpty()) {
                    Toast.makeText(getApplicationContext(), "Username dan password tidak boleh kosong!", Toast.LENGTH_SHORT).show();
                    button_signin.setEnabled(true);
                    button_signin.setText("SIGN IN");
                }else if(username.isEmpty()){
                    Toast.makeText(getApplicationContext(), "Username tidak boleh kosong!", Toast.LENGTH_SHORT).show();
                    button_signin.setEnabled(true);
                    button_signin.setText("SIGN IN");
                } else {
                    if (password.isEmpty()){
                        Toast.makeText(getApplicationContext(), "Password tidak boleh kosong", Toast.LENGTH_SHORT).show();
                        button_signin.setEnabled(true);
                        button_signin.setText("SIGN IN");
                    } else{
                        reference = FirebaseDatabase.getInstance().getReference()
                                .child("Users").child(username);
                        reference.addListenerForSingleValueEvent(new ValueEventListener() {
                            @Override
                            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                                if (dataSnapshot.exists()){

                                    //ambil data pw dr firebase
                                    String passwordFromFirebase = dataSnapshot.child("password").getValue().toString();
                                    //validasi pw input dg pw di firebase
                                    if (password.equals(passwordFromFirebase)){

                                        //menyimpan data ke local storage
                                        SharedPreferences sharedPreferences = getSharedPreferences(USERNAME_KEY, MODE_PRIVATE);
                                        SharedPreferences.Editor editor = sharedPreferences.edit();
                                        editor.putString(username_key, usernamex.getText().toString());
                                        editor.apply();

                                        Intent gotoHome = new Intent(SignInActivity.this, HomeActivity.class);
                                        startActivity(gotoHome);

                                    }else{
                                        Toast.makeText(getApplicationContext(), "Password salah",Toast.LENGTH_SHORT).show();
                                        button_signin.setEnabled(true);
                                        button_signin.setText("SIGN IN");
                                    }


                                }else{
                                    Toast.makeText(getApplicationContext(), "Username tidak ada",Toast.LENGTH_SHORT).show();
                                    button_signin.setEnabled(true);
                                    button_signin.setText("SIGN IN");
                                }
                            }

                            @Override
                            public void onCancelled(@NonNull DatabaseError databaseError) {
                                Toast.makeText(getApplicationContext(), "Database error", Toast.LENGTH_SHORT).show();
                            }
                        });
                    }

                }

            }
        });
    }
}
