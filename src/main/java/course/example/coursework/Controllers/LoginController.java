package course.example.coursework.Controllers;

import course.example.coursework.Fabric.SceneFabric;
import course.example.coursework.Services.ConnectionService;
import course.example.coursework.Services.LoginService;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class LoginController {

    @FXML
    private TextField loginField;
    @FXML
    private PasswordField passwordField;
    @FXML
    private Button loginButton;
    @FXML
    private Label errorLabel;

    @FXML
    private void handleLogin() {
        String login = loginField.getText();
        String passwd = passwordField.getText();
        try {
            ConnectionService.getConnection(login, passwd);
            Scene scene = SceneFabric.getScene(LoginService.getUserRoleGroup());

            Stage stage = (Stage) loginButton.getScene().getWindow();
            stage.setScene(scene);
        } catch (Exception e) {
            loginField.clear();
            passwordField.clear();
            errorLabel.opacityProperty().set(1);
        }
    }
}

