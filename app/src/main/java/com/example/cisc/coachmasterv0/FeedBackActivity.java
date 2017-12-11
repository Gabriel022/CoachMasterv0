package com.example.cisc.coachmasterv0;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import static android.R.id.message;

public class FeedBackActivity extends AppCompatActivity implements View.OnClickListener {

    Button sendFeedBack;
    EditText feedBackText;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_feed_back);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        sendFeedBack = (Button) findViewById(R.id.feedBackSendButton);
        feedBackText = (EditText) findViewById(R.id.feedBackeditText);
        sendFeedBack.setOnClickListener(this);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }


    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.feedBackSendButton:
                Intent intent = new Intent(Intent.ACTION_SENDTO, Uri.fromParts(
                        "mailto", "bettipb@gmail.com", null));
                intent.putExtra(Intent.EXTRA_SUBJECT, "Feedback");
                intent.putExtra(Intent.EXTRA_TEXT, feedBackText.getText().toString());
                startActivity(Intent.createChooser(intent, "Choose an Email client :"));
                break;
        }

    }
}
