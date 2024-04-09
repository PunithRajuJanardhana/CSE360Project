package asuHelloWorldJavaFX;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class ASUHelloWorldJavaFX extends Application {

	private Stage primaryStage;

    @Override
    public void start(Stage primaryStage) {
        this.primaryStage = primaryStage;
        showMainView();
    }

    void showMainView() {
        VBox root = new VBox(20);
        root.setAlignment(Pos.CENTER);
        root.setStyle("-fx-padding: 20; -fx-border-style: solid inside;" + 
                      "-fx-border-width: 2; -fx-border-insets: 5;" + 
                      "-fx-border-radius: 5; -fx-border-color: black;");

        Label welcomeLabel = new Label("Welcome to Heart Health Imaging and Recording System");
        welcomeLabel.setStyle("-fx-font-size: 20px; -fx-padding: 20;");

        Button btnPatient = new Button("Patient");
        btnPatient.setPrefWidth(200);
        btnPatient.setStyle("-fx-font-size: 14px;");
        btnPatient.setOnAction(event -> showPatientLoginView());

        Button btnOfficeStaff = new Button("Office Staff");
        btnOfficeStaff.setPrefWidth(200);
        btnOfficeStaff.setStyle("-fx-font-size: 14px;");
        btnOfficeStaff.setOnAction(event -> showOfficeStaffView());

        String buttonStyle = "-fx-background-color: #007bff; -fx-text-fill: white;";
        btnPatient.setStyle(buttonStyle);
        btnOfficeStaff.setStyle(buttonStyle);

        root.getChildren().addAll(welcomeLabel, btnPatient, btnOfficeStaff);

        Scene scene = new Scene(root, 600, 500);
        primaryStage.setTitle("Main UI of the System");
        primaryStage.setScene(scene);
        primaryStage.show();
        
        
    }

    private void showPatientLoginView() {
        VBox root = new VBox(20);
        root.setAlignment(Pos.CENTER);
        root.setStyle("-fx-padding: 20;");

        Label titleLabel = new Label("Patient");
        titleLabel.setStyle("-fx-font-size: 24px;");

        Button btnCreateAccount = new Button("Create Account");
        btnCreateAccount.setPrefWidth(200);
        btnCreateAccount.setOnAction(event -> showReceptionistView());

        Button btnLogin = new Button("Login");
        btnLogin.setPrefWidth(200);
        btnLogin.setOnAction(event -> showPatientView());

        String buttonStyle = "-fx-background-color: #007bff; -fx-text-fill: white;";
        btnCreateAccount.setStyle(buttonStyle);
        btnLogin.setStyle(buttonStyle);
        
        Button back1 = new Button("Back");
        back1.setPrefWidth(200);
        back1.setStyle(buttonStyle);
        back1.setOnAction(event ->showMainView());

        root.getChildren().addAll(titleLabel, btnCreateAccount, btnLogin,back1);

        Scene scene = new Scene(root, 600, 500);
        primaryStage.setTitle("Patient");
        primaryStage.setScene(scene);
        
        
    }

    public void showOfficeStaffView() {
        VBox root1 = new VBox(20);
        root1.setAlignment(Pos.CENTER);
        root1.setStyle("-fx-padding: 20;");

        Label titleLabel = new Label("Office Staff");
        titleLabel.setStyle("-fx-font-size: 24px;");

        Button btnTechnicianView = new Button("Doctor View");
        btnTechnicianView.setPrefWidth(200);
        btnTechnicianView.setOnAction(event -> showTechnicianView());

        Button btnDoctorView = new Button("Message");
        btnDoctorView.setPrefWidth(200);
        btnDoctorView.setOnAction(event -> showDoctorView());
        
        Button btnNurseView = new Button("Patient Vitals");
        btnNurseView.setPrefWidth(200);
        btnNurseView.setOnAction(event -> {
            NurseView nurseView = new NurseView();
            VBox nurseRoot = new VBox(20);
            nurseRoot.setAlignment(Pos.TOP_LEFT);
            nurseRoot.getChildren().add(nurseView);
            
            Scene nurseScene = new Scene(nurseRoot, 600, 500);
            Stage nurseStage = new Stage();
            nurseStage.setTitle("Patient Vitals");
            nurseStage.setScene(nurseScene);
            nurseStage.show();
        });
        

        String buttonStyle = "-fx-background-color: #007bff; -fx-text-fill: white;";
        btnTechnicianView.setStyle(buttonStyle);
        btnDoctorView.setStyle(buttonStyle);
        btnNurseView.setStyle(buttonStyle);
        
        Button immunization = new Button("Immunization Record");
        immunization.setPrefWidth(200);
        immunization.setStyle(buttonStyle);
        
        immunization.setOnAction(event -> updateImmunizationRecord());
        
        Button back = new Button("Back");
        back.setPrefWidth(200);
        back.setStyle(buttonStyle);
        back.setOnAction(event ->showMainView());
        

        root1.getChildren().addAll(titleLabel, btnTechnicianView, btnDoctorView,btnNurseView,immunization,back);

        // Get the current stage from the primary scene
        Stage currentStage = (Stage) primaryStage.getScene().getWindow();
        currentStage.setTitle("Office Staff"); // Set the title of the current stage
        currentStage.setScene(new Scene(root1, 600, 500)); // Set the scene of the current stage
    }

    private void showReceptionistView() {
        ReceptionistView receptionistView = new ReceptionistView();
        receptionistView.start(new Stage(),null);
    }

    public void showTechnicianView() {
        TechnicianView technicianView = new TechnicianView(this);
        technicianView.display(primaryStage);
    }


    private void showPatientView() {
    	 LoginView loginView = new LoginView(this); // 'this' refers to the current ASUHelloWorldJavaFX instance
    	    loginView.display(primaryStage);

    }
    
    private void updateImmunizationRecord() {
    	updateImmunization a = new updateImmunization();
    	a.start(primaryStage);
	
    }

    private void showDoctorView() {
        DoctorView doctorView = new DoctorView();
        try {
            doctorView.start(new Stage());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        launch(args);
    }
}

