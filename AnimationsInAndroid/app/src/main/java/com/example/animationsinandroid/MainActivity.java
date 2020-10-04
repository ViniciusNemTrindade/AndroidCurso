package com.example.animationsinandroid;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private TextView txtHelloWorld;
    private TextView txtHiWorld;
    private TextView txtAndroid;
    private Button btnAnimate;

    private boolean isHelloWorldShowing;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



        txtHelloWorld = findViewById(R.id.txtHelloWorld);
        txtHiWorld = findViewById(R.id.txtHioWorld);
        txtAndroid = findViewById(R.id.txtAndroid);
        btnAnimate = findViewById(R.id.btnAnimate);

        txtHelloWorld.setX(2000);
        txtHiWorld.setX(-2000);
        txtAndroid.setY(-3000);

        txtHelloWorld.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                if (isHelloWorldShowing) {

                    txtHelloWorld.animate().alpha(0).setDuration(3000);
                    txtHiWorld.animate().alpha(1).setDuration(3000);
                    isHelloWorldShowing = false;
                } else if (!isHelloWorldShowing) {
                    txtHelloWorld.animate().alpha(1).setDuration(3000);
                    txtHiWorld.animate().alpha(0).setDuration(3000);

                    isHelloWorldShowing = true;
                }


            }
        });

        txtAndroid.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                txtAndroid.animate().scaleY(0.2f).setDuration(3000);
            }
        });

        btnAnimate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                txtHelloWorld.animate().translationXBy(-2000).rotation(2000).setDuration(3000);
                txtHiWorld.animate().translationXBy(2000).scaleX(200).setDuration(2000);
                txtAndroid.animate().translationYBy(3000).alpha(0.7f).setDuration(4000);
            }
        });

    }
}
