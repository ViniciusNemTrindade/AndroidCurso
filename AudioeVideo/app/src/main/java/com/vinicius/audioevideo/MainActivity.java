package com.vinicius.audioevideo;

import androidx.appcompat.app.AppCompatActivity;

import android.media.AudioManager;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.MediaController;
import android.widget.SeekBar;
import android.widget.Toast;
import android.widget.VideoView;

import java.sql.Time;
import java.util.Timer;
import java.util.TimerTask;

public class MainActivity extends AppCompatActivity implements View.OnClickListener, SeekBar.OnSeekBarChangeListener, MediaPlayer.OnCompletionListener {

    // Ui Components
    private VideoView myVideoView;
    private Button btnPlayVideo;
    private MediaController mediaController;
    private Button btnPlayMusic;
    private Button btnPauseMusic;

    private MediaPlayer mediaPlayer;

    private SeekBar volumeSeekBar;
    private SeekBar moveParaFrenteEparaTrasSeekBar;
    private AudioManager audioManager;
    private Timer timer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        myVideoView = findViewById(R.id.videoView);
        btnPlayVideo = findViewById(R.id.btnPlay);
        btnPlayMusic = findViewById(R.id.btnMusic);
        btnPauseMusic = findViewById(R.id.btnPause);
        volumeSeekBar = findViewById(R.id.seekBarVolume);
        moveParaFrenteEparaTrasSeekBar = findViewById(R.id.seekBarMove);

        btnPlayVideo.setOnClickListener(MainActivity.this);
        btnPlayMusic.setOnClickListener(MainActivity.this);
        btnPauseMusic.setOnClickListener(MainActivity.this);

        mediaController = new MediaController(MainActivity.this);

        mediaPlayer = MediaPlayer.create(this, R.raw.tobu_mesmerize);
        audioManager = (AudioManager) getSystemService(AUDIO_SERVICE);

        int maximoVolumedoDispositivoDoUsuario = audioManager.getStreamMaxVolume(AudioManager.STREAM_MUSIC);
        int volumeAtualDoDispositivoDoUsuario = audioManager.getStreamVolume(AudioManager.STREAM_MUSIC);
        volumeSeekBar.setMax(maximoVolumedoDispositivoDoUsuario);
        volumeSeekBar.setProgress(volumeAtualDoDispositivoDoUsuario);

        volumeSeekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {

                if(fromUser) {

//                    Toast.makeText(MainActivity.this, Integer.toString(progress), Toast.LENGTH_SHORT ).show();

                    audioManager.setStreamVolume(AudioManager.STREAM_MUSIC, progress, 0);
                }
                
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

        moveParaFrenteEparaTrasSeekBar.setOnSeekBarChangeListener(this);
        moveParaFrenteEparaTrasSeekBar.setMax(mediaPlayer.getDuration() );
        mediaPlayer.setOnCompletionListener(this);

    }

    @Override
    public void onClick(View buttonView) {

        switch (buttonView.getId()) {
            case R.id.btnPlay:
                Uri videoUri = Uri.parse("android.resource://" +  getPackageName() + "/" + R.raw.airbaloon);
                myVideoView.setVideoURI(videoUri);
                myVideoView.setMediaController(mediaController);
                mediaController.setAnchorView(myVideoView );
                myVideoView.start();
                break;

            case R.id.btnMusic:
                mediaPlayer.start();
                timer = new Timer();
                timer.scheduleAtFixedRate(new TimerTask() {
                    @Override
                    public void run() {

                        moveParaFrenteEparaTrasSeekBar.setProgress(mediaPlayer.getCurrentPosition());
                    }
                },0, 1000);

                break;

            case R.id.btnPause:
                mediaPlayer.pause();
                timer.cancel();;
                break;

        }


    }

    @Override
    public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {

        if (fromUser) {

            mediaPlayer.seekTo(progress);
        }

    }

    @Override
    public void onStartTrackingTouch(SeekBar seekBar) {

        mediaPlayer.pause();

    }

    @Override
    public void onStopTrackingTouch(SeekBar seekBar) {

        mediaPlayer.start();
    }

    @Override
    public void onCompletion(MediaPlayer mp) {
        timer.cancel();
        Toast.makeText(this, "A musica terminou!", Toast.LENGTH_SHORT).show();
    }
}