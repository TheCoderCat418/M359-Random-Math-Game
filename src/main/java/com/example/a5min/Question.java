package com.example.a5min;

public class Question {
    private int operation;
    private String randomNumbers;
    private int answer;

    public Question(int operation, int randomMin, int randomMax){
        this.operation = operation;
        this.randomNumbers = assembleRandomNumbers(randomMin, randomMax);
        this.answer = processAnswer();
    }
    private int processAnswer(){
        String[] rns = randomNumbers.split(",");
        int num1 = Integer.parseInt(rns[0]);
        int num2 = Integer.parseInt(rns[1]);

        if(operation == 1){
            return num1 + num2;
        }
        throw new RuntimeException("Invalid Operation");
    }
    private String assembleRandomNumbers(int min, int max){
        int number1 = min+(int)(Math.random() * ((max - min) + 1));
        int number2 = min+(int)(Math.random() * ((max - min) + 1));

        return number1+","+number2;
    }

    public int getOperation() {
        return operation;
    }
    public int getAnswer(){
        return answer;
    }
    public String getRandomNumbers(){
        return randomNumbers;
    }
}
