package com.example.recyclerviewproject;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements PersonAdapter.ItemClicked {

    RecyclerView recyclerView;
    RecyclerView.Adapter myAdapter;
    RecyclerView.LayoutManager layoutManager;

    ArrayList<Person> people;

    Button btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn = findViewById(R.id.add);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                people.add(new Person("Stanley", "Hudson", "bus"));
                myAdapter.notifyDataSetChanged();
            }
        });

        recyclerView = findViewById(R.id.list);
        recyclerView.setHasFixedSize(true);

        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);

        people = new ArrayList<Person>();
        people.add(new Person("Jim", "Halpert", "bus"));
        people.add(new Person("Michael", "Scott", "flight"));
        people.add(new Person("Dwight", "Schrute", "bus"));
        people.add(new Person("Pam", "Beesly", "flight"));
        people.add(new Person("Oscar", "Martinez", "bus"));
        people.add(new Person("Andy", "Bernard", "flight"));
        people.add(new Person("Kevin", "Malone", "bus"));
        people.add(new Person("Creed","Bratton", "flight"));
        people.add(new Person("Ryan", "Howard", "bus"));
        people.add(new Person("Kelly", "Kapoor", "flight"));
        people.add(new Person("Angela", "Martin", "bus"));
        people.add(new Person("Toby", "Flenderson", "flight"));

        myAdapter = new PersonAdapter(this, people);

        recyclerView.setAdapter(myAdapter);

    }

    @Override
    public void onItemClicked(int index) {

        Toast.makeText(this, "Surname: "+ people.get(index).getSurname(), Toast.LENGTH_SHORT).show();

    }
}