package com.example.a45pobranieczasu;

import android.annotation.SuppressLint;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.TimePicker;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    TimePicker czas;
    TextView textView1;
    TimePicker timePicker2;
    TextView textWiev2;
    SharedPreferences sharedPreferences;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        textView1=findViewById(R.id.text1);
        czas=findViewById(R.id.zegar1);
        czas.setIs24HourView(true);

        timePicker2 = findViewById(R.id.timePicker);
        textWiev2 = findViewById(R.id.text2);

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }
    public void Pobierz (View view)
    {
        int hour, minute;
        hour=czas.getHour();
        minute=czas.getMinute();textView1.setText("Wybrana godzina "+hour +":"+minute);
    }
    public void Odczytaj(View view) {
        int hour = sharedPreferences.getInt("hour", 0);
        int minute = sharedPreferences.getInt("minute", 0);

        textWiev2.setText("Odczytana godzina: " + hour + ":" + minute);
    }

    public void Zapisz(View view) {
        int hour = timePicker2.getHour();
        int minute = timePicker2.getMinute();
        textView1.setText("Wybrana godzina: " + hour + ":" + minute);
    }

}