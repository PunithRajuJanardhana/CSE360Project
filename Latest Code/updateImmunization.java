package asuHelloWorldJavaFX;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class updateImmunization extends Application {
    private TextArea immunizationTextArea;
    private TextArea Prescriptions;

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Update Immunization and Prescriptions");

        VBox patientRecordBox = createPatientRecordUI();
        
        immunizationTextArea = new TextArea();
        immunizationTextArea.setEditable(true);
        
        Prescriptions = new TextArea();
        Prescriptions.setEditable(true);
        

        // Layout for the integrated UI
        VBox root = new VBox(10);
        root.setPadding(new Insets(20));
        root.getChildren().addAll(patientRecordBox,immunizationTextArea, Prescriptions);

        // Display
        Scene scene = new Scene(root, 600, 500);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private VBox createPatientRecordUI() {
        Label patientIdLabel = new Label("Patient ID:");
        TextField patientIdField = new TextField();

        Button seeRecordButton = new Button("See Patient's Immunization Record and Prescriptions");
        seeRecordButton.setOnAction(e -> seeRecord(patientIdField.getText()));

        Button updateRecordButton = new Button("Update Patient's Immunization Record");
        updateRecordButton.setOnAction(e -> updateRecord(patientIdField.getText()));

        VBox patientRecordBox = new VBox(10);
        patientRecordBox.getChildren().addAll(patientIdLabel, patientIdField, seeRecordButton, updateRecordButton);

        return patientRecordBox;
    }
    private void seeRecord(String patientId) {
        if (!patientId.isEmpty()) {
            try {
                BufferedReader reader = new BufferedReader(new FileReader(patientId + "_immunization.txt"));
                StringBuilder recordBuilder = new StringBuilder();
                String line;
                while ((line = reader.readLine()) != null) {
                    recordBuilder.append(line).append("\n");
                }
                reader.close();
                
                // Set the content of the TextArea to the read record
                immunizationTextArea.setText(recordBuilder.toString());
            } catch (IOException e) {
                e.printStackTrace();
                immunizationTextArea.setText("Error reading immunization record for patient ID: " + patientId);
            }
            
            
            try {
                BufferedReader reader = new BufferedReader(new FileReader(patientId + "_prescriptions.txt"));
                StringBuilder recordBuilder = new StringBuilder();
                String line;
                while ((line = reader.readLine()) != null) {
                    recordBuilder.append(line).append("\n");
                }
                reader.close();
                
                // Set the content of the TextArea to the read record
                Prescriptions.setText(recordBuilder.toString());
            } catch (IOException e) {
                e.printStackTrace();
                immunizationTextArea.setText("Error reading prescriptions for patient ID: " + patientId);
            }
            
        } else {
            immunizationTextArea.setText("Please enter a patient ID.");
        }
    }


    private void updateRecord(String patientId) {
        if (!patientId.isEmpty()) {
            String immunizationContent = immunizationTextArea.getText();
            String prescriptions = Prescriptions.getText();
            try {
                FileWriter writer = new FileWriter(patientId + "_immunization.txt");
                writer.write(immunizationContent);
                writer.close();
                System.out.println("Immunization record updated successfully for patient ID: " + patientId);
            } catch (IOException e) {
                e.printStackTrace();
                System.out.println("Error updating immunization record for patient ID: " + patientId);
            }
            
            try {
                FileWriter writer = new FileWriter(patientId + "_prescriptions.txt");
                writer.write(prescriptions);
                writer.close();
                System.out.println("Prescriptions updated successfully for patient ID: " + patientId);
            } catch (IOException e) {
                e.printStackTrace();
                System.out.println("Error updating immunization record for patient ID: " + patientId);
            }
            
        } else {
            System.out.println("Please enter a patient ID.");
        }
    }

    public static void main(String[] args) {
        launch(args);
    }
}
