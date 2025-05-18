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

    // Getters
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

    // Setters
    public void setRepairNo(int repairNo) {
        this.repairNo = repairNo;
    }

    public void setDepartmentID(int departmentID) {
        this.departmentID = departmentID;
    }

    public void setCarSerialNum(String carSerialNum) {
        this.carSerialNum = carSerialNum;
    }

    public void setRepairDate(Date repairDate) {
        this.repairDate = repairDate;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public void setRepairSum(Double repairSum) {
        this.repairSum = repairSum;
    }
}
