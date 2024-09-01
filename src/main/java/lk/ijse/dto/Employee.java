package lk.ijse.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

public class Employee {
    private String employeeName;
    private String contact;
    private String employeeId;
    private String employeenic;
    private String employeeAdress;


    public String getEmployeeName() {
        return employeeName;
    }

    public void setEmployeeName(String employeeName) {
        this.employeeName = employeeName;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    public String getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(String employeeId) {
        this.employeeId = employeeId;
    }

    public String getEmployeenic() {
        return employeenic;
    }

    public void setEmployeenic(String employeenic) {
        this.employeenic = employeenic;
    }

    public String getEmployeeAdress() {
        return employeeAdress;
    }

    public void setEmployeeAdress(String employeeAdress) {
        this.employeeAdress = employeeAdress;
    }

    public Employee(String employeeName, String contact, String employeeId, String employeenic, String employeeAdress) {
        this.employeeName=employeeName;
        this.contact=contact;
        this.employeeAdress=employeeAdress;
        this.employeeId=employeeId;
        this.employeenic=employeenic;
    }

    public Employee() {
    }

    @Override
    public String toString() {
        return "Employee{" +
                "employeeName='" + employeeName + '\'' +
                ", contact='" + contact + '\'' +
                ", employeeId='" + employeeId + '\'' +
                ", employeenic='" + employeenic + '\'' +
                ", employeeAdress='" + employeeAdress + '\'' +
                '}';
    }
}
