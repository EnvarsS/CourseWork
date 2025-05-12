module course.example.coursework {
    requires javafx.controls;
    requires javafx.fxml;

    opens course.example.coursework.Controllers to javafx.fxml;
    opens course.example.coursework to javafx.fxml;
    exports course.example.coursework;
}