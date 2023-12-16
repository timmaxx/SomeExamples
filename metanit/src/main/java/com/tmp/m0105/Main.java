package com.tmp.m0105;

import javafx.application.Application;
/*
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;
*/
import javafx.stage.Stage;

import java.io.File;

public class Main extends Application {
    // ScreenSaverYT

    public static void main(String[] args) {
        launch( args);
    }

    @Override
    public void start(Stage stage) throws Exception {
        //File file = new File( "D:\\Мульты\\PixarShortFilmsCollection\\02.Pixar.Luxo.Jr.1986.mkv");
        File file = new File( "D:\\Temp\\VID_20190630_163842.mp4");
        // D:\Мульты\PixarShortFilmsCollection\02.Pixar.Luxo.Jr.1986.mkv
/*
        Media media = new Media( file.toURI().toURL().toString());
        MediaPlayer mediaPlayer = new MediaPlayer( media);
        MediaView mediaView = new MediaView( mediaPlayer);

        DoubleProperty width = mediaView.fitWidthProperty( );
        DoubleProperty height = mediaView.fitHeightProperty( );
        width.bind( Bindings.selectDouble( mediaView.sceneProperty(), "width"));
        height.bind( Bindings.selectDouble( mediaView.sceneProperty(), "height"));
        mediaView.setPreserveRatio( true);

        StackPane root = new StackPane( );
        root.getChildren( ).add( mediaView);

        Scene scene = new Scene( root, 500, 500, Color.BLACK);

        stage.setScene( scene);
        stage.setTitle( "ScreenSaver");
        stage.setFullScreen( true);
        stage.show();

        mediaPlayer.play( );
        */
    }
}

