package com.vinicius.dadoapp;

import androidx.appcompat.app.AppCompatActivity;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.daimajia.androidanimations.library.Techniques;
import com.daimajia.androidanimations.library.YoYo;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final ImageView imagemDado1 = findViewById(R.id.imgDice1);
        final ImageView imagemDado2 = findViewById(R.id.imgDice2);

        final int [] imagensDados = {R.drawable.dice1, R.drawable.dice2, R.drawable.dice3, R.drawable.dice4, R.drawable.dice5, R.drawable.dice6};

        Button btnRolar = findViewById(R.id.btnRolarOsDados);

        final MediaPlayer mp = MediaPlayer.create(this, R.raw.dice_sound );

        btnRolar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                //Log.i("MeuDadoApp", "btnRolar pressionado!");

                Random rndObject = new Random();

                int meuNumeroRandomico = rndObject.nextInt(6); // Gera um númeero randômico, entre 0 e 5
                //Log.i("MeuDadoApp","O numero ramdômico gerado foi: " + meuNumeroRandomico + "");
                imagemDado1.setImageResource(imagensDados[meuNumeroRandomico]);

                meuNumeroRandomico = rndObject.nextInt(6); // Gera um númeero randômico, entre 0 e 5
                imagemDado2.setImageResource(imagensDados[meuNumeroRandomico]);

                YoYo.with(Techniques.Shake)
                        .duration(500)// em milesegundos(ms)
                        .repeat(0)
                        .playOn(findViewById(R.id.imgDice1));

                YoYo.with(Techniques.Shake)
                        .duration(500)// em milesegundos(ms)
                        .repeat(0)
                        .playOn(findViewById(R.id.imgDice2));

                mp.start();
            }
        });

    }
}