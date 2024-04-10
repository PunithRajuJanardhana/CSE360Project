package asuHelloWorldJavaFX;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;


public class ReceptionistView extends Application {

    private Label lastPatientIdLabel = new Label(""); // Label to display the last generated patient ID
    

    public static ArrayList<String> patiendIDs = new ArrayList<>();
    public static ArrayList<Patient> patientList = new ArrayList<>();
    private static Patient a;
    private static int b;
    

    private static TextField firstNameTextField,lastNameTextField,birthDayField, pharmacyName
    ,phoneTextField,healthHistoryTextField,insuranceIDTextField;


    public void start(Stage primaryStage, Patient obj) {
    	if(obj ==null) {
    		a = new Patient();
    		b = 1;
    	}
    	else {
    		a = obj;
    		b = 0;
    	}
        VBox vbox = new VBox(10);
        vbox.setAlignment(Pos.TOP_CENTER);
        vbox.setPadding(new Insets(20, 50, 20, 50));

        Label titleLabel = new Label("Patient Intake Form");
        titleLabel.setStyle("-fx-font-size: 20px; -fx-font-weight: bold;");

        // Create and configure the grid pane for form inputs
        GridPane grid = new GridPane();
        grid.setAlignment(Pos.CENTER);
        grid.setVgap(10);
        grid.setHgap(20);
        grid.setPadding(new Insets(20, 20, 20, 20));

        // Form fields
        firstNameTextField = new TextField();
        lastNameTextField = new TextField();
        birthDayField = new TextField();
        pharmacyName = new TextField();
         phoneTextField = new TextField();
         healthHistoryTextField = new TextField();
         insuranceIDTextField = new TextField();

        // Populate the grid with labels and corresponding text fields
        grid.add(new Label("First Name:"), 0, 0);
        grid.add(firstNameTextField, 1, 0);
        grid.add(new Label("Last Name:"), 0, 1);
        grid.add(lastNameTextField, 1, 1);
        grid.add(new Label("BirthDay:"), 0, 2);
        grid.add(birthDayField, 1, 2);
        grid.add(new Label("Phone Number:"), 0, 3);
        grid.add(phoneTextField, 1, 3);
        grid.add(new Label("Health History:"), 0, 4);
        grid.add(healthHistoryTextField, 1, 4);
        grid.add(new Label("Insurance ID:"), 0, 5);
        grid.add(insuranceIDTextField, 1, 5);
        grid.add(new Label("Pharmacy: "), 0, 6);
        grid.add(pharmacyName, 1, 6);


        // Create the save button with an event handler to save patient data and update the patient ID label
        Button saveButton = new Button("Save");
        saveButton.setStyle("-fx-background-color: #0000FF; -fx-text-fill: white;");
        saveButton.setMinWidth(100);
        
        saveButton.setOnAction(e -> {
            String patientID;
            if (b == 1) {
                patientID = generatePatientID();
                savePatientData(patientID,firstNameTextField.getText(),
                		lastNameTextField.getText(),birthDayField.getText(),
                		phoneTextField.getText(),healthHistoryTextField.getText(),
                		insuranceIDTextField.getText(),pharmacyName.getText());
                lastPatientIdLabel.setText("Account created successfully. Patient id: "+ patientID);
            } else {
                patientID = a.getID();
            

            try (BufferedWriter writer = new BufferedWriter(new FileWriter(patientID + "_PatientInfo.txt"))) {
                writer.write("Patient ID: " + patientID + "\n");
                writer.write("First Name: " + firstNameTextField.getText() + "\n");
                writer.write("Last Name: " + lastNameTextField.getText() + "\n");
                writer.write("Birthday: " + birthDayField.getText() + "\n");
                writer.write("Phone: " + phoneTextField.getText() + "\n");
                writer.write("Health History: " + healthHistoryTextField.getText() + "\n");
                writer.write("Insurance ID: " + insuranceIDTextField.getText() + "\n");
                writer.write("Pharmacy: " + pharmacyName.getText() + "\n");


                lastPatientIdLabel.setText("Information Saved Successfully");
            } catch (IOException ex) {
                showAlert(Alert.AlertType.ERROR, "Error", "An error occurred while saving the data.");
                ex.printStackTrace();
            }
            }
           
        });
        
        Button backButton = new Button("Back");
        backButton.setStyle("-fx-background-color: #0000FF; -fx-text-fill: white;");
        backButton.setMinWidth(100);
        backButton.setOnAction(event -> {
            Stage stage = (Stage) backButton.getScene().getWindow();
            ASUHelloWorldJavaFX mainApp = new ASUHelloWorldJavaFX();
            try {
                mainApp.start(stage); // Call the start method of ASUHelloWorldJavaFX with the existing stage
            } catch (Exception e) {
                e.printStackTrace();
            }
        });

        // Initialize the label for displaying the last generated patient ID
        lastPatientIdLabel.setStyle("-fx-font-size: 14px;");

        vbox.getChildren().addAll(titleLabel, grid, saveButton, backButton,lastPatientIdLabel);
        Scene scene = new Scene(vbox, 600, 500);
               
        
       

        
        primaryStage.setScene(scene);
        primaryStage.setTitle("Patient Intake Form");
        primaryStage.show();
    }

    private void showAlert(Alert.AlertType alertType, String title, String content) {
        Alert alert = new Alert(alertType);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(content);
        alert.showAndWait();
    }


	private String generatePatientID() {
		String a = firstNameTextField.getText().substring(0, 3);
		String b = a +  lastNameTextField.getText().substring(0, 3);
		String c = b + birthDayField.getText().substring(0, 2);
		patiendIDs.add(c);
		return c;
    }

	private void savePatientData(String patientId, String firstName, String lastName, String bday, String phone, String healthHistory, String insuranceID, String pharmacy) {
	    if (patientId.isEmpty() || firstName.isEmpty() || lastName.isEmpty() || bday.isEmpty() || phone.isEmpty() || healthHistory.isEmpty() || insuranceID.isEmpty() || pharmacy.isEmpty()) {
	        showAlert(Alert.AlertType.ERROR, "Error", "All fields must be filled out.");
	    } else {
	        try (BufferedWriter writer = new BufferedWriter(new FileWriter(patientId + "_PatientInfo.txt"))) {
	            writer.write("Patient ID: " + patientId + "\n");
	            writer.write("First Name: " + firstName + "\n");
	            writer.write("Last Name: " + lastName + "\n");
	            writer.write("Email: " + bday + "\n");
	            writer.write("Phone: " + phone + "\n");
	            writer.write("Health History: " + healthHistory + "\n");
	            writer.write("Insurance ID: " + insuranceID + "\n");
	            writer.write("Pharmacy: " + pharmacy + "\n");

	            
	            
	        } catch (IOException ex) {
	            showAlert(Alert.AlertType.ERROR, "Error", "An error occurred while saving the data.");
	            ex.printStackTrace();
	        }
	

	        if(b!=0) {
	        try(BufferedWriter writer = new BufferedWriter(new FileWriter(patientId + "_immunization.txt"))) {
	        	
	        	writer.write("Immunization Record:\n");
	        } catch (IOException e) {
				e.printStackTrace();
			}
	        
             try(BufferedWriter writer = new BufferedWriter(new FileWriter(patientId + "_prescriptions.txt"))) {
	        	
	        	writer.write("Prescriptions:\n");
	        } catch (IOException e) {
				e.printStackTrace();
			}
	        
	    }
	    }
	   
        patientList.add(a);
        a.setFirstName(firstName);
        a.setID(patientId);
        a.setLastName(lastName);
        a.setBirthDay(bday);
        a.setHealthHistory(healthHistory);
        a.setInsuranceID(insuranceID);
        a.setPharmacy(pharmacy);
        a.setPhoneNumber(phone);
	}

	public static ArrayList<Patient> getArrayList() {
        return patientList;
    }
    
	 public static ArrayList<String> getArrayListofIDS() {
	        return patiendIDs;
	    }
    public static void main(String[] args) {
        launch(args);
    }

	@Override
	public void start(Stage arg0) throws Exception {
		// TODO Auto-generated method stub
		
	}
}
