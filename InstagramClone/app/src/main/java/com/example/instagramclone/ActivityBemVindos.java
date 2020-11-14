package com.example.instagramclone;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.parse.ParseUser;

public class ActivityBemVindos extends AppCompatActivity {

    private TextView mTxtBemVindoView;
    private Button mBtnLogout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bem_vindos);

        mTxtBemVindoView = findViewById(R.id.txtBemVindoView);
        mTxtBemVindoView.setText("Bem-Vindos! "+ ParseUser.getCurrentUser().get("username"));


        mBtnLogout = findViewById(R.id.btnLogout);
        mBtnLogout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ParseUser.logOut();
                finish();
            }
        });
    }

}