package lk.ijse.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import lk.ijse.dto.Supplier;
import lk.ijse.model.SupplierModel;

import java.sql.SQLException;

public class SuppliesFormController {

    @FXML
    private TextField txtadress;

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
        if (txtid.getText().matches("^[S0-9]{4}$")) {
            String id = txtid.getText();
            try {
                boolean isDelete = SupplierModel.delete(id);
                if (isDelete) {
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
    void btnSaveOnAction(ActionEvent event) {
        if (txtid.getText().matches("^[S0-9]{4}$")){
        String id=txtid.getText();
        String contact=txtcontact.getText();
        String name=txtname.getText();
        String nic=txtnic.getText();
        String adress=txtadress.getText();

        Supplier supplier=new Supplier(id,contact,name,nic,adress);

        try {
            boolean isSave=SupplierModel.save(supplier);
            if (isSave){
                new Alert(Alert.AlertType.CONFIRMATION,"OK").show();
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
    }else {
            new Alert(Alert.AlertType.WARNING, "ID NOT VALIED !!!").show();
        }
    }

    @FXML
    void btnSearchOnAction(ActionEvent event) {
        if (txtid.getText().matches("^[S0-9]{4}$")){
        String id=txtid.getText();
        try {
            Supplier supplier= SupplierModel.search(id);
            if (supplier!=null){
                txtid.setText(supplier.getSuppliersID());
                txtcontact.setText(supplier.getContact());
                txtname.setText(supplier.getSuppliersName());
                txtnic.setText(supplier.getSuppliersNic());
                txtadress.setText(supplier.getSuppliersAdress());
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
    } else {
            new Alert(Alert.AlertType.WARNING, "ID NOT VALIED !!!").show();
        }
    }

    @FXML
    void btnUpdateOnAction(ActionEvent event) {
        if (txtid.getText().matches("^[S0-9]{4}$")){
        String id=txtid.getText();
        String contact=txtcontact.getText();
        String name=txtname.getText();
        String nic=txtnic.getText();
        String adress=txtadress.getText();

        Supplier suppliers=new Supplier(id,contact,name,nic,adress);
        try {
            boolean isUpdate=SupplierModel.update(suppliers);
            if (isUpdate){
                new Alert(Alert.AlertType.CONFIRMATION,"OK").show();
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
    }else {
            new Alert(Alert.AlertType.WARNING, "ID NOT VALIED !!!").show();
        }
    }

    public void btnClearOnAction(ActionEvent actionEvent) {
        txtid.setText("");
        txtcontact.setText("");
        txtname.setText("");
        txtnic.setText("");
        txtadress.setText("");
    }
}
