package com.example.vedantsingh.calculator;

import android.annotation.SuppressLint;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.lang.Math;


public class MainActivity extends AppCompatActivity {

    int flag = 0;
    double num1, num2, result;
    String number1 = "", number2 = "", number3 = "", res = "";

    public void clickNumber(View view) {
        Button button = (Button) view;

        String string = button.getText().toString();

        TextView bottomText = findViewById(R.id.textView1);

        bottomText.setText(bottomText.getText().toString() + string);
    }

    public void clickSpecial(View view) {
        Button button = (Button) view;

        Toast.makeText(MainActivity.this, "Saale 0 ko hi 2 baar daba deta, aalsi !", Toast.LENGTH_LONG).show();

        String string = button.getText().toString();

        TextView bottomText = findViewById(R.id.textView1);

        bottomText.setText(bottomText.getText().toString() + string);

    }

    public void clickOperator(View view) {

        TextView bottomText = findViewById(R.id.textView1);

        Button button = (Button) view;
        number1 = bottomText.getText().toString();

        num1 = Double.parseDouble(number1);

        String string = button.getText().toString();

        if(string.equals("/")) {
            flag = 1;
        }
        else if(string.equals("X")) {
            flag = 2;
        }
        else if(string.equals("-")) {
            flag = 3;
        }
        else if(string.equals("+")) {
            flag = 4;
        }
        else if(string.equals("^")) {
            flag = 5;
        }

        bottomText.setText(bottomText.getText().toString() + " " + string + " ");

        number1 = bottomText.getText().toString();


    }

    public void exec(View view) {
        TextView topText = findViewById(R.id.textView2);
        TextView bottomText = findViewById(R.id.textView1);

        topText.setText(bottomText.getText().toString());

        number2 = bottomText.getText().toString();
        number3 = number2.substring(number1.length(), number2.length());

        num2 = Double.parseDouble(number3);

        result = 0;



        if(flag == 1) {
            if(num2 != 0) {
                result = num1 / num2;
                res = Double.toString(result);
                bottomText.setText("=  " + res);
            }
            else{
                Toast.makeText(MainActivity.this, "Division by 0 is not possible", Toast.LENGTH_SHORT).show();
                res = "ERROR";
                bottomText.setText(res);
            }
        }
        else if(flag == 2) {
            result = num1 * num2;
            res = Double.toString(result);
            bottomText.setText("=  " + res);
        }
        else if(flag == 3) {
            result = num1 - num2;
            res = Double.toString(result);
            bottomText.setText("=  " + res);
        }
        else if(flag == 4) {
            result = num1 + num2;
            res = Double.toString(result);
            bottomText.setText("=  " + res);
        }
        else if(flag == 5) {
            result = Math.pow(num1, num2);
            res = Double.toString(result);
            bottomText.setText("=  " + res);
        }
        else if(flag == 0) {
            topText.setText("");
            bottomText.setText(bottomText.getText().toString());


        }




    }

    public void clear(View view) {
        TextView topText = findViewById(R.id.textView2);
        TextView bottomText = findViewById(R.id.textView1);

        topText.setText("");
        bottomText.setText("");

        num1 = 0;
        num2 = 0;
        result = 0;
        number1 = "";
        number2 = "";
        number3 = "";
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}
