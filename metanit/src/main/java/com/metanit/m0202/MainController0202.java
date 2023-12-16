package com.metanit.m0202;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;

public class MainController0202 {

    @FXML
    private Button btn;

    @FXML
    private void click(ActionEvent event) {
        btn.setText("You've clicked!");
    }
}