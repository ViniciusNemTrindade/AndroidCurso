package com.vinicius.helloworldapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {


    public void btnPressionar(View buttonView ) {

        // int resultado = 5 * 3;
        // Log.i("Operacao: ", resultado + "");
        TextView texto = findViewById(R.id.texto);
        Log.i("TAG", texto.getText().toString());
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}