package demo;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;

public class SignUpController extends AnchorPane implements Initializable {

    @FXML
    TextField tf_fullname;
    @FXML
    TextField tf_email;
    @FXML
    TextField tf_id;
    @FXML
    PasswordField pf_password;
    @FXML
    PasswordField pf_password2;
    @FXML
    Button btn_back;
    @FXML
    Button btn_signUp;
    @FXML
    Label l_error;
    @FXML
    private ComboBox<String> cb_role;
    private ComboBox<String> cb_position;
    
    private Main application;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        tf_fullname.setPromptText("Enter Fullname");
        tf_email.setPromptText("Enter Email");
        pf_password.setPromptText("Enter Password");
        pf_password2.setPromptText("Confirm password");
        fillComboBox1();
        fillComboBox2();
    }

    public void setApp(Main application) {
        this.application = application;
    }
    
    public void back(ActionEvent event) {
        application.backToLogin();
    }
    
    public void signUp(ActionEvent event) {
        boolean isActive = true;
        if (!pf_password.getText().equals(pf_password2.getText())) {
            l_error.setText("Passwords do not match.");
        } 
        else if (tf_fullname.getText() == null
                || pf_password.getText() == null || tf_email.getText() == null
                || pf_password2.getText() == null || cb_role.getSelectionModel().getSelectedItem() == null
                || cb_position.getSelectionModel().getSelectedItem() == null
                || isActive == false) {
            l_error.setText("Please fill all the fields.");
        } 
        else if (!application.userSignUp(tf_id.getText(), tf_fullname.getText(),
                tf_email.getText(),pf_password.getText(), 
                cb_position.getSelectionModel().getSelectedItem(),
                cb_role.getSelectionModel().getSelectedItem(),
                isActive)) {
            l_error.setText("ID is already in use.");
        }
    }

    private void fillComboBox1() {
        cb_role.getItems().add("Admin");
        cb_role.getItems().add("User");
    }

    private void fillComboBox2() {
        cb_position.getItems().add("Commander");
        cb_position.getItems().add("Maintencane Test Pilot");
        cb_position.getItems().add("Officer Pilot");
        cb_position.getItems().add("Officer Pilot");
    }
}