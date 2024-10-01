package com.example.constaints_layout;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class SignIn_Activity extends AppCompatActivity {

    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_in);

//        getSupportActionBar().setTitle("Sign In");
        textView=findViewById(R.id.txtViewRegister);

        textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(SignIn_Activity.this, "don't have account is clicked", Toast.LENGTH_SHORT).show();

                Intent intent=new Intent(SignIn_Activity.this,Signup_Activity.class);
                startActivity(intent);
            }
        });

    }
}