package javafx.timmax.p02;

import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import java.util.List;


public class Pane01NoConnect extends AbstractConnectStatePane {
    private final TextField serverAddressTextField;
    private final TextField serverPortTextField;
    private final TextField connectStringTextField;


    public Pane01NoConnect() {
        super();

        // 1 (обязательные)
        // Контролы для продвижения состояния "вперёд":
        Label serverAddressLabel = new Label("Address");
        serverAddressTextField = new TextField();
        Label serverPortLabel = new Label("Port");
        serverPortTextField = new TextField();
        connectStringTextField = new TextField();
        connectStringTextField.setEditable(false);
        {   // Инициализация для отладки. Потом либо убрать, либо через конфигурационный файл!
            serverAddressTextField.setText("localhost");
            serverPortTextField.setText("8887");
        }

        nextStateButton.setText("Connect");
        nextStateButton.setOnAction(event -> {
            disableAllControls();

            System.out.println("getParent() = " + getParent());
            MainVBox parent = (MainVBox) getParent();

            Pane07GameMatchSelected pane = (Pane07GameMatchSelected) parent.getPane2();
            pane.setDisableNextStateControls(false);
        });

        // Контролы для продвижения состояния "назад":
        prevStateButton.setText("Disconnect");
        prevStateButton.setFocusTraversable(false);
        prevStateButton.setOnAction(event -> {
            disableAllControls();
        });

        // 1
        serverAddressLabel.setLayoutX(LAYOUT_X_OF_FIRST_COLUMN);
        serverAddressLabel.setLayoutY(LAYOUT_Y_OF_FIRST_ROW);
        serverAddressTextField.setLayoutX(LAYOUT_X_OF_SECOND_COLUMN);
        serverAddressTextField.setLayoutY(LAYOUT_Y_OF_FIRST_ROW);

        // 2
        serverPortLabel.setLayoutX(LAYOUT_X_OF_FIRST_COLUMN);
        serverPortLabel.setLayoutY(DIFFERENCE_OF_LAYOUT_Y);
        serverPortTextField.setLayoutX(LAYOUT_X_OF_SECOND_COLUMN);
        serverPortTextField.setLayoutY(DIFFERENCE_OF_LAYOUT_Y);

        // 3
        connectStringTextField.setLayoutX(LAYOUT_X_OF_SECOND_COLUMN);
        connectStringTextField.setLayoutY(2 * DIFFERENCE_OF_LAYOUT_Y);

        // Получилось 3 строки контролов:
        nextStatePane.setPrefHeight(DIFFERENCE_OF_LAYOUT_Y * 3);
        nextStatePane.setMinHeight(DIFFERENCE_OF_LAYOUT_Y * 3);

        // Вызов setListsOfControlsAndAllDisable() нужен для разделения контролов на два перечня: "вперёд" и "назад".
        setListsOfControlsAndAllDisable(
                List.of(serverAddressLabel, serverAddressTextField, serverPortLabel, serverPortTextField, connectStringTextField),
                List.of()
        );
        // ToDo: метод с параметром 'false' нужно вызывать, когда панель соответствует состоянию.
        setDisableNextStateControls(false);
    }
}
