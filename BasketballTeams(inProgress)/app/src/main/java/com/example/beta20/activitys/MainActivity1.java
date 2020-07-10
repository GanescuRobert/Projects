package com.example.beta20.activitys;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;

import com.example.beta20.teams.CreateTeams;
import com.example.beta20.player.Player;
import com.example.beta20.adapters.TeamListAdapter;
import com.example.beta20.R;

import java.util.ArrayList;
import java.util.List;


public class MainActivity1 extends AppCompatActivity implements View.OnClickListener {


    public static List<Player> team1 = new ArrayList<>();
    public static List<Player> team2 = new ArrayList<>();
    public static TeamListAdapter adapterTeam1;
    public static TeamListAdapter adapterTeam2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button playersBtn = (Button) findViewById(R.id.playersBtn);
        Button rollTeamsBtn = (Button) findViewById(R.id.rollTeamsBtn);
        ListView team1ListView = (ListView) findViewById(R.id.playersT1ListView);
        ListView team2ListView = (ListView) findViewById(R.id.playersT2ListView);

        playersBtn.setOnClickListener((View.OnClickListener) this);
        rollTeamsBtn.setOnClickListener((View.OnClickListener) this);

        adapterTeam1 = new TeamListAdapter(this, R.layout.adapter_view_team_layout, team1);
        adapterTeam2 = new TeamListAdapter(this, R.layout.adapter_view_team_layout, team2);
        team1ListView.setAdapter(adapterTeam1);
        team2ListView.setAdapter(adapterTeam2);

    }
    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.playersBtn:
                Intent intent0 = new Intent(MainActivity1.this, PlayersActivity2.class);
                startActivity(intent0);
                break;
            case R.id.rollTeamsBtn:
                if (PlayersActivity2.allPlayers.size() > 1) {
                    new CreateTeams();
                }
                Intent intent1 = getIntent();
                finish();
                startActivity(intent1);
                break;
        }


    }
}