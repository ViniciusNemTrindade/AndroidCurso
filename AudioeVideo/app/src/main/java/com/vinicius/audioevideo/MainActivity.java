package com.vinicius.audioevideo;

import androidx.appcompat.app.AppCompatActivity;

import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.MediaController;
import android.widget.VideoView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private VideoView myVideoView;
    private Button btnPlayVideo;
    private MediaController mediaController;
    private Button btnPlayMusic;
    private Button btnPauseMusic;
    private MediaPlayer mediaPlayer;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        myVideoView = findViewById(R.id.videoView);
        btnPlayVideo = findViewById(R.id.btnPlay);
        btnPlayMusic = findViewById(R.id.btnMusic);
        btnPauseMusic = findViewById(R.id.btnPause);

        btnPlayVideo.setOnClickListener(MainActivity.this);
        btnPlayMusic.setOnClickListener(MainActivity.this);
        btnPauseMusic.setOnClickListener(MainActivity.this);

        mediaController = new MediaController(MainActivity.this);
        mediaPlayer = new MediaPlayer.create(this, R.raw.dragon_ball);

    }

    @Override
    public void onClick(View buttonView) {

        switch (buttonView) {
            case R.id.btnPlay:
                Uri videoUri = Uri.parse("android.resource://" +  getPackageName() + "/" + R.raw.airbaloon);
                myVideoView.setVideoURI(videoUri);

                myVideoView.setMediaController(mediaController);
                mediaController.setAnchorView(myVideoView );

                myVideoView.start();
                break;
            case R.id.btnMusic:
                Uri videoUri = Uri.parse("android.resource://" +  getPackageName() + "/" + R.raw.airbaloon);
                myVideoView.setVideoURI(videoUri);

                myVideoView.setMediaController(mediaController);
                mediaController.setAnchorView(myVideoView );

                myVideoView.start();
                break;
            case R.id.btnPause
                break;

        }


    }
}