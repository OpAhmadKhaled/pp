package demo;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

/**
 * Login Controller.
 */
public class LoginController implements Initializable {

    @FXML
    private TextField tf_email;
    @FXML
    private PasswordField tf_password;
    @FXML
    private Button btn_login;
    @FXML
    private Button btn_signup;
    @FXML
    private Label errorMessage;

    private Main application;

    public void setApp(Main application) {
        this.application = application;
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        tf_email.setPromptText("EMAIL");
        if (tf_password != null) {
            tf_password.setPromptText("PASSWORD");
        } else {
            System.err.println("tf_password is null");
        }
    }


    @FXML
    public void processLogin(ActionEvent event) {
        if (tf_email.getText().isEmpty() || tf_password.getText().isEmpty()) {
            errorMessage.setText("Please fill out all fields");
        } else if (!application.userLogging(tf_email.getText(), tf_password.getText())) {
            errorMessage.setText("Username/Password is incorrect");
        }
    }

    @FXML
    public void processSignUp(ActionEvent event) {
        application.SignUp();
    }
}
