package javafx.timmax.p02;

import javafx.scene.layout.Pane;

import java.util.List;

public class Pane07GameMatchSelected extends AbstractConnectStatePane {
    private final Pane gameViewsAndControlsPane;

    public Pane07GameMatchSelected() {

        System.out.println("Pane07GameMatchSelected :: Pane07GameMatchSelected(TransportOfClient transportOfClient)");

        gameViewsAndControlsPane = new Pane();
        gameViewsAndControlsPane.setPrefWidth(200);

        GameClientPaneJfx gameClientPaneJfx = new GameClientPaneJfx();
        gameClientPaneJfx.setPrefWidth(100);
        gameClientPaneJfx.setMinWidth(100);

        gameViewsAndControlsPane.getChildren().add(gameClientPaneJfx);


        // 1 (обязательные)
        // Контролы для продвижения состояния "вперёд":
        nextStateButton.setText("Start the game match");
        nextStateButton.setOnAction(event -> {
            disableAllControls();

            gameViewsAndControlsPane.setPrefWidth(200);
            // getParent().getScene().getWindow().sizeToScene();
        });

        // Контролы для продвижения состояния "назад":
        //gameViewsAndControlsPane.autosize();

        prevStateButton.setText("Stop the game match");
        prevStateButton.setFocusTraversable(false); // Это в любом случае д.б.
        prevStateButton.setOnAction(event -> {
            disableAllControls();
            // transportOfClient.resetGameMatch();
        });

        // По сравнению с предыдущими Pane0X (1 - 6)
        // Здесь нет строки "Получилось N строк контролов:"

        // Вызов setListsOfControlsAndAllDisable() нужен для разделения контролов на два перечня: "вперёд" и "назад".
        setListsOfControlsAndAllDisable(
                List.of(),
                List.of(gameViewsAndControlsPane)
        );
    }

    // X
    @Override
    public void doOnPrevState() {
        super.doOnPrevState();

        nextStatePane.setPrefHeight(DIFFERENCE_OF_LAYOUT_Y);
        nextStatePane.setMinHeight(DIFFERENCE_OF_LAYOUT_Y);
        setListsOfControlsAndAllDisable(
                List.of(),
                List.of(gameViewsAndControlsPane)
        );
        gameViewsAndControlsPane.getChildren().clear();
        prevStatePane.setPrefWidth(PANE_PREV_STATE_PREF_WIDTH);

        getParent().getScene().getWindow().setHeight(
                LAYOUT_Y_OF_FIRST_ROW
                        + 2 * PIXELS_ON_TOP_N_BOTTOM_FOR_MAIN_FIELD_FITS_INTO_PRIMARY_STAGE
                        + (ROWS_OF_CONTROLS_IN_PANE0X_EXCEPT_LAST + 1) * DIFFERENCE_OF_LAYOUT_Y
        );
    }
}
