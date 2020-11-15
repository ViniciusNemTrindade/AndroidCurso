package com.example.instagramclone;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

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

                final ParseUser appUser = new ParseUser();
                appUser.setEmail(edtViewEmailCadastro.getText().toString());
                appUser.setUsername(edtViewUsuarioCadastro.getText().toString());
                appUser.setPassword(edtViewSenhaCadastro.getText().toString());

                appUser.signUpInBackground(new SignUpCallback() {
                    @Override
                    public void done(ParseException e) {
                        if (e == null) {
                            FancyToast.makeText(ActivityCadastro.this, appUser.getUsername() +
                                    " , O cadastrofoi realizado com sucesso!", FancyToast.LENGTH_LONG, FancyToast.SUCCESS, true).show();
                        } else {
                            FancyToast.makeText(ActivityCadastro.this, "Algo deu errado!" +
                                    e.getMessage(), FancyToast.LENGTH_LONG, FancyToast.ERROR, true).show();
                        }
                    }
                });
                break;

            case R.id.btnViewCadastroLogar:

                Intent intent = new Intent(ActivityCadastro.this, ActivityLogin.class);
                startActivity(intent);

                break;

        }
    }
}