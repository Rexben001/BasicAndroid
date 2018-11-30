package com.android.rexben.associateexam1;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

public class BatteryCharging extends AppCompatActivity {

    ImageView battery;
    int count = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_battery_charging);
        battery = findViewById(R.id.battery);
    }

    public void minus(View view) {
        if(count <= 0){
            count = 0;
            Toast.makeText(this, "E do do na. It can't go lower than this ", Toast.LENGTH_SHORT).show();

        }
        count--;

        switch (count){
            case 0:
                battery.setImageResource(R.drawable.ic_battery_20_black_24dp);
                break;
            case 1:
                battery.setImageResource(R.drawable.ic_battery_30_black_24dp);
                break;
            case 2:
                battery.setImageResource(R.drawable.ic_battery_50_black_24dp);
                break;
            case 3:
                battery.setImageResource(R.drawable.ic_battery_90_black_24dp);
                break;


        }

    }

    public void add(View view) {
        if(count >= 3){
            count = 3;
            Toast.makeText(this, "Battery is full na. Wetin you want again? ", Toast.LENGTH_SHORT).show();
        }
        count++;

        switch (count){
            case 0:
                battery.setImageResource(R.drawable.ic_battery_20_black_24dp);
                break;
            case 1:
                battery.setImageResource(R.drawable.ic_battery_30_black_24dp);
                break;
            case 2:
                battery.setImageResource(R.drawable.ic_battery_50_black_24dp);
                break;
            case 3:
                battery.setImageResource(R.drawable.ic_battery_90_black_24dp);
                break;
        }

    }
}
