package asuHelloWorldJavaFX;


import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class PatientResults {
	Patient patient1 = new Patient();
    public void display(Stage primaryStage, Patient patientObj) {
        Stage patientStage = new Stage();
        patientStage.setTitle("Patient Results");

        GridPane gridPane = new GridPane();
        gridPane.setHgap(10);
        gridPane.setVgap(10);

        Label nameLabel = new Label("Hello "+ patientObj.getFirstName());         
        nameLabel.setFont(Font.font("Arial", 20)); 
        
        Label totalCAC = new Label("The total Agaston CAC Score" );
        totalCAC.setFont(Font.font("Arial", 20)); 

        
        Label totalCacVal = new Label(String.valueOf(patientObj.getTotalCAC()));
        totalCacVal.setFont(Font.font("Arial", 20)); 


         Label LM = new Label("LM:   " +patientObj.getLmValue());
         LM.setFont(Font.font("Arial", 20)); 

        Label LAD = new Label("LAD: "+ patientObj.getLadValue());
        LAD.setFont(Font.font("Arial", 20)); 

        Label LCX = new Label("LCX: "+patientObj.getLcxValue());
        LCX.setFont(Font.font("Arial", 20)); 

        Label RCA = new Label("RCA: "+ patientObj.getRdaValue());
        RCA.setFont(Font.font("Arial", 20)); 

        Label PDA = new Label("PDA: " + patientObj.getPdaValue());
        PDA.setFont(Font.font("Arial", 20)); 

        // Simulate fetching CT scan results based on patientID

        gridPane.add(nameLabel, 2, 0);
        gridPane.add(totalCAC, 0, 1);
        gridPane.add(totalCacVal,2,1);
        gridPane.add(LM, 0, 3);
        gridPane.add(LAD, 0, 4);
        gridPane.add(LCX, 0, 5);
        gridPane.add(RCA, 0, 6);
        gridPane.add(PDA, 0, 7);
     

        Scene scene = new Scene(gridPane, 800, 600);
        patientStage.setScene(scene);
        patientStage.show();
    }
}