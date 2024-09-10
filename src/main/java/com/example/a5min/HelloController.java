package com.example.a5min;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleButton;

public class HelloController {

    public TextField name1;
    public TextField name2;
    public TextField rounds;
    public Button d1;
    public Button d2;
    public Button d3;
    public TextField range1;
    public TextField range2;
    public ToggleButton plus;
    public ToggleButton minus;
    public ToggleButton division;
    public Button start;
    public ToggleButton multiplication;
    public TextField answer;
    public Label questionLabel;
    public Label p1points;
    public Label p2points;
    public Label toast;
    public Button submit;
    public Label inarow15;
    public Label inarow10;
    public Label inarow20;
    public Label all5;
    public Label alldone;
    public Label all5p2;
    public Label inarow10p2;
    public Label inarow15p2;
    public Label inarow20p2;
    public Label alldonep2;
    public Label hsp1;
    public Label hsp2;
    public ToggleButton negitive;

    private boolean singlePlayer = true;
    private int dificulty = 1;
    private String operation = "+";
    private Person p1;
    private Person p2;
    private int questionNum = 1;
    private Question currentQuestion;
    private int numOfRounds = 20;
    private boolean started = false;

    @FXML
    protected void onGameStart(){
        singlePlayer = true;
        lockAll();
        if(!name2.getText().isBlank()){
            singlePlayer = false;
        }
        p1 = new Person(name1.getText());
        p2 = new Person(name2.getText());
        if(started){
            p1 = new Person(name1.getText());
            p2 = new Person(name2.getText());
        }
        updateScores();
        questionNum = 1;
        displayQuestion();
    }

    protected void displayQuestion(){
        if(questionNum==numOfRounds+1){
            endGame();
            return;
        }
        currentQuestion = new Question(operation, dificulty, negitive.isSelected());
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
                    p2.incrementStreak();
                }else {
                    p1.modifyScore(1);
                    p1.incrementStreak();
                }
            }else {
                p1.modifyScore(1);
                p1.incrementStreak();
            }
            updateScores();
            toast.setText("Correct!");
        }else{
            if(!singlePlayer){
                if(questionNum%2==0){
                    p2.resetStreak();
                }else {
                    p1.resetStreak();
                }
            }else {
                p1.resetStreak();
            }
            toast.setText("Incorrect! The anwser was " + currentQuestion.getAnswer() + ".");
        }
        questionNum++;
        displayQuestion();
    }

    protected void updateScores(){
        updateHighScores();
        checkForBadges();
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
        operation = "";
        if(plus.isSelected()){
            operation += "+";
        }else if(minus.isSelected()){
            operation += "-";
        }else if(multiplication.isSelected()){
            operation += "*";
        }else if(division.isSelected()) {
            operation += "/";
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

    protected void checkForBadges(){
        Person p = p1;
        for(int i = 10; i<30;i+=10){
            if(p.getStreak() >= 20) {
                giveBadge(3 + i);
            }
            if(p.getStreak() >= 15) {
                giveBadge(2+i);
            }
            if(p.getStreak() >= 10){
                giveBadge(1+i);
            }
            if(p.getAdditionQuestionsCorrect() >= 5 && p.getMultiplicationQuestionsCorrect() >= 5 && p.getSubtractionQuestionsCorrect() >= 5 && p.getDivisonQuestionsCorrect() >= 5){
                giveBadge(4+i);
            }
            if(p.getScore() == numOfRounds){
                giveBadge(5+i);
            }
            p = p2;
        }

    }

    protected void updateHighScores(){
        hsp1.setText(Integer.toString(p1.getHighScore()));
        hsp2.setText(Integer.toString(p2.getHighScore()));

    }
    protected void giveBadge(int badgeId){
        switch (badgeId){
            case 11:
                inarow10.setVisible(true);
                break;
            case 12:
                inarow15.setVisible(true);
                break;
            case 13:
                inarow20.setVisible(true);
                break;
            case 14:
                all5.setVisible(true);
                break;
            case 15:
                alldone.setVisible(true);
                break;
            case 21:
                inarow10p2.setVisible(true);
                break;
            case 22:
                inarow15p2.setVisible(true);
                break;
            case 23:
                inarow20p2.setVisible(true);
                break;
            case 24:
                all5p2.setVisible(true);
                break;
            case 25:
                alldonep2.setVisible(true);
                break;
        }
    }
}