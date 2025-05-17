package course.example.coursework.Fabric;

import course.example.coursework.Enum.SceneType;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;

public class SceneFabric {
    public static Scene getScene(SceneType sceneType) {
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
