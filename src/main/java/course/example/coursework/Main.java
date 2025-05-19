package course.example.coursework;

import course.example.coursework.Enum.SceneType;
import course.example.coursework.Fabric.SceneFabric;
import course.example.coursework.Services.GeneralServices.StageService;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

import java.util.Objects;

public class Main  extends Application {
    @Override
    public void start(Stage primaryStage) {
        try {
            Scene mainScene = SceneFabric.getScene(SceneType.LOGIN);
            StageService.setStage(primaryStage);
            StageService.activeStage().setScene(mainScene);
            StageService.activeStage().setTitle("ENVYCorp: Car Repair");
            StageService.activeStage().setResizable(false);
             StageService.activeStage().getIcons().add(
                     new Image(Objects.requireNonNull(getClass().getResourceAsStream("/images/companyLogo.png")))
        );
            StageService.activeStage().show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public static void main(String[] args) {
        launch();
    }
}
