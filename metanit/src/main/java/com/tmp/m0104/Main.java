package com.tmp.m0104;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

class Main extends Application {

    @Override
    public void start( Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load( getClass( ).getResource("views/main.fxml"));
        primaryStage.setTitle("Users List");
        primaryStage.setScene(new Scene(root));
        primaryStage.show();
    }


    public static void main( String[ ] args) {
        launch( args);
    }
}
