package course.example.coursework.Controllers;

import course.example.coursework.Fabric.SceneFabric;
import course.example.coursework.Services.HibernateService;
import course.example.coursework.Services.LoginService;
import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

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
            HibernateService.connect(login, passwd);
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

