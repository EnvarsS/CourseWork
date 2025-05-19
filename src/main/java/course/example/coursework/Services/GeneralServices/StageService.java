package course.example.coursework.Services.GeneralServices;

import javafx.stage.Stage;

public class StageService {
    private static Stage activeStage;

    public static void setStage(Stage stage) {
        activeStage = stage;
    }

    public static Stage activeStage() {
        return activeStage;
    }

}
