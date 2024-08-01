package javafx.timmax.p02;

import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.scene.layout.Region;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
            Map<String, Integer> paramsOfModelValueMap = new HashMap<>();
            for (Region region : getNextStateControlsList()) {
                if (region instanceof TextField textField) {
                    paramsOfModelValueMap.put(
                            textField.getId(),
                            Integer.valueOf(textField.getText()));
                }
            }
            // transportOfClient.setGameMatchIsPlaying(paramsOfModelValueMap);

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


    // interface ObserverOnAbstractEvent
    // 6
    //@Override
    public void updateOnSetGameMatch() {
        nextStatePane.getChildren().clear();
        List<Region> regionList = new ArrayList<>();

        int y = LAYOUT_Y_OF_FIRST_ROW;
        // ToDo: Отказаться от прямого доступа к getParamName_paramModelDescriptionMap().
        //       Здесь используется
        //       LocalClientStateAutomaton :: Map<String, ParamOfModelDescription> getParamName_paramModelDescriptionMap()
/*
        for (String paramName : transportOfClient.getLocalClientStateAutomaton().getParamName_paramModelDescriptionMap().keySet()) {
            Label paramNameLabel = new Label(paramName);
            paramNameLabel.setLayoutX(LAYOUT_X_OF_FIRST_COLUMN);
            paramNameLabel.setLayoutY(y);

            TextField paramNameTextField = new TextField();
            paramNameTextField.setId(paramName);
            paramNameTextField.setLayoutX(LAYOUT_X_OF_SECOND_COLUMN);
            paramNameTextField.setLayoutY(y);
            ParamOfModelDescription paramOfModelDescription = transportOfClient
                    .getLocalClientStateAutomaton()
                    .getParamName_paramModelDescriptionMap()
                    .get(paramName);
            paramNameTextField.setTextFormatter(
                    new TextFormatter<>(
                            new IntegerStringConverterWithMinAndMax(
                                    paramOfModelDescription.getMinValue(),
                                    paramOfModelDescription.getMaxValue()
                            ),
                            paramOfModelDescription.getDefaultValue(),
                            new IntegerFilter()
                    )
            );

            regionList.add(paramNameLabel);
            regionList.add(paramNameTextField);
            y += DIFFERENCE_OF_LAYOUT_Y;
        }
*/
        nextStatePane.setPrefHeight(y);
        nextStatePane.setMinHeight(y);

        setListsOfControlsAndAllDisable(
                regionList,
                List.of(gameViewsAndControlsPane)
        );

        gameViewsAndControlsPane.getChildren().clear();
        gameViewsAndControlsPane.getChildren().add(new GameClientPaneJfx());

        if (y > DIFFERENCE_OF_LAYOUT_Y) {
            y -= DIFFERENCE_OF_LAYOUT_Y;
        }

        // ToDo: Похожий код см. в ViewMainFieldJfx::initMainField()
        // System.out.println("getParent().getScene().getWindow().getWidth() = " + getParent().getScene().getWindow().getWidth());
        int widthTmp = LAYOUT_X_OF_FIRST_COLUMN
                + PIXELS_ON_LEFT_N_RIGHT_FOR_MAIN_FIELD_FITS_INTO_PRIMARY_STAGE
                + PANE_NEXT_STATE_PREF_WIDTH
                + BUTTON_NEXT_STATE_PREF_WIDTH
                + BUTTON_PREV_STATE_PREF_WIDTH
                - 1;
        // System.out.println( "getParent().getScene().getWindow().setWidth( " + widthTmp + " )");
        getParent().getScene().getWindow().setWidth(widthTmp);

        // ToDo: Вернуться к информационным представлениям (про 180).
        // // 180 - количество пикселей в высоту, нужное для достаточного отображения четырёх текстовых выборок
        getParent().getScene().getWindow().setHeight(
                LAYOUT_Y_OF_FIRST_ROW
                        + (2 * PIXELS_ON_LEFT_N_RIGHT_FOR_MAIN_FIELD_FITS_INTO_PRIMARY_STAGE)
                        + (ROWS_OF_CONTROLS_IN_PANE0X_EXCEPT_LAST + 1) * DIFFERENCE_OF_LAYOUT_Y
                        + y
        );

        doOnThisState();
    }
/*
    // 7
    @Override
    public void updateOnSetGameMatchIsPlaying() {
        doOnNextState();
    }
*/
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
