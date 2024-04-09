package gui;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class Main extends Application {

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

        // Add text "Welcome" inside the black box
        Text welcomeText = new Text("Welcome!");
        welcomeText.setFill(Color.WHITE);
        welcomeText.setFont(Font.font("Arial", 17)); // Set font size

        // Adjusting the vertical position of the welcome text within the black box
        welcomeText.setTranslateY(-250); // Adjust the value (-20 in this case) to move the text up or down as needed

        // Adding a thin white line inside the black box
        Rectangle whiteLine = new Rectangle(boxWidth, 1);
        whiteLine.setFill(Color.WHITE);

        // Positioning the white line vertically in the middle of the black box
        whiteLine.setTranslateY(-233); // Assuming the height of the black box is 550, this positions the line in the middle

        // Add text "Please select your role: Patient or Office staff" below the white line
        Text roleSelectionText = new Text("Please select your role:");
        roleSelectionText.setFill(Color.WHITE);
        roleSelectionText.setFont(Font.font("Arial", 20)); // Set font size

        // Positioning the role selection text below the white line
        roleSelectionText.setTranslateY(-215); // Adjust the value to move the text up or down as needed

        // Creating a ComboBox with options for Patient and Office staff
        ComboBox<String> roleComboBox = new ComboBox<>();
        roleComboBox.setItems(FXCollections.observableArrayList("Patient", "Office staff"));
        roleComboBox.setValue("Patient"); // Default selection

        // Positioning the ComboBox below the role selection text
        roleComboBox.setTranslateY(-185); // Adjust the value to move the ComboBox up or down as needed

        // Add text "Please enter your username and password" below the ComboBox
        Text credentialsText = new Text("Please enter your username and password:");
        credentialsText.setFill(Color.WHITE);
        credentialsText.setFont(Font.font("Arial", 20)); // Set font size

        // Positioning the credentials text below the ComboBox
        credentialsText.setTranslateY(-130); // Adjust the value to move the text up or down as needed

        // Creating text fields for entering username and password
        TextField usernameField = new TextField();
        usernameField.setPromptText("Username"); // Placeholder text
        usernameField.setMaxWidth(150); // Set maximum width
        TextField passwordField = new TextField();
        passwordField.setPromptText("Password"); // Placeholder text
        passwordField.setMaxWidth(150); // Set maximum width

        // Creating text labels for username and password
        Text usernameLabel = new Text("Username:");
        usernameLabel.setFill(Color.WHITE);
        usernameLabel.setFont(Font.font("Arial", 15)); // Set font size

        Text passwordLabel = new Text("Password:");
        passwordLabel.setFill(Color.WHITE);
        passwordLabel.setFont(Font.font("Arial", 15)); // Set font size

        // Positioning the text labels next to the respective text entry fields
        usernameLabel.setTranslateY(-80);
        usernameLabel.setTranslateX(-150); // Adjust the X position as needed
        passwordLabel.setTranslateY(-40);
        passwordLabel.setTranslateX(-150); // Adjust the X position as needed

        // Positioning the text fields below the credentials text
        usernameField.setTranslateY(-80);
        passwordField.setTranslateY(-40);

        // Creating a confirm button
        Button confirmButton = new Button("Confirm");
        confirmButton.setStyle("-fx-background-color: #4CAF50; -fx-text-fill: white; -fx-font-size: 14px;"); // Styling the button

        // Positioning the confirm button at the bottom of the black box
        confirmButton.setTranslateY(240); // Adjust the Y position as needed

        // Handling the confirm button action
        confirmButton.setOnAction(e -> {
            // Get the entered username and password
            String enteredUsername = usernameField.getText();
            String enteredPassword = passwordField.getText();

            // Dummy validation logic (replace this with actual validation logic)
            boolean credentialsValid = validateCredentials(enteredUsername, enteredPassword);

            if (credentialsValid) {
                // If credentials are valid, open the Doctor class popup
                Doctor.display("Doctor Portal");
            } else {
                // If credentials are invalid, show an error message (for simplicity, we'll show a popup)
                displayErrorPopup("Invalid Credentials", "Please enter valid username and password.");
            }
        });

        // Adding the black box, the text, the white line, the role selection text, the ComboBox,
        // the credentials text, the text labels, the text fields, and the confirm button to the stack pane
        root.getChildren().addAll(blackBox, welcomeText, whiteLine, roleSelectionText, roleComboBox,
                credentialsText, usernameField, passwordField,
                usernameLabel, passwordLabel, confirmButton);

        // Centering the text within the black box
        StackPane.setAlignment(welcomeText, javafx.geometry.Pos.CENTER);

        // Creating a scene with the specified dimensions and adding the stack pane to it
        Scene scene = new Scene(root, screenWidth, screenHeight);

        // Setting the scene to the stage and displaying the stage
        primaryStage.setScene(scene);
        primaryStage.setTitle("Dark Blue Background with Black Box");
        primaryStage.show();
    }

    // Method to validate credentials (dummy implementation)
    private boolean validateCredentials(String username, String password) {
        // Dummy validation logic (replace this with actual validation logic)
        return username.equals("doctor") && password.equals("password");
    }

    // Method to display error popup with given title and message
    private void displayErrorPopup(String title, String message) {
        Stage errorPopup = new Stage();

        errorPopup.initModality(Modality.APPLICATION_MODAL);
        errorPopup.setTitle(title);
        errorPopup.setMinWidth(250);

        Label label = new Label(message);

        Button closeButton = new Button("Close");
        closeButton.setOnAction(e -> errorPopup.close());

        VBox layout = new VBox(10);
        layout.getChildren().addAll(label, closeButton);
        layout.setAlignment(Pos.CENTER);

        Scene scene = new Scene(layout, 300, 150);
        errorPopup.setScene(scene);
        errorPopup.showAndWait();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
