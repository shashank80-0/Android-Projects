package com.example.temperaturecricket;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.text.DecimalFormat;

public class MainActivity extends AppCompatActivity {

    EditText etChirps;
    Button btCalculate;
    TextView tvResult;
    DecimalFormat formatter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etChirps = findViewById(R.id.etChirps);
        btCalculate = findViewById(R.id.btCalculate);
        tvResult = findViewById(R.id.tvResult);
        formatter = new DecimalFormat("#0.00");

        tvResult.setVisibility(View.INVISIBLE);

        btCalculate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(etChirps.getText().toString().isEmpty()){
                    Toast.makeText(MainActivity.this, "Please Enter a number", Toast.LENGTH_SHORT).show();
                }
                else {
                    int chirps = Integer.parseInt(etChirps.getText().toString().trim());
                    double temperature = (chirps / 3) + 4;

                    String text = getString(R.string.part1) + " " + formatter.format(temperature) + getString(R.string.part2);
                    tvResult.setText(text);
                    tvResult.setVisibility(View.VISIBLE);
                }
            }
        });
    }
}