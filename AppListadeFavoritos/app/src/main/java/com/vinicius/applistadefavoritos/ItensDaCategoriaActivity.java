package com.vinicius.applistadefavoritos;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class ItensDaCategoriaActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_itens_da_categoria);

        Categoria categoria = (Categoria) getIntent().getSerializableExtra(MainActivity.CATEGORIA_OBJECT_KEY);
        setTitle(categoria.getNome());

    }
}