package course.example.coursework.Services.ClientServices;

import course.example.coursework.Model.ClientCar;
import course.example.coursework.Model.Manufacturer;
import course.example.coursework.Model.Mark;
import course.example.coursework.Services.GeneralServices.HibernateService;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import org.hibernate.Session;
import org.hibernate.query.NativeQuery;

import java.util.ArrayList;
import java.util.List;

public class ClientCarService {
    private static ArrayList<ClientCar> clientCars;

    public static void loadClientCars() {
        try (Session session = HibernateService.getSessionFactory().openSession()) {
            NativeQuery<ClientCar> query = session.createNativeQuery("SELECT serialnum, clientid, markid, carmanyear FROM ClientCar", ClientCar.class);
            clientCars = (ArrayList<ClientCar>) query.list();
            clientCars.add(new ClientCar("fsasafasfas", 1, 23, 1993));
            clientCars.add(new ClientCar("gdsgsdbcxbvdsds", 1, 10, 1995));
        }
    }

    public static VBox createCarsVBox_ClientInfoButton() {
        VBox personalCarsVBox = new VBox();
        personalCarsVBox.setLayoutX(30.0);
        personalCarsVBox.setLayoutY(250.0);
        personalCarsVBox.setPrefWidth(538.0);
        personalCarsVBox.setSpacing(15.0);
        personalCarsVBox.getStylesheets().add(ClientCarService.class.getResource("/styles/clientViewInfo.css").toExternalForm());
        personalCarsVBox.setId("personalCarsVBox");
        return personalCarsVBox;
    }

    public static AnchorPane createCarsHeaderAnchorPane_ClientCarsInfoButton() {
        AnchorPane carInfoHeaderAnchorPane = new AnchorPane();
        carInfoHeaderAnchorPane.setPrefHeight(46.0);
        carInfoHeaderAnchorPane.setPrefWidth(200.0);
        carInfoHeaderAnchorPane.setLayoutX(199.0);
        carInfoHeaderAnchorPane.setLayoutY(14.0);
        carInfoHeaderAnchorPane.setId("carInfoHeaderAnchorPane");
        carInfoHeaderAnchorPane.getStylesheets().add(ClientCarService.class.getResource("/styles/clientCarsViewInfo.css").toExternalForm());

        Label carInfoHeaderLabel = new Label("CARS");
        carInfoHeaderLabel.setLayoutX(70.0);
        carInfoHeaderLabel.setLayoutY(12.0);
        carInfoHeaderLabel.setId("CarInfoHeaderLabel");
        carInfoHeaderLabel.getStylesheets().add(ClientCarService.class.getResource("/styles/clientCarsViewInfo.css").toExternalForm());
        carInfoHeaderAnchorPane.getChildren().add(carInfoHeaderLabel);
        return carInfoHeaderAnchorPane;
    }

    public static VBox createCarsInfoVBox_ClientCarsInfoButton(int carNumber) { /// ///////////////
        double firstLayout = 100.0;
        double exactLayout = firstLayout + 40 * carNumber + 150 * carNumber;
        VBox personalCarsInfoVBox = new VBox();
        personalCarsInfoVBox.setLayoutX(30.0);
        personalCarsInfoVBox.setLayoutY(exactLayout);
        personalCarsInfoVBox.setPrefWidth(538.0);
        personalCarsInfoVBox.setSpacing(15.0);
        personalCarsInfoVBox.getStylesheets().add(ClientCarService.class.getResource("/styles/clientCarsViewInfo.css").toExternalForm());
        personalCarsInfoVBox.setId("personalCarsInfoVBox");
        return personalCarsInfoVBox;
    }

    public static void showClientCarsInfo_partial(VBox personalCarsVBox) {
        personalCarsVBox.getChildren().clear();
        Label header = new Label("Cars");
        header.setId("PersonalCarsHeader");
        header.getStyleClass().add("clientViewInfo");
        personalCarsVBox.getChildren().add(header);
        if (clientCars.isEmpty()) {
            Label label = new Label("Cars are not added yet");
            label.setId("PersonalCarsLabel");
            label.getStyleClass().add("clientViewInfo");
            personalCarsVBox.getChildren().add(label);
            return;
        }
        for (ClientCar car : clientCars) {
            Mark mark = getCarMarkByMarkID(car.getMarkID());
            Manufacturer manufacturer = getCarManufacturerByManufacturerID(mark.getManufacturerID());
            Label label = new Label((clientCars.indexOf(car) + 1) + ". " + manufacturer.getName() + " " + mark.getName());
            label.setId("PersonalCarsLabel");
            label.getStyleClass().add("clientViewInfo");
            personalCarsVBox.getChildren().add(label);
        }
    }

    public static void showClientCarsInfo_full(AnchorPane userDetailsPane) {////////////////////////
        if (clientCars.isEmpty()) {
            VBox vbox = createCarsInfoVBox_ClientCarsInfoButton(1);
            Label label = new Label("Cars are not added yet");
            label.setId("PersonalCarsInfoLabel");
            label.getStylesheets().add(ClientCarService.class.getResource("/styles/clientCarsViewInfo.css").toExternalForm());
            vbox.getChildren().add(label);
            userDetailsPane.getChildren().add(vbox);
            return;
        }
        for (ClientCar car : clientCars) {
            Mark mark = getCarMarkByMarkID(car.getMarkID());
            Manufacturer manufacturer = getCarManufacturerByManufacturerID(mark.getManufacturerID());
            int carNumber = clientCars.indexOf(car);
            VBox carInfoVBox = createCarsInfoVBox_ClientCarsInfoButton(carNumber);
            Label carManufacturer_Mark = new Label(manufacturer.getName() + " " + mark.getName());
            Label carSerialNum = new Label("Serial number: " + car.getSerialNum());
            Label carManYear = new Label("Year of manufacture: " + car.getCarManYear());

            carManufacturer_Mark.getStylesheets().add(ClientCarService.class.getResource("/styles/clientCarsViewInfo.css").toExternalForm());
            carManufacturer_Mark.setId("carNameLabel");
            carInfoVBox.getChildren().add(carManufacturer_Mark);
            for (Label label : List.of(carSerialNum, carManYear)) {
                label.getStylesheets().add(ClientCarService.class.getResource("/styles/clientCarsViewInfo.css").toExternalForm());
                label.setId("PersonalCarsInfoLabel");
                carInfoVBox.getChildren().add(label);
            }
            userDetailsPane.getChildren().add(carInfoVBox);
        }
    }


    private static Mark getCarMarkByMarkID(Integer markID) {
        try (Session session = HibernateService.getSessionFactory().openSession()) {
            NativeQuery<Mark> query = session.createNativeQuery("SELECT * FROM Mark  WHERE markID = ?", Mark.class);
            query.setParameter(1, markID);
            return query.uniqueResult();
        }
    }

    private static Manufacturer getCarManufacturerByManufacturerID(Integer manufacturerID) {
        try (Session session = HibernateService.getSessionFactory().openSession()) {
            NativeQuery<Manufacturer> query = session.createNativeQuery("SELECT * FROM Manufacturer WHERE ManufacturerID = ?", Manufacturer.class);
            query.setParameter(1, manufacturerID);
            return query.uniqueResult();
        }
    }
}
