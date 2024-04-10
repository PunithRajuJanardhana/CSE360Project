package HW1;

import javafx.scene.control.Button;

import javafx.scene.Scene;
import javafx.scene.layout.GridPane;
import javafx.geometry.Pos;
import javafx.stage.Stage;

public class PatientOptions {
    ReceptionistView object = new ReceptionistView();
    PatientView obj2 = new PatientView();
    PatientResults obj1 = new PatientResults();
    AppointmentScheduler obj4 = new AppointmentScheduler();
    
    public void start(Stage primaryStage, Patient obj) {
        // Create a GridPane layout
        GridPane gridPane = new GridPane();
        gridPane.setAlignment(Pos.CENTER); // Align gridPane to the center

        // Create buttons
        Button button1 = new Button("Message");
        Button button2 = new Button("View Results");
        Button button3 = new Button("Update Information");
        Button button4 = new Button("Schedule Appointment");
        Button backButton = new Button("Back"); // Creating the back button

        button1.setOnAction(event -> obj2.start(primaryStage,obj));
        button2.setOnAction(event -> {
            PatientResults patientResults = new PatientResults();
            patientResults.display(primaryStage, obj); 
        });

        button3.setOnAction(event -> object.start(primaryStage,obj));
        button4.setOnAction(event -> obj4.start(primaryStage, obj));
        
        backButton.setOnAction(event -> goBack(primaryStage)); 

        // Set preferred width and height for buttons
        double buttonWidth = 150; 
        double buttonHeight = 50; 
        
        
        double backButtonWidth = 100; 
        double backButtonHeight = 30; 
        
        button1.setPrefWidth(buttonWidth);
        button1.setPrefHeight(buttonHeight);
        button2.setPrefWidth(buttonWidth);
        button2.setPrefHeight(buttonHeight);
        button3.setPrefWidth(buttonWidth);
        button3.setPrefHeight(buttonHeight);
        button4.setPrefWidth(buttonWidth);
        button4.setPrefHeight(buttonHeight);
        backButton.setPrefWidth(backButtonWidth); 
        backButton.setPrefHeight(backButtonHeight); 

        // Add buttons to the grid layout
        gridPane.add(button1, 0, 0); // Row 0, Column 0
        gridPane.add(button2, 1, 0); // Row 0, Column 1
        gridPane.add(button3, 0, 1); // Row 1, Column 0
        gridPane.add(button4, 1, 1); // Row 1, Column 1
        gridPane.add(backButton, 0, 2); // Row 2, Column 0

        // Set horizontal and vertical gaps between buttons
        gridPane.setHgap(25);
        gridPane.setVgap(25);

        // Create a scene and set it on the stage
        Scene scene = new Scene(gridPane, 600, 500);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Button Grid");
        primaryStage.show();
    }
    
    private void goBack(Stage primaryStage) {
        // Code to navigate back to previous screen
        primaryStage.close();
    }
}