package HW1;

import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.util.ArrayList;

public class LoginView  {
    private PatientOptions options;
    private ArrayList<String> ArrayList = ReceptionistView.getArrayListofIDS();
	private ArrayList<Patient> patientList = ReceptionistView.getArrayList();
    Patient patientFound = null;
	private HW1 mainApp;

    public LoginView(HW1 mainApp) {
        // Initialize the patient view
        this.mainApp = mainApp;

        options = new PatientOptions();
    }

    public void display(Stage primaryStage) {
    	
        primaryStage.setTitle("Login");
        

        VBox root = new VBox(10);
        root.setPrefWidth(600);
        root.setPrefHeight(500);
        root.setStyle("-fx-padding: 24px");

        Label titleLabel = new Label("Patient Login");
        Label idLabel = new Label("Patient ID:");
        TextField idField = new TextField();
        Button loginButton = new Button("Login");
        
        Button back = new Button("Back");

        loginButton.setOnAction(event -> {
            String enteredID = idField.getText();
            if (isValidID(enteredID)) {
                
                String id = enteredID;

                for (Patient patient : patientList) {
                    if (patient.getID().equals(id)) {
                        patientFound = patient;
                        break; 
                    }
                }

                if (patientFound != null) {
        
                	options.start(primaryStage,patientFound);
                } else {
                    System.out.println("CT Scan Report not Available. Please try again.");
                }
            } else {
                System.out.println("Error: Patient information not found.");
            }
        });
        
        back.setOnAction(event -> mainApp.showMainView());

        root.getChildren().addAll(titleLabel, idLabel, idField, loginButton, back);

        Scene scene = new Scene(root);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private boolean isValidID(String patientID) {
        patientID = patientID.trim();

        String id = patientID;
        
        return ArrayList.contains(id);
    }

}