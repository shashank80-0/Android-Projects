    package com.example.localstrorage;

    import android.annotation.SuppressLint;
    import android.content.SharedPreferences;
    import android.os.Bundle;
    import android.view.View;
    import android.widget.Button;
    import android.widget.EditText;
    import android.widget.TextView;
    import android.widget.Toast;

    import androidx.appcompat.app.AppCompatActivity;

    public class MainActivity extends AppCompatActivity {

    TextView tvWelcome;
    EditText etName;
    Button btnSubmit;
    public static final String MY_PREFS_FILENAME = "package com.example.localstrorage.Names";

    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tvWelcome = findViewById(R.id.tvWelcome);
        etName = findViewById(R.id.etName);
        btnSubmit = findViewById(R.id.btnSubmit);

        SharedPreferences prefs = getSharedPreferences(MY_PREFS_FILENAME,MODE_PRIVATE);
        String user = prefs.getString("user",null);
        if(user!=null){
            tvWelcome.setText("Welcome to my app "+user + " !");

        }





        btnSubmit.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("SetTextI18n")
            @Override
            public void onClick(View v) {

                if(etName.getText().toString().isEmpty()){
                    Toast.makeText(MainActivity.this, "Please enter a name!", Toast.LENGTH_SHORT).show();
                }
                else {


                    String name = etName.getText().toString().trim();
                    tvWelcome.setText("Welcome to my app " + name + " !");

                    SharedPreferences.Editor editor = getSharedPreferences(MY_PREFS_FILENAME, MODE_PRIVATE).edit();
                    editor.putString("user", name);
                    editor.apply();
                }
            }
        });


    }
}