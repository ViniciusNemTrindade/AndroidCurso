package com.example.instagramclone;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.parse.LogInCallback;
import com.parse.ParseException;
import com.parse.ParseUser;
import com.parse.SignUpCallback;
import com.shashank.sony.fancytoastlib.FancyToast;

public class  ActivityLogin extends AppCompatActivity implements View.OnClickListener {
    //Componentes de UI
    private EditText edtViewLoginEmail,  edtViewLoginSenha;
    private Button mBtnViewLoginCadastrar, mBtnViewLoginLogar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        setTitle("Login");

        edtViewLoginEmail = findViewById(R.id.edtTextEmailLogin);
        edtViewLoginSenha = findViewById(R.id.edtTextSenhaLogin);

        mBtnViewLoginCadastrar = findViewById(R.id.btnViewLoginCadastrar);
        mBtnViewLoginCadastrar.setOnClickListener(this);

        mBtnViewLoginLogar = findViewById(R.id.btnViewLoginLogar);
        mBtnViewLoginLogar.setOnClickListener(this);

        if (ParseUser.getCurrentUser() != null) {
            ParseUser.getCurrentUser().logOut();
        }

    }

    @Override
    public void onClick(View view) {

        switch (view.getId()) {

            case R.id.btnViewLoginLogar:
                ParseUser.logInInBackground(edtViewLoginEmail.getText().toString(), edtViewLoginSenha.getText().toString(), new LogInCallback() {
                    @Override
                    public void done(ParseUser user, ParseException e) {

                        if (e == null && user != null) {
                            FancyToast.makeText(ActivityLogin.this, user.getUsername() +
                                    " , O Login! foi realizado com sucesso!", FancyToast.LENGTH_LONG, FancyToast.SUCCESS, true).show();
                        } else {
                            FancyToast.makeText(ActivityLogin.this, "Login falhou!" + e.getMessage(), FancyToast.LENGTH_LONG, FancyToast.ERROR, true).show();
                        }
                    }
                });
                break;

            case R.id.btnViewLoginCadastrar:
                break;

        }
    }
}