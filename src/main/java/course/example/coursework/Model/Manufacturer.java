package course.example.coursework.Model;

import jakarta.persistence.*;
import java.util.*;

@Entity
@Table(name = "manufacturer")
public class Manufacturer {
    @Id
    @Column(name = "manufacturerid")
    private int manufacturerID;

    @OneToMany(mappedBy = "manufacturer", fetch = FetchType.LAZY)
    private List<Mark> marks;

    public int getManufacturerID() {
        return manufacturerID;
    }

    public List<Mark> getMarks() {
        return marks;
    }
}
