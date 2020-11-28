package com.example.instagramclone;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
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
        edtViewLoginSenha.setOnKeyListener(new View.OnKeyListener() {
            @Override
            public boolean onKey(View view, int keyCode, KeyEvent event) {

                if (keyCode == KeyEvent.KEYCODE_ENTER && event.getAction() == KeyEvent.ACTION_DOWN) {
                    onClick(mBtnViewLoginLogar);
                }

                return false;
            }
        });

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
                if (edtViewLoginEmail.getText().toString().equals("") ||
                        edtViewLoginSenha.getText().toString().equals("")) {

                    FancyToast.makeText(ActivityLogin.this, "Email e Senha precisam ser preechidos!"
                            , FancyToast.LENGTH_LONG, FancyToast.INFO, true).show();

                }
                else {
                    ParseUser.logInInBackground(edtViewLoginEmail.getText().toString(), edtViewLoginSenha.getText().toString(), new LogInCallback() {
                        @Override
                        public void done(ParseUser user, ParseException e) {

                            if (e == null && user != null) {
                                FancyToast.makeText(ActivityLogin.this, user.getUsername() +
                                        " , O Login! foi realizado com sucesso!", FancyToast.LENGTH_LONG, FancyToast.SUCCESS, true).show();
                                        rootLayoutPressionado(edtViewLoginEmail);
                            } else {
                                FancyToast.makeText(ActivityLogin.this, "Login falhou!" + e.getMessage(), FancyToast.LENGTH_LONG, FancyToast.ERROR, true).show();
                            }
                        }
                    });
                }
                break;

            case R.id.btnViewLoginCadastrar:

                Intent intent = new Intent(ActivityLogin.this, ActivityCadastro.class);
                startActivity(intent);

                break;

        }
    }

    public void rootLayoutPressionado (View view) {
       try {

           InputMethodManager inputMethodManager = (InputMethodManager) getSystemService(INPUT_METHOD_SERVICE);
           inputMethodManager.hideSoftInputFromWindow(getCurrentFocus().getWindowToken(), 0);
       } catch (Exception e) {
            e.printStackTrace();
       }
    }
}