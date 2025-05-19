package course.example.coursework.Model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import java.util.Date;

@Entity
@Table(name = "repair")
public class Repair {
    @Id
    @Column(name = "repairno")
    private int repairNo;

    @Column(name = "departmentid")
    private int departmentID;

    @Column(name = "carserialnum")
    private String carSerialNum;

    @Column(name = "repairdate")
    private Date repairDate;

    @Column(name = "comment")
    private String comment;

    @Column(name = "status")
    private String status;

    @Column(name = "repairsum")
    private Double repairSum;

    public int getRepairNo() {
        return repairNo;
    }

    public int getDepartmentID() {
        return departmentID;
    }

    public String getCarSerialNum() {
        return carSerialNum;
    }

    public Date getRepairDate() {
        return repairDate;
    }

    public String getComment() {
        return comment;
    }

    public String getStatus() {
        return status;
    }

    public Double getRepairSum() {
        return repairSum;
    }

}
