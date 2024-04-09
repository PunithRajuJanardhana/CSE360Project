package gui;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class Data_Entry {

    public static void display(String title) {
        Stage window = new Stage();

        // Creating a stack pane to hold elements
        StackPane root = new StackPane();

        // Setting the background color to dark blue with gradient
        root.setStyle("-fx-background-color: linear-gradient(to bottom, #265B78, #0D1C2B);");

        // Creating a black box with a white border
        double boxWidth = 700; // Adjusted width
        double boxHeight = 700; // Adjusted height
        Rectangle blackBox = new Rectangle(boxWidth, boxHeight);
        blackBox.setFill(Color.BLACK);
        blackBox.setStroke(Color.WHITE);
        blackBox.setStrokeWidth(1);

        // Add welcome message at the top
        Text welcomeText = new Text("Data Entry / History Page");
        welcomeText.setFill(Color.WHITE);
        welcomeText.setFont(Font.font("Arial", 20));

        // Creating buttons for different functionalities
        Button immunizationRecordsButton = new Button("Immunization Records");
        Button prescribedMedicationsButton = new Button("Prescribed Medications");
        Button patientVitalsButton = new Button("Patient Vitals");
        Button pastVisitsButton = new Button("Past Visits");
        Button backButton = new Button("Back");

        // Styling buttons
        String buttonStyle = "-fx-background-color: gray; -fx-text-fill: white; -fx-font-size: 16px;";
        immunizationRecordsButton.setStyle(buttonStyle);
        prescribedMedicationsButton.setStyle(buttonStyle);
        patientVitalsButton.setStyle(buttonStyle);
        pastVisitsButton.setStyle(buttonStyle);
        backButton.setStyle(buttonStyle);

        // Set fixed size for buttons except back button
        double buttonWidth = 200; // Matched with Doctor class
        double buttonHeight = 100; // Matched with Doctor class
        immunizationRecordsButton.setPrefWidth(buttonWidth);
        immunizationRecordsButton.setPrefHeight(buttonHeight);
        prescribedMedicationsButton.setPrefWidth(buttonWidth);
        prescribedMedicationsButton.setPrefHeight(buttonHeight);
        patientVitalsButton.setPrefWidth(buttonWidth);
        patientVitalsButton.setPrefHeight(buttonHeight);
        pastVisitsButton.setPrefWidth(buttonWidth);
        pastVisitsButton.setPrefHeight(buttonHeight);

        // Handling button actions
        immunizationRecordsButton.setOnAction(e -> {
            // Implement action to view immunization records
        });

        prescribedMedicationsButton.setOnAction(e -> {
            // Implement action to view prescribed medications
        });

        patientVitalsButton.setOnAction(e -> {
            // Implement action to view patient vitals
        });

        pastVisitsButton.setOnAction(e -> {
            // Implement action to view past visits
        });

        backButton.setOnAction(e -> {
            window.close(); // Close the window when back button is clicked
        });

        // Creating a GridPane to hold buttons
        GridPane buttonsGrid = new GridPane();
        buttonsGrid.setAlignment(Pos.CENTER);
        buttonsGrid.setHgap(10);
        buttonsGrid.setVgap(10);

        // Adding buttons to the GridPane
        buttonsGrid.add(immunizationRecordsButton, 0, 0);
        buttonsGrid.add(prescribedMedicationsButton, 1, 0);
        buttonsGrid.add(patientVitalsButton, 0, 1);
        buttonsGrid.add(pastVisitsButton, 1, 1);

        // Adding elements to the stack pane
        root.getChildren().addAll(blackBox, welcomeText, buttonsGrid, backButton);

        // Centering text within the black box
        StackPane.setAlignment(welcomeText, Pos.TOP_CENTER);
        StackPane.setAlignment(backButton, Pos.TOP_LEFT); // Adjust position to top left
        StackPane.setMargin(backButton, new Insets(20, 0, 0, 20)); // Move button downwards

        // Set different size for the back button
        double backButtonWidth = 100;
        double backButtonHeight = 50;
        backButton.setPrefWidth(backButtonWidth);
        backButton.setPrefHeight(backButtonHeight);

        // Creating a scene with specified dimensions and adding the stack pane to it
        Scene scene = new Scene(root, boxWidth, boxHeight);

        // Setting the scene to the stage and displaying the stage
        window.setScene(scene);
        window.setTitle(title);
        window.showAndWait(); // Display window and wait for it to be closed
    }
}
