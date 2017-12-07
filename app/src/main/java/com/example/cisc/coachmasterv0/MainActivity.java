package com.example.cisc.coachmasterv0;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    Button playerButton;
    Button coachButton;
    Button sendFeedback;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        playerButton = (Button) findViewById(R.id.playerButton);
        coachButton = (Button) findViewById(R.id.coachButton);
        sendFeedback = (Button) findViewById(R.id.feedbackButton);

        playerButton.setOnClickListener(this);
        coachButton.setOnClickListener(this);
        sendFeedback.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch(v.getId()) {
            case R.id.playerButton:
                Intent y;
                y = new Intent(this,PlayerActivity.class);
                startActivity(y);
                break;
            case R.id.coachButton:
                Intent c;
                c = new Intent(this,coachActivity.class);
                startActivity(c);
                break;
            case R.id.feedbackButton:
                Intent f;
                f = new Intent(this, FeedBackActivity.class);
                startActivity(f);
                break;
        }

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            Intent preferencesIntent = new Intent(this, SettingsActivity.class);
            startActivity(preferencesIntent);
        }

        return super.onOptionsItemSelected(item);
    }
}
