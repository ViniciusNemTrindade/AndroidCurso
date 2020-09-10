package com.vinicius.lyricsfinder;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText editeNomeArtista, editeNomeMusica;
    Button btnBuscaLetrasMusica;
    TextView textoLetras;

    //https://api.lyrics.ovh/v1/Rihanna/Diamonds#

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editeNomeArtista = findViewById(R.id.edtNomeArtista);
        editeNomeMusica = findViewById(R.id.edtNomeMusica);
        btnBuscaLetrasMusica = findViewById(R.id.btnGetLetras);
        textoLetras = findViewById(R.id.txtLetras);

        btnBuscaLetrasMusica.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getApplicationContext(), "Este botão foi pressionado!", Toast.LENGTH_SHORT).show();
            }
        });
    }
}