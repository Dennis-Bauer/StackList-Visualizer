package de.dennis.qlvisualizer;

import de.dennis.qlvisualizer.Panes.StartScreen;
import de.dennis.qlvisualizer.Utilities.ConsoleUtilities;
import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.TextAlignment;
import javafx.stage.Stage;

import static de.dennis.qlvisualizer.Utilities.JavaFXConstructorUtilities.*;
import static de.dennis.qlvisualizer.Utilities.JavaUtilities.isStringInt;

public class Main extends Application {

    public static final double WINDOW_WIDTH = 800;
    public static final double WINDOW_HEIGHT = 600;
    public static final String TEXT_FONT = "Arial";
    public static final double FONT_SIZE = (WINDOW_HEIGHT + WINDOW_WIDTH) * 0.015;

    // Debug/Variables
    public static final int MAX_INPUT_LENGTH = 3;
    public static final Color FIRST_LAST_ARROW_COLOR = Color.BLUE; // Default: BLUE
    public static final Color CONTENT_COLOR_CURRENT = Color.GRAY; // Default: GRAY
    public static final Color CONTENT_COLOR_GOT = Color.WHITE; // Default: WHITE
    public static final Color CONTENT_COLOR_NOTHING = Color.BLACK; // Default: BLACK

    private static Scene primaryScene;

    @Override
    public void start(Stage stage) {

        primaryScene = new Scene(new StartScreen(), WINDOW_WIDTH, WINDOW_HEIGHT);

        stage.setTitle("QueueList-Visualizer");
        stage.setScene(primaryScene);
        stage.show();
        ConsoleUtilities.consoleOutPutLine(ConsoleUtilities.colors.GREEN, ConsoleUtilities.textStyle.REGULAR, "Application started successfully.");
    }

    private static Queue primaryList;

    public static void createPreList() {
        createListView(2, true);

        for (int i = 0; i < 8; i++)
            primaryList.add(new ListElement((i * 2) + 3));
    }

    public static void createListView(int i, boolean createWithElement) {

        if (createWithElement) primaryList = new Queue(new ListElement(i));
        else primaryList = new Queue();

        // Input Box
        VBox inputBoxPane = new VBox();
        inputBoxPane.setAlignment(Pos.CENTER);

        Label inputBoxHeader = buildLabel("inputBox_Header", "Input", Font.font(TEXT_FONT, FontWeight.EXTRA_BOLD, FONT_SIZE * 1.5), TextAlignment.CENTER, Color.BLACK);
        TextField inputBox = buildTextField("inputListWithElement", "int", WINDOW_WIDTH * 0.31, WINDOW_HEIGHT * 0.125);
        inputBox.setAlignment(Pos.CENTER);
        inputBox.setMaxWidth(WINDOW_WIDTH * 0.31);
        inputBox.setText("1");

        inputBoxPane.getChildren().addAll(inputBoxHeader, inputBox);

        // Output Label
        Rectangle outPutBackground = buildRectangle("outputLabel_Background", WINDOW_WIDTH * 0.32, WINDOW_HEIGHT * 0.08, Color.WHITE, false, null, 0);
        Label outputLabel = buildLabel("outputLabel", "Output: ___", Font.font(TEXT_FONT, FontWeight.EXTRA_BOLD, FONT_SIZE * 1.5), TextAlignment.CENTER, Color.BLACK);

        StackPane outputPane = new StackPane(outPutBackground, outputLabel);

        // Buttons
        Button addButton = createStandardButton("enqueue(Content)"); // Here I use the term 'enqueue' because that's how it's written in the doc. To make it easier to read I use 'add', that is exactly what it does.
        Button removeButton = createStandardButton("dequeue()"); // Here I use the term 'dequeue' because that's how it's written in the doc. To make it easier to read I use 'remove', that is exactly what it does.
        Button isEmptyButton = createStandardButton("isEmpty()");
        Button frontButton = createStandardButton("front()");

        // Actions
        frontButton.setOnMouseClicked(_ -> primaryList.front());
        removeButton.setOnMouseClicked(_ -> primaryList.remove());
        isEmptyButton.setOnMouseClicked(_ -> {
            if (primaryList.isEmpty()) {
                outputLabel.setText("Output: true");
                outputLabel.setTextFill(Color.GREEN);
            } else {
                outputLabel.setText("Output: false");
                outputLabel.setTextFill(Color.RED);
            }
        });

        // With input
        addButton.setOnMouseClicked(_ -> {
            if (!inputBox.getText().isEmpty() && isStringInt(inputBox.getText()) && inputBox.getText().length() <= Main.MAX_INPUT_LENGTH)
                primaryList.add(new ListElement(Integer.parseInt(inputBox.getText())));
        });

        double buttonSpacing = WINDOW_HEIGHT * 0.01;
        HBox buttonPane = new HBox(buttonSpacing,
                new VBox(buttonSpacing,
                        addButton,
                        removeButton
                ),
                new VBox(buttonSpacing,
                        isEmptyButton,
                        frontButton
                )
        );

        buttonPane.setAlignment(Pos.CENTER);

        primaryScene.setRoot(new VBox(WINDOW_HEIGHT * 0.02,
                primaryList,
                buttonPane,
                outputPane,
                inputBoxPane
        ));
    }

    private static Button createStandardButton(String text) {
        return buildButton("listControlButton", text, WINDOW_WIDTH * 0.32, WINDOW_HEIGHT * 0.08, Font.font(TEXT_FONT, FontWeight.BOLD, FONT_SIZE));
    }


    public static void main(String[] args) {
        ConsoleUtilities.consoleOutPutLine(ConsoleUtilities.colors.GREEN, ConsoleUtilities.textStyle.REGULAR, "Program started. Attempting to launch the application...");
        launch();
        ConsoleUtilities.consoleOutPutLine(ConsoleUtilities.colors.RED, ConsoleUtilities.textStyle.REGULAR, "The program was terminated.");
    }
}