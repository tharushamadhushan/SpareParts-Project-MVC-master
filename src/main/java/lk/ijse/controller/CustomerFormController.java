package lk.ijse.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import lk.ijse.dto.Customer;
import lk.ijse.model.CustomerModel;

import java.sql.SQLException;

public class CustomerFormController {

    @FXML
    private TextField txtcontact;

    @FXML
    private TextField txtid;

    @FXML
    private TextField txtname;

    @FXML
    private TextField txtnic;

    @FXML
    void btnDeleteOnAction(ActionEvent event) {
        if (txtid.getText().matches("^[C0-9]{4}$")) {
            String id = txtid.getText();
            try {
                boolean isDelete = CustomerModel.delete(id);
                if (isDelete) {
                    new Alert(Alert.AlertType.CONFIRMATION, "OK").show();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }else{
            new Alert(Alert.AlertType.WARNING,"ID NOT VALIED !!!").show();
        }
    }

    @FXML
    void btnSaveOnAction(ActionEvent event) {
        if (txtid.getText().matches("^[C0-9]{4}$")) {
            String id = txtid.getText();
            String name = txtname.getText();
            String contact = txtcontact.getText();
            String nic = txtnic.getText();

            Customer customer = new Customer(id, name, contact, nic);

            try {
                boolean isSave = CustomerModel.save(customer);
                if (isSave) {
                    new Alert(Alert.AlertType.CONFIRMATION, "ok").show();
                }
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }else{
            new Alert(Alert.AlertType.WARNING, "ID NOT VALIED !!!").show();
        }
    }

    @FXML
    void btnSearchOnAction(ActionEvent event) {
        if (txtid.getText().matches("^[C0-9]{4}$")) {
            String id = txtid.getText();

            try {
                Customer customer = CustomerModel.search(id);

                if (customer != null) {
                    txtid.setText(customer.getCustId());
                    txtname.setText(customer.getCustName());
                    txtcontact.setText(customer.getContact());
                    txtnic.setText(customer.getCustNic());
                }
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        } else {
            new Alert(Alert.AlertType.WARNING, "ID NOT VALIED !!!").show();
        }
    }

    @FXML
    void btnUpdateOnAction(ActionEvent event) {
        if (txtid.getText().matches("^[C0-9]{4}$")) {
            String id = txtid.getText();
            String name = txtname.getText();
            String nic = txtnic.getText();
            String contact = txtcontact.getText();

            Customer customer = new Customer(id, name, nic, contact);
            try {
                boolean isUpdate = CustomerModel.Update(customer);
                if (isUpdate) {
                    new Alert(Alert.AlertType.CONFIRMATION, "OK").show();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        } else {
            new Alert(Alert.AlertType.WARNING, "ID NOT VALIED !!!").show();
        }
    }
@FXML
    public void btnClearOnAction(ActionEvent actionEvent) {
        txtid.setText("");
        txtname.setText("");
        txtnic.setText("");
        txtcontact.setText("");
    }
}

