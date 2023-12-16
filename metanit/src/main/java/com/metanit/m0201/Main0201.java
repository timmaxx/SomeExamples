package com.metanit.m0201;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main0201 extends Application{

    public static void main( String[ ] args) {
        Application.launch( args);
    }

    @Override
    public void start( Stage stage) throws Exception {
        System.out.println( getClass( ).getResource("Main0201.fxml"));
        //System.out.println( Main0201.class.getResource("../q.txt"));
        Parent root = FXMLLoader.load( getClass( ).getResource("Main0201.fxml"));

/*
        FXMLLoader loader = new FXMLLoader(getClass().getResource("Main0201.fxml"));
        loader.setController(new MainController(path));
        Pane mainPane = loader.load();
        */

        Scene scene = new Scene( root);

        stage.setScene( scene);

        stage.setTitle( "Hello JavaFX");
        stage.setWidth( 250);
        stage.setHeight( 200);

        stage.show( );
    }
}