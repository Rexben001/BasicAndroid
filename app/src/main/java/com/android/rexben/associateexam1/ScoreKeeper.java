package com.android.rexben.associateexam1;

import android.os.PersistableBundle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.app.AppCompatDelegate;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

public class ScoreKeeper extends AppCompatActivity {

    private int mScore1, mScore2;
    private TextView mScoreText1, mScoreText2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_score_keeper);

        mScoreText1 = findViewById(R.id.score_1);
        mScoreText2 = findViewById(R.id.score_2);

        if (savedInstanceState != null) {
            mScore1 = savedInstanceState.getInt("score1");
            mScore2 = savedInstanceState.getInt("score2");

            mScoreText1.setText(String.valueOf(mScore1));
            mScoreText2.setText(String.valueOf(mScore2));


        }
    }

    public void increaseScore(View view) {
        switch (view.getId()) {
            case R.id.incraseTeam1:
                mScore1++;
                mScoreText1.setText(String.valueOf(mScore1));
                break;
            case R.id.incraseTeam2:
                mScore2++;
                mScoreText2.setText(String.valueOf(mScore2));
                break;
        }
    }

    public void decreaseScore(View view) {
        switch (view.getId()) {
            case R.id.decraseTeam1:
                mScore1--;
                mScoreText1.setText(String.valueOf(mScore1));
                break;
            case R.id.decraseTeam2:
                mScore2--;
                mScoreText2.setText(String.valueOf(mScore2));
                break;
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.score_menu, menu);
        //Change the text to conform to the changes between dark mode and light mode
        int nightmode = AppCompatDelegate.getDefaultNightMode();
        if (nightmode == AppCompatDelegate.MODE_NIGHT_YES) {
            menu.findItem(R.id.night).setTitle(R.string.day_mode);
        } else {
            menu.findItem(R.id.night).setTitle(R.string.night_mode);

        }
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        //Apply night mode to your App
        if (item.getItemId() == R.id.night) {
            int nightmode = AppCompatDelegate.getDefaultNightMode();

            AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES);
            if (nightmode == AppCompatDelegate.MODE_NIGHT_YES) {
                AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);

            } else {
                AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES);
            }
            recreate();
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        outState.putInt("score1", mScore1);
        outState.putInt("score2", mScore2);
        super.onSaveInstanceState(outState);
    }
}
