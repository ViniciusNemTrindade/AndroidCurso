package com.example.locutorsportivo;

import androidx.appcompat.app.AppCompatActivity;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private ImageButton mImgBoxing, mImgKickboxing, mImgJudo, mImgKarate, mImgAikido, mImgTaekwondo;

    private MediaPlayer sportPlayer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mImgBoxing = findViewById(R.id.imgBoxing);
        mImgKickboxing = findViewById(R.id.imgKickboxing);
        mImgJudo = findViewById(R.id.imgJudo);
        mImgKarate = findViewById(R.id.imgKarate);
        mImgAikido = findViewById(R.id.imgAikido);
        mImgTaekwondo = findViewById(R.id.imgTaekwondo);

        mImgKickboxing.setOnClickListener(MainActivity.this);
    }

    @Override
    public void onClick(View imageButtonView) {

        switch (imageButtonView.getId()) {

            case R.id.imgBoxing:
                break;
            case R.id.imgKickboxing:
                break;
            case R.id.imgJudo:
                break;
            case R.id.imgKarate:
                break;
            case R.id.imgAikido:
                break;
            case R.id.imgTaekwondo:
                break;
        }

    }

    public void coloqueNomeSport(String nomeSport) {

        sportPlayer = MediaPlayer.create(this, getResources().getIdentifier(nomeSport, "raw", getPackageName()));

    }

}