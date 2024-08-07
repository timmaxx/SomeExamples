package javafx.timmax.p02;

import javafx.collections.ListChangeListener;
import javafx.scene.Scene;

public class MyListChangeListener<E> implements ListChangeListener<E> {
    private Scene scene;

    public void setScene(Scene scene) {
        this.scene = scene;
    }

    @Override
    public void onChanged(Change<? extends E> c) {
        System.out.println("c = " + c);
        scene.getWindow().sizeToScene();
    }
}
