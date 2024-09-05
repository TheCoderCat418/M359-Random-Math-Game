package com.example.a5min;

public class Person {
    private String name;
    private int score = 0;
    private int levelOfAchievement = 0;
    private int highScore = 0;

    public Person(String name) {
        this.name = name;
    }


    public String getName(){
        return name;
    }
}
