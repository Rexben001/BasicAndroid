package com.android.rexben.associateexam1;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

public class ImageActivity extends AppCompatActivity {

    private String mOrderMessage;

    //captures the message in this activity
    public static final String EXTRA_MESSAGE = "com.android.rexben.associateexam1.extra.MESSAGE";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_image);

        TextView donut_description = findViewById(R.id.donut_description);
        registerForContextMenu(donut_description);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder alert = new AlertDialog.Builder(ImageActivity.this);

                alert.setTitle("Alert");
                alert.setMessage("Click OK to continue or Cancel to stop:");
                alert.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        startActivity(new Intent(getApplicationContext(), OrderActivity.class));
                    }
                });

                alert.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Toast.makeText(ImageActivity.this, "cancel clicked", Toast.LENGTH_SHORT).show();
                    }
                });
                alert.show();
            }
        });
    }

    public void displayMessage(String message) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }


    public void donut(View view) {
        mOrderMessage = getString(R.string.donut_message);
        displayMessage(mOrderMessage);
    }

    public void iceCream(View view) {
        mOrderMessage = getString(R.string.ice_cream_message);
        displayMessage(mOrderMessage);
    }

    public void froyo(View view) {
        mOrderMessage = getString(R.string.froyo_message);
        displayMessage(mOrderMessage);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.contacts:
                toastMessage(getString(R.string.contacts_message));
                return true;
            case R.id.orders:
                Intent intent = new Intent(ImageActivity.this, OrderActivity.class);
                //send the container and the captured message
                intent.putExtra(EXTRA_MESSAGE, mOrderMessage);
                startActivity(intent);
                return true;
            case R.id.favourites:
                toastMessage(getString(R.string.favourite_message));
                return true;
            case R.id.status:
                toastMessage(getString(R.string.status_message));
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }

    }

    public void toastMessage(String message) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_context, menu);
    }

    @Override
    public boolean onContextItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.edit:
                toastMessage("Edit text selected");
                return true;
            case R.id.share:
                toastMessage("share text selected");
                return true;
            case R.id.delete:
                toastMessage("delete text selected");
                return true;
            default:
                return super.onContextItemSelected(item);

        }
    }
}
