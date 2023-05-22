
package demo;

import demo.model.User;
import java.io.InputStream;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.fxml.JavaFXBuilderFactory;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import demo.security.Authenticator;
import java.io.IOException;
import javafx.scene.Parent;
import java.net.URL;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;


/**
 * Main Application. This class handles navigation and user session.
 */
public class Main extends Application {

    /*The JavaFX Stage class is the top level JavaFX container. 
    The primary Stage is constructed by the platform. 
    Additional Stage objects may be constructed by the application.*/
    private Stage stage;
    /*Initiate the POJO class user that contains 
    getters and setters for the user information.*/
    private User loggedUser;
    private final double MINIMUM_WINDOW_WIDTH = 390.0;
    private final double MINIMUM_WINDOW_HEIGHT = 500.0;

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        /* Equivalent to launch(args) but more targeted to the main class*/
        Application.launch(Main.class, (java.lang.String[])null);
    }

    @Override
    public void start(Stage primaryStage) {
        try {
            stage = primaryStage;
            stage.setTitle("Login Page");
            stage.setMinWidth(MINIMUM_WINDOW_WIDTH);
            stage.setMinHeight(MINIMUM_WINDOW_HEIGHT);
            loginPage();
            primaryStage.show();
        } catch (Exception ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public User getLoggedUser() {
        return loggedUser;
    }
        
//    public boolean userLogging(String email, String password){
//        if (Authenticator.validate(email, password)) {
//            loggedUser = User.of(email);
//            LoggedIn();
//            return true;
//        } else {
//            return false;
//        }
//    }
//    
    public void userLogout(){
        loggedUser = null;
        loginPage();
    }

    public void backToLogin(){
        loginPage();
    }

//    public void backToHomePage(){
//        LoggedIn();
//    }
       
    private void loginPage(){
       try {
            LoginController login = (LoginController) replaceSceneContent("/demo/login.fxml");
            login.setApp(this);
        } catch (Exception ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
        
//    private void LoggedIn() {
//        try {
//            LoggedInController loggedIn = (LoggedInController) replaceSceneContent("/demo/loggedin.fxml");
//            loggedIn.setApp(this);
//        } catch (Exception ex) {
//            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
//        }
//    }
    
    public void SignUp() {
        try {
            SignUpController signUp = (SignUpController) replaceSceneContent("/demo/SignUp.fxml");
            signUp.setApp(this);
        } catch (Exception ex) {
           Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
//    public void AddAircraft() {
//        try {
//            AircraftController addAC = (AircraftController) replaceSceneContent("/demo/aircraftController.fxml");
//            addAC.setApp(this);
//        } catch (Exception ex) {
//           Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
//        }
//    }
//    
//    public void updateHours() {
//        try {
//            UpdateController upd = (UpdateController) replaceSceneContent("/demo/updateController.fxml");
//            upd.setApp(this);
//        } catch (Exception ex) {
//           Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
//        }
//    }
//
//    public void history() {
//        try {
//            MalfunctionController mal = (MalfunctionController) replaceSceneContent("/demo/Malfunction.fxml");
//            mal.setApp(this);
//        } catch (Exception ex) {
//           Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
//        }
//    }
//    
//    public void reportMalfunction() {
//        try {
//            ReportMalfunctionHistoryController rm = 
//                    (ReportMalfunctionHistoryController) replaceSceneContent("/demo/reportMalfunctionHistoryController.fxml");
//            rm.setApp(this);
//        } catch (Exception ex) {
//           Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
//        }
//    }
    
//    public boolean userSignUp(String uid,String fullName, String email, String password, 
//        String role, String position, boolean isActive) {
//        
//        if (Authenticator.create(uid, fullName, email, password, role, position, isActive)) {
//            loggedUser = User.of(uid);
//            LoggedIn();
//            return true;
//        } else {
//            return false;
//        }
//    } 
    
    private Initializable replaceSceneContent(String fxml) throws Exception {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource(fxml));
        Parent root = loader.load();

        Scene scene = new Scene(root, 600, 400);
        stage.setScene(scene);
        stage.sizeToScene();

        return loader.getController();
    }

}