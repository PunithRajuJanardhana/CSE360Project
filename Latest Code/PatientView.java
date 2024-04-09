package asuHelloWorldJavaFX;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.util.List;

public class PatientView extends Application {

    private TextField tfPatientID;
    private TextArea messageTextArea;
    private TextField messageTextField;
    private Button sendButton;
    

    public void start(Stage primaryStage, Patient obj) {
        VBox vbox = new VBox(20);
        vbox.setPadding(new Insets(20));

        // Messaging interface
        Label messagesLabel = new Label("Messages:");
        messageTextArea = new TextArea();
        messageTextArea.setEditable(false);
        messageTextArea.setPrefHeight(200);

        messageTextField = new TextField();
        messageTextField.setPromptText("Type your message...");

        sendButton = new Button("Send");
        sendButton.setOnAction(e -> sendMessage());

        HBox messageBox = new HBox(10, messageTextField, sendButton);
        VBox messagesLayout = new VBox(10, messagesLabel, messageTextArea, messageBox);

        vbox.getChildren().add(messagesLayout);
        vbox.setAlignment(Pos.CENTER);

        Scene scene = new Scene(vbox, 600, 500);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Patient View");
        primaryStage.show();
    }

    private void sendMessage() {
        String message = messageTextField.getText();
        if (!message.isEmpty()) {
            // You can implement the message sending functionality here
            // For now, let's just append the message to the text area
            messageTextArea.appendText("You: " + message + "\n");
            messageTextField.clear();
        }
    }

    public static void main(String[] args) {
        launch(args);
    }

	@Override
	public void start(Stage arg0) throws Exception {
		// TODO Auto-generated method stub
		
	}
}

