package asuHelloWorldJavaFX;

import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Random;
import javafx.scene.control.*;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Font;
import javafx.scene.control.DatePicker;

public class ReceptionistView {
    public static ArrayList<LocalDate> reservedDates = new ArrayList<>(); 
    public static ArrayList<Integer> patientIds = new ArrayList<>();
    public static ArrayList<Patient> patientList = new ArrayList<>();
    LocalDate selectedDate;
    Patient a;
    int year,month,day;
    TextField nameTextField = new TextField();
    TextField lastNameTextField = new TextField();
    TextField addressTextField = new TextField();
    TextField phoneTextField = new TextField();
    TextField insuranceIdTextField = new TextField(); 
    DatePicker datePicker = new DatePicker();
    Label result;
    Label successLabel = new Label();
    String firstName,lastName,address,phone,insur;



    public static int patientID;

    public void addToPane(BorderPane pane) {
        Label intakeFormLabel = new Label("Patient Intake Form");
        intakeFormLabel.setFont(Font.font("Arial", 20));
        successLabel.setPrefWidth(450);
        successLabel.setFont(Font.font("Arial", 14));

        GridPane gridPane = new GridPane();
        gridPane.setHgap(10);
        gridPane.setVgap(10);

        gridPane.add(intakeFormLabel, 0, 0, 2, 1);
        gridPane.add(new Label("Name:"), 0, 1);
        gridPane.add(nameTextField, 1, 1);
        gridPane.add(new Label("Last Name:"), 0, 2);
        gridPane.add(lastNameTextField, 1, 2);
        gridPane.add(new Label("Address:"), 0, 3);
        gridPane.add(addressTextField, 1, 3);
        gridPane.add(new Label("Phone Number:"), 0, 4);
        gridPane.add(phoneTextField, 1, 4);
        gridPane.add(new Label("Insurance ID:"), 0, 5);
        gridPane.add(insuranceIdTextField, 1, 5);
        gridPane.add(new Label("Appointment Date:"), 0, 6);
        gridPane.add(datePicker, 1, 6);


        Button saveButton = new Button("Save");
        saveButton.setStyle("-fx-background-color: #4473c5; -fx-min-width: 120px; -fx-min-height: 40px;");
        saveButton.setOnAction(event -> {
            if (areFieldsEmpty()) {
                successLabel.setText("Error: Please fill in all fields.");
            } else {
                savePatientInfo();
            }
        });

        Button backButton = new Button("Back");
        backButton.setStyle("-fx-background-color: #4473c5; -fx-min-width: 120px; -fx-min-height: 40px;");
        backButton.setOnAction(event -> ASUHelloWorldJavaFX.showInitialView());

        gridPane.add(saveButton, 0, 7);
        gridPane.add(backButton, 1, 7);
        
        gridPane.add(successLabel, 0, 9, 2, 1);

        // Add the gridPane to the center of the provided BorderPane
        pane.setCenter(gridPane);
        
        datePicker.setOnAction(event -> {
            LocalDate selectedDate = datePicker.getValue();
            if (selectedDate != null) {
            	if(!reservedDates.contains(selectedDate)){
            		reservedDates.add(selectedDate);
                 year = selectedDate.getYear();
                 month = selectedDate.getMonthValue();
                 day = selectedDate.getDayOfMonth();
            	}
            	else {
            		System.out.println("Date is already reserved. Please pick another date");
                	
            	}
            }
            
        });
        // Disable dates that have already been picked
        datePicker.setDayCellFactory(picker -> new DateCell() {
            @Override
            public void updateItem(LocalDate date, boolean empty) {
                super.updateItem(date, empty);
                setDisable(reservedDates.contains(date));
            }
        });
        clearFields();
    }

    private void savePatientInfo() {
         firstName = nameTextField.getText().trim();
        a = new Patient();
        a.setpatientName(firstName);

         lastName  = lastNameTextField.getText().trim();
         address   = addressTextField.getText().trim();
         phone     = phoneTextField.getText().trim();
         insur     = insuranceIdTextField.getText().trim();
        if (firstName.isEmpty() || lastName.isEmpty() || address.isEmpty() || phone.isEmpty() || insur.isEmpty() || datePicker.getValue()==null) {
        	successLabel.setText("Error: Please fill in all fields.");
            clearFields();
            return;
        }
        else {

        try {
            // Generate a unique 5-digit patient ID
            Random random = new Random();
            patientID = 10000 + random.nextInt(90000);

            patientIds.add(patientID);

            a = new Patient();
            patientList.add(a);
            a.setpatientName(firstName);
            a.setID(patientID);

            String fileName = patientID + "_PatientInfo.txt";
            FileWriter fileWriter = new FileWriter(fileName);
            fileWriter.write("Patient ID: " + patientID + "\n");
            fileWriter.write("First Name: " + firstName + "\n");
            fileWriter.write("Last Name: " + lastName + "\n");
            fileWriter.write("Address: " + address + "\n");
            fileWriter.write("Phone Number: " + phone + "\n");
            if (datePicker.getValue() != null) {
      
                fileWriter.write("Date of Appointment: " + day + "/" + month + "/" + year + "\n");
            }
            fileWriter.write("Insurance ID: " + insur + "\n");

            fileWriter.close();

            successLabel.setText("Success: Patient information saved successfully. Patient ID: " + patientID);
        } catch (IOException e) {
            System.out.println("Error: An error occurred while saving patient information.");
        }
        }
    }

    public static ArrayList<Patient> getArrayList() {
        return patientList;
    }

    public static ArrayList<Integer> getArrayListofIDS() {
        return patientIds;
    }

    private void clearFields() {
        nameTextField.clear();
        lastNameTextField.clear();
        addressTextField.clear();
        phoneTextField.clear();
        insuranceIdTextField.clear();
        datePicker.setValue(null);
        successLabel.setText("");
    }
    private boolean areFieldsEmpty() {
        return nameTextField.getText().trim().isEmpty() ||
               lastNameTextField.getText().trim().isEmpty() ||
               addressTextField.getText().trim().isEmpty() ||
               phoneTextField.getText().trim().isEmpty() ||
               insuranceIdTextField.getText().trim().isEmpty() ||
               datePicker.getValue() == null;
    }
}
