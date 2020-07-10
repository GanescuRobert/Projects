package com.example.beta20.comparators;

import com.example.beta20.player.Player;

import java.util.Comparator;

public class ValuePlayerComparator implements Comparator<Player> {
    public int compare(Player p1, Player p2) {
        int p1v=(int)(p1.getValue()*100);
        int p2v=(int)(p2.getValue()*100);

        if(p1v==p2v) return 0;
        else if(p1v<p2v) return 1;
        else return -1;
    }
}
