package com.example.instagramclone;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;

import com.parse.ParseException;
import com.parse.ParseUser;
import com.parse.SignUpCallback;
import com.shashank.sony.fancytoastlib.FancyToast;

public class ActivityCadastro extends AppCompatActivity implements View.OnClickListener {

    //Componentes de UI
    private EditText edtViewEmailCadastro, edtViewUsuarioCadastro, edtViewSenhaCadastro;
    private Button btnViewCadastrar, btnViewLogin;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastro);

        setTitle("Cadastro");

        edtViewEmailCadastro = findViewById(R.id.edtTextEmailCadastro);
        edtViewUsuarioCadastro = findViewById(R.id.edtTextUsuarioCadastro);
        edtViewSenhaCadastro = findViewById(R.id.edtTextSenhaCadastro);
        edtViewSenhaCadastro.setOnKeyListener(new View.OnKeyListener() {
            @Override
            public boolean onKey(View view, int keyCode, KeyEvent event) {

                if (keyCode == KeyEvent.KEYCODE_ENTER && event.getAction() == KeyEvent.ACTION_DOWN) {

                    onClick(btnViewCadastrar);
                }

                return false;
            }
        });

        btnViewCadastrar = findViewById(R.id.btnViewCadastroCadastrar);
        btnViewCadastrar.setOnClickListener(this);

        btnViewLogin = findViewById(R.id.btnViewCadastroLogar);
        btnViewLogin.setOnClickListener(this);

        if (ParseUser.getCurrentUser() != null) {
            ParseUser.getCurrentUser().logOut();
        }
    }

    @Override
    public void onClick(View view) {

        switch (view.getId()) {

            case R.id.btnViewCadastroCadastrar:
                if (edtViewEmailCadastro.getText().toString().equals("") ||
                        edtViewUsuarioCadastro.getText().toString().equals("") ||
                        edtViewSenhaCadastro.getText().toString().equals("")) {

                    FancyToast.makeText(ActivityCadastro.this, "Email, Usuario e Senha precisam ser preechidos!"
                            , FancyToast.LENGTH_LONG, FancyToast.INFO, true).show();

                } else {
                    final ParseUser appUser = new ParseUser();
                    appUser.setEmail(edtViewEmailCadastro.getText().toString());
                    appUser.setUsername(edtViewUsuarioCadastro.getText().toString());
                    appUser.setPassword(edtViewSenhaCadastro.getText().toString());

                    ProgressDialog progressDialog = new ProgressDialog(this);
                    progressDialog.setMessage("Cadastrando usuaário: " + edtViewUsuarioCadastro.getText().toString());
                    progressDialog.show();
                    appUser.signUpInBackground(new SignUpCallback() {
                        @Override
                        public void done(ParseException e) {
                            if (e == null) {
                                FancyToast.makeText(ActivityCadastro.this, appUser.getUsername() +
                                        " , O cadastrofoi realizado com sucesso!", FancyToast.LENGTH_LONG, FancyToast.SUCCESS, true).show();
                                    rootLayoutPressionado(edtViewUsuarioCadastro);
                            } else {
                                FancyToast.makeText(ActivityCadastro.this, "Algo deu errado!" +
                                        e.getMessage(), FancyToast.LENGTH_LONG, FancyToast.ERROR, true).show();
                            }

                            progressDialog.dismiss();
                        }
                    });
                }
                break;

            case R.id.btnViewCadastroLogar:

                Intent intent = new Intent(ActivityCadastro.this, ActivityLogin.class);
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