package com.example.tiktactoe;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class MainLogin extends AppCompatActivity {
    TextView online, offline, ai;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_login);
        getSupportActionBar().hide();

        online = findViewById(R.id.loginOnPvp);
        offline = findViewById(R.id.loginOffPvp);
        ai = findViewById(R.id.loginAi);

        online.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainLogin.this, "Coming Soon", Toast.LENGTH_SHORT).show();
            }
        });
        ai.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainLogin.this, "Coming Soon", Toast.LENGTH_SHORT).show();
            }
        });
        offline.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(v.getContext(), MainActivity.class);
                startActivity(intent);
            }
        });
    }
}