package edu.zsk.spr;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class ReportedActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_reported);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        Intent intent = getIntent();

        String iname = intent.getStringExtra("name");
        TextView name = findViewById(R.id.reported_name);
        name.setText(iname);

        String isurname = intent.getStringExtra("surname");
        TextView surname = findViewById(R.id.reported_surname);
        surname.setText(isurname);

        String iclass = intent.getStringExtra("class");
        TextView clas = findViewById(R.id.reported_class);
        clas.setText(iclass);

        Button btn = findViewById(R.id.button);

        btn.setOnClickListener(v -> {
            finish();
        });
    }
}