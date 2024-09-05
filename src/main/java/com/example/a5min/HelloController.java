package com.example.a5min;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class HelloController {

    public TextField name1;
    public TextField name2;
    public TextField rounds;
    public Button d1;
    public Button d2;
    public Button d3;
    public TextField range1;
    public TextField range2;
    public Button plus;
    public Button minus;
    public Button division;
    public Button start;
    public Button multiplication;
    public TextField answer;
    public Label questionLabel;

    private boolean singlePlayer = true;
    private int dificulty = 1;
    private int operation = 1;
    private Person p1;
    private Person p2;
    private int questionNum = 1;
    private Question currentQuestion;

    @FXML
    protected void onGameStart(){
        lockAll();
        if(!name2.getText().isBlank()){
            singlePlayer = false;
        }
        p1 = new Person(name1.getText());
        p2 = new Person(name2.getText());
        displayQuestion();





    }

    protected void displayQuestion(){
        currentQuestion = new Question(operation, dificulty);
        Person currentPlayer = p1;
        if(!singlePlayer){
            if(questionNum%2==1){
                currentPlayer=p2;
            }
        }
        questionLabel.setText(currentPlayer.getName()+", what is ["+currentQuestion.questionString()+"] ?");
    }
    @FXML
    protected void handleAnwser(){
        questionNum++;
        if(answer.getText().equals(Integer.toString(currentQuestion.getAnswer()))){
            
        }
    }
    @FXML
    protected void updateDificulty(ActionEvent ae){
        Button pushed = (Button) ae.getSource();
        if(pushed.equals(d1)){
            dificulty = 1;
            d1.setDisable(true);
            d2.setDisable(false);
            d3.setDisable(false);
        }else if(pushed.equals(d2)) {
            dificulty = 2;
            d1.setDisable(false);
            d2.setDisable(true);
            d3.setDisable(false);
        } else if(pushed.equals(d3)){
            dificulty = 3;
            d1.setDisable(false);
            d2.setDisable(false);
            d3.setDisable(true);
        }
    }
    @FXML
    private void updateOperation(ActionEvent ae){
        Button pushed = (Button) ae.getSource();
        if(pushed.equals(plus)){
            operation = 1;
            plus.setDisable(true);
            minus.setDisable(false);
        }else if(pushed.equals(minus)){
            operation = 2;
            plus.setDisable(false);
            minus.setDisable(true);
        }
    }

    protected void lockAll(){
        name1.setDisable(true);
        name2.setDisable(true);
        rounds.setDisable(true);
        d1.setDisable(true);
        d2.setDisable(true);
        d3.setDisable(true);
        plus.setDisable(true);
        minus.setDisable(true);
        multiplication.setDisable(true);
        division.setDisable(true);
        range1.setDisable(true);
        range2.setDisable(true);
        start.setDisable(true);
    }


    private Question generateQuestion(int rangeMin, int rangeMax, int operation){
        return null;
    }
}