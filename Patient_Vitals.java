package gui;


import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class Patient_Vitals {

    public static void display(String title) {
        Stage window = new Stage();

        // Creating a stack pane to hold elements
        StackPane root = new StackPane();

        // Setting the background color to dark blue with gradient
        root.setStyle("-fx-background-color: linear-gradient(to bottom, #265B78, #0D1C2B);");

        // Creating a black box with a white border
        double boxWidth = 600; // Adjusted width
        double boxHeight = 600; // Adjusted height
        Rectangle blackBox = new Rectangle(boxWidth, boxHeight);
        blackBox.setFill(Color.BLACK);
        blackBox.setStroke(Color.WHITE);
        blackBox.setStrokeWidth(1);

        // Add welcome message at the top
        Text welcomeText = new Text("Please fill out the following fields for the patient's visit");
        welcomeText.setFill(Color.WHITE);
        welcomeText.setFont(Font.font("Arial", 20));

        // Creating labels and text fields
        Label firstNameLabel = new Label("Patient's First Name:");
        firstNameLabel.setTextFill(Color.WHITE); // Setting font color to white
        TextField firstNameField = new TextField();

        Label lastNameLabel = new Label("Patient's Last Name:");
        lastNameLabel.setTextFill(Color.WHITE); // Setting font color to white
        TextField lastNameField = new TextField();

        Label birthdayLabel = new Label("Patient's Birthday:");
        birthdayLabel.setTextFill(Color.WHITE); // Setting font color to white
        ComboBox<String> dayComboBox = new ComboBox<>();
        for (int i = 1; i <= 31; i++) {
            dayComboBox.getItems().add(String.valueOf(i));
        }
        ComboBox<String> monthComboBox = new ComboBox<>();
        monthComboBox.getItems().addAll("January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December");
        ComboBox<String> yearComboBox = new ComboBox<>();
        for (int i = 1900; i <= 2025; i++) {
            yearComboBox.getItems().add(String.valueOf(i));
        }

        Label weightLabel = new Label("Patient's Weight:");
        weightLabel.setTextFill(Color.WHITE); // Setting font color to white
        TextField weightField = new TextField();

        Label heightLabel = new Label("Patient's Height:");
        heightLabel.setTextFill(Color.WHITE); // Setting font color to white
        TextField heightField = new TextField();

        Label temperatureLabel = new Label("Patient's Blood Temperature:");
        temperatureLabel.setTextFill(Color.WHITE); // Setting font color to white
        TextField temperatureField = new TextField();

        Label pressureLabel = new Label("Patient's Blood Pressure:");
        pressureLabel.setTextFill(Color.WHITE); // Setting font color to white
        TextField pressureField = new TextField();

        // Creating a GridPane to hold labels and text fields
        GridPane gridPane = new GridPane();
        gridPane.setAlignment(Pos.CENTER);
        gridPane.setHgap(10);
        gridPane.setVgap(10);
        gridPane.setPadding(new Insets(20));

        // Adding labels and text fields to the GridPane
        gridPane.add(firstNameLabel, 0, 0);
        gridPane.add(firstNameField, 1, 0);
        gridPane.add(lastNameLabel, 0, 1);
        gridPane.add(lastNameField, 1, 1);
        gridPane.add(birthdayLabel, 0, 2);
        gridPane.add(dayComboBox, 1, 2);
        gridPane.add(monthComboBox, 2, 2);
        gridPane.add(yearComboBox, 3, 2);
        gridPane.add(weightLabel, 0, 3);
        gridPane.add(weightField, 1, 3);
        gridPane.add(heightLabel, 0, 4);
        gridPane.add(heightField, 1, 4);
        gridPane.add(temperatureLabel, 0, 5);
        gridPane.add(temperatureField, 1, 5);
        gridPane.add(pressureLabel, 0, 6);
        gridPane.add(pressureField, 1, 6);

        // Creating a back button
        Button backButton = new Button("Back");
        backButton.setOnAction(e -> window.close());

        // Creating a confirm button
        Button confirmButton = new Button("Confirm");
        confirmButton.setOnAction(e -> {
            // Add functionality to create visit and pass data
            window.close();
        });

        // Creating a VBox to hold buttons
        VBox buttonsVBox = new VBox(10);
        buttonsVBox.setAlignment(Pos.BOTTOM_RIGHT);
        buttonsVBox.setPadding(new Insets(20));
        buttonsVBox.getChildren().addAll(backButton, confirmButton);

        // Adding elements to the stack pane
        root.getChildren().addAll(blackBox, welcomeText, gridPane, buttonsVBox);

        // Centering text within the black box
        StackPane.setAlignment(welcomeText, Pos.TOP_CENTER);

        // Creating a scene with specified dimensions and adding the stack pane to it
        Scene scene = new Scene(root, boxWidth, boxHeight);

        // Setting the scene to the stage and displaying the stage
        window.setScene(scene);
        window.setTitle(title);
        window.showAndWait(); // Display window and wait for it to be closed
    }
}
