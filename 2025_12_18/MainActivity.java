package com.example.myapplication;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.view.View;


import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        TextView message = findViewById(R.id.message);
        message.setText("Autor 12345678901");

        EditText email = findViewById(R.id.email);
        EditText password1 = findViewById(R.id.password1);
        EditText password2 = findViewById(R.id.password2);
        Button btn = findViewById(R.id.btn);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String mail = email.getText().toString();
                String password = password1.getText().toString();
                String passwordRepeat = password2.getText().toString();

                if (!mail.contains("@")) {
                    message.setText("Nieprawidłowy adres e-mail");
                } else if (!password.equals(passwordRepeat)) {
                    message.setText("Hasła się różnią");
                } else {
                    message.setText("Witaj " + mail);
                }
            }
        });


    }



}