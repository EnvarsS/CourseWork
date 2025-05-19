module course.example.coursework {
    requires javafx.controls;
    requires javafx.fxml;
    requires jakarta.persistence;
    requires org.hibernate.orm.core;
    requires java.naming;
    requires spring.data.commons;
    requires spring.data.jpa;

    opens course.example.coursework.Controllers to javafx.fxml;
    opens course.example.coursework to javafx.fxml;
    opens course.example.coursework.Model to org.hibernate.orm.core, javafx.base;

    exports course.example.coursework;
    exports course.example.coursework.Model;
    exports course.example.coursework.Controllers;
}