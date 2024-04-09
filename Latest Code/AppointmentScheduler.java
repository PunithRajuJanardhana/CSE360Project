
package asuHelloWorldJavaFX;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.DateCell;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import java.time.LocalDate;
import java.util.ArrayList;

public class AppointmentScheduler extends Application {
    private ArrayList<LocalDate> blockedDates = new ArrayList<>();
    private Label confirmationLabel;

    public void start(Stage primaryStage, Patient obj) {
        primaryStage.setTitle("Appointment Scheduler");

        VBox root = new VBox(10);
        root.setPadding(new Insets(20));

        DatePicker datePicker = new DatePicker();
        datePicker.setDayCellFactory(this::getDayCellFactory);

        Button scheduleButton = new Button("Schedule Appointment");
        scheduleButton.setOnAction(e -> scheduleAppointment(datePicker.getValue()));

        Button backButton = new Button("Back");
        backButton.setOnAction(e -> goBack(primaryStage, obj));

        confirmationLabel = new Label();

        root.getChildren().addAll(datePicker, scheduleButton, backButton, confirmationLabel);

        Scene scene = new Scene(root, 600, 500);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private DateCell getDayCellFactory(DatePicker datePicker) {
        return new DateCell() {
            @Override
            public void updateItem(LocalDate item, boolean empty) {
                super.updateItem(item, empty);

                if (blockedDates.contains(item)) {
                    setDisable(true);
                    setStyle("-fx-background-color: #ffc0cb;"); // Change color for blocked dates
                }
            }
        };
    }

    private void scheduleAppointment(LocalDate selectedDate) {
        if (selectedDate != null && !blockedDates.contains(selectedDate)) {
            blockedDates.add(selectedDate);
            confirmationLabel.setText("Appointment scheduled for: " + selectedDate);
        } else {
            confirmationLabel.setText("Please select a valid date for the appointment.");
        }
    }

    private void goBack(Stage primaryStage, Patient obj) {
        PatientOptions patientOptions = new PatientOptions();
        patientOptions.start(primaryStage, obj);
    }

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        // Placeholder method, not used
    }
}

