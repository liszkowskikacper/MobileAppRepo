package com.example.vetapp;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.TimePicker;

public class MainActivity extends AppCompatActivity {

    String selectedSpecies = "Pies";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        EditText ownerName = findViewById(R.id.ownerName);
        EditText visitPurpose = findViewById(R.id.visitPurpose);
        ListView speciesList = findViewById(R.id.speciesList);
        SeekBar ageSeek = findViewById(R.id.ageSeek);
        TextView ageValue = findViewById(R.id.ageValue);
        TimePicker timePicker = findViewById(R.id.timePicker);
        Button okButton = findViewById(R.id.okButton);
        TextView resultText = findViewById(R.id.resultText);

        String[] species = {"Pies", "Kot", "Świnka morska"};
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this,
                android.R.layout.simple_list_item_1, species);
        speciesList.setAdapter(adapter);
        speciesList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                selectedSpecies = species[position];

                switch (selectedSpecies) {
                    case "Pies":
                        ageSeek.setMax(18);
                        break;
                    case "Kot":
                        ageSeek.setMax(20);
                        break;
                    case "Świnka morska":
                        ageSeek.setMax(9);
                        break;
                }
            }
        });

        ageSeek.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                ageValue.setText(String.valueOf(progress));
            }

            @Override public void onStartTrackingTouch(SeekBar seekBar) {}
            @Override public void onStopTrackingTouch(SeekBar seekBar) {}
        });

        okButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                int hour = timePicker.getHour();
                int minute = timePicker.getMinute();

                String timeFormatted = String.format("%02d:%02d", hour, minute);

                String result = ownerName.getText().toString() + ", "
                        + selectedSpecies + ", "
                        + ageValue.getText().toString() + ", "
                        + visitPurpose.getText().toString() + ", "
                        + timeFormatted;

                resultText.setText(result);
            }
        });
    }
}
