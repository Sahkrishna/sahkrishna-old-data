package com.example.calculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.InputType;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    Button btnAdd;
    Button btnSubtract;
    Button btnMultiply;
    Button btnDivide;
    EditText etFirstValue;


    EditText etSecondValue;
    TextView answer;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnAdd=findViewById(R.id.btnPlus);
        btnSubtract =findViewById(R.id.btnSub);
        btnMultiply=findViewById(R.id.btnMul);
        btnDivide=findViewById(R.id.btnDiv);

        etFirstValue=findViewById(R.id.etFirstValue);
        // Set the input type to allow decimal values
        etFirstValue.setInputType(InputType.TYPE_CLASS_NUMBER | InputType.TYPE_NUMBER_FLAG_DECIMAL);
        etSecondValue=findViewById(R.id.etSecondValue);
        // Set the input type to allow decimal values
        etSecondValue.setInputType(InputType.TYPE_CLASS_NUMBER | InputType.TYPE_NUMBER_FLAG_DECIMAL);

        answer=findViewById(R.id.tvAns);

        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                float firstValue,secondValue;
                       float ans;
                firstValue= Float.parseFloat(etFirstValue.getText().toString());
                secondValue=Float.parseFloat(etSecondValue.getText().toString());

                ans= firstValue+secondValue;

                String answerShow=Float.toString(ans);
                answer.setText(answerShow);

            }
        });

        btnSubtract.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                float firstValue,secondValue;float ans;
                firstValue= Float.parseFloat(etFirstValue.getText().toString());
                secondValue=Float.parseFloat(etSecondValue.getText().toString());
                ans= firstValue-secondValue;
                String answerShow=Float.toString(ans);
                answer.setText(answerShow);
            }
        });
        btnMultiply.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                float firstValue,secondValue,ans;
                firstValue= Float.parseFloat(etFirstValue.getText().toString());
                secondValue=Float.parseFloat(etSecondValue.getText().toString());

                ans=firstValue*secondValue;
                String answerShow=Float.toString(ans);
                answer.setText(answerShow);
            }
        });
        btnDivide.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                float firstValue,secondValue,ans;
                firstValue= Float.parseFloat(etFirstValue.getText().toString());
                secondValue=Float.parseFloat(etSecondValue.getText().toString());
                ans=firstValue/secondValue;
                String answerShow=Float.toString(ans);
                answer.setText(answerShow);
            }
        });
    }
}