package de.dennis.slvisualizer;

import de.dennis.slvisualizer.Panes.ListView;
import javafx.scene.control.ScrollPane;

import java.util.List;


public class Stack extends ScrollPane {

    private final ListView LIST_VIEW = new ListView();

    private ListElement first;

    public Stack(ListElement firstElement) {
        setContent(LIST_VIEW);

        addFirstElement(firstElement);
    }

    public Stack() {
        setContent(LIST_VIEW);

        setVbarPolicy(ScrollPane.ScrollBarPolicy.NEVER);
        setHbarPolicy(ScrollPane.ScrollBarPolicy.AS_NEEDED);
        setMinHeight(Main.WINDOW_HEIGHT * 0.35);

        first = null;
    }

    public void push(ListElement e) {
        if (first == null) addFirstElement(e);
        else {
            // Reset front() method
            first.getGraphicObject().resetShow();

            first.getGraphicObject().setPosArrowVisible(false);

            e.setNext(first);
            first = e;

            first.getGraphicObject().setPosArrowToFirst();
            first.getGraphicObject().setPosArrowVisible(true);

            LIST_VIEW.addNode(first, 1);
        }
    }

    public ListElement pop() {
        if (first != null) {
            ListElement tmp = first;

            first = first.getNext();

            if (first != null) {
                first.getGraphicObject().setPosArrowToFirst();
                first.getGraphicObject().setPosArrowVisible(true);
            }

            LIST_VIEW.removeNode(1);

            return tmp;
        }
        return null;
    }

    public boolean isEmpty() {
        return first == null;
    }

    public void peek() {
        if (first != null) {
            first.getGraphicObject().showContent();
        }
    }

    private void addFirstElement(ListElement e) {
        first = e;

        e.getGraphicObject().setPosArrowToFirst();
        e.getGraphicObject().setPosArrowVisible(true);

        LIST_VIEW.addNode(e, 1);
    }

}
