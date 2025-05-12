package course.example.coursework.Fabric;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;

import java.util.HashMap;

public class SceneFabric {
    public static Scene getScene(course.example.coursework.Enum.Scene sceneType) {
        try {
            return switch (sceneType) {
                case LOGIN ->
                        new Scene(FXMLLoader.load(SceneFabric.class.getResource("/course/example/coursework/login-view.fxml")));
                case CLIENT ->
                        new Scene(FXMLLoader.load(SceneFabric.class.getResource("/course/example/coursework/client-view.fxml")));
                case MECHANIC -> null;
                case ADMIN -> null;
            };
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

}
