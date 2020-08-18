package com.example.recyclerchallengeapp;

import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;

import java.util.Objects;

public class MainActivity extends AppCompatActivity implements CarAdapter.itemClicked {

    TextView tvName;
    TextView tvTel;
    Button btnOwner,  btnCar;
    ImageView ivMake;
    TextView tvModel;
    String tvMake;
    FragmentManager fragmentManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tvName = findViewById(R.id.tvName);
        tvTel = findViewById(R.id.tvTel);
        btnCar = findViewById(R.id.btnCar);
        btnOwner = findViewById(R.id.btnOwner);
        ivMake = findViewById(R.id.ivMake);
        tvModel = findViewById(R.id.tvModel);
        fragmentManager = this.getSupportFragmentManager();


        btnOwner.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.KITKAT)
            @Override
            public void onClick(View v) {

                fragmentManager.beginTransaction()
                        .show(Objects.requireNonNull(fragmentManager.findFragmentById(R.id.ownerFrag)))
                        .hide(Objects.requireNonNull(fragmentManager.findFragmentById(R.id.makeFrag)))
                        .commit();


            }
        });

        btnCar.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.KITKAT)
            @Override
            public void onClick(View v) {

                fragmentManager.beginTransaction()
                        .hide(Objects.requireNonNull(fragmentManager.findFragmentById(R.id.ownerFrag)))
                        .show(Objects.requireNonNull(fragmentManager.findFragmentById(R.id.makeFrag)))
                        .commit();

            }
        });
        onItemClicked(0);

    }

    @Override
    public void onItemClicked(int index) {
        tvModel.setText(ApplicationClass.vehicle.get(index).getModel());
        tvTel.setText(ApplicationClass.vehicle.get(index).getPhone());
        tvName.setText(ApplicationClass.vehicle.get(index).getOwner());
        tvMake = ApplicationClass.vehicle.get(index).getMake();

        switch (tvMake) {
            case "Volkswagen":
                ivMake.setImageResource(R.drawable.volkswagen);
                break;
            case "Nissan":
                ivMake.setImageResource(R.drawable.nissan);
                break;
            case "Mercedes":
                ivMake.setImageResource(R.drawable.mercedes);
                break;
        }


    }
}