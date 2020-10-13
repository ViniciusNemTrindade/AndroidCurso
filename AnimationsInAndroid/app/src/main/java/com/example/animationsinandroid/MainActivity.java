package com.example.animationsinandroid;

import androidx.appcompat.app.AppCompatActivity;
import androidx.gridlayout.widget.GridLayout;

import android.media.Image;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    enum Jogador {
        JOGADOR_1, JOGADOR_2, NO;
    }

    Jogador jogadorAtual = Jogador.JOGADOR_1;

    Jogador[] escolhasDoJogador = new Jogador[9];

    int[][] vencedorLinhasColunas = {{0, 1, 2}, {3, 4, 5}, {6, 7, 8},
            {0, 3, 6}, {1, 4, 7}, {2, 5, 8}, {0, 4, 8}, {2, 4, 6}};

    private boolean oJogoAcabou = false;

    private Button btnReset;

    private GridLayout gridLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        for (int index = 0; index < escolhasDoJogador.length; index++) {

            escolhasDoJogador[index] = Jogador.NO;
        }
        
        btnReset = findViewById(R.id.btnReset);
        gridLayout = findViewById(R.id.idGridLayout);

        btnReset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                reiniciarJogo();
            }
        });

    }

    public void imgViewFoiPressionada(View imageView) {

        ImageView imageViewPressionada = (ImageView) imageView;

        int imgViewTag = Integer.parseInt(imageViewPressionada.getTag().toString());

        if (escolhasDoJogador[imgViewTag] == Jogador.NO && oJogoAcabou == false) {


            imageViewPressionada.setTranslationX(-2000);


            escolhasDoJogador[imgViewTag] = jogadorAtual;

            if (jogadorAtual == Jogador.JOGADOR_1) {
                imageViewPressionada.setImageResource(R.drawable.lion);
                jogadorAtual = Jogador.JOGADOR_2;

            } else if (jogadorAtual == Jogador.JOGADOR_2) {
                imageViewPressionada.setImageResource(R.drawable.tiger);
                jogadorAtual = Jogador.JOGADOR_1;
            }

            imageViewPressionada.animate().translationXBy(2000).alpha(1).rotation(3600).setDuration(1000);

            Toast.makeText(this, imageViewPressionada.getTag().toString(), Toast.LENGTH_SHORT).show();

            for (int[] vencedorColunas : vencedorLinhasColunas) {

                if (escolhasDoJogador[vencedorColunas[0]] == escolhasDoJogador[vencedorColunas[1]] &&
                        escolhasDoJogador[vencedorColunas[1]] == escolhasDoJogador[vencedorColunas[2]] &&
                        escolhasDoJogador[vencedorColunas[0]] != Jogador.NO) {

                    btnReset.setVisibility(View.VISIBLE);
                    oJogoAcabou = true;

                    String vencedorDoJogo = "";

                    if (jogadorAtual == Jogador.JOGADOR_1) {

                        vencedorDoJogo = "Jogador 1";

                    } else if (jogadorAtual == Jogador.JOGADOR_2) {

                        vencedorDoJogo = "Jogador 2";
                    }

                    Toast.makeText(this, vencedorDoJogo + " eh o vencedor!", Toast.LENGTH_LONG).show();

                }

            }

        }
    }

    // Função para reiniciar o jogo
    private void reiniciarJogo () {

        for (int index =  0; index < gridLayout.getChildCount(); index++) {

            ImageView imageView = (ImageView) gridLayout.getChildAt(index);
            imageView.setImageDrawable(null);
            imageView.setAlpha(0.2f);
        }

        jogadorAtual = Jogador.JOGADOR_1;

        for (int index = 0; index < escolhasDoJogador.length; index++) {

            escolhasDoJogador[index] = Jogador.NO;
        }

        oJogoAcabou = false;

        btnReset.setVisibility(View.INVISIBLE);
    }
}
