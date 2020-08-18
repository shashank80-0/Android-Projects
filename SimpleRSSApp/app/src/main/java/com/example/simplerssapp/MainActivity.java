package com.example.simplerssapp;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.app.ProgressDialog;
import android.content.Intent;
import android.net.Uri;
import android.nfc.Tag;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
import org.xmlpull.v1.XmlPullParserFactory;

import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URL;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ListView lvRss;
    ArrayList<String> titles;
    ArrayList<String> links;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        lvRss = findViewById(R.id.lvRss);
        titles = new ArrayList<>();
        links = new ArrayList<>();
        lvRss.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Uri uri = Uri.parse(links.get(position));
                Intent intent = new Intent(Intent.ACTION_VIEW,uri);
                startActivity(intent);

            }
        });
        new ProcessInBackground().execute();
    }

    public InputStream getInputStream(URL url){

        try{
            return url.openConnection().getInputStream();
        }
        catch (IOException e){
            Log.e("LOOK HERE - 1 ", "This is the error");
            return  null;
        }
    }

    @SuppressLint("StaticFieldLeak")
    public class ProcessInBackground extends AsyncTask<Void,Void,Exception>{

        ProgressDialog progressDialog = new ProgressDialog(MainActivity.this);


        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            progressDialog.setMessage("Busy loading rss feed! Please wait..");
            progressDialog.show();
        }

        @Override
        protected Exception doInBackground(Void... voids) {

            Exception exception = null;

            try {
                URL url = new URL("http://feeds.news24.com/articles/fin24/tech/rss");

                XmlPullParserFactory factory = XmlPullParserFactory.newInstance();

                factory.setNamespaceAware(false);

                XmlPullParser xpp = factory.newPullParser();

                xpp.setInput(getInputStream(url),"UTF_8");

                boolean insideItem = false;

                int eventType = xpp.getEventType();

                while(eventType != XmlPullParser.END_DOCUMENT){

                    if(eventType == XmlPullParser.START_TAG){
                        if (xpp.getName().equalsIgnoreCase("item")){
                            insideItem = true;
                        }
                        else if (xpp.getName().equalsIgnoreCase("title")){
                            if(insideItem){
                                titles.add(xpp.nextText());
                            }
                        }
                        else if(xpp.getName().equalsIgnoreCase("link")){
                            if (insideItem){
                                links.add(xpp.nextText());
                            }
                        }
                    }
                    else if(eventType == XmlPullParser.END_TAG && xpp.getName().equalsIgnoreCase("item")){
                        insideItem = false;
                    }

                    eventType = xpp.next();
                }

            }
            catch (MalformedURLException e){
                exception = e;
                Log.e("LOOK HERE - 2 ", "This is the error");
                            }
            catch (XmlPullParserException e){
                exception = e;
                Log.e("LOOK HERE - 3 ", "This is the error");
                           }
            catch (IOException e){
                exception = e;
                Log.e("LOOK HERE - 4 ", "This is the error");
                         }
            return exception;
        }

        @Override
        protected void onPostExecute(Exception s) {
            super.onPostExecute(s);
            ArrayAdapter<String> adapter = new ArrayAdapter<>(MainActivity.this,android.R.layout.simple_list_item_1,titles);
            lvRss.setAdapter(adapter);
            progressDialog.dismiss();


        }
    }

}