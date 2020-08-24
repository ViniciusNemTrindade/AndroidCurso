package com.vinicius.appfatos01;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView fatosTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        fatosTextView = findViewById(R.id.txt_fato);

        String[] meusFatos = Fato.getFatos();

        for(String fato : meusFatos) {

                fatosTextView.append(fato + "\n\n");
        }

    }
}