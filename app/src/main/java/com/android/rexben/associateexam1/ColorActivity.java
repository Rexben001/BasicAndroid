package com.android.rexben.associateexam1;

import android.os.PersistableBundle;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import java.util.Random;

public class ColorActivity extends AppCompatActivity {

    private TextView mColorTextView;
    private String[] mColorArray = {"black", "white", "blue", "grey", "blur"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_color);

        mColorTextView = findViewById(R.id.color_text);

        //Calls the saved state in case of restart or recreation af an activity
        if(savedInstanceState != null){
            mColorTextView.setTextColor(savedInstanceState.getInt("color"));
        }

    }

    //Save the state of a view incase of recreation or restart
    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);

        outState.putInt("color", mColorTextView.getCurrentTextColor());
    }

    public void changeColor(View view) {

        //get random int between 1 and 5
        Random random = new Random();
        String colorName = mColorArray[random.nextInt(5)];
        //Get all the resources in your project and associate them with an identifier
        int colorResourceName = getResources().getIdentifier(colorName, "color", getApplicationContext().getPackageName());
        //Get the specific colot
        int colorRes = ContextCompat.getColor(this, colorResourceName);

        mColorTextView.setTextColor(colorRes);
    }
}
