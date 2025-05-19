package course.example.coursework.Services.ClientServices;

import course.example.coursework.Model.Client;
import course.example.coursework.Model.ClientCar;
import course.example.coursework.Services.GeneralServices.HibernateService;
import course.example.coursework.Services.GeneralServices.StageService;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import org.hibernate.Session;
import org.hibernate.query.NativeQuery;

import java.util.List;

public class ClientService {
    private static Client currentClient;

    public static void loadCurrentClient() {
        try (Session session = HibernateService.getSessionFactory().openSession()) {
            NativeQuery<Client> query = session.createNativeQuery("SELECT * FROM Client", Client.class);
            currentClient = query.uniqueResult();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static VBox createUserInfoVBox(){
        VBox personalInfoVBox = new VBox();
        personalInfoVBox.setLayoutX(30.0);
        personalInfoVBox.setLayoutY(30.0);
        personalInfoVBox.setPrefWidth(538.0);
        personalInfoVBox.setSpacing(15.0);
        personalInfoVBox.getStylesheets().add(ClientService.class.getResource("/styles/clientViewInfo.css").toExternalForm());
        personalInfoVBox.setId("personalInfoVBox");
        return personalInfoVBox;
    }

    public static void showClientInfo(VBox personalInfoVBox) {
        personalInfoVBox.getChildren().clear();
        Label header = new Label("Personal Info");
        header.setId("PersonalInfoHeader");
        header.getStyleClass().add("clientViewInfo");
        Label firstNameLabel = new Label("Name: " + currentClient.getFirstName() + " " + currentClient.getLastName());
        Label telLabel = new Label("Phone Number: " + currentClient.getTelNo());
        Label discountLabel = new Label("Discount: " + (currentClient.getDiscount() == null ? "0%" : (currentClient.getDiscount() + "%")));
        personalInfoVBox.getChildren().add(header);

        for (Label label : List.of(firstNameLabel, telLabel, discountLabel)) {
            label.setId("PersonalInfoLabel");
            label.getStyleClass().add("clientViewInfo");
            personalInfoVBox.getChildren().add(label);
        }
    }
}
