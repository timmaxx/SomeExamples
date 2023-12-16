package com.metanit.m0408;

import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.FlowPane;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.SelectionMode;
import javafx.scene.control.MultipleSelectionModel;
import javafx.collections.ObservableList;
import javafx.collections.FXCollections;

import javafx.geometry.Orientation;
import javafx.beans.value.ObservableValue;
import javafx.beans.value.ChangeListener;

public class Main040803 extends Application{

    public static void main(String[] args) {

        Application.launch(args);
    }

    @Override
    public void start(Stage stage) throws Exception {

        Label selectedLbl = new Label();

        // создаем список объектов
        ObservableList<String> langs = FXCollections.observableArrayList("Java", "JavaScript", "C#", "Python");
        ListView<String> langsListView = new ListView<String>(langs);
        langsListView.setPrefSize(250, 150);

        // получаем модель выбора элементов
        MultipleSelectionModel<String> langsSelectionModel = langsListView.getSelectionModel();
        langsSelectionModel.setSelectionMode(SelectionMode.MULTIPLE);

        // устанавливаем слушатель для отслеживания изменений
        langsSelectionModel.selectedItemProperty().addListener(new ChangeListener<String>(){

            public void changed(ObservableValue<? extends String> changed, String oldValue, String newValue){

                String selectedItems = "";
                ObservableList<String> selected = langsSelectionModel.getSelectedItems();
                for (String item : selected){
                    selectedItems += item + " ";
                }
                selectedLbl.setText("Selected: " + selectedItems);
            }
        });

        FlowPane root = new FlowPane(Orientation.VERTICAL, 10, 10, selectedLbl, langsListView);

        Scene scene = new Scene(root, 250, 200);

        stage.setScene(scene);
        stage.setTitle("ListView in JavaFX");
        stage.show();
    }
}