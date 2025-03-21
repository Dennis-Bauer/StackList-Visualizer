package de.dennis.slvisualizer;

import de.dennis.slvisualizer.Panes.ElementObjekt;

public class ListElement {

    private int content;
    private ListElement next = null;

    private final ElementObjekt objekt;

    public ListElement(int content) {
        this.content = content;

        objekt = new ElementObjekt(content);
    }

    public ElementObjekt getGraphicObject() {
        return objekt;
    }

    public int getContent() { return content; }

    public ListElement getNext() {
        return next;
    }

    public void setNext(ListElement next) {
        this.next = next;
    }
}

