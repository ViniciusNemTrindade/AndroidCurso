package com.example.instagramclone;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.parse.ParseUser;

public class ActivityCadastroLogin extends AppCompatActivity {

    private EditText mEdtCadastroNomeUsuario;
    private EditText mEdtCadastroSenhaUsuario;
    private Button mBtnCadastroUsuario;

    private EditText mEdtLoginNomeUsuario;
    private EditText mEdtLoginSenhaUsuario;
    private Button mBtnLoginUsuario;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastro_login);

        mEdtCadastroNomeUsuario = findViewById(R.id.edtCadastroNomeUsuario);
        mEdtCadastroSenhaUsuario = findViewById(R.id.edtCadastroSenhaUsuario);
        mBtnCadastroUsuario = findViewById(R.id.btnCadastroUsuario);
        mBtnCadastroUsuario.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                ParseUser appUser = new ParseUser();
                appUser.setUsername(mEdtCadastroNomeUsuario.getText().toString());
                appUser.setPassword(mEdtCadastroNomeUsuario.getText().toString());
            }
        });

        mEdtLoginNomeUsuario = findViewById(R.id.edtLoginNomeUsuario);
        mEdtLoginSenhaUsuario = findViewById(R.id.edtLoginSenhaUsuario);
        mBtnLoginUsuario = findViewById(R.id.btnLogarUsuario);
        mBtnLoginUsuario.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
    }
}
