package course.example.coursework.Controllers;

import course.example.coursework.Services.ClientServices.ClientCarService;
import course.example.coursework.Services.ClientServices.ClientService;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;

import java.net.URL;
import java.util.ResourceBundle;


public class ClientController implements Initializable {
    @FXML
    private Button carInfoButton;
    @FXML
    private BorderPane userGlobalBorderPane;
    @FXML
    private ScrollPane centerScrollPane;

    @FXML
    private Button clientInfoButton;

    @FXML
    private VBox personalCarsVBox;

    @FXML
    private VBox personalInfoVBox;

    @FXML
    private Button repairsInfoButton;

    @FXML
    private AnchorPane userDetailsPane;

    @FXML
    private AnchorPane carInfoHeaderAnchorPane;


    @FXML
    public void initialize(URL location, ResourceBundle resources) {
        ClientService.loadCurrentClient();
        ClientCarService.loadClientCars();

        personalInfoVBox = ClientService.createUserInfoVBox();
        userDetailsPane.getChildren().add(personalInfoVBox);
        ClientService.showClientInfo(personalInfoVBox);

        personalCarsVBox = ClientCarService.createCarsVBox_ClientInfoButton();
        userDetailsPane.getChildren().add(personalCarsVBox);
        ClientCarService.showClientCarsInfo_partial(personalCarsVBox);
    }

    @FXML
    public void clientInfoButtonClicked(ActionEvent event) {
        userDetailsPane.getChildren().clear();
        personalInfoVBox = ClientService.createUserInfoVBox();
        userDetailsPane.getChildren().add(personalInfoVBox);
        ClientService.showClientInfo(personalInfoVBox);

        personalCarsVBox = ClientCarService.createCarsVBox_ClientInfoButton();
        userDetailsPane.getChildren().add(personalCarsVBox);
        ClientCarService.showClientCarsInfo_partial(personalCarsVBox);
    }

    @FXML
    void carInfoButtonClicked(ActionEvent event) {
        userDetailsPane.getChildren().clear();
        carInfoHeaderAnchorPane = ClientCarService.createCarsHeaderAnchorPane_ClientCarsInfoButton();
        userDetailsPane.getChildren().add(carInfoHeaderAnchorPane);

        ClientCarService.showClientCarsInfo_full(userDetailsPane);

    }

    @FXML
    void repairsInfoButtonClicked(ActionEvent event) {
        userDetailsPane.getChildren().clear();

    }


}
