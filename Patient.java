package asuHelloWorldJavaFX;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class Patient extends Application {

    // Text displaying patient information
    private Text patientInfoText;
    private TextArea editTextArea;
    private Button backButton;
    private Button doneButton;
    private boolean editMode = false;

    @Override
    public void start(Stage primaryStage) {
        // Creating a stack pane to hold our elements
        StackPane root = new StackPane();

        // Setting the background color to dark blue with gradient
        root.setStyle("-fx-background-color: linear-gradient(to bottom, #265B78, #0D1C2B);");

        // Creating a black box with a white border
        double screenWidth = 700; // Adjust this according to your screen size
        double screenHeight = 700; // Adjust this according to your screen size
        double boxWidth = screenWidth * 0.75; // 75% of the screen width
        double boxHeight = 550; // Increased height for the black box
        Rectangle blackBox = new Rectangle(boxWidth, boxHeight);
        blackBox.setFill(Color.BLACK);
        blackBox.setStroke(Color.WHITE);
        blackBox.setStrokeWidth(1); // Very thin white border

        // Adding the black box to the stack pane
        root.getChildren().add(blackBox);

        // Initialize patient information text
        patientInfoText = new Text("Patient Information:\n\nFirst Name: John\n\nLast Name: Doe\n\nContact Information: 123-456-7890\n\nInsurance: XYZ Insurance\n\nPharmacy: ABC Pharmacy");
        patientInfoText.setFill(Color.WHITE);
        patientInfoText.setFont(Font.font("Arial", 20));

        // Positioning the patient information text within the black box
        StackPane.setAlignment(patientInfoText, javafx.geometry.Pos.CENTER);
        patientInfoText.setTranslateX(-100); // Adjust the X position as needed (positive for right, negative for left)
        patientInfoText.setTranslateY(-145); // Adjust the Y position as needed

        // Adding the patient information text to the stack pane
        root.getChildren().add(patientInfoText);

        // Creating a line gap after the patient information
        Text lineGap = new Text("\n");
        root.getChildren().add(lineGap);

        // Creating an edit text area for editing patient information
        editTextArea = new TextArea();
        editTextArea.setPrefSize(boxWidth * 0.7, boxHeight * 0.7); // 70% of box width and height
        editTextArea.setVisible(false); // Initially hidden

        // Positioning the edit text area within the black box
        StackPane.setAlignment(editTextArea, javafx.geometry.Pos.CENTER);

        // Adding the edit text area to the stack pane
        root.getChildren().add(editTextArea);

        // Creating a done button
        doneButton = new Button("Done");
        doneButton.setStyle("-fx-background-color: #333333; -fx-text-fill: white; -fx-font-size: 14px;"); // Styling the button

        // Positioning the done button at the bottom of the page
        doneButton.setTranslateY((screenHeight / 2 - boxHeight / 2) + 260); // Adjust the Y position as needed
        doneButton.setVisible(false); // Initially hidden

        // Adding event handler for the done button
        doneButton.setOnAction(event -> {
            // Update patient information text with edited information
            String editedText = editTextArea.getText();
            patientInfoText.setText("Patient Information:\n\n" + editedText);
            
            // Hide edit text area and show patient information text
            editTextArea.setVisible(false);
            patientInfoText.setVisible(true);
            
            // Show back button
            backButton.setVisible(true);
            
            // Hide done button
            doneButton.setVisible(false);
            
            // Toggle edit mode off
            editMode = false;
        });

        // Adding the done button to the stack pane
        root.getChildren().add(doneButton);

        // Creating a back button
        backButton = new Button("Back");
        backButton.setStyle("-fx-background-color: #333333; -fx-text-fill: white; -fx-font-size: 14px;"); // Styling the button

        // Positioning the back button at the top left corner
        backButton.setTranslateX(-(screenWidth / 2 - boxWidth / 2) + -235); // Adjust the X position as needed
        backButton.setTranslateY(-(screenHeight / 2 - boxHeight / 2) + -260); // Adjust the Y position as needed
        backButton.setVisible(false); // Initially hidden

        // Adding event handler for the back button
        backButton.setOnAction(event -> {
            if (editMode) {
                // Show patient information text and hide edit text area
                patientInfoText.setVisible(true);
                editTextArea.setVisible(false);
                // Show back button
                backButton.setVisible(true);
                // Hide done button
                doneButton.setVisible(false);
                // Toggle edit mode off
                editMode = false;
            }
        });

        // Adding the back button to the stack pane
        root.getChildren().add(backButton);

        // Creating an edit button
        Button editButton = new Button("Edit");
        editButton.setStyle("-fx-background-color: #333333; -fx-text-fill: white; -fx-font-size: 14px;"); // Styling the button

        // Positioning the edit button at the bottom of the page
        editButton.setTranslateY((screenHeight / 2 - boxHeight / 2) + 260); // Adjust the Y position as needed

        // Adding event handler for the edit button
        editButton.setOnAction(event -> {
            // Toggle edit mode
            editMode = !editMode;
            if (editMode) {
                // Show edit text area and hide patient information text
                editTextArea.setText(patientInfoText.getText());
                editTextArea.setVisible(true);
                patientInfoText.setVisible(false);
                // Hide back button
                backButton.setVisible(false);
                // Show done button
                doneButton.setVisible(true);
            } else {
                // Show patient information text and hide edit text area
                patientInfoText.setVisible(true);
                editTextArea.setVisible(false);
                // Show back button
                backButton.setVisible(true);
                // Hide done button
                doneButton.setVisible(false);
            }
        });

        // Adding the edit button to the stack pane
        root.getChildren().add(editButton);

        // Creating a scene with the specified dimensions and adding the stack pane to it
        Scene scene = new Scene(root, screenWidth, screenHeight);

        // Setting the scene to the stage and displaying the stage
        primaryStage.setScene(scene);
        primaryStage.setTitle("Dark Blue Background with Black Box (With Patient Information)");
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
