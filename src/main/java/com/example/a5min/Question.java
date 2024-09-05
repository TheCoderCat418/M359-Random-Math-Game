package com.example.a5min;

public class Question {
    private int operation;
    private String randomNumbers;
    private int answer;

    public Question(int operation, int dificulty){
        int randomMin, randomMax;
        if(dificulty == 1){
            randomMin = 0;
            randomMax = 10;
        }else if(dificulty == 2){
            randomMin = 10;
            randomMax = 100;
        }else{
            randomMin = 100;
            randomMax = 500;
        }
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

    public String questionString(){
        String[] rns = randomNumbers.split(",");
        String op = " ERROR ";
        if(operation == 1){
            op=" + ";
        }
        return rns[0]+op+rns[1];
    }
}
