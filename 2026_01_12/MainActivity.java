package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

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

        btn.setOnClickListener(view -> {
            String mail = email.getText().toString();
            String pass1 = password1.getText().toString();
            String pass2 = password2.getText().toString();

            message.setTextColor(getResources().getColor(android.R.color.red));

            if (!isEmailValid(mail)) {
                message.setText("Nieprawidłowy adres e-mail");
            } else if (!pass1.equals(pass2)) {
                message.setText("Hasła się różnią");
            } else if (!isPasswordValid(pass1)) {
                message.setText("Hasło musi mieć min. 8 znaków, cyfrę, małą i wielką literę");
            } else {
                Intent intent = new Intent(MainActivity.this, WelcomeActivity.class);
                intent.putExtra("EMAIL", mail);
                startActivity(intent);
            }
        });
    }

    private boolean isEmailValid(String email) {
        return email.matches("^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$");
    }

    private boolean isPasswordValid(String password) {
        return password.matches("^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d).{8,}$");
    }
}
