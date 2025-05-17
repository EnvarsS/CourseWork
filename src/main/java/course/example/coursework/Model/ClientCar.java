package course.example.coursework.Model;

import jakarta.persistence.*;

@Entity
@Table(name = "clientcar")
public class ClientCar {
    @Id
    @Column(name = "serialnum")
    private String serialNum;
    @ManyToOne
    @JoinColumn(name = "clientID")
    private Client client;
    @ManyToOne
    @JoinColumn(name = "markID")
    private Mark mark;
    @Column(name = "carmanyear")
    private int carManYear;

    public String getSerialNum() {
        return serialNum;
    }

    public Client getClient() {
        return client;
    }

    public Mark getMark() {
        return mark;
    }

    public int getCarManYear() {
        return carManYear;
    }
}
