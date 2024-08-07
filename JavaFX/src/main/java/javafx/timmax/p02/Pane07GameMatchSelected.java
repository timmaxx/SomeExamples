package javafx.timmax.p02;

import java.util.List;

public class Pane07GameMatchSelected extends AbstractConnectStatePane {
    private final GameClientPaneJfx gameClientPaneJfx;

    public Pane07GameMatchSelected() {
        gameClientPaneJfx = new GameClientPaneJfx();

        // 1 (обязательные)
        // Контролы для продвижения состояния "вперёд":
        nextStateButton.setText("Start the game match");
        nextStateButton.setOnAction(event -> {
            gameClientPaneJfx.createControls();
            getParent().getScene().getWindow().sizeToScene();
            prevStateButton.setDisable(false);
        });

        // Контролы для продвижения состояния "назад":
        prevStateButton.setText("Stop the game match");
        prevStateButton.setOnAction(event -> {
            gameClientPaneJfx.getChildren().clear();
            getParent().getScene().getWindow().sizeToScene();
            prevStateButton.setDisable(true);
        });

        // По сравнению с предыдущими Pane0X (1 - 6)
        // Здесь нет строки "Получилось N строк контролов:"

        // Вызов setListsOfControlsAndAllDisable() нужен для разделения контролов на два перечня: "вперёд" и "назад".
        setListsOfControlsAndAllDisable(
                List.of(),
                List.of(gameClientPaneJfx)
        );
    }
}
