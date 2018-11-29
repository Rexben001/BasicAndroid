package com.android.rexben.associateexam1;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.RadioButton;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class OrderActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order);

        Spinner spinner = findViewById(R.id.spinner);

        Intent intent = getIntent();

        if (spinner != null) {
            spinner.setOnItemSelectedListener(this);
        }

        //Receive the message from the previous activity
        //It returns null if no message was captured

        String message = "Order: " + intent.getStringExtra(ImageActivity.EXTRA_MESSAGE);

        TextView textView = findViewById(R.id.textView2);

        textView.setText(message);

        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.phone, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        if (spinner != null) {
            spinner.setAdapter(adapter);
        }
    }

    public void displayToastMessage(String message) {
        Toast.makeText(getApplicationContext(), message, Toast.LENGTH_SHORT).show();
    }

    public void onRadioLabel(View view) {


        boolean checked = ((RadioButton) view).isChecked();

        switch (view.getId()) {
            case R.id.next:
//                if (checked)
                displayToastMessage("You've order will be delivered tomorrow");
                break;
            case R.id.same:
//                if (checked)
                displayToastMessage("Waiting at your doorsteps");
                break;
            case R.id.pick:
//                if (checked)
                displayToastMessage("You can come to pick it up");
                break;
            default:
                break;


        }
    }

    public void nextt(View view) {
        Toast.makeText(getApplicationContext(), "Hello", Toast.LENGTH_LONG).show();
    }


    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        String spinnerLabel = parent.getItemAtPosition(position).toString();
        displayToastMessage(spinnerLabel);
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
}
