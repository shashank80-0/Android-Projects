package com.example.floatinghint;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;

public class MainActivity extends AppCompatActivity {

    AutoCompleteTextView etFirstName, etLastName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etFirstName = findViewById(R.id.etFirstName);
        etLastName = findViewById(R.id.etLastName);

        String[] firstNames = {"Jim", "Michael", "Dwight", "Angela", "Pam", "Toby"};
        String[] lastNames = {"Halpert", "Scott", "Schrutt", "Martin", "Beasly", "Flenderson"};
        ArrayAdapter<String> firstNameAdapter = new ArrayAdapter<>(this, android.R.layout.simple_dropdown_item_1line, firstNames);
        ArrayAdapter<String> lastNameAdapter = new ArrayAdapter<>(this, R.layout.last_name_layout, lastNames);
        etFirstName.setThreshold(1);
        etFirstName.setAdapter(firstNameAdapter);
        etLastName.setThreshold(1);
        etLastName.setAdapter(lastNameAdapter);

    }
}