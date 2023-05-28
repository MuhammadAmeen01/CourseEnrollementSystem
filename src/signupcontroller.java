import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class signupcontroller {

    public Stage appStage;
    public Scene scene;
    public Parent root;

    @FXML
    private TextField usernameField;

    @FXML
    private TextField firstNameField;

    @FXML
    private TextField lastNameField;

    @FXML
    private TextField studentNumberField;

    @FXML
    private PasswordField passwordField;

    @FXML
    private Button signupButton;

    @FXML
    private void closeButtonClicked(ActionEvent event) {
        // Perform actions when the close button is clicked
        // For example, close the current stage/window
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.close();
    }
    @FXML
    
    private void alreadyHaveAccountClicked(ActionEvent e) throws IOException {
        // Switch to the login screen
        root = FXMLLoader.load(getClass().getResource("login.fxml"));
        appStage = (Stage) ((Node) e.getSource()).getScene().getWindow();
        scene = new Scene(root);
        appStage.setScene(scene);
        appStage.show();
    }

    @FXML
    private void signupButtonClicked(ActionEvent e) throws IOException {
        String username = usernameField.getText();
        String firstName = firstNameField.getText();
        String lastName = lastNameField.getText();
        String studentNumber = studentNumberField.getText();
        String password = passwordField.getText();

        // Perform signup logic here
        if (saveUserData(username, firstName, lastName, studentNumber, password)) {
            System.out.println("Signup successful");
            root = FXMLLoader.load(getClass().getResource("login.fxml"));
            appStage = (Stage) ((Node) e.getSource()).getScene().getWindow();
            scene = new Scene(root);
            appStage.setScene(scene);
            appStage.show();
            // Save the user's information or perform any other actions
        } else {
            System.out.println("Failed to save user data");
            // Display an error message or perform any other actions
        }
    }

    
    private boolean saveUserData(String username, String firstName, String lastName, String studentNumber, String password) {

        String username1 = usernameField.getText();
        String firstName1 = firstNameField.getText();
        String lastName1 = lastNameField.getText();
        String studentNumber1 = studentNumberField.getText();
        String password1 = passwordField.getText();
        User newuser=new User();
        if(newuser.signup(username1, firstName1, lastName1, studentNumber1, password1)) {
        	return true;
        }
        return false;
    }
}
