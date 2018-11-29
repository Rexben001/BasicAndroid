package com.android.rexben.associateexam1;

import android.content.Intent;
import android.nfc.Tag;
import android.os.PersistableBundle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

   private static final String LOG_TAG = MainActivity.class.getSimpleName();
   private Button increase, decrease;
    private TextView display;
    private int count = 0;
    private CheckBox checkBox;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        increase = findViewById(R.id.increase_btn);
        decrease = findViewById(R.id.decrease_btn);
        display = findViewById(R.id.display);
        checkBox = findViewById(R.id.checkBox);

        if(savedInstanceState != null){
            count = savedInstanceState.getInt("count");
            Log.d(LOG_TAG, "Saved value of count: " +count);
            display.setText("" +count);
        }


        increase.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                count++;
                display.setText(""+count);
                Log.d(LOG_TAG, "Value incremented by 1: " + count);
            }
        });

        decrease.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(count < 1){
//                    decrease.setClickable(false);
                    count = 0;
                    display.setText("" +count);
                }else {
//                    decrease.setClickable(true);
                    count--;
                    display.setText("" + count);
                }
            }
        });
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        outState.putInt("count", count);
        Log.d("count","count = " + count);
        super.onSaveInstanceState(outState);

    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d(LOG_TAG, "Activity started");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d(LOG_TAG, "paused");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d(LOG_TAG, "On resume");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d(LOG_TAG, "activity destroyed");
    }

    public void next(View view) {

//        String newACtivity =  display.getText().toString();
//        Intent newIntent = new Intent();
//        newIntent.putExtra("Count" , newACtivity);
//        setResult(RESULT_OK, newIntent);
//
//        startActivity(new Intent(MainActivity.this, SecondActivity.class).putExtra("count", count));
        startActivity(new Intent(MainActivity.this, MaterialMe.class));
        Log.d(LOG_TAG, "Completed");
    }
}
