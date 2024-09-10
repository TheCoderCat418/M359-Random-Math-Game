package com.example.a5min;

public class Person {
    private String name;

    private int totalScore = 0;
    private int highScore = 0;

    private int multiplicationQuestionsCorrect = 0;
    private int additionQuestionsCorrect = 0;
    private int subtractionQuestionsCorrect = 0;
    private int divisonQuestionsCorrect = 0;

    private int streak = 0;

    public Person(String name) {
        this.name = name;
    }

    public Person(String name, int highScore) {
        this.name = name;
        this.highScore = highScore;
    }

    public String getName(){
        return name;
    }

    public void modifyScore(int amount){
        totalScore += amount;
        if(totalScore > highScore){
            highScore = totalScore;
        }
    }

    public int getScore(){
        return totalScore;
    }

    public int getAdditionQuestionsCorrect() {
        return additionQuestionsCorrect;
    }

    public int getDivisonQuestionsCorrect() {
        return divisonQuestionsCorrect;
    }

    public int getMultiplicationQuestionsCorrect() {
        return multiplicationQuestionsCorrect;
    }

    public int getSubtractionQuestionsCorrect() {
        return subtractionQuestionsCorrect;
    }

    public void incrementAdditionQuestionsCorrect() {
        additionQuestionsCorrect++;
    }

    public void incrementDivisonQuestionsCorrect() {
        divisonQuestionsCorrect++;
    }

    public void incrementMultiplicationQuestionsCorrect() {
        multiplicationQuestionsCorrect++;
    }

    public void incrementSubtractionQuestionsCorrect() {
        subtractionQuestionsCorrect++;
    }

    public int getHighScore() {
        return highScore;
    }

    public int getStreak() {
        return streak;
    }

    public void incrementStreak(){
        streak++;
    }

    public void resetStreak(){
        streak = 0;
    }

}
