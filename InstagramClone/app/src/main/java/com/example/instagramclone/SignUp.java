package com.example.instagramclone;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.parse.ParseException;
import com.parse.ParseObject;
import com.parse.SaveCallback;
import com.shashank.sony.fancytoastlib.FancyToast;

public class SignUp extends AppCompatActivity implements View.OnClickListener {

    private Button mBtnSalvarObjLutadorMMA;

    private EditText mEdtTxtVelocidadeSocoLutadorMMA;
    private EditText mEdtTxtForcaSocoLutadorMMA;
    private EditText mEdtTxtVelocidadeChuteLutadorMMA;
    private EditText mEdtTxtForcaChuteLutadorMMA;
    private EditText mEdtTxtNomeLutadorMMA;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        mEdtTxtNomeLutadorMMA = findViewById(R.id.edtTxtLutadorMMA);
        mEdtTxtVelocidadeSocoLutadorMMA = findViewById(R.id.edtTxtVelocidadeSoco);
        mEdtTxtForcaSocoLutadorMMA = findViewById(R.id.edtTxtForcaSoco);
        mEdtTxtVelocidadeChuteLutadorMMA = findViewById(R.id.edtTxtVelocidadeChute);
        mEdtTxtForcaChuteLutadorMMA = findViewById(R.id.edtTxtForcaChute);

        mBtnSalvarObjLutadorMMA = findViewById(R.id.btnSalvar);
        mBtnSalvarObjLutadorMMA.setOnClickListener(SignUp.this);
    }

    public void onClick(View view) {
        try {

            final ParseObject lutadorMMA = new ParseObject("LutadorMMA");
            lutadorMMA.put("nome", mEdtTxtNomeLutadorMMA.getText().toString());
            lutadorMMA.put("velocidadeSoco", mEdtTxtVelocidadeSocoLutadorMMA.getText().toString());
            lutadorMMA.put("forcaSoco", mEdtTxtForcaSocoLutadorMMA.getText().toString());
            lutadorMMA.put("velocidadeChute", mEdtTxtVelocidadeChuteLutadorMMA.getText().toString());
            lutadorMMA.put("forcaChute", mEdtTxtForcaChuteLutadorMMA.getText().toString());
            lutadorMMA.saveInBackground(new SaveCallback() {
                @Override
                public void done(ParseException e) {
                    if (e == null) {
                        FancyToast.makeText(SignUp.this, "O objeto LutadorMMA de nome: " +
                                lutadorMMA.get("nome") + " foi salvo como sucesso!", FancyToast.LENGTH_LONG, FancyToast.SUCCESS, true).show();
                    } else {
                        FancyToast.makeText(SignUp.this, "Ocorreu um erro! Ao salvar o objeto de nome: " +
                                lutadorMMA.get("nome"), FancyToast.LENGTH_LONG, FancyToast.ERROR, true).show();
                    }
                }
            });
        }catch(Exception e) {
            FancyToast.makeText(SignUp.this, "Ocorreu um erro! Ao salvar o Objeto!", FancyToast.LENGTH_LONG, FancyToast.ERROR, true).show();
        }
    }
}