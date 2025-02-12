package de.dennis.slvisualizer;

import de.dennis.slvisualizer.Panes.ListView;
import javafx.scene.control.ScrollPane;


public class Stack extends ScrollPane {

    private final ListView LIST_VIEW = new ListView();

    private int listLength;

    private ListElement first;
    private ListElement last;

    public Stack(ListElement firstElement) {
        setContent(LIST_VIEW);

        addFirstElement(firstElement);
    }

    public Stack() {
        setContent(LIST_VIEW);

        setVbarPolicy(ScrollPane.ScrollBarPolicy.NEVER);
        setHbarPolicy(ScrollPane.ScrollBarPolicy.AS_NEEDED);
        setMinHeight(Main.WINDOW_HEIGHT * 0.35);


        listLength = 0;

        first = null;
        last = null;
    }

    public void push(ListElement e) {
        if (first == null) addFirstElement(e);
        else {
            listLength++;

            // Reset front() method
            first.getGraphicObject().resetShow();

            first.getGraphicObject().setPosArrowVisible(false);

            e.setNext(first);
            first = e;

            e.getGraphicObject().setPosArrowToFirst();
            e.getGraphicObject().setPosArrowVisible(true);

            LIST_VIEW.addNode(e, listLength);
        }
    }

    public void remove() {
        if (first != null) {
            listLength--;

            first = first.getNext();

            if (first != null) {
                if (first == last) first.getGraphicObject().setPosArrowToBoth();
                else first.getGraphicObject().setPosArrowToFirst();

                first.getGraphicObject().setPosArrowVisible(true);
            } else last = null;

            LIST_VIEW.removeNode(1);
        }
    }

    public boolean isEmpty() {
        return first == null && last == null;
    }

    private void addFirstElement(ListElement e) {
        listLength = 1;

        first = e;
        last = e;

        e.getGraphicObject().setPosArrowToBoth();
        e.getGraphicObject().setPosArrowVisible(true);

        LIST_VIEW.addNode(e, 1);
    }

    public void front() {
        if (first != null) {
            first.getGraphicObject().showContent();
        }
    }

}
