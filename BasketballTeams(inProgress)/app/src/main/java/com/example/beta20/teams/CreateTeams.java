package com.example.beta20.teams;

import com.example.beta20.activitys.MainActivity1;
import com.example.beta20.activitys.PlayersActivity2;

import java.util.ArrayList;
import java.util.Collections;

public class CreateTeams {

    final int times = 10000;
    double eps = 1;
    boolean isCalibrated=false;
    public CreateTeams() {
        int teamSize = 5;
        while(!isCalibrated) {
            for (int time = 0; time <= times; time++) {
                Collections.shuffle(PlayersActivity2.allPlayers);
                double team1Value = 0, team2Value = 0;
                for (int i = 0; i < 2 * teamSize; i++) {
                    if (i < teamSize) {
                        team1Value += PlayersActivity2.allPlayers.get(i).getValue();
                    } else {
                        team2Value += PlayersActivity2.allPlayers.get(i).getValue();
                    }
                }

                if (Math.abs(team1Value - team2Value) < eps) {
                    MainActivity1.team1 = new ArrayList(PlayersActivity2.allPlayers.subList(0, teamSize));
                    MainActivity1.team2 = new ArrayList(PlayersActivity2.allPlayers.subList(teamSize, 2*teamSize));
                    isCalibrated = true;
                    break;
                }
            }
            eps += 0.5;
        }
    }

}
