package course.example.coursework.Model;

import jakarta.persistence.*;
import java.util.*;

@NamedNativeQueries(
            @NamedNativeQuery(name = "getCurrentClient",
            query = "SELECT * FROM client",
            resultClass = Client.class)
    )

@Entity
@Table(name = "client")
public class Client {
    @Id
    private int clientID;
    @Column(name = "firstname")
    private String firstName;
    @Column(name = "lastname")
    private String lastName;
    @Column(name = "telno")
    private String telNo;
    @Column(name = "username")
    private String username;
    @OneToMany(mappedBy = "client", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<ClientCar> clientCars;

    public int getClientID() {
        return clientID;
    }

    public void setClientID(int clientID) {
        this.clientID = clientID;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getTelNo() {
        return telNo;
    }

    public void setTelNo(String telNo) {
        this.telNo = telNo;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public List<ClientCar> getClientCars() {
        return clientCars;
    }
}
