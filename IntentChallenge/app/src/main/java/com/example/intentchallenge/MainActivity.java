package com.example.intentchallenge;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    Button btnNewContact;
    TextView tvMain;
    ImageView imgFace;
    ImageView imgPhone;
    ImageView imgWeb;
    ImageView imgLocation;
    LinearLayout imageLayout;
    final int Activity2 = 2;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnNewContact = findViewById(R.id.btnNewContact);
        tvMain = findViewById(R.id.tvMain);
        imgFace = findViewById(R.id.imgFace);
        imgPhone = findViewById(R.id.imgPhone);
        imgWeb = findViewById(R.id.imgWeb);
        imgLocation = findViewById(R.id.imgLocation);
        imageLayout = findViewById(R.id.imageLayout);

        imageLayout.setVisibility(View.GONE);


        btnNewContact.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,com.example.intentchallenge.Activity2.class);
                startActivityForResult(intent,Activity2);


            }
        });

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if(requestCode == Activity2){
            if(resultCode == RESULT_OK){

                final String name = data.getStringExtra("name");
                final String number = data.getStringExtra("number");
                final String website = data.getStringExtra("website");
                final String location = data.getStringExtra("location");
                final int image = data.getIntExtra("image",0);

                if(image == 1){
                    imgFace.setImageResource(R.drawable.happy);
                }
                else if(image == 2){
                    imgFace.setImageResource(R.drawable.okay);
                }
                else if(image == 3){
                    imgFace.setImageResource(R.drawable.sad);
                }

                imageLayout.setVisibility(View.VISIBLE);

                imgPhone.setOnClickListener((new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:"+number));
                        startActivity(intent);
                    }
                }));

                imgLocation.setOnClickListener((new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("geo:0,0?q="+location));
                        startActivity(intent);
                    }
                }));

                imgWeb.setOnClickListener((new View.OnClickListener() {

                    @Override
                    public void onClick(View v) {
                        Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://"+website));
                        startActivity(intent);
                    }
                }));
            }

            if(resultCode == RESULT_CANCELED){

                imageLayout.setVisibility(View.GONE);

            }
        }

    }
}