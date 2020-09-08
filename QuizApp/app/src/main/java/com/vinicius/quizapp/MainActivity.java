package com.vinicius.quizapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button botaoVerdade = findViewById(R.id.btnVerdade);

        View.OnClickListener meuClickListener = new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if(view.getId() == R.id.btnVerdade) {
                    Log.i("Listener", "O botão Verdade! Foi pressionado!");
                }
            }
        };

        botaoVerdade.setOnClickListener(meuClickListener);

        Button botaoFalso = findViewById(R.id.btnFalso);

//        botaoFalso.setOnClickListener(meuClickListener);

        botaoFalso.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Log.i("Listener", "O botão Falso! Foi pressionado!");

            }
        });
    }
}