package course.example.coursework;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

import java.util.Objects;

public class Main  extends Application {
    @Override
    public void start(Stage primaryStage) {
        try {
            Parent root = FXMLLoader.load(getClass().getResource("/course/example/coursework/login-view.fxml"));
            Scene scene = new Scene(root);
            primaryStage.setTitle("ENVYCorp: Car Repair");
            primaryStage.setScene(scene);
            primaryStage.setResizable(false);
             primaryStage.getIcons().add(
                     new Image(Objects.requireNonNull(getClass().getResourceAsStream("/images/companyLogo.png")))
        );
            primaryStage.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public static void main(String[] args) {
        launch();
    }
}
