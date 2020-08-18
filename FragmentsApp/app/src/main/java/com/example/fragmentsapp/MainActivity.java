package com.example.fragmentsapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;

import android.os.Bundle;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements listFrag.ItemSelected {

    TextView tvDescription;
    String [] detail;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tvDescription = findViewById(R.id.tvDescription);

        detail = getResources().getStringArray(R.array.descriptions);

        if(findViewById(R.id.layout_potrait) != null){
            //potrait mode

            FragmentManager manager = this.getSupportFragmentManager();

            manager.beginTransaction()
                    .show(manager.findFragmentById(R.id.fragList))
                    .hide(manager.findFragmentById(R.id.fragDescription))
                    .commit();
        }

        if(findViewById(R.id.layout_land) != null){
            //landscape mode

            FragmentManager manager = this.getSupportFragmentManager();

            manager.beginTransaction()
                    .show(manager.findFragmentById(R.id.fragList))
                    .show(manager.findFragmentById(R.id.fragDescription))
                    .commit();

        }
    }

    @Override
    public void onItemSelected(int index) {
        tvDescription.setText(detail[index]);

        if(findViewById(R.id.layout_potrait) != null){
            //potrait mode

            FragmentManager manager = this.getSupportFragmentManager();

            manager.beginTransaction()
                    .hide(manager.findFragmentById(R.id.fragList))
                    .show(manager.findFragmentById(R.id.fragDescription))
                    .addToBackStack(null)
                    .commit();
        }


    }
}