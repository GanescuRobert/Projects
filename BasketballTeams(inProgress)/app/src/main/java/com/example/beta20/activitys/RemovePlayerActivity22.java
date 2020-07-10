package com.example.beta20.activitys;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.beta20.R;
import com.example.beta20.player.RemovePlayer;

public class RemovePlayerActivity22 extends AppCompatActivity {
    private static final String TAG = "RemovePlayerActivity22";
    private static Context mContext;
    public static boolean Remove =false;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_remove_player);

        mContext = this;
        final Button removePlayerButton = (Button) findViewById(R.id.removePlayerButton);
        final Button giveUpButton = (Button) findViewById(R.id.giveUpBtn);

        giveUpButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent8 = new Intent(RemovePlayerActivity22.this, PlayersActivity2.class);
                startActivity(intent8);
            }
        });

        removePlayerButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                new RemovePlayer(mContext);
                if (Remove==true) {
                    Intent intent9 = new Intent(RemovePlayerActivity22.this, PlayersActivity2.class);
                    startActivity(intent9);
                    Toast.makeText(getApplicationContext(), "Player removed", Toast.LENGTH_LONG).show();
                } else {
                    Intent intent10 = getIntent();
                    finish();
                    startActivity(intent10);
                }
            }
        });
    }
}