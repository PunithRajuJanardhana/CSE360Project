package HW1;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class updateImmunization extends Application {
    private TextArea immunizationTextArea;
    private TextArea prescriptions;
    private Stage primaryStage; 
    private TextField patientIdField;
	private ArrayList<Patient> patientList = ReceptionistView.getArrayList();
	private Patient obj = null;
	private Label pharmacyMessage;


    public updateImmunization(Stage primaryStage) {
        this.primaryStage = primaryStage;
    }

    @Override
    public void start(Stage primaryStage) {
        this.primaryStage.setTitle("Update Immunization and Prescriptions");
        
    	pharmacyMessage = new Label();


        VBox patientRecordBox = createPatientRecordUI();

        immunizationTextArea = new TextArea();
        immunizationTextArea.setEditable(true);

        prescriptions = new TextArea();
        prescriptions.setEditable(true);

        Button backButton = new Button("Back");
        backButton.setOnAction(e -> goBack());

        Button sendPrescription = new Button("Send prescription to Pharmacy");
        sendPrescription.setOnAction(e -> sendPrescriptionToPharmacy());

        // Layout for the integrated UI
        VBox root = new VBox(10);
        root.setPadding(new Insets(20));
        root.getChildren().addAll(patientRecordBox, sendPrescription, immunizationTextArea, prescriptions, backButton, pharmacyMessage);

        // Display
        Scene scene = new Scene(root, 600, 500);
        this.primaryStage.setScene(scene);
        this.primaryStage.show();
    }

    private VBox createPatientRecordUI() {
        Label patientIdLabel = new Label("Patient ID:");
        patientIdField = new TextField(); // Initialize the class-level patientIdField here

        Button seeRecordButton = new Button("See Patient's Immunization Record and Prescriptions");
        seeRecordButton.setOnAction(e -> seeRecord(patientIdField.getText()));

        Button updateRecordButton = new Button("Update Patient's Immunization Record and Prescriptions");
        updateRecordButton.setOnAction(e -> updateRecord(patientIdField.getText()));

        VBox patientRecordBox = new VBox(10);
        patientRecordBox.getChildren().addAll(patientIdLabel, patientIdField, seeRecordButton, updateRecordButton);

        return patientRecordBox;
    }


    private void seeRecord(String patientId) {
        if (!patientId.isEmpty()) {
            try {
                // Read immunization record
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
                // Read prescriptions
                BufferedReader reader = new BufferedReader(new FileReader(patientId + "_prescriptions.txt"));
                StringBuilder recordBuilder = new StringBuilder();
                String line;
                while ((line = reader.readLine()) != null) {
                    recordBuilder.append(line).append("\n");
                }
                reader.close();

                // Set the content of the TextArea to the read record
                prescriptions.setText(recordBuilder.toString());
            } catch (IOException e) {
                e.printStackTrace();
                prescriptions.setText("Error reading prescriptions for patient ID: " + patientId);
            }
        } else {
            immunizationTextArea.setText("Please enter a patient ID.");
        }
    }

    private void updateRecord(String patientId) {
        if (!patientId.isEmpty()) {
            String immunizationContent = immunizationTextArea.getText();
            String prescriptionsContent = prescriptions.getText();
            try {
                // Update immunization record
                FileWriter writer = new FileWriter(patientId + "_immunization.txt");
                writer.write(immunizationContent);
                writer.close();
                System.out.println("Immunization record updated successfully for patient ID: " + patientId);
            } catch (IOException e) {
                e.printStackTrace();
                System.out.println("Error updating immunization record for patient ID: " + patientId);
            }

            try {
                // Update prescriptions
                FileWriter writer = new FileWriter(patientId + "_prescriptions.txt");
                writer.write(prescriptionsContent);
                writer.close();
                System.out.println("Prescriptions updated successfully for patient ID: " + patientId);
            } catch (IOException e) {
                e.printStackTrace();
                System.out.println("Error updating prescriptions for patient ID: " + patientId);
            }
        } else {
            System.out.println("Please enter a patient ID.");
        }
    }

    private void sendPrescriptionToPharmacy() {
    	
    	for(int i = 0;i<patientList.size();i++) {
    		if(patientList.get(i).getID().equals(patientIdField.getText())){
    			 obj = patientList.get(i);
    		}
    		
    	}
    	if(obj == null) {
    		 pharmacyMessage.setText("Patiend ID does not exist");
    	}
    	else {
        String pharmacyFileName = obj.getFirstName() + "_"+ obj.getPharmacy()+".txt";
        String prescriptionsContent = prescriptions.getText();

        try {
            FileWriter writer = new FileWriter(pharmacyFileName);
            writer.write("Patient name: " + obj.getFirstName() + " " + obj.getLastName() + "\n");
            writer.write("Pharmacy: " + obj.getPharmacy() + "\n");
            writer.write(prescriptionsContent);
            writer.close();
            pharmacyMessage.setText("Prescriptions sent to pharmacy successfully.");
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("Error sending prescriptions to pharmacy.");
        }
     }
    }
    private void goBack() {
        HW1 mainApp = new HW1();
        mainApp.start(primaryStage);
    }

    public static void main(String[] args) {
        launch(args);
    }
}
