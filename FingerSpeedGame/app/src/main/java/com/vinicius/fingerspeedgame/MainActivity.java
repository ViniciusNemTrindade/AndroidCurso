package com.vinicius.fingerspeedgame;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView txtTempoView;
    TextView textMilView;
    Button btnToqueToque;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txtTempoView = findViewById(R.id.txtTempo);
        textMilView = findViewById(R.id.txtMil);
        btnToqueToque = findViewById(R.id.btnToque);

        btnToqueToque.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.i("TAG", "O botao foi pressionado!");
            }
        });
    }
}