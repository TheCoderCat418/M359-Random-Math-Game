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
    public Label p1points;
    public Label p2points;
    public Label toast;
    public Button submit;

    private boolean singlePlayer = true;
    private int dificulty = 1;
    private int operation = 1;
    private Person p1;
    private Person p2;
    private int questionNum = 1;
    private Question currentQuestion;

    @FXML
    protected void onGameStart(){
        singlePlayer = true;
        lockAll();
        if(!name2.getText().isBlank()){
            singlePlayer = false;
        }
        p1 = new Person(name1.getText());
        p2 = new Person(name2.getText());
        updateScores();
        questionNum = 1;
        displayQuestion();
    }

    protected void displayQuestion(){
        if(questionNum==11){
            endGame();
            return;
        }
        currentQuestion = new Question(operation, dificulty);
        Person currentPlayer = p1;
        if(!singlePlayer){
            if(questionNum%2==0){
                currentPlayer=p2;
            }
        }
        questionLabel.setText(currentPlayer.getName()+", what is ["+currentQuestion.questionString()+"] ?");
    }

    @FXML
    protected void handleAnwser(){
        if(currentQuestion.isCorrect(Integer.parseInt(answer.getText()))){
            if(!singlePlayer){
                if(questionNum%2==0){
                    p2.modifyScore(1);
                }else {
                    p1.modifyScore(1);
                }
            }else {
                p1.modifyScore(1);
            }
            updateScores();
            toast.setText("Correct!");
        }else{
            toast.setText("Incorrect! The anwser was " + currentQuestion.getAnswer() + ".");
        }
        questionNum++;
        displayQuestion();
    }

    protected void updateScores(){
        if(!singlePlayer){
            p2points.setText(p2.getName()+"'s Score: "+Integer.toString(p2.getScore()));
        }else{
            p2points.setText("Single player mode");
        }
        p1points.setText(p1.getName()+"'s Score: "+Integer.toString(p1.getScore()));
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
        submit.setDisable(false);
    }

    protected void unlockAll(){
        name1.setDisable(false);
        name2.setDisable(false);
        rounds.setDisable(false);
        d1.setDisable(false);
        d2.setDisable(false);
        d3.setDisable(false);
        plus.setDisable(false);
        minus.setDisable(false);
        multiplication.setDisable(false);
        division.setDisable(false);
        range1.setDisable(false);
        range2.setDisable(false);
        start.setDisable(false);
        submit.setDisable(true);
    }

    protected void endGame(){
        if(p1.getScore()> p2.getScore()){
            questionLabel.setText("All done! The winner is " + p1.getName());
        }else{
            questionLabel.setText("All done! The winner is " + p2.getName());
        }

        unlockAll();
    }
}