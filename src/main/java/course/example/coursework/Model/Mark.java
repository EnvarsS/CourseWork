package course.example.coursework.Model;

import jakarta.persistence.*;

@Entity
@Table(name = "mark")
public class Mark {
    @Id
    @Column(name = "markid")
    private int markID;
    @Column(name = "name")
    private String name;
    @Column(name = "manufacturerid")
    private int manufacturerID;

    public Mark() {

    }

    public int getMarkID() {
        return markID;
    }

    public String getName() {
        return name;
    }

    public int getManufacturerID() {
        return manufacturerID;
    }

    public Mark(int markID, String name, int manufacturerID) {
        this.markID = markID;
        this.name = name;
        this.manufacturerID = manufacturerID;
    }
}
