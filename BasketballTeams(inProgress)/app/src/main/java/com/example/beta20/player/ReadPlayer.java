package com.example.beta20.player;

import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

import com.example.beta20.R;
import com.example.beta20.activitys.PlayersActivity2;

public class ReadPlayer extends AppCompatActivity {

    public ReadPlayer() {
        EditText nameEditText = findViewById(R.id.nameEditText);
        EditText experienceEditText = findViewById(R.id.experienceEditText);
        EditText powerEditText = findViewById(R.id.powerEditText);
        EditText ageEditText = findViewById(R.id.ageEditText);
        EditText heightEditText = findViewById(R.id.heightEditText);
        EditText agilityEditText = findViewById(R.id.agilityEditText);

        String name = nameEditText.getText().toString();
        int agility = Integer.parseInt(agilityEditText.getText().toString());
        int experience = Integer.parseInt(experienceEditText.getText().toString());
        int power = Integer.parseInt(powerEditText.getText().toString());
        int age = Integer.parseInt(ageEditText.getText().toString());
        int height = Integer.parseInt(heightEditText.getText().toString());

    }
}
