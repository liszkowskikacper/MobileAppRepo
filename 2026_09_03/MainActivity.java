package com.example.grakosci;

import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    private static final int LICZBA_KOSTEK = 5;

    private ImageView[] diceImages;
    private TextView tvRollResult;
    private TextView tvGameResult;
    private final int[] diceDrawables = {
            R.drawable.k1,
            R.drawable.k2,
            R.drawable.k3,
            R.drawable.k4,
            R.drawable.k5,
            R.drawable.k6
    };

    private int gameScore = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        diceImages = new ImageView[]{
                findViewById(R.id.imgDice1),
                findViewById(R.id.imgDice2),
                findViewById(R.id.imgDice3),
                findViewById(R.id.imgDice4),
                findViewById(R.id.imgDice5)
        };

        tvRollResult = findViewById(R.id.tvRollResult);
        tvGameResult = findViewById(R.id.tvGameResult);

        Button btnRoll = findViewById(R.id.btnRoll);
        Button btnReset = findViewById(R.id.btnReset);

        btnRoll.setOnClickListener(v -> {
            int[] wyniki = rollDice(LICZBA_KOSTEK);
            wyswietlKostki(wyniki);

            int punkty = calculatePoints(wyniki);
            tvRollResult.setText("Wynik tego losowania: " + punkty);

            gameScore += punkty;
            tvGameResult.setText("Wynik gry: " + gameScore);
        });

        btnReset.setOnClickListener(v -> resetGry());
    }
    private int[] rollDice(int liczbaKostek) {
        Random random = new Random();
        int[] wyniki = new int[liczbaKostek];
        for (int i = 0; i < liczbaKostek; i++) {
            wyniki[i] = random.nextInt(6) + 1;
        }
        return wyniki;
    }
    private int calculatePoints(int[] wyniki) {
        int[] licznikWystapien = new int[7];
        for (int wartosc : wyniki) {
            licznikWystapien[wartosc]++;
        }

        int suma = 0;
        for (int oczko = 1; oczko <= 6; oczko++) {
            if (licznikWystapien[oczko] >= 2) {
                suma += oczko * licznikWystapien[oczko];
            }
        }
        return suma;
    }

    private void wyswietlKostki(int[] wyniki) {
        for (int i = 0; i < diceImages.length; i++) {
            int wartosc = wyniki[i];
            diceImages[i].setImageResource(diceDrawables[wartosc - 1]);
        }
    }

    private void resetGry() {
        for (ImageView img : diceImages) {
            img.setImageResource(R.drawable.question);
        }
        gameScore = 0;
        tvRollResult.setText("Wynik tego losowania: 0");
        tvGameResult.setText("Wynik gry: 0");
    }
}
