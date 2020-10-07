package com.example.animationsinandroid;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private TextView txtOlaMundo;
    private TextView txtEaiMundo;
    private TextView txtAndroid;
    private Button btnAnimado;

    private boolean estaMostrandoOlaMundo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



        txtOlaMundo = findViewById(R.id.txtOlaMundo);
        txtEaiMundo = findViewById(R.id.txtEaiMundo);
        txtAndroid = findViewById(R.id.txtAndroid);
        btnAnimado = findViewById(R.id.btnAnimado);

        txtOlaMundo.setX(2000);
        txtEaiMundo.setX(-2000);
        txtAndroid.setY(-3000);

        txtOlaMundo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                if (estaMostrandoOlaMundo) {

                    txtOlaMundo.animate().alpha(0).setDuration(3000);
                    txtEaiMundo.animate().alpha(1).setDuration(3000);
                    estaMostrandoOlaMundo = false;
                } else if (!estaMostrandoOlaMundo) {
                    txtOlaMundo.animate().alpha(1).setDuration(3000);
                    txtEaiMundo.animate().alpha(0).setDuration(3000);

                    estaMostrandoOlaMundo = true;
                }


            }
        });

        txtAndroid.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                txtAndroid.animate().scaleY(0.2f).setDuration(3000);
            }
        });

        btnAnimado.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                txtOlaMundo.animate().translationXBy(-2000).rotation(2000).setDuration(3000);
                txtEaiMundo.animate().translationXBy(2000).scaleX(200).setDuration(2000);
                txtAndroid.animate().translationYBy(3000).alpha(0.7f).setDuration(4000);
            }
        });

    }
}
