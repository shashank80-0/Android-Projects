package com.example.textfiles;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class MainActivity extends AppCompatActivity {

    EditText etFirstName, etLastName;
    //Button btnAdd, btnSave;
    TextView tvResults;
    ArrayList<Person> persons;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etFirstName = findViewById(R.id.etFirstName);
        etLastName = findViewById(R.id.etLastName);
        //btnAdd = findViewById(R.id.btnAdd);
        //btnSave = findViewById(R.id.btnSave);
        tvResults = findViewById(R.id.tvResults);

        persons = new ArrayList<>();
        try {
            loadData();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void btnAddData(View v){

        String firstName = etFirstName.getText().toString();
        String lastName = etLastName.getText().toString();

        Person person = new Person(firstName,lastName);
        persons.add(person);
        
        setTexttoTextView();
    }

    private void setTexttoTextView() {

        StringBuilder text  = new StringBuilder();

        for(int i=0 ;i<persons.size(); i++)
            text.append(persons.get(i).getFirstName()).append(" ").append(persons.get(i).getLastName()).append("\n");
        tvResults.setText(text.toString());
    }


    public void loadData() throws IOException {
        persons.clear();
        File file = getApplicationContext().getFileStreamPath("Data.txt");
        String lineFromFile;

        if(file.exists())
        {
            try{
                BufferedReader reader = new BufferedReader(new InputStreamReader(openFileInput("Data.txt")));
                while((lineFromFile = reader.readLine()) != null){
                    StringTokenizer tokens = new StringTokenizer(lineFromFile,",");
                    Person person = new Person(tokens.nextToken(),tokens.nextToken());
                    persons.add(person);
                }

                reader.close();
                setTexttoTextView();

            }
            catch (IOException e){
                Toast.makeText(this, e.getMessage(), Toast.LENGTH_SHORT).show();
            }
        }
    }

    public void btnSaveData(View v){

        try{

            FileOutputStream file = openFileOutput("Data.txt", MODE_PRIVATE);
            OutputStreamWriter outputFile = new OutputStreamWriter(file);

            for(int i=0; i<persons.size(); i++){
                outputFile.write(persons.get(i).getFirstName() + "," + persons.get(i).getLastName() + "\n");
            }
            outputFile.flush();
            outputFile.close();
            Toast.makeText(this, "Successfully saved!", Toast.LENGTH_SHORT).show();
        }
        catch (IOException e){

            Toast.makeText(this, e.getMessage(), Toast.LENGTH_SHORT).show();

        }

    }


}