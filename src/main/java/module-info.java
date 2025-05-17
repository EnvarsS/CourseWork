module course.example.coursework {
    requires javafx.controls;
    requires javafx.fxml;
    requires jakarta.persistence;
    requires org.hibernate.orm.core;
    requires java.naming;

    opens course.example.coursework.Controllers to javafx.fxml;
    opens course.example.coursework to javafx.fxml;
    exports course.example.coursework;
}