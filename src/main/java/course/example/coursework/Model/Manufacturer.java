package course.example.coursework.Model;

import jakarta.persistence.*;
import java.util.*;

@Entity
@Table(name = "manufacturer")
public class Manufacturer {
    @Id
    @Column(name = "manufacturerid")
    private int manufacturerID;
    @Column(name = "name")
    private String name;

    public Manufacturer() {

    }

    public String getName() {
        return name;
    }

    public int getManufacturerID() {
        return manufacturerID;
    }

    public Manufacturer(int manufacturerID, String name) {
        this.manufacturerID = manufacturerID;
        this.name = name;
    }
}
