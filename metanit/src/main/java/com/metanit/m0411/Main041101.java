package com.metanit.m0411;

import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.FlowPane;
import javafx.scene.control.TreeView;
import javafx.scene.control.TreeItem;
import javafx.geometry.Orientation;

public class Main041101 extends Application{

    public static void main(String[] args) {

        Application.launch(args);
    }

    @Override
    public void start(Stage stage) throws Exception {

        // определяем корневой узел
        TreeItem<String> rootTreeNode = new TreeItem<String>("Languages");

        // определяем набор вложенных узлов
        TreeItem<String> germanics = new TreeItem<String>("Germanic");
        germanics.getChildren().add(new TreeItem<String>("German"));
        germanics.getChildren().add(new TreeItem<String>("English"));

        TreeItem<String> romans = new TreeItem<String>("Roman");
        romans.getChildren().add(new TreeItem<String>("French"));
        romans.getChildren().add(new TreeItem<String>("Spanish"));
        romans.getChildren().add(new TreeItem<String>("Italian"));

        // добавляем узлы в корневой узел
        rootTreeNode.getChildren().add(germanics);
        rootTreeNode.getChildren().add(romans);

        // устанавливаем корневой узел для TreeView
        TreeView<String> langsTreeView = new TreeView<String>(rootTreeNode);
        langsTreeView.setPrefSize(150, 200);
        FlowPane root = new FlowPane(10, 10, langsTreeView);

        Scene scene = new Scene(root, 300, 250);

        stage.setScene(scene);
        stage.setTitle("TreeView in JavaFX");
        stage.show();
    }
}