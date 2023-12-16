package com.tmp.m0103;

import javafx.application.Application;
import javafx.stage.Stage;

public class UserAndPasswFormLaunch extends Application {

    @Override
    public void start( Stage primaryStage) /*throws Exception*/ {
        UserAndPasswForm userAndPasswForm = new UserAndPasswForm( );
        userAndPasswForm.BuildAndShow( primaryStage);
    }

    public static void main( String[ ] args) {
        launch( );
    }
}
