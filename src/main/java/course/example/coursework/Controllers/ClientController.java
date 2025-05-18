package course.example.coursework.Controllers;

import course.example.coursework.Model.*;
import course.example.coursework.Services.HibernateService;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.scene.Node;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import org.hibernate.Session;
import org.hibernate.query.NativeQuery;
import org.hibernate.query.Query;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;


public class ClientController implements Initializable {
    @FXML
    private Button clientInfoButton;
    @FXML
    private Button carInfoButton;
    @FXML
    private Button repairsInfoButton;
    @FXML
    private ScrollPane centerScrollPane;

    private Client currentClient;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        loadCurrentClient();
        //setupButtonActions();
        showClientInfo(); // Show client info by default
    }

    private void loadCurrentClient() {
        try (Session session = HibernateService.getSessionFactory().openSession()) {
            Query<Client> query = session.createNamedQuery("getCurrentClient", Client.class);
            currentClient = query.uniqueResult();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
     @FXML
    private void showClientInfo() {

        VBox content = new VBox(20);
        content.setPadding(new Insets(30));
        //content.getStyleClass().add("content-container");

        // Title
        Label title = new Label("Personal Information");
        //title.getStyleClass().add("title-label");

        // Client details form
        GridPane infoGrid = new GridPane();
        infoGrid.setHgap(20);
        infoGrid.setVgap(15);
        //infoGrid.getStyleClass().add("info-grid");

        // Client ID
        Label clientIdLabel = new Label("Client ID:");
        //clientIdLabel.getStyleClass().add("info-label");
        Label clientIdValue = new Label(String.valueOf(currentClient.getClientID()));
        //clientIdValue.getStyleClass().add("info-value");

        // First Name
        Label firstNameLabel = new Label("First Name:");
        //firstNameLabel.getStyleClass().add("info-label");
        Label firstNameValue = new Label(currentClient.getFirstName());
        //firstNameValue.getStyleClass().add("info-value");

        // Last Name
        Label lastNameLabel = new Label("Last Name:");
        //lastNameLabel.getStyleClass().add("info-label");
        Label lastNameValue = new Label(currentClient.getLastName());
        //lastNameValue.getStyleClass().add("info-value");

        // Phone Number
        Label phoneLabel = new Label("Phone Number:");
        //phoneLabel.getStyleClass().add("info-label");
        Label phoneValue = new Label(currentClient.getTelNo());
        //phoneValue.getStyleClass().add("info-value");

        // Username
        Label usernameLabel = new Label("Username:");
        //usernameLabel.getStyleClass().add("info-label");
        Label usernameValue = new Label(currentClient.getUsername());
        //usernameValue.getStyleClass().add("info-value");

        // Add to grid
        infoGrid.add(clientIdLabel, 0, 0);
        infoGrid.add(clientIdValue, 1, 0);
        infoGrid.add(firstNameLabel, 0, 1);
        infoGrid.add(firstNameValue, 1, 1);
        infoGrid.add(lastNameLabel, 0, 2);
        infoGrid.add(lastNameValue, 1, 2);
        infoGrid.add(phoneLabel, 0, 3);
        infoGrid.add(phoneValue, 1, 3);
        infoGrid.add(usernameLabel, 0, 4);
        infoGrid.add(usernameValue, 1, 4);

        content.getChildren().addAll(title, infoGrid);
        centerScrollPane.setContent(content);
    }
}
