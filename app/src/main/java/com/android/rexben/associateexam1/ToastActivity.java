package com.android.rexben.associateexam1;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.Toast;

public class ToastActivity extends AppCompatActivity{

    CheckBox one, two, three, four;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_toast);

        one = findViewById(R.id.one);
        two = findViewById(R.id.two);
        three = findViewById(R.id.three);
        four = findViewById(R.id.four);


    }

    public void toastMessage(View view) {
        if(one.isChecked() && two.isChecked()){
            String messageOne = one.getText().toString();
            String messageTwo = two.getText().toString();
            Toast.makeText(getApplicationContext(), messageTwo+" , " + messageOne, Toast.LENGTH_SHORT).show();
        }
    }
}
