package com.example.beta20.activitys;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;

import com.example.beta20.teams.ClearTeams;
import com.example.beta20.player.Player;
import com.example.beta20.R;
import com.example.beta20.adapters.AllPlayersListAdapter;
import com.example.beta20.tests.AddPlayersForTest;

import java.util.ArrayList;

public class PlayersActivity2 extends AppCompatActivity implements View.OnClickListener {

    public static ArrayList<Player> allPlayers = new ArrayList<>();
    public static AllPlayersListAdapter adapterAllPlayers;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_players);

        Button newPlayerBtn = (Button) findViewById(R.id.newPlayerBtn);
        Button removePlayerBtn = (Button) findViewById(R.id.addBtn);
        Button clearListBtn = (Button) findViewById(R.id.clearListBtn);
        Button backBtn = (Button) findViewById(R.id.backBtn);
        Button add10CasesBtn = (Button) findViewById(R.id.add10CasesBtn);

        newPlayerBtn.setOnClickListener((View.OnClickListener) this);
        removePlayerBtn.setOnClickListener((View.OnClickListener) this);
        clearListBtn.setOnClickListener((View.OnClickListener) this);
        backBtn.setOnClickListener((View.OnClickListener) this);
        add10CasesBtn.setOnClickListener((View.OnClickListener) this);

        ListView allPlayersListView = (ListView) findViewById(R.id.allPlayersListView);
        adapterAllPlayers = new AllPlayersListAdapter(this, R.layout.adapter_view_all_players_layout, allPlayers);
        allPlayersListView.setAdapter(adapterAllPlayers);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.newPlayerBtn:
                Intent intent2 = new Intent(PlayersActivity2.this, NewPlayerActivity21.class);
                startActivity(intent2);
                break;
            case R.id.addBtn:
                Intent intent3 = new Intent(PlayersActivity2.this, RemovePlayerActivity22.class);
                startActivity(intent3);
                break;
            case R.id.clearListBtn:
                new ClearTeams();
                Intent intent4 = getIntent();
                finish();
                startActivity(intent4);
                break;
            case R.id.backBtn:
                Intent intent5 = new Intent(PlayersActivity2.this, MainActivity1.class);
                startActivity(intent5);
                break;
            case R.id.add10CasesBtn:
                new AddPlayersForTest(allPlayers);
                Intent intent6 = getIntent();
                finish();
                startActivity(intent6);
                break;
        }


    }
}