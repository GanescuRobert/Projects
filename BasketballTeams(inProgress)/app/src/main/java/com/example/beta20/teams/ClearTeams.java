package com.example.beta20.teams;

import com.example.beta20.activitys.MainActivity1;
import com.example.beta20.activitys.PlayersActivity2;

public class ClearTeams {

    public ClearTeams() {

        PlayersActivity2.allPlayers.clear();
        MainActivity1.team1.clear();
        MainActivity1.team2.clear();

        PlayersActivity2.adapterAllPlayers.clear();
        MainActivity1.adapterTeam1.clear();
        MainActivity1.adapterTeam2.clear();


    }
}
