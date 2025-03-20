module de.dennis.slvisualizer {
    requires javafx.controls;
    requires javafx.fxml;

    opens de.dennis.slvisualizer to javafx.fxml;
    exports de.dennis.slvisualizer;
}