package asuHelloWorldJavaFX;

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
        
        button1.setOnAction(event -> obj2.start(primaryStage,obj));
        
        
        
        button3.setOnAction(event -> object.start(primaryStage,obj));
        
        button4.setOnAction(event -> obj4.start(primaryStage, obj));

        // Set preferred width and height for buttons
        double buttonWidth = 150; // Set your desired width
        double buttonHeight = 50; // Set your desired height
        button1.setPrefWidth(buttonWidth);
        button1.setPrefHeight(buttonHeight);
        button2.setPrefWidth(buttonWidth);
        button2.setPrefHeight(buttonHeight);
        button3.setPrefWidth(buttonWidth);
        button3.setPrefHeight(buttonHeight);
        button4.setPrefWidth(buttonWidth);
        button4.setPrefHeight(buttonHeight);

        // Add buttons to the grid layout
        gridPane.add(button1, 0, 0); // Row 0, Column 0
        gridPane.add(button2, 1, 0); // Row 0, Column 1
        gridPane.add(button3, 0, 1); // Row 1, Column 0
        gridPane.add(button4, 1, 1); // Row 1, Column 1

        // Set horizontal and vertical gaps between buttons
        gridPane.setHgap(25);
        gridPane.setVgap(25);

        // Create a scene and set it on the stage
        Scene scene = new Scene(gridPane, 600, 500);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Button Grid");
        primaryStage.show();
    }
}
