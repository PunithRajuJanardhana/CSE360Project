package asuHelloWorldJavaFX;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class NurseView extends GridPane {
	 

    public NurseView() {
    

    	   
        setPadding(new Insets(20));
        setHgap(10);
        setVgap(10);
        setAlignment(Pos.CENTER);

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
    }
}
