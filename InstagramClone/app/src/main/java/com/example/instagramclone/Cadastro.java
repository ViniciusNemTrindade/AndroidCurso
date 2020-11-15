package com.example.instagramclone;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class Cadastro extends AppCompatActivity  implements View.OnClickListener {

    //Componentes de UI
    private EditText edtViewEmailCadastro, edtViewUsuarioCadastro, edtViewSenhaCadastro;
    private Button btnViewCadastrar, btnViewLogin;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastro);

        edtViewEmailCadastro = findViewById(R.id.edtTextEmailCadastro);
        edtViewUsuarioCadastro = findViewById(R.id.edtTextUsuarioCadastro);
        edtViewSenhaCadastro = findViewById(R.id.edtTextSenhaCadastro);


    }

    @Override
    public void onClick(View v) {

    }
}