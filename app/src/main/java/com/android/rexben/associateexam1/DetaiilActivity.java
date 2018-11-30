package com.android.rexben.associateexam1;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

public class DetaiilActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detaiil);
        TextView sportTitle = findViewById(R.id.titleDetails);
        ImageView sportImage = findViewById(R.id.sportsImageDetails);

        sportTitle.setText(getIntent().getStringExtra("title"));
        Glide.with(this).load(getIntent().getIntExtra("image", 0)).into(sportImage);
    }
}
