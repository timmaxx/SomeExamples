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

public class Main041102 extends Application{

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

        // получаем модель выбора
        MultipleSelectionModel<TreeItem<String>> selectionModel = langsTreeView.getSelectionModel();
        // устанавливаем множественный выбор (если он необходим)
        selectionModel.setSelectionMode(SelectionMode.MULTIPLE);

        Label lbl = new Label();
        Button btn = new Button("Get Selected");
        btn.setOnAction(event -> {

            String selected = "";
            // перебираем выбранные элементы
            for(TreeItem<String> item : selectionModel.getSelectedItems()){

                selected += item.getValue() + " ";
            }
            lbl.setText("Selected: " + selected);
        });

        FlowPane root = new FlowPane(Orientation.VERTICAL, 10, 10, langsTreeView, lbl, btn);

        Scene scene = new Scene(root, 300, 250);

        stage.setScene(scene);
        stage.setTitle("TreeView in JavaFX");
        stage.show();
    }
}