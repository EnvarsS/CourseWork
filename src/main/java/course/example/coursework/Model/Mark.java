package course.example.coursework.Model;

import jakarta.persistence.*;
import java.util.List;
@Entity
@Table(name = "mark")
public class Mark {
    @Id
    @Column(name = "markid")
    private int markID;
    @Column(name = "name")
    private String name;
    @ManyToOne
    @JoinColumn(name = "manufacturerid")
    private Manufacturer manufacturer;
    @OneToMany(mappedBy = "mark", fetch = FetchType.LAZY)
    private List<ClientCar> clientCars;

    public int getMarkID() {
        return markID;
    }

    public String getName() {
        return name;
    }

    public Manufacturer getManufacturer() {
        return manufacturer;
    }

    public List<ClientCar> getClientCars() {
        return clientCars;
    }
}
