package course.example.coursework.Model;

import jakarta.persistence.*;

@Entity
@Table(name = "clientcar")
public class ClientCar {
    @Id
    @Column(name = "serialnum")
    private String serialNum;
    @Column(name = "markid")
    private Integer markID;
    @Column(name = "clientid")
    private Integer clientID;
    @Column(name = "carmanyear")
    private int carManYear;

    public ClientCar() {

    }

    public String getSerialNum() {
        return serialNum;
    }

    public Integer getClientID() {
        return clientID;
    }

    public Integer getMarkID() {
        return markID;
    }

    public int getCarManYear() {
        return carManYear;
    }

    public ClientCar(String serialNum, Integer clientID, Integer markID, int carManYear) {
        this.serialNum = serialNum;
        this.clientID = clientID;
        this.markID = markID;
        this.carManYear = carManYear;
    }
}
