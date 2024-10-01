package com.example.constaints_layout;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Button loginButton;
    Button registerButton;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//        getSupportActionBar().setTitle("Cafe House");

        loginButton=findViewById(R.id.btnLogin);
        registerButton=findViewById(R.id.btnRegister);

        registerButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(MainActivity.this, "Register button is clicked", Toast.LENGTH_SHORT).show();

                Intent intent=new Intent(MainActivity.this,Signup_Activity.class);
                startActivity(intent);
            }
        });

        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(MainActivity.this, "Login Button is clicked", Toast.LENGTH_SHORT).show();

                Intent intent=new Intent(MainActivity.this,SignIn_Activity.class);

                startActivity(intent);
            }
        });
    }
}