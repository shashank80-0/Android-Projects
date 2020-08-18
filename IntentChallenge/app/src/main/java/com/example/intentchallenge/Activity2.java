package com.example.intentchallenge;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

public class Activity2 extends AppCompatActivity {

    EditText etName;
    EditText etNumber;
    EditText etWebsite;
    EditText etLocation;
    ImageView imghappy;
    ImageView imgokay;
    ImageView imgsad;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_2);

        etName = findViewById(R.id.etName);
        etNumber = findViewById(R.id.etNumber);
        etWebsite = findViewById(R.id.etWebsite);
        etLocation = findViewById(R.id.etLocation);
        imghappy = findViewById(R.id.imghappy);
        imgokay = findViewById(R.id.imgokay);
        imgsad = findViewById(R.id.imgsad);

        imghappy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                transferData(etName,etNumber,etWebsite,etLocation,1);
            }
        });

        imgokay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                transferData(etName,etNumber,etWebsite,etLocation,2);
            }
        });

        imgsad.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                transferData(etName,etNumber,etWebsite,etLocation,3);
            }
        });
    }

    protected void transferData(EditText etName, EditText etNumber, EditText etWebsite, EditText etLocation, int image){

        if(etName.getText().toString().isEmpty() || etNumber.getText().toString().isEmpty() ||
                etWebsite.getText().toString().isEmpty() || etLocation.getText().toString().isEmpty()){
            Toast.makeText(Activity2.this, "Please Enter all Fields", Toast.LENGTH_SHORT).show();
        }
        else{
            Intent intent = new Intent();
            intent.putExtra("name", etName.getText().toString().trim());
            intent.putExtra("number", etNumber.getText().toString().trim());
            intent.putExtra("website", etWebsite.getText().toString().trim());
            intent.putExtra("location", etLocation.getText().toString().trim());
            intent.putExtra("image", image);
            setResult(RESULT_OK,intent);
            Activity2.this.finish();
        }
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        setResult(RESULT_CANCELED);
        Activity2.this.finish();
    }
}