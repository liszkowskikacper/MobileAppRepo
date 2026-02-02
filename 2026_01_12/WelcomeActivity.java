package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class WelcomeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);

        TextView welcomeText = findViewById(R.id.welcomeText);
        TextView emailText = findViewById(R.id.emailText);
        Button logoutBtn = findViewById(R.id.logoutBtn);

        String email = getIntent().getStringExtra("EMAIL");

        welcomeText.setText("Witamy w aplikacji");
        emailText.setText("Zalogowano jako " + email);

        logoutBtn.setOnClickListener(v -> {
            Intent intent = new Intent(WelcomeActivity.this, MainActivity.class);
            startActivity(intent);
            finish();
        });
    }
}
