package com.example.cisc.coachmasterv0;

import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.RatingBar;
import android.widget.TextView;

import static android.R.attr.name;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    Button playerButton;
    Button coachButton;
    Button sendFeedback;


    Dialog rankDialog;
    RatingBar ratingBar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
//loading animation to activity
        final Animation shake = AnimationUtils.loadAnimation(this, R.anim.shake);
        final Animation milkshake = AnimationUtils.loadAnimation(this, R.anim.milkshake);


        playerButton = (Button) findViewById(R.id.playerButton);
        coachButton = (Button) findViewById(R.id.coachButton);
        sendFeedback = (Button) findViewById(R.id.feedbackButton);

        sendFeedback.startAnimation(shake);
        coachButton.startAnimation(milkshake);

        playerButton.setOnClickListener(this);
        coachButton.setOnClickListener(this);
        sendFeedback.setOnClickListener(this);

        //Getting the User to Rate the app.
        try {

            // Get the app's shared preferences
            SharedPreferences app_preferences = PreferenceManager.getDefaultSharedPreferences(this);

            // Get the value for the run counter
            int counter = app_preferences.getInt("counter", 0);

            // Do every x times
            int RunEvery = 3;

            if(counter != 0  && counter % RunEvery == 0 )
            {
                //Toast.makeText(this, "This app has been started " + counter + " times.", Toast.LENGTH_SHORT).show();

                AlertDialog.Builder alert = new AlertDialog.Builder(
                        MainActivity.this);
                alert
                        .setTitle("Please rate");
                alert.setIcon(R.mipmap.appicon); //app icon here
                alert.setMessage("Thanks for using this app. Please take a moment to rate it.");

                alert.setPositiveButton("Cancel",
                        new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog,
                                                int whichButton) {
                                //Do nothing
                            }
                        });

                alert.setNegativeButton("Rate it",
                        new DialogInterface.OnClickListener() {

                            public void onClick(DialogInterface dialog, int which) {

                            // Code for creating a dialog which displays the rating bar(stars)
                                rankDialog = new Dialog(MainActivity.this, R.style.FullHeightDialog);
                                rankDialog.setContentView(R.layout.rank_dialog);
                                rankDialog.setCancelable(true);
                                ratingBar = (RatingBar)rankDialog.findViewById(R.id.dialog_ratingbar);
                                //ratingBar.setRating(ratingBar.getRating());  -- not working properly

                                TextView text = (TextView) rankDialog.findViewById(R.id.rank_dialog_text1);
                                text.setText("Rate the App");

                                Button updateButton = (Button) rankDialog.findViewById(R.id.rank_dialog_button);
                                updateButton.setOnClickListener(new View.OnClickListener() {
                                    @Override
                                    public void onClick(View v) {
                                        rankDialog.dismiss();
                                    }
                                });


                                    //now that the dialog is set up, it's time to show it
                                    rankDialog.show();





            //Code for open the rating on the Google play
//                                final String appName = getApplicationContext().getPackageName();
//                                try {
//                                    startActivity(new Intent(Intent.ACTION_VIEW,
//                                            Uri.parse("market://details?id="
//                                                    + appName)));
//                                } catch (android.content.ActivityNotFoundException anfe) {
//                                    startActivity(new Intent(
//                                            Intent.ACTION_VIEW,
//                                            Uri.parse("http://play.google.com/store/apps/details?id="
//                                                    + appName)));
//                                }

                            }
                        });
                alert.show();
            }


            // Increment the counter
            SharedPreferences.Editor editor = app_preferences.edit();
            editor.putInt("counter", ++counter);
            editor.commit(); // Very important

        } catch (Exception e) {
            //Do nothing, don't run but don't break
        }
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
