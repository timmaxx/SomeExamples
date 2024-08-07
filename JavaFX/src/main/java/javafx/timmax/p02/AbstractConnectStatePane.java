package javafx.timmax.p02;

import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.Region;

import java.util.List;

public abstract class AbstractConnectStatePane extends HBox {
    public final static int LAYOUT_X_OF_FIRST_COLUMN = 0;
    public final static int LAYOUT_X_OF_SECOND_COLUMN = 100;

    // Количество пикселей слева и справа, что-бы главное поле влезло во внутреннее окно - PrimaryStage
    public final static int PANE_NEXT_STATE_PREF_WIDTH = 300;
    public final static int PANE_PREV_STATE_PREF_WIDTH = 0;

    public final static int BUTTON_NEXT_STATE_PREF_WIDTH = 160;
    public final static int BUTTON_PREV_STATE_PREF_WIDTH = 160;

    // Y - составляющие
    public final static int LAYOUT_Y_OF_FIRST_ROW = 0;
    public final static int DIFFERENCE_OF_LAYOUT_Y = 30;
    // Количество пикселей сверху и снизу, что-бы главное поле влезло во внутреннее окно - PrimaryStage
    public final static int PIXELS_ON_TOP_N_BOTTOM_FOR_MAIN_FIELD_FITS_INTO_PRIMARY_STAGE = 17;
    // Количество "строк" контролов в панелях Pane0x..., кроме последней ("строк" от 1 до 6: 3 + 2 + 1 + 1)
    // В Pane0X (с первого по предпоследний) можно найти:
    //   paneNextState.setPrefHeight(DIFFERENCE_OF_LAYOUT_Y * ?);
    //   paneNextState.setMinHeight(DIFFERENCE_OF_LAYOUT_Y * ?);
    public final static int ROWS_OF_CONTROLS_IN_PANE0X_EXCEPT_LAST = 7;


    protected Pane nextStatePane;
    protected Pane prevStatePane;

    protected Button nextStateButton;
    protected Button prevStateButton;
    private List<Region> nextStateControlsList;
    private List<Region> prevStateControlsList;

    public AbstractConnectStatePane() {


        nextStatePane = new Pane();
        nextStatePane.setPrefWidth(PANE_NEXT_STATE_PREF_WIDTH); // 300
        nextStatePane.setMinWidth(PANE_NEXT_STATE_PREF_WIDTH); // 300

        nextStateButton = new Button();
        nextStateButton.setPrefWidth(BUTTON_NEXT_STATE_PREF_WIDTH); // 160
        nextStateButton.setMinWidth(BUTTON_NEXT_STATE_PREF_WIDTH); // 160
        nextStateButton.setLayoutX(nextStatePane.getPrefWidth() - nextStateButton.getPrefWidth()); // 300 - 160 = 140

        prevStateButton = new Button();
        prevStateButton.setPrefWidth(BUTTON_PREV_STATE_PREF_WIDTH); // 160
        prevStateButton.setMinWidth(BUTTON_PREV_STATE_PREF_WIDTH); // 160
        prevStateButton.setLayoutX(LAYOUT_X_OF_FIRST_COLUMN); // 0

        prevStatePane = new Pane();
        // prevStatePane.setPrefWidth(PANE_PREV_STATE_PREF_WIDTH); // 0
        prevStatePane.setLayoutX(LAYOUT_X_OF_FIRST_COLUMN + BUTTON_PREV_STATE_PREF_WIDTH); // 0 + 160 = 160

        getChildren().addAll(nextStatePane, nextStateButton, prevStateButton, prevStatePane);
    }

    public void setListsOfControlsAndAllDisable(
            List<Region> nextStateControlsList,
            List<Region> prevStateControlsList
    ) {
        this.nextStateControlsList = nextStateControlsList;
        this.prevStateControlsList = prevStateControlsList;
        nextStatePane.getChildren().clear();
        prevStatePane.getChildren().clear();

        nextStatePane.getChildren().addAll(nextStateControlsList);
        prevStatePane.getChildren().addAll(prevStateControlsList);
        disableAllControls();
    }

    protected void disableAllControls() {
        for (Region control : nextStateControlsList) {
            control.setDisable(true);
        }
        nextStateButton.setDisable(true);
        for (Region control : prevStateControlsList) {
            control.setDisable(true);
        }
        prevStateButton.setDisable(true);
    }

    protected void setDisableNextStateControls(boolean disableNextStateControls) {
        for (Region control : nextStateControlsList) {
            control.setDisable(disableNextStateControls);
        }
        nextStateButton.setDisable(disableNextStateControls);
        for (Region control : prevStateControlsList) {
            control.setDisable(!disableNextStateControls);
        }
        prevStateButton.setDisable(!disableNextStateControls);
    }

    //
    protected void doOnPrevState() {
        disableAllControls();
    }
}
