package com.example.cisc.coachmasterv0;

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

public class PlayerActivity extends AppCompatActivity implements View.OnClickListener {

    Button addNewScoreButton;
    //Declare some variables for the sound effect
    private SoundPool soundPool;
    int sample2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_player);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        addNewScoreButton = (Button) findViewById(R.id.newScoreButton);
        addNewScoreButton.setOnClickListener(this);


        getSupportActionBar().setDisplayHomeAsUpEnabled(true);


        //this code in the onCreate method to load the sound into memory
        //
        soundPool = new SoundPool(10, AudioManager.STREAM_MUSIC,0);
        try {
            AssetManager assetManager = getAssets();
            AssetFileDescriptor descriptor;
            descriptor = assetManager.openFd("sound2.ogg");
            sample2 = soundPool.load(descriptor, 0);
        } catch (IOException e) {
            //catch excpetion here
        }
    }

    @Override
    public void onClick(View view) {
        soundPool.play(sample2, 1, 1, 0, 0, 1);
    }
}
