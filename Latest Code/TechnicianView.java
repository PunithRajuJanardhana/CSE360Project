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
import javafx.scene.text.Font;
import javafx.stage.Stage;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class TechnicianView {
	
	
	public static TextField blankField;
	public static TextField totalcac;
	public static TextField lmTextField;
	public static TextField ladTextField;
	public static TextField lcxTextField;
	public static TextField rdaTextField;
	public static TextField pdaTextField;
    Patient obj;
    ASUHelloWorldJavaFX object = new ASUHelloWorldJavaFX();


	public static ArrayList<String> patientctScan = new ArrayList<>();
	private ArrayList<Patient> patientList = ReceptionistView.getArrayList();
	private ArrayList<String> patientIds = ReceptionistView.getArrayListofIDS();
	private ASUHelloWorldJavaFX mainApp;

	public TechnicianView(ASUHelloWorldJavaFX mainApp) {
	    this.mainApp = mainApp;
	}


	public Patient patientWithId(String patientID) {
        Patient patientF = null;
        for (Patient patient : patientList) {
            if (patient.getID().equals(patientID)) {
                patientF = patient;
                break; // Exit loop once found
            }
        }
        if (patientF == null) {
            System.out.println("Error: Patient not found with ID " + patientID);
        }
        return patientF;
    }

	
	public void display(Stage primaryStage) {
	 
		primaryStage.setTitle("CT Scan Tech View");

	    GridPane gridPane = new GridPane();
	    gridPane.setHgap(10);
	    gridPane.setVgap(10);

	    Label patientIDLabel = new Label("Patient ID:");
	    blankField = new TextField(); // Empty label for blank space
	    blankField.setPrefWidth(400);

	    Label agastonCACLabel = new Label("The total Agaston CAC score:");
	    totalcac = new TextField();
	    agastonCACLabel.setMaxWidth(400);

	    Label vesselLevelCACLabel = new Label("Vessel level Agaston CAC score:");
	    vesselLevelCACLabel.setMaxWidth(400);

	    Label lmLabel = new Label("LM:");
	    lmTextField = new TextField();
	    lmTextField.setPrefWidth(100);

	    Label ladLabel = new Label("LAD:");
	    ladTextField = new TextField();
	    ladTextField.setPrefWidth(100);

	    Label lcxLabel = new Label("LCX:");
	    lcxTextField = new TextField();
	    lcxTextField.setPrefWidth(100);

	    Label rdaLabel = new Label("RCA:");
	    rdaTextField = new TextField();
	    rdaTextField.setPrefWidth(100);

	    Label pdaLabel = new Label("PDA:");
	    pdaTextField = new TextField();
	    pdaTextField.setPrefWidth(100);

	    Button saveButton = new Button("Save");
	    
	    Button back = new Button("Back");
	    

	    
	 // Set font size for labels and text fields
        Font labelFont = new Font("Arial", 14); // Change 14 to your desired font size
        patientIDLabel.setFont(labelFont);
        agastonCACLabel.setFont(labelFont);
        vesselLevelCACLabel.setFont(labelFont);
        lmLabel.setFont(labelFont);
        ladLabel.setFont(labelFont);
        lcxLabel.setFont(labelFont);
        rdaLabel.setFont(labelFont);
        pdaLabel.setFont(labelFont);

        // Set font size for text fields
        Font textFieldFont = new Font("Arial", 14); // Change 14 to your desired font size
        blankField.setFont(textFieldFont);
        lmTextField.setFont(textFieldFont);
        ladTextField.setFont(textFieldFont);
        lcxTextField.setFont(textFieldFont);
        rdaTextField.setFont(textFieldFont);
        pdaTextField.setFont(textFieldFont);
        
	    gridPane.add(patientIDLabel, 0, 0);
	    gridPane.add(blankField, 2, 0); // Add blank label for spacing
	    gridPane.add(agastonCACLabel, 0, 1);
	    gridPane.add(totalcac, 2, 1);
	    gridPane.add(vesselLevelCACLabel, 0, 2);
	    gridPane.add(lmLabel, 0, 3);
	    gridPane.add(lmTextField, 1, 3);
	    gridPane.add(ladLabel, 0, 4);
	    gridPane.add(ladTextField, 1, 4);
	    gridPane.add(lcxLabel, 0, 5);
	    gridPane.add(lcxTextField, 1, 5);
	    gridPane.add(rdaLabel, 0, 6);
	    gridPane.add(rdaTextField, 1, 6);
	    gridPane.add(pdaLabel, 0, 7);
	    gridPane.add(pdaTextField, 1, 7);
	    gridPane.add(saveButton, 2, 15);
	    gridPane.add(back,4,15);
	    saveButton.setOnAction(e -> saveCTScanData());
	    saveButton.setStyle("-fx-background-color: #4473c5; -fx-min-width: 120px; -fx-min-height: 40px;");
	    
	    back.setOnAction(event -> mainApp.showMainView());

	    back.setStyle("-fx-background-color: #4473c5; -fx-min-width: 120px; -fx-min-height: 40px;");
	    
	

	    

	    Scene scene = new Scene(gridPane, 600, 500);
	    primaryStage.setScene(scene);
	    primaryStage.show();
	}
	
	public void saveCTScanData() {
		String patientctscan =  blankField.getText();
		patientctScan.add(patientctscan);
		
		if(patientIds.contains(patientctscan) && !totalcac.getText().isEmpty() && !lmTextField.getText().isEmpty() && !ladTextField.getText().isEmpty() 
				&& !lcxTextField.getText().isEmpty() && !rdaTextField.getText().isEmpty() && !pdaTextField.getText().isEmpty()) {
			
		
	    Patient obj= patientWithId(patientctscan);

		
		int totalCAC =  Integer.parseInt(totalcac.getText());
		obj.setTotalCAC(totalCAC);
		
		int lmValue  =  Integer.parseInt(lmTextField.getText());
		obj.setLmValue(lmValue);
		
		int ladValue =  Integer.parseInt(ladTextField.getText());
		obj.setLadValue(ladValue);
		
		int lcxValue =  Integer.parseInt(lcxTextField.getText());
		obj.setLcxValue(lcxValue);
		
		int rdaValue =  Integer.parseInt(rdaTextField.getText());
		obj.setRdaValue(rdaValue);
		
		int pdaValue =  Integer.parseInt(pdaTextField.getText());
		obj.setPdaValue(pdaValue);
		
        // Code to save the CT scan data
		try {

			String fileName = patientctscan + "CTResults.txt";
			FileWriter fileWriter = new FileWriter(fileName);
			fileWriter.write("Patient ID: " + patientctscan+ "\n");
			fileWriter.write("The Total Agaston CAC Score: " + totalCAC+ "\n");
			fileWriter.write("Vessel Level Agaston CAC Score"+ "\n");
			fileWriter.write("LM: " + lmValue+ "\n");
			fileWriter.write("LAD: " + ladValue+ "\n");
			fileWriter.write("LCX: " + lcxValue+ "\n");
			fileWriter.write("RDA: " + rdaValue+ "\n");
			fileWriter.write("PDA: " + pdaValue+ "\n");
			fileWriter.close();
		}
		catch (IOException e) {
		    showAlert(Alert.AlertType.ERROR, "Error", "An error occurred while saving the data.");
              

		} 
	}
        
     }
	public static ArrayList<String> getArrayList() {
        return patientctScan;
    }

    private void showAlert(Alert.AlertType alertType, String title, String content) {
        Alert alert = new Alert(alertType);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(content);
        alert.showAndWait();
    }
    
}