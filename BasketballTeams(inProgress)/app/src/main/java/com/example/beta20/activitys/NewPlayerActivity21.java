package com.example.beta20.activitys;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.beta20.R;
import com.example.beta20.player.ReadPlayer;

public class NewPlayerActivity21 extends AppCompatActivity {
    private static final String TAG = "NewPlayerActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_player);

        final Button addButton = (Button) findViewById(R.id.addBtn);
        final Button giveUpButton = (Button) findViewById(R.id.giveUpBtn);

        giveUpButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent6 = new Intent(NewPlayerActivity21.this, PlayersActivity2.class);
                startActivity(intent6);
            }
        });

        addButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new ReadPlayer();
                Intent intent7 = new Intent(NewPlayerActivity21.this, PlayersActivity2.class);
                startActivity(intent7);
            }
        });
    }
}