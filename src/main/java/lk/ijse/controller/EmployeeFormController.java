package lk.ijse.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import lk.ijse.dto.Employee;
import lk.ijse.model.EmployeeModel;

import java.sql.SQLException;

public class EmployeeFormController {

    @FXML
    private TextField empAdress;

    @FXML
    private TextField empContact;

    @FXML
    private TextField empId;

    @FXML
    private TextField empName;

    @FXML
    private TextField empNic;

    @FXML
    void btnDeleteOnAction(ActionEvent event) {
        if (empId.getText().matches("^[E0-9]{4}$")) {
            String id = empId.getText();

            try {
                boolean isDelete = EmployeeModel.delete(id);
                if (isDelete) {
                    new Alert(Alert.AlertType.CONFIRMATION, "ok").show();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }else {
            new Alert(Alert.AlertType.WARNING,"ID NOT VALIED !!!").show();
        }
    }

    @FXML
    void btnSaveOnAction(ActionEvent event) {
        if (empId.getText().matches("^[E0-9]{4}$")) {
            String name = empName.getText();
            String contact = empContact.getText();
            String id = empId.getText();
            String nic = empNic.getText();
            String adress = empAdress.getText();

            Employee employee = new Employee(name, contact, id, nic, adress);

            try {
                boolean isSave = EmployeeModel.save(employee);

                if (isSave) {
                    new Alert(Alert.AlertType.CONFIRMATION, "Ok").show();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }

        } else {
            new Alert(Alert.AlertType.WARNING, "ID NOT VALIED !!!").show();
        }
    }

    @FXML
    void btnSearchOnAction(ActionEvent event) {
        if (empId.getText().matches("^[E0-9]{4}$")) {
            String id = empId.getText();
            try {
                Employee employee = EmployeeModel.search(id);
                if (employee != null) {
                    empName.setText(employee.getEmployeeName());
                    empContact.setText(employee.getContact());
                    empId.setText(employee.getEmployeeId());
                    empNic.setText(employee.getEmployeenic());
                    empAdress.setText(employee.getEmployeeAdress());
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }

        } else {
            new Alert(Alert.AlertType.WARNING, "ID NOT VALIED !!!").show();
        }
    }

    @FXML
    void btnUpdateOnAction(ActionEvent event) {
        if (empId.getText().matches("^[E0-9]{4}$")) {
            String name = empName.getText();
            String contact = empContact.getText();
            String id = empId.getText();
            String nic = empNic.getText();
            String adress = empAdress.getText();

            Employee employee = new Employee(name, contact, id, nic, adress);
            try {
                boolean isUpdate = EmployeeModel.Update(employee);
                if (isUpdate) {
                    new Alert(Alert.AlertType.CONFIRMATION, "OK").show();
                }

            } catch (Exception e) {
                e.printStackTrace();
            }
        } else {
            new Alert(Alert.AlertType.WARNING, "ID NOT VALIED !!!").show();
        }
    }

    public void btnClearOnAction(ActionEvent actionEvent) {
        empName.setText("");
        empContact.setText("");
        empId.setText("");
        empNic.setText("");
        empAdress.setText("");
    }
}
