package course.example.coursework.Services;


import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.io.InputStream;
import java.util.Properties;

public class HibernateService {
    private static SessionFactory sessionFactory;

    public static void connect(String login, String password) {
        Properties props = new Properties();
        try {
            InputStream input = HibernateService.class.getClassLoader().getResourceAsStream("hibernate.properties");
            props.load(input);
            props.setProperty("hibernate.connection.username", "ann_koval"/*login*/);
            props.setProperty("hibernate.connection.password", "ann_koval1928"/*password*/);
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        Configuration config = new Configuration();
        config.addProperties(props);
        sessionFactory = config.buildSessionFactory();
    }

    public static SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    public static void close() {
        try {
            sessionFactory.close();
            sessionFactory = null;
        } catch (Exception e) {

        }
    }

}
