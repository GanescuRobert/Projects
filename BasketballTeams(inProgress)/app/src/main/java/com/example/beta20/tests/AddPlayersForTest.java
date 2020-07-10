package com.example.beta20.tests;

import com.example.beta20.player.Player;

import java.util.ArrayList;
import java.util.Random;

public class AddPlayersForTest {


    public static int generateRandomIntIntRange(int min, int max) {
        Random r = new Random();
        return r.nextInt((max - min) + 1) + min;
    }
    public AddPlayersForTest(ArrayList<Player> T) {
        int numberOfPlayers = 10;
        while (numberOfPlayers-- != 0) {
            int experience = generateRandomIntIntRange(1, 10);
            int power = generateRandomIntIntRange(1, 10);
            int height = generateRandomIntIntRange(1, 10);
            int agility = generateRandomIntIntRange(1, 10);
            int age = generateRandomIntIntRange(10, 50);

            T.add(new Player("name" + (10 - numberOfPlayers), experience, power, height, agility, age));
        }
    }
}
