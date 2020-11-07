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

        mImgBoxing.setOnClickListener(MainActivity.this);
        mImgKickboxing.setOnClickListener(MainActivity.this);
        mImgJudo.setOnClickListener(MainActivity.this);
        mImgKarate.setOnClickListener(MainActivity.this);
        mImgTaekwondo.setOnClickListener(MainActivity.this);
        mImgAikido.setOnClickListener(MainActivity.this);
    }

    @Override
    public void onClick(View imageButtonView) {

        switch (imageButtonView.getId()) {

            case R.id.imgBoxing:
                toqueNomeSport(mImgBoxing.getTag().toString());
                break;
            case R.id.imgKickboxing:
                toqueNomeSport(mImgKickboxing.getTag().toString());
                break;
            case R.id.imgJudo:
                toqueNomeSport(mImgJudo.getTag().toString());
                break;
            case R.id.imgKarate:
                toqueNomeSport(mImgKarate.getTag().toString());
                break;
            case R.id.imgAikido:
                toqueNomeSport(mImgAikido.getTag().toString());
                break;
            case R.id.imgTaekwondo:
                toqueNomeSport(mImgTaekwondo.getTag().toString());
                break;
        }

    }

    public void toqueNomeSport(String nomeSport) {

        sportPlayer = MediaPlayer.create(this, getResources().getIdentifier(nomeSport, "raw", getPackageName()));

        sportPlayer.start();

    }

}