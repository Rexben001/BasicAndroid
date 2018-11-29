package com.android.rexben.associateexam1;

import android.app.DialogFragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class PickerActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_picker);
    }

    public void date(View view) {
        DatePickerFragment fragment = new DatePickerFragment();
        fragment.show(getSupportFragmentManager(), "datePicker");
    }

    public void processDate(int year, int month, int day){
        String month_STring = Integer.toString(month + 1);

        String day_STring = Integer.toString(day);

        String year_STring = Integer.toString(year);

        String dateMessage = (month_STring + "/" + day_STring + "/" + year_STring);

        Toast.makeText(this, "date is: " + dateMessage, Toast.LENGTH_SHORT).show();
    }

    public void time(View view) {
        TimePickerFragment fragment = new TimePickerFragment();
        fragment.show(getSupportFragmentManager(), "timePicker");
    }
    public void processTime(int hour, int minute){
        String hour_STring = Integer.toString(hour);

        String minute_STring = Integer.toString(minute);

//        String second_STring = Integer.toString(second);

        String time = (hour_STring + ":" + minute_STring);

        Toast.makeText(this, "time is: " + time, Toast.LENGTH_SHORT).show();
    }
}
