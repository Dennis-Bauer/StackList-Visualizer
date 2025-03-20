package de.dennis.slvisualizer.Panes;

import de.dennis.slvisualizer.ListElement;
import de.dennis.slvisualizer.Main;
import javafx.geometry.Insets;
import javafx.scene.layout.HBox;

import java.util.ArrayList;

public class ListView extends HBox {

    private final ArrayList<ElementObjekt> nodeList = new ArrayList<>();

    public ListView() {
        setSpacing(Main.WINDOW_WIDTH * 0.01);

        // space between scrollPane and node rectangle
        setPadding(new Insets(Main.WINDOW_HEIGHT * 0.025));
    }

    public void addNode(ListElement e, int pos) {
        nodeList.add(pos - 1,  e.getGraphicObject());

        getChildren().addFirst(nodeList.get(pos - 1));
    }

    public void removeNode(int pos) {
        nodeList.remove(pos - 1);
        getChildren().remove(pos - 1);
    }

}
