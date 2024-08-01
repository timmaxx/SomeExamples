package javafx.timmax.p02;

import javafx.scene.control.Button;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;

public class GameClientPaneJfx extends VBox {

    public GameClientPaneJfx() {
/*
        BaseController baseController = new BaseController(transportOfClient);
        LocalClientStateAutomaton localClientStateAutomaton = transportOfClient.getLocalClientStateAutomaton();

        // ToDo: Переделать. См. комментарий к
        //       LocalClientStateAutomaton :: Map<String, Class<? extends View>> getViewName_ViewClassMap()
        Map<String, Class<? extends View>> viewName_ViewClassMap = localClientStateAutomaton.getViewName_ViewClassMap();

        for (Map.Entry<String, Class<? extends View>> viewName_ViewClassEntry : viewName_ViewClassMap.entrySet()) {
            // ToDo: Исправить
            //       Warning:(29, 21) Unchecked cast: 'java.lang.reflect.Constructor<capture<? extends timmax.tilegame.baseview.View>>' to 'java.lang.reflect.Constructor<? extends timmax.tilegame.guiengine.jfx.view.ViewJfx>'
            Constructor<? extends ViewJfx> viewConstructor =
                    new ViewJfxClass(viewName_ViewClassEntry.getValue()).getViewConstructor();
            ViewJfx viewJfx;
            try {
                viewJfx = viewConstructor.newInstance(transportOfClient, baseController, viewName_ViewClassEntry.getKey());
            } catch (InstantiationException | IllegalAccessException | InvocationTargetException e) {
                throw new RuntimeException(e);
            }
            viewJfx.autosize();
            localClientStateAutomaton.addView(viewJfx);
            getChildren().add(viewJfx);
        }
*/
        Pane viewJfx = new Pane();
        viewJfx.setPrefWidth(200);
        Button button = new Button();
        button.setPrefWidth(100);
        viewJfx.getChildren().add(button);

        getChildren().add(viewJfx);

    }
}
