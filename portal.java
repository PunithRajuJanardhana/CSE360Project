
package asuHelloWorldJavaFX;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class portal extends Application {

    @Override
    public void start(Stage primaryStage) {
        // Creating a stack pane to hold our elements
        StackPane root = new StackPane();

        // Setting the background color to dark blue with gradient
        root.setStyle("-fx-background-color: linear-gradient(to bottom, #265B78, #0D1C2B);");

        // Adjusting parameters for the white section
        double screenWidth = 700; // Adjust this according to your screen size
        double screenHeight = 700; // Adjust this according to your screen size
        double whiteSectionWidth = screenWidth * 0.3; // Adjust the percentage of screen width
        double whiteSectionHeight = screenHeight; // You can set a specific height if needed
        double whiteSectionXPosition = -(screenWidth / 2) + (whiteSectionWidth / 2); // Adjust horizontal position
        double whiteSectionYPosition = 0; // Adjust vertical position

        // Creating the white section rectangle
        Rectangle whiteSection = new Rectangle(whiteSectionWidth, whiteSectionHeight);
        whiteSection.setTranslateX(whiteSectionXPosition);
        whiteSection.setTranslateY(whiteSectionYPosition);
        whiteSection.setFill(Color.WHITE);

        // Adding the white section to the stack pane
        root.getChildren().add(whiteSection);

        // Text for welcome message
        Text welcomeText = new Text("Welcome to the patient portal");
        welcomeText.setFont(Font.font("Arial", FontWeight.BOLD, 24)); // Adjusting font size
        welcomeText.setFill(Color.WHITE); // Adjusting text color
        StackPane.setAlignment(welcomeText, Pos.CENTER);

        // Calculating X-axis position for the welcome message
        double welcomeTextWidth = welcomeText.getLayoutBounds().getWidth();
        double welcomeTextXPosition = (screenWidth - welcomeTextWidth) / 3.1;

        welcomeText.setTranslateX(welcomeTextXPosition); // Setting X position
        welcomeText.setTranslateY(-330); // Adjusting Y position to center vertically
        root.getChildren().add(welcomeText);

        // Text for messages
        Text inboxMessagesText = new Text("Inbox/Messages");
        inboxMessagesText.setFont(Font.font("Arial", 12)); // Adjusting font size
        inboxMessagesText.setFill(Color.BLACK); // Adjusting text color

        // Calculating X-axis position for the inbox/message text
        double inboxMessagesTextWidth = inboxMessagesText.getLayoutBounds().getWidth();
        double inboxMessagesTextXPosition = (screenWidth - inboxMessagesTextWidth) / 2.5;

        inboxMessagesText.setTranslateX(-300); // Setting X position
        inboxMessagesText.setTranslateY(-300); // Adjusting Y position below the welcome message
        root.getChildren().add(inboxMessagesText);

        // Back button
        Button backButton = new Button("Back");
        backButton.setTranslateX(-(screenWidth / 2) + 25); // Adjusting X position
        backButton.setTranslateY(-(screenHeight / 2) + 20); // Adjusting Y position
        root.getChildren().add(backButton);

        // Creating four different buttons with different functions
        Button button1 = new Button("Schedule an Appointment");
        button1.setOnAction(e -> {
            // Define action for button 1 here
            System.out.println("Button 1 clicked!");
        });
        button1.setPrefSize(150, 150); // Setting button size to 2 inches by 2 inches
        button1.setTranslateX(-(screenWidth / 2) + 320); // Adjusting X position
        button1.setTranslateY((screenHeight / 2) - 560); // Adjusting Y position
        root.getChildren().add(button1);

        Button button2 = new Button("Message a medical professional");
        button2.setOnAction(e -> {
            // Define action for button 2 here
            System.out.println("Button 2 clicked!");
        });
        button2.setPrefSize(150, 150); // Setting button size to 2 inches by 2 inches
        button2.setTranslateX(-(screenWidth / 2) + 540); // Adjusting X position
        button2.setTranslateY((screenHeight / 2) - 560); // Adjusting Y position
        root.getChildren().add(button2);

        Button button3 = new Button("Update Contact Information");
        button3.setOnAction(e -> {
            // Define action for button 3 here
            System.out.println("Button 3 clicked!");
        });
        button3.setPrefSize(150, 150); // Setting button size to 2 inches by 2 inches
        button3.setTranslateX(-(screenWidth / 2) + 320); // Adjusting X position
        button3.setTranslateY((screenHeight / 2) - 300); // Adjusting Y position
        root.getChildren().add(button3);

        Button button4 = new Button("View Previous Visits");
        button4.setOnAction(e -> {
            // Define action for button 4 here
            System.out.println("Button 4 clicked!");
        });
        button4.setPrefSize(150, 150); // Setting button size to 2 inches by 2 inches
        button4.setTranslateX(-(screenWidth / 2) + 540); // Adjusting X position
        button4.setTranslateY((screenHeight / 2) - 300); // Adjusting Y position
        root.getChildren().add(button4);

        // Creating a scene with the specified dimensions and adding the stack pane to it
        Scene scene = new Scene(root, screenWidth, screenHeight);

        // Setting the scene to the stage and displaying the stage
        primaryStage.setScene(scene);
        primaryStage.setTitle("Dark Blue Background with Customized White Section");
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}