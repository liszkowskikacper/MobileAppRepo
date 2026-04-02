package edu.zsk.spr;

import static android.app.PendingIntent.getActivity;

import static java.lang.Thread.*;
import static java.lang.Thread.sleep;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

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
        Button btn = findViewById(R.id.button);
        btn.setOnClickListener(v -> {

            EditText rawname = findViewById(R.id.editTextText);
            String name = rawname.getText().toString();

            EditText rawsurname = findViewById(R.id.editTextText2);
            String surname = rawsurname.getText().toString();

            EditText rawclass = findViewById(R.id.editTextText3);
            String clas = rawclass.getText().toString();

            if (name.isEmpty() || surname.isEmpty() || clas.isEmpty()) {
                Toast.makeText(this, getString(R.string.toast), Toast.LENGTH_LONG).show();
            }
            else {
                Intent intent = new Intent(this, ReportedActivity.class);
                intent.putExtra("name", name);
                intent.putExtra("surname", surname);
                intent.putExtra("class", clas);

                try {
                    Toast.makeText(this, getString(R.string.makeshift_wait), Toast.LENGTH_LONG).show();
                    rawname.setText("");
                    rawsurname.setText("");
                    rawclass.setText("");
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }

                startActivity(intent);
            }
        });
    }
}