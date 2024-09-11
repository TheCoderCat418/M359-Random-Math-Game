package com.example.a5min;

public class Question {
    private String operation;
    private char setOperation;
    private String randomNumbers;
    private int answer;

    public Question(String operation, int dificulty, boolean negitive){
        int randomMin, randomMax;
        if(dificulty == 1){
            randomMin = 0;
            randomMax = 10;
            if(negitive){
                randomMin = -10;
            }
        }else if(dificulty == 2){
            randomMin = 10;
            randomMax = 100;
            if(negitive){
                randomMin = -50;
            }
        }else{
            randomMin = 100;
            randomMax = 500;
            if(negitive){
                randomMin = -250;
            }
        }
        this.operation = operation;
        this.randomNumbers = assembleRandomNumbers(randomMin, randomMax);
        this.answer = processAnswer();
    }

    private int processAnswer(){
        String[] rns = randomNumbers.split(",");
        int num1 = Integer.parseInt(rns[0]);
        int num2 = Integer.parseInt(rns[1]);

        int op = operation.length();
        op = (int)(Math.random() * op)+1;
        if(op == 1){
            setOperation = operation.charAt(0);
            return eval(num1, num2, operation.charAt(0));
        }else if(op == 2){
            setOperation = operation.charAt(1);
            return eval(num1, num2, operation.charAt(1));
        }else if(op == 3){
            setOperation = operation.charAt(2);
            return eval(num1, num2, operation.charAt(2));
        }else if(op == 4){
            setOperation = operation.charAt(3);
            return eval(num1, num2, operation.charAt(3));
        }
        throw new RuntimeException("Invalid Operation");
    }

    private int eval(int num1, int num2, char operaton){
        if(operaton == '+'){
            return num1 + num2;
        }else if(operaton == '-'){
            return num1 - num2;
        }else if(operaton == '*'){
            return num1 * num2;
        }else if(operaton == '/'){
            return num1 / num2;
        }
        throw new RuntimeException("Invalid Operation");
    }

    private String assembleRandomNumbers(int min, int max){
        int number1 = min+(int)(Math.random() * ((max - min) + 1));
        int number2 = min+(int)(Math.random() * ((max - min) + 1));

        return number1+","+number2;
    }

    public boolean isCorrect(int playerAnwser){
        return playerAnwser == answer;
    }

    public String getOperation() {
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
        if(setOperation == '+'){
            op = " + ";
        }else if(setOperation == '-'){
            op = " - ";
        }else if(setOperation == '*'){
            op = " * ";
        }else if(setOperation == '/'){
            op = " / ";
        }
        return rns[0]+op+rns[1];
    }
}
