package com.example.splapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.SQLException;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText etName;
    EditText etPhone;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etName = findViewById(R.id.etName);
        etPhone = findViewById(R.id.etPhone);

    }

    public void btnSubmit(View v){

        String name = etName.getText().toString().trim();
        String cell = etPhone.getText().toString().trim();

        try {
            ContactsDB db = new ContactsDB(this);
            db.open();
            db.createEntry(name,cell);
            db.close();
            Toast.makeText(this, "Successfully saved!", Toast.LENGTH_SHORT).show();
            etName.setText(null);
            etPhone.setText(null);
        }
        catch (SQLException e){
            Toast.makeText(this, e.getMessage(), Toast.LENGTH_SHORT).show();
        }
    }

    public void btnShowData(View v){
        startActivity(new Intent(this, Data.class));
    }

    public void btnEditData(View v) {

        String name = etName.getText().toString().trim();
        String cell = etPhone.getText().toString().trim();

        try {
            ContactsDB db = new ContactsDB(this);
            db.open();
            db.updateEntry("1", name, cell);
            db.close();
            Toast.makeText(this, "Successfully updated!", Toast.LENGTH_SHORT).show();
        }
        catch (SQLException e){
            Toast.makeText(this, e.getMessage(), Toast.LENGTH_SHORT).show();
        }

    }

    public void btnDeleteData(View v){

        try {
            ContactsDB db = new ContactsDB(this);
            db.open();
            db.deleteEntry("1");
            db.close();
            Toast.makeText(this, "Successfully deleted!", Toast.LENGTH_SHORT).show();
        }
        catch (SQLException e){
            Toast.makeText(this, e.getMessage(), Toast.LENGTH_SHORT).show();
        }
    }
}