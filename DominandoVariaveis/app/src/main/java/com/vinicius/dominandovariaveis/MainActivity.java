package com.vinicius.dominandovariaveis;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView mostrarResultado;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }

    public void onClickCalcular(View view) {

        EditText edtNumerador = findViewById(R.id.editNumerador);
        EditText edtDenominador = findViewById(R.id.editDenominador);

        int restoDivisao = Integer.parseInt(edtNumerador.getText().toString()) %
                Integer.parseInt(edtDenominador.getText().toString());

        mostrarResultado = findViewById(R.id.viewCalcular);
        mostrarResultado.setText(restoDivisao + " ");

    }

}