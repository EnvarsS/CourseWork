package course.example.coursework.Model;

import jakarta.persistence.*;
import org.hibernate.annotations.Type;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.*;

@Entity
@Table(name = "client")
public class Client {
    @Id
    private Short clientID;
    @Column(name = "firstname")
    private String firstName;
    @Column(name = "lastname")
    private String lastName;
    @Column(name = "telno")
    private String telNo;
    @Column(name = "discount", nullable = true)
    private BigDecimal discount;
    @Column(name = "username")
    private String username;

    @OneToMany(mappedBy = "clientid", fetch = FetchType.LAZY)
    private List<ClientCar> cars;

    public Client(Short clientID, String firstName, String lastName, String telNo, BigDecimal discount, String username) {
        this.clientID = clientID;
        this.firstName = firstName;
        this.lastName = lastName;
        this.telNo = telNo;
        this.discount = discount;
        this.username = username;
    }

    public Client() {

    }

    public int getClientID() {
        return clientID;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getTelNo() {
        return telNo;
    }

    public BigDecimal getDiscount() {
        return discount;
    }

    public String getUsername() {
        return username;
    }
}
