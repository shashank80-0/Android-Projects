package com.example.fragmentsrecycler;

import android.app.Application;
import android.speech.SpeechRecognizer;

import java.util.ArrayList;

public class ApplicationClass extends Application {

    public static ArrayList<Person> people;

    @Override
    public void onCreate() {
        super.onCreate();

        people = new ArrayList<Person>();
        people.add(new Person("Michael Scott","9634107618"));
        people.add(new Person("Jim Halpert","9837543813"));

    }
}
