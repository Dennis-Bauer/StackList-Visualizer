# **Stack List Visualizer (German)** 

Ein Visualisierungstool für Kellerspeicher-Listen, programmiert in **Java** mit **JavaFX**.  

## **Funktionen**  

- **Visualisierung des Zeigers**: Es wird der Zeiger **First** gezeigt.
- **Keine sichtbaren Werte in den Nodes**: Werte, beim First-zeiger, werden erst vollständig sichtbar, wenn `peek()` aufgerufen wird.  
- **Voreingestellte Test-Liste**: Eine vorgefertigte Liste kann genutzt und bearbeitet werden.  
- **Erstellung neuer Listen**:  
  - Leere Liste  
  - Liste mit einem initialen Element  
- **Methodennamen als Button-Beschriftungen**: Die Buttons sind exakt so benannt wie die Methoden aus der offiziellen **Java-Documentation** für Stacks.  

  Eine Ausnahme bildet die Methode **`top()`**, die in Schulen häufig verwendet wird – in diesem Visualizer folgt sie der offiziellen Java-Konvention und ist daher als **`peek()`** beschriftet.  
- **Eingabe über Input-Box**: Werte werden aus der Input-Box entnommen.  
- **Anpassbare Darstellung** in der `Main`-Klasse:  
  - **Fenstergröße**  
  - **Schriftart und Schriftgröße**  
  - **Farben der Pfeile**  
- **Integer-Liste**: Standardmäßig sind Zahlen auf **3 Ziffern begrenzt** (anpassbar in `Main`).  
- **Null-Zeiger**: Das letzte Element im Stack zeigt in dieser Visualisierung ins nichts. Dies ist **kein Fehler**, sondern soll veranschaulichen, dass das Element **nicht weiß**, dass es das letzte ist, und daher auf `null` verweist.  

## **Methoden**  

### `push(Content)`  
Fügt das **Element an den Anfang** der Liste hinzu (`Content` aus der Input-Box).  

### `pop()`  
Entfernt das **oberste Element** des Stacks und gibt es zurück (wird hier über das **Output-Label** dargestellt).  

Diese Funktion entspricht der offiziellen **Java-Documentation**, wo `pop()` das entfernte Element zurückgibt. In Schulen wird diese Methode oft nur zum **Entfernen** genutzt, ohne das Element zurückzugeben.  

### `peek()`  
Macht die gespeicherte Zahl, auf dem der First-Zeiger steht, in der **List-View heller**. 

In Schulen wird diese Methode oft als `top()` bezeichnet. 

### `isEmpty()`  
Gibt `true` zurück, wenn die Liste **leer** ist.  

---

Diese **Stack-List Visualisierung** bietet eine intuitive Möglichkeit, das Verhalten einer **Kellerspeicher-Liste** zu verstehen und zu testen. 

---

# **Stack List Visualizer (English)**  

A visualization tool for stack lists, programmed in **Java** with **JavaFX**.  

## **Features**  

- **Pointer visualization**: Displays the **First** pointer.  
- **No visible values in the nodes**: Values at the First pointer become fully visible only when `peek()` is called.  
- **Predefined test list**: A prebuilt list can be used and modified.  
- **Creation of new lists**:  
  - Empty list  
  - List with an initial element  
- **Method names as button labels**: Buttons are named exactly like the methods from the official **Java Documentation** for stacks.  

  One exception is the method **`top()`**, which is commonly used in schools. In this visualizer, it follows the official Java convention and is therefore labeled as **`peek()`**.  
- **Input via input box**: Values are taken from the input box.  
- **Customizable display** in the `Main` class:  
  - **Window size**  
  - **Font and font size**  
  - **Arrow colors**  
- **Integer list**: By default, numbers are **limited to 3 digits** (customizable in `Main`).  
- **Null pointer**: The last element in the stack points to nothing in this visualization. This is **not a bug** but is meant to illustrate that the element **does not know** it is the last one and therefore points to `null`.  

## **Methods**  

### `push(Content)`  
Adds the **element to the beginning** of the list (`Content` from the input box).  

### `pop()`  
Removes the **top element** of the stack and returns it (displayed via the **output label**).  

This function follows the official **Java Documentation**, where `pop()` returns the removed element. In schools, this method is often used only for **removal**, without returning the element.  

### `peek()`  
Highlights the stored number at the **First pointer** in the list view.  

In schools, this method is often called `top()`.  

### `isEmpty()`  
Returns `true` if the list is **empty**.  

---

This **Stack List Visualization** provides an intuitive way to understand and test the behavior of a **stack list**.  

---

# **Example Pictures (Beispiel Bilder)**  

(Coming soon)
