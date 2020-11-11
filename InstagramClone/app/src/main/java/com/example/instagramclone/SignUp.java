package com.example.instagramclone;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.parse.ParseException;
import com.parse.ParseObject;
import com.parse.SaveCallback;

public class SignUp extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);
    }

    public void  helloWorldPressionado(View view) {
//
//        ParseObject boxer = new ParseObject("Boxer");
//        boxer.put("velocidade_soco", 200);
//        boxer.saveInBackground(new SaveCallback() {
//            @Override
//            public void done(ParseException e) {
//                if (e == null) {
//                    Toast.makeText(SignUp.this, "Objeto boxer salvo com Sucesso!", Toast.LENGTH_LONG).show();
//                }
//            }
//        });

        ParseObject kickboxer = new ParseObject("Kicboxer");
        kickboxer.put("nome", "Joaquim");
        kickboxer.put("velociadade do soco", 500);
        kickboxer.put("velocidade do chute", 800);
        kickboxer.saveInBackground(new SaveCallback() {
            @Override
            public void done(ParseException e) {
                if (e != null) {
                    Toast.makeText(SignUp.this, " objeto kickboxer " + kickboxer.get("nome") + ", salvo sucesso no Server!", Toast.LENGTH_LONG).show();
                }
            }
        });

    }
}