package HW1;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import java.util.List;

public class PatientView extends Application {
    private TextArea messageTextArea;
    private TextField messageTextField;
    private Button sendButton, syncButton, backButton;
    private String patientId;

    public void start(Stage primaryStage, Patient patient) {
        this.patientId = patient.getID();
        VBox vbox = new VBox(20);
        vbox.setPadding(new Insets(20));

        Label messagesLabel = new Label("Messages:");
        messageTextArea = new TextArea();
        messageTextArea.setEditable(false);
        messageTextArea.setPrefHeight(200);

        messageTextField = new TextField();
        messageTextField.setPromptText("Type your message...");

        sendButton = new Button("Send");
        sendButton.setOnAction(e -> sendMessage());

        // Sync button to fetch and display all messages
        syncButton = new Button("Sync");
        syncButton.setOnAction(e -> displayMessages());

        backButton = new Button("Back");
        backButton.setOnAction(e -> goBack());

        HBox messageBox = new HBox(10, messageTextField, sendButton, syncButton);
        VBox messagesLayout = new VBox(10, messagesLabel, messageTextArea, messageBox, backButton);

        vbox.getChildren().add(messagesLayout);
        vbox.setAlignment(Pos.CENTER);

        Scene scene = new Scene(vbox, 600, 500);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Patient View");
        primaryStage.show();
    }

    private void sendMessage() {
        String messageContent = messageTextField.getText().trim();
        if (!messageContent.isEmpty()) {
            Message message = new Message("Patient", messageContent);
            MessageManager.getInstance().addMessage(patientId, message);
            displayMessages(); // Refresh the message view
            messageTextField.clear();
        }
    }

    private void displayMessages() {
        List<Message> messages = MessageManager.getInstance().getMessages(patientId);
        StringBuilder sb = new StringBuilder();
        for (Message message : messages) {
            sb.append(message.getSender()).append(": ").append(message.getContent()).append("\n");
        }
        messageTextArea.setText(sb.toString());
    }

    private void goBack() {
        Stage stage = (Stage) backButton.getScene().getWindow();
        stage.close();
    }

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage arg0) throws Exception {
        // Placeholder method, not used
    }
}