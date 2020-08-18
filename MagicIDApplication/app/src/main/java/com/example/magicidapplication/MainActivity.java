package com.example.magicidapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    EditText edId;
    Button btSubmit;
    TextView tvResults;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        edId = findViewById(R.id.etID);
        btSubmit = findViewById(R.id.btSubmit);
        tvResults = findViewById(R.id.tvResults);

        tvResults.setVisibility(View.GONE);

        btSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String idNumber = edId.getText().toString().trim();
                String dob = idNumber.substring(0,6);
                int gender = Integer.parseInt(Character.toString(idNumber.charAt(6)));
                String sGender;
                if(gender<5)
                    sGender = getString(R.string.Female);
                else
                    sGender = getString(R.string.Male);
                int nationality = Integer.parseInt(Character.toString(idNumber.charAt(10)));

                String sNationality;
                if(nationality==0)
                    sNationality = getString(R.string.SA);
                else
                    sNationality = getString(R.string.permanentResident);

                String text = (getString(R.string.DOB)+ dob + getString(R.string.new_line) +
                        getString(R.string.gender)+ sGender + getString(R.string.new_line) +
                        getString(R.string.nationality) +sNationality);

                tvResults.setText(text);
                tvResults.setVisibility(View.VISIBLE);



            }
        });
    }





}