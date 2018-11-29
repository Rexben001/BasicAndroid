package com.android.rexben.associateexam1;

import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class DialNumbers extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dial_numbers);

        EditText editText = findViewById(R.id.call);

        if (editText != null){
            editText.setOnEditorActionListener(new TextView.OnEditorActionListener() {
                @Override
                public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {

                    boolean handled = false;
                    // If the send button is clicked, dial the number
                    if (actionId == EditorInfo.IME_ACTION_SEND){
                        dialNumbers();
                        handled = true;
                    }
                    return handled;
                }
            });
        }
    }

    //Get the number, add tel and parse it to make call
    private void dialNumbers() {
        EditText editText = findViewById(R.id.call);
        String phoneNum = null;

        if (editText != null) phoneNum = "tel:" + editText.getText().toString();

            Intent intent = new Intent(Intent.ACTION_DIAL);
            intent.setData(Uri.parse(phoneNum));

            if (intent.resolveActivity(getPackageManager()) != null){
                startActivity(intent);
            }else {
                Log.d("Implicit intents", "Can not make calls");
            }
    }

    public void checkAlert(View view) {
        AlertDialog.Builder alert = new AlertDialog.Builder(DialNumbers.this);

        alert.setTitle("Alert");
        alert.setMessage("Click OK to continue or Cancel to stop:");
        alert.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Toast.makeText(DialNumbers.this, "Ok clicked", Toast.LENGTH_SHORT).show();
            }
        });

        alert.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Toast.makeText(DialNumbers.this, "cancel clicked", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
