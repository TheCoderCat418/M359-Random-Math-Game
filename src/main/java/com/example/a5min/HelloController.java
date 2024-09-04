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

    private boolean singlePlayer = true;
    private int dificulty = 1;
    private int operation = 1;

    @FXML
    protected void onGameStart(){
        if(!name2.getText().isBlank()){
            singlePlayer = false;
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

    private Question generateQuestion(int rangeMin, int rangeMax, int operation){
        return null;
    }
}