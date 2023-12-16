package com.metanit.m0102;

import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class HelloController0102 {
    @FXML
    private Label welcomeText;

    @FXML
    protected void onHelloButtonClick() {
        welcomeText.setText("Welcome to JavaFX Application!");
    }
}