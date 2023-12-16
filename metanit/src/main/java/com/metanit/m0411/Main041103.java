package com.metanit.m0411;

import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.FlowPane;
import javafx.scene.control.Label;
import javafx.scene.control.Button;
import javafx.scene.control.TreeView;
import javafx.scene.control.TreeItem;
import javafx.scene.control.MultipleSelectionModel;
import javafx.scene.control.SelectionMode;
import javafx.geometry.Orientation;
import javafx.beans.value.ObservableValue;
import javafx.beans.value.ChangeListener;

public class Main041103 extends Application{

    public static void main(String[] args) {

        Application.launch(args);
    }

    @Override
    public void start(Stage stage) throws Exception {

        TreeItem<String> rootTreeNode = new TreeItem<String>("Languages");

        TreeItem<String> germanics = new TreeItem<String>("Germanic");
        germanics.getChildren().add(new TreeItem<String>("German"));
        germanics.getChildren().add(new TreeItem<String>("English"));

        TreeItem<String> romans = new TreeItem<String>("Roman");
        romans.getChildren().add(new TreeItem<String>("French"));
        romans.getChildren().add(new TreeItem<String>("Spanish"));
        romans.getChildren().add(new TreeItem<String>("Italian"));

        rootTreeNode.getChildren().add(germanics);
        rootTreeNode.getChildren().add(romans);

        TreeView<String> langsTreeView = new TreeView<String>(rootTreeNode);
        langsTreeView.setPrefSize(150, 200);

        MultipleSelectionModel<TreeItem<String>> selectionModel = langsTreeView.getSelectionModel();

        Label lbl = new Label();
        // устанавливаем слушатель для отслеживания изменений
        selectionModel.selectedItemProperty().addListener(new ChangeListener<TreeItem<String>>(){

            public void changed(ObservableValue<? extends TreeItem<String>> changed,
                                TreeItem<String> oldValue, TreeItem<String> newValue){

                lbl.setText("Selected: " + newValue.getValue());
            }
        });

        FlowPane root = new FlowPane(Orientation.VERTICAL, 10, 10, langsTreeView, lbl);

        Scene scene = new Scene(root, 300, 250);

        stage.setScene(scene);
        stage.setTitle("TreeView in JavaFX");
        stage.show();
    }
}