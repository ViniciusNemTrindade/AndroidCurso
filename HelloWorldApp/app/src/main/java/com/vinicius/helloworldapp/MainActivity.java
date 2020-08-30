package com.vinicius.helloworldapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {


    public void btnPressionar(View buttonView ) {

        // int resultado = 5 * 3;
        // Log.i("Operacao: ", resultado + "");
//         TextView texto = findViewById(R.id.texto);
        // Log.i("TAG", texto.getText().toString());
        EditText edtNome = findViewById(R.id.editeTexto);
//        Log.i("NOME: ", edtNome.getText().toString());

        EditText edtNumTelefone = findViewById(R.id.editeTelefone);
//        Log.i("NÚMERO: ", edtNumTelefone.getText().toString());
//        Toast.makeText(MainActivity.this, texto.getText().toString(), Toast.LENGTH_LONG).show();

        Toast.makeText(MainActivity.this, "Seu nome eh: "+ edtNome.getText().toString() + "\n"
                + "Seu telefone eh: " + edtNumTelefone.getText().toString(), Toast.LENGTH_LONG).show();

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}