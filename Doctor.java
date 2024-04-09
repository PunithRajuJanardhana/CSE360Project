package gui;

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class Doctor {

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
        Text welcomeText = new Text("Welcome to Medical Professional Portal");
        welcomeText.setFill(Color.WHITE);
        welcomeText.setFont(Font.font("Arial", 20));

        // Creating buttons for different functionalities
        Button viewMessagesButton = new Button("View Messages");
        Button enterVitalsButton = new Button("Enter Patient Vitals");
        Button addRecordsButton = new Button("Add/View Patient Records");
        Button addPatientButton = new Button("Add Patient");

        // Styling buttons
        String buttonStyle = "-fx-background-color: gray; -fx-text-fill: white; -fx-font-size: 16px;";
        viewMessagesButton.setStyle(buttonStyle);
        enterVitalsButton.setStyle(buttonStyle);
        addRecordsButton.setStyle(buttonStyle);
        addPatientButton.setStyle(buttonStyle);

        // Set fixed size for buttons
        double buttonWidth = 200;
        double buttonHeight = 100;
        viewMessagesButton.setPrefWidth(buttonWidth);
        viewMessagesButton.setPrefHeight(buttonHeight);
        enterVitalsButton.setPrefWidth(buttonWidth);
        enterVitalsButton.setPrefHeight(buttonHeight);
        addRecordsButton.setPrefWidth(buttonWidth);
        addRecordsButton.setPrefHeight(buttonHeight);
        addPatientButton.setPrefWidth(buttonWidth);
        addPatientButton.setPrefHeight(buttonHeight);

        // Handling button actions
        viewMessagesButton.setOnAction(e -> {
            // Implement action to view messages
        });

        enterVitalsButton.setOnAction(e -> {
            // Display Patient Vitals view
            Patient_Vitals.display("Enter Patient Vitals");
        });

        addRecordsButton.setOnAction(e -> {
            // Display Data Entry window for adding/viewing patient records
            Data_Entry.display("Patient Records");
        });

        addPatientButton.setOnAction(e -> {
            // Implement action to add a patient
            // For simplicity, we'll just show a popup
            displayPatientPopup();
        });

        // Creating a GridPane to hold buttons
        GridPane buttonsGrid = new GridPane();
        buttonsGrid.setAlignment(Pos.CENTER);
        buttonsGrid.setHgap(10);
        buttonsGrid.setVgap(10);

        // Adding buttons to the GridPane
        buttonsGrid.add(viewMessagesButton, 0, 0);
        buttonsGrid.add(enterVitalsButton, 1, 0);
        buttonsGrid.add(addRecordsButton, 0, 1);
        buttonsGrid.add(addPatientButton, 1, 1);

        // Adding elements to the stack pane
        root.getChildren().addAll(blackBox, welcomeText, buttonsGrid);

        // Centering text within the black box
        StackPane.setAlignment(welcomeText, Pos.TOP_CENTER);

        // Creating a scene with specified dimensions and adding the stack pane to it
        Scene scene = new Scene(root, boxWidth, boxHeight);

        // Setting the scene to the stage and displaying the stage
        window.setScene(scene);
        window.setTitle(title);
        window.showAndWait(); // Display window and wait for it to be closed
    }

    // Method to display popup for adding a patient
    private static void displayPatientPopup() {
        Stage popupWindow = new Stage();

        popupWindow.initModality(Modality.APPLICATION_MODAL);
        popupWindow.setTitle("Add Patient");
        popupWindow.setMinWidth(300);

        // Creating labels and text fields for patient details
        Label firstNameLabel = new Label("First Name:");
        firstNameLabel.setTextFill(Color.WHITE);
        TextField firstNameField = new TextField();

        Label lastNameLabel = new Label("Last Name:");
        lastNameLabel.setTextFill(Color.WHITE);
        TextField lastNameField = new TextField();

        Label birthdayLabel = new Label("Birthday:");
        birthdayLabel.setTextFill(Color.WHITE);
        TextField birthdayField = new TextField();

        Label insuranceLabel = new Label("Insurance Provider:");
        insuranceLabel.setTextFill(Color.WHITE);
        TextField insuranceField = new TextField();

        Label pharmacyLabel = new Label("Best Pharmacy:");
        pharmacyLabel.setTextFill(Color.WHITE);
        TextField pharmacyField = new TextField();

        // Creating a grid pane layout to hold labels and text fields
        GridPane layout = new GridPane();
        layout.setAlignment(Pos.CENTER);
        layout.setHgap(10);
        layout.setVgap(10);

        // Adding labels and text fields to the grid pane
        layout.add(firstNameLabel, 0, 0);
        layout.add(firstNameField, 1, 0);
        layout.add(lastNameLabel, 0, 1);
        layout.add(lastNameField, 1, 1);
        layout.add(birthdayLabel, 0, 2);
        layout.add(birthdayField, 1, 2);
        layout.add(insuranceLabel, 0, 3);
        layout.add(insuranceField, 1, 3);
        layout.add(pharmacyLabel, 0, 4);
        layout.add(pharmacyField, 1, 4);

        // Creating a button to submit patient details
        Button submitButton = new Button("Submit");
        submitButton.setOnAction(e -> {
            // Retrieve patient details and do something with them
            String firstName = firstNameField.getText();
            String lastName = lastNameField.getText();
            String birthday = birthdayField.getText();
            String insuranceProvider = insuranceField.getText();
            String pharmacy = pharmacyField.getText();

            // Here you can do something with the retrieved patient details,
            // such as adding them to a database or displaying them elsewhere

            // For demonstration, let's just print the details
            System.out.println("First Name: " + firstName);
            System.out.println("Last Name: " + lastName);
            System.out.println("Birthday: " + birthday);
            System.out.println("Insurance Provider: " + insuranceProvider);
            System.out.println("Best Pharmacy: " + pharmacy);

            // Close the popup window
            popupWindow.close();
        });

        // Adding the submit button to the grid pane
        layout.add(submitButton, 1, 5);

        // Setting background color
        layout.setStyle("-fx-background-color: linear-gradient(to bottom, #265B78, #0D1C2B);");

        Scene scene = new Scene(layout, 400, 300);
        popupWindow.setScene(scene);
        popupWindow.showAndWait();
    }
}
