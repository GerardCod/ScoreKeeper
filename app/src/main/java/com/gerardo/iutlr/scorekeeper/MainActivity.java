package com.gerardo.iutlr.scorekeeper;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.app.AppCompatDelegate;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private int scoreTeam1 = 0;
    private int scoreTeam2 = 0;
    private TextView score1;
    private TextView score2;
    static final String STATE_SCORE_1 = "Team 1 Score";
    static final String STATE_SCORE_2 = "Team 2 Score";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        score1 = findViewById(R.id.score_1);
        score2 = findViewById(R.id.score_2);

        if (savedInstanceState != null) {
            scoreTeam1 = savedInstanceState.getInt(STATE_SCORE_1);
            scoreTeam2 = savedInstanceState.getInt(STATE_SCORE_2);
            score1.setText(""+ scoreTeam1);
            score2.setText(""+scoreTeam2);
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main_menu, menu);
        int nightMode = AppCompatDelegate.getDefaultNightMode();
        if(nightMode == AppCompatDelegate.MODE_NIGHT_YES){
            menu.findItem(R.id.night_mode).setTitle(R.string.day_mode);
        } else{
            menu.findItem(R.id.night_mode).setTitle(R.string.night_mode);
        }
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        if (item.getItemId() == R.id.night_mode) {
            int nightMode = AppCompatDelegate.getDefaultNightMode();

            if (nightMode == AppCompatDelegate.MODE_NIGHT_YES) {
                AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);
            } else {
                AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES);
            }

            recreate();
        }

        return super.onOptionsItemSelected(item);
    }

    public void decreaseScore(View view) {
        if (view.getId() == R.id.decreaseTeam1) {
            scoreTeam1--;
            score1.setText(""+scoreTeam1);
        } else {
            scoreTeam2--;
            score2.setText(""+scoreTeam2);
        }
    }

    public void increaseScore(View view) {
        if (view.getId() == R.id.increaseTeam1) {
            scoreTeam1++;
            score1.setText(""+scoreTeam1);
        } else {
            scoreTeam2++;
            score2.setText(""+scoreTeam2);
        }
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        outState.putInt(STATE_SCORE_1, scoreTeam1);
        outState.putInt(STATE_SCORE_2, scoreTeam2);
        super.onSaveInstanceState(outState);
    }
}
