package com.vinicius.apppetteste;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import java.util.Calendar;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void botaoCalcular(View buttonView){

        EditText edtAnoNascimento = findViewById(R.id.anoNascimento);
        int agePet = Calendar.getInstance().get(Calendar.YEAR) - Integer.parseInt(edtAnoNascimento.getText().toString());

        TextView mostraIdade = findViewById(R.id.resultadoIdade);
        mostraIdade.setText(agePet + "" + " anos!");

    }
}