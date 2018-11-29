package com.android.rexben.associateexam1;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class Calculator extends AppCompatActivity {

    private EditText first, second;
    private Button add, minus, times, divide;
    private TextView result;
    private int firstVal, secondVal;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculator);

        first = findViewById(R.id.first);
        second = findViewById(R.id.second);
        result = findViewById(R.id.result);

        add = findViewById(R.id.add);
        minus = findViewById(R.id.minus);
        times = findViewById(R.id.times);
        divide = findViewById(R.id.divide);

        firstVal = Integer.parseInt(first.getText().toString());
        secondVal = Integer.parseInt(second.getText().toString());
    }


    public void add(View v) {
        double total = addTwoNumbers(firstVal, secondVal);
        result.setText("" + total);

    }


    public void minus(View v) {
        double total = substractTwoNumbers(firstVal, secondVal);
        result.setText("" + total);
    }


    public void times(View v) {
        double total = multiplyTwoNumbers(firstVal, secondVal);
        result.setText("" + total);
    }

    public void divide(View v) {
        double total = divideTwoNumbers(firstVal, secondVal);
        result.setText("" + total);
    }

    public void power(View v) {
        double total = raiseToPower(firstVal, secondVal);
        result.setText("" + total);
    }


    public double addTwoNumbers(double val, double value) {
        double total = val + value;
        return total;
    }

    public double substractTwoNumbers(double val, double value) {
        double total = val - value;
        return total;
    }

    public double divideTwoNumbers(double val, double value) {
        double total = 0;
        try {
            total = val / value;

        }catch (IllegalArgumentException e) {
        e.printStackTrace();
        }
        return total;

    }

    public double multiplyTwoNumbers(double val, double value) {
        double total = val * value;
        return total;
    }

    public double raiseToPower(int firstVal, int secondVal) {
        double total = Math.pow(firstVal, secondVal);
        return total;
    }

}
