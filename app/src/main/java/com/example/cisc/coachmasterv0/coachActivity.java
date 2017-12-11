package com.example.cisc.coachmasterv0;

import android.content.Intent;
import android.content.res.AssetFileDescriptor;
import android.content.res.AssetManager;
import android.media.AudioManager;
import android.media.SoundPool;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;

import java.io.IOException;

public class coachActivity extends AppCompatActivity implements View.OnClickListener {

    Button addNewPlayerButton;
    Button listButton;
    //Declare some variables for the sound effect
    private SoundPool soundPool;
    int sample1;
    int sample2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_coach);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        addNewPlayerButton = (Button) findViewById(R.id.newPlayerButton);
        addNewPlayerButton.setOnClickListener(this);
        listButton = (Button) findViewById(R.id.listButton);
        listButton.setOnClickListener(this);
        //this code in the onCreate method to load the sound into memory
        //
        soundPool = new SoundPool(10, AudioManager.STREAM_MUSIC, 0);
        try {
            AssetManager assetManager = getAssets();
            AssetFileDescriptor descriptor, descriptor2;
            descriptor = assetManager.openFd("sound1.ogg");
            descriptor2 = assetManager.openFd("sound3.ogg");

            sample1 = soundPool.load(descriptor, 0);
            sample2 = soundPool.load(descriptor2, 0);
        } catch (IOException e) {
            //catch excpetion here
        }
    }


    @Override
    public void onClick(View v) {
        switch (v.getId()) {

            case R.id.newPlayerButton:
                soundPool.play(sample1, 1, 1, 0, 0, 1);
                break;
            case R.id.listButton:
                soundPool.play(sample2, 1, 1, 0, 0, 1);
                break;

        }
    }
}
