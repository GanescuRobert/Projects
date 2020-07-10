package com.example.beta20.player;

import java.util.Comparator;

import static java.lang.StrictMath.round;

public class Player {
    private int id;
    private String name;
    private int experience;
    private int power;
    private int height;
    private int agility;
    private int age;
    private double value;


    void roundValue(){
        value = value*100;
        value = (double)((int) value);
        value = value /100;
    }
    void calculateValue() {
        value = experience * 5 + power * 4 + height * 3 + agility * 2 + age;
        value /= 15;
        roundValue();
    }

    public Player(String name, int experience, int power, int height, int agility, int age) {
        this.id = (int) (Math.PI*(height+10*age))/name.length()+10*(power+agility);
        this.name = name;
        this.agility = agility;
        this.experience = experience;
        this.power = power;
        this.age = age;
        this.height = height;
        calculateValue();
    }
    public String getName() {
        return name;
    }


    public double getValue() {
        return value;
    }
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public void setName(String name) {
        this.name = name;
    }
    public int getAgility() {
        return agility;
    }
    public void setAgility(int agility) {
        this.agility = agility;
    }
    public int getExperience() {
        return experience;
    }
    public void setExperience(int experience) {
        this.experience = experience;
    }
    public int getPower() {
        return power;
    }
    public void setPower(int power) {
        this.power = power;
    }
    public int getAge() {
        return age;
    }
    public void setAge(int age) {
        this.age = age;
    }
    public int getHeight() {
        return height;
    }
    public void setHeight(int height) {
        this.height = height;
    }
}
