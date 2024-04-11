package HW1;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Font;
import javafx.stage.Stage;

import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import javafx.geometry.HPos;

public class NurseView extends GridPane {

    private Label submittedVitalsLabel;

    public NurseView() {
        setPadding(new Insets(20));
        setHgap(10);
        setVgap(10);
        setAlignment(Pos.CENTER);

        Label PatientID = new Label("Enter patient ID: ");
        TextField PatientIDText = new TextField();      
        
        Label titleLabel = new Label("Patient Vitals");
        titleLabel.setFont(Font.font("Arial", 20));

        Label nameLabel = new Label("Weight:");
        TextField nameTextField = new TextField();

        Label ageLabel = new Label("Height:");
        TextField ageTextField = new TextField();

        Label weightLabel = new Label("Body Temperature:");
        TextField weightTextField = new TextField();

        Label heightLabel = new Label("Blood Pressure:");
        TextField heightTextField = new TextField();

        Label bloodPressureLabel = new Label("Age:");
        TextField bloodPressureTextField = new TextField();

        Button submitButton = new Button("Submit");
        submitButton.setOnAction(e -> {
            // Retrieve the values from text fields
        	String ID = PatientIDText.getText();
        	String name = nameTextField.getText();
            String age = ageTextField.getText();
            String weight = weightTextField.getText();
            String height = heightTextField.getText();
            String bloodPressure = bloodPressureTextField.getText();

            // Format the current date
            LocalDate currentDate = LocalDate.now();
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
            String formattedDate = currentDate.format(formatter);

            // Construct the data string
            String data = "ID: " + ID + "\n Age: " + age + "\n Weight:" + weight + "\n Height: " + height
                    + "\n Blood Pressure: " + bloodPressure + "\n Date: " + formattedDate;

            // Display the submitted vitals in a single line
            submittedVitalsLabel.setText("Submitted Vitals:\n " + data);

            // Write data to a text file
            try {
                FileWriter writer = new FileWriter("patient_data.txt", true);
                writer.write(data + "\n");
                writer.close();
            } catch (IOException ex) {
                ex.printStackTrace();
            }

            // Clear text fields after submission
            nameTextField.clear();
            ageTextField.clear();
            weightTextField.clear();
            heightTextField.clear();
            bloodPressureTextField.clear();
        });

        Button backButton = new Button("Back");
        backButton.setOnAction(e -> goBackToMainView());

        submittedVitalsLabel = new Label("Submitted Vitals:\n ");
        add(titleLabel, 0, 0, 2, 1);
        add(nameLabel, 0, 1);
        add(nameTextField, 1, 1);
        add(ageLabel, 0, 2);
        add(ageTextField, 1, 2);
        add(weightLabel, 0, 3);
        add(weightTextField, 1, 3);
        add(heightLabel, 0, 4);
        add(heightTextField, 1, 4);
        add(bloodPressureLabel, 0, 5);
        add(bloodPressureTextField, 1, 5);
        add(PatientID, 0, 6);
        add(PatientIDText, 1, 6);

        // Add the submit button to the bottom of the GridPane
        add(submitButton, 0, 7);
        setHalignment(submitButton, HPos.CENTER);

        // Add the back button to the bottom of the GridPane
        add(backButton, 1, 7);
        setHalignment(backButton, HPos.CENTER);

        // Add the label to display submitted vitals
        add(submittedVitalsLabel, 0, 8, 2, 1);
    }
    
    // Method to go back to the main view
    private void goBackToMainView() {
        HW1 mainView = new HW1();
        Stage stage = (Stage) getScene().getWindow(); // Get the current stage
        mainView.start(stage);
    }
}