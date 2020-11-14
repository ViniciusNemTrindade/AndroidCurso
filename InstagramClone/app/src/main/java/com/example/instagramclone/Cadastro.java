package com.example.instagramclone;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.parse.FindCallback;
import com.parse.GetCallback;
import com.parse.ParseException;
import com.parse.ParseObject;
import com.parse.ParseQuery;
import com.parse.SaveCallback;
import com.shashank.sony.fancytoastlib.FancyToast;

import java.util.List;

public class Cadastro extends AppCompatActivity implements View.OnClickListener {

    private Button mBtnSalvarObjLutadorMMA;

    private EditText mEdtTxtVelocidadeSocoLutadorMMA;
    private EditText mEdtTxtForcaSocoLutadorMMA;
    private EditText mEdtTxtVelocidadeChuteLutadorMMA;
    private EditText mEdtTxtForcaChuteLutadorMMA;
    private EditText mEdtTxtNomeLutadorMMA;
    private TextView mTxtObterDados;
    private Button mBtnTodosDadosLutador;
    private String mTodosLutadoresMMA;
    private Button mBtnTrocarActivity;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.cadastro);

        mEdtTxtNomeLutadorMMA = findViewById(R.id.edtTxtLutadorMMA);
        mEdtTxtVelocidadeSocoLutadorMMA = findViewById(R.id.edtTxtVelocidadeSoco);
        mEdtTxtForcaSocoLutadorMMA = findViewById(R.id.edtTxtForcaSoco);
        mEdtTxtVelocidadeChuteLutadorMMA = findViewById(R.id.edtTxtVelocidadeChute);
        mEdtTxtForcaChuteLutadorMMA = findViewById(R.id.edtTxtForcaChute);

        mBtnTrocarActivity = findViewById(R.id.btnTrocarActivity);

        mTxtObterDados = findViewById(R.id.txtObterDados);
        mTxtObterDados.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                mTodosLutadoresMMA = "";
                ParseQuery<ParseObject> parseQuery = ParseQuery.getQuery("LutadorMMA");
                parseQuery.getInBackground("Ga6rS33sNI", new GetCallback<ParseObject>() {
                    @Override
                    public void done(ParseObject object, ParseException e) {
                        if (object != null && e == null) {

                            mTxtObterDados.setText(object.get("nome") + " - " + "Força do soco: " + object.get("forcaSoco") + " Velocidade do soco: "
                                    + object.get("velocidadeSoco") + " Força do chute: " +  object.get("forcaChute") + " Velocidade do chute: " + object.get("velocidadeChute") );
                        }
                    }

                });
            }
        });

        mBtnTodosDadosLutador = findViewById(R.id.btnTodosDadosLutador);
        mBtnTodosDadosLutador.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                ParseQuery<ParseObject> todasQuery = ParseQuery.getQuery("LutadorMMA");

//                todasQuery.whereStartsWith("nome", "A");
                todasQuery.setLimit(3);

                todasQuery.findInBackground(new FindCallback<ParseObject>() {
                    @Override
                    public void done(List<ParseObject> objects, ParseException e) {
                        if (e == null) {
                            if (objects.size() > 1) {

                                for (ParseObject lutadroMMA : objects) {
                                    mTodosLutadoresMMA = mTodosLutadoresMMA + lutadroMMA.get("nome") + "\n";
                                }
                                FancyToast.makeText(Cadastro.this, mTodosLutadoresMMA, FancyToast.LENGTH_LONG, FancyToast.SUCCESS, true).show();

                            } else {
                                FancyToast.makeText(Cadastro.this, "Ocorreu um erro! Ao salvar o objeto de nome: " , FancyToast.LENGTH_LONG, FancyToast.ERROR, true).show();
                            }
                        }
                    }
                });
            }
        });


        mBtnSalvarObjLutadorMMA = findViewById(R.id.btnSalvar);
        mBtnSalvarObjLutadorMMA.setOnClickListener(Cadastro.this);


        mBtnTrocarActivity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(Cadastro.this, ActivityCadastroLogin.class);
                startActivity(intent);
            }
        });


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
                        FancyToast.makeText(Cadastro.this, "O objeto LutadorMMA de nome: " +
                                lutadorMMA.get("nome") + " foi salvo como sucesso!", FancyToast.LENGTH_LONG, FancyToast.SUCCESS, true).show();
                    } else {
                        FancyToast.makeText(Cadastro.this, "Ocorreu um erro! Ao salvar o objeto de nome: " +
                                lutadorMMA.get("nome"), FancyToast.LENGTH_LONG, FancyToast.ERROR, true).show();
                    }
                }
            });
        } catch (Exception e) {
            FancyToast.makeText(Cadastro.this, "Ocorreu um erro! Ao salvar o Objeto!", FancyToast.LENGTH_LONG, FancyToast.ERROR, true).show();
        }
    }
}