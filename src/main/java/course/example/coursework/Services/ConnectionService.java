package course.example.coursework.Services;


import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectionService {
    public static Connection currentConnection;

    public static void getConnection(String login, String password) {
        try {
            if (currentConnection != null) {
                closeConnection();
            }
            currentConnection = DriverManager.getConnection(
                    "jdbc:postgresql://localhost:5432/ProjectDB",
                    login,
                    password);//koval_19081994
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void closeConnection() {
        try {
            currentConnection.close();
            currentConnection = null;
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
