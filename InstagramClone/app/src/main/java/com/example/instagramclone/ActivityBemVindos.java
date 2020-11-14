package com.example.instagramclone;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class ActivityBemVindos extends AppCompatActivity {

    private TextView mTxtBemVindoView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bem_vindos);

        mTxtBemVindoView = findViewById(R.id.txtBemVindoView);
        mTxtBemVindoView.setText("Bem-Vindos!");
    }

}