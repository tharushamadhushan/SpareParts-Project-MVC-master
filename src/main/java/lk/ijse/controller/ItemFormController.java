package lk.ijse.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import lk.ijse.dto.Customer;
import lk.ijse.dto.Employee;
import lk.ijse.dto.Item;
import lk.ijse.model.CustomerModel;
import lk.ijse.model.EmployeeModel;
import lk.ijse.model.ItemModel;

import java.sql.SQLException;

public class ItemFormController {

    @FXML
    private TextField txtid;

    @FXML
    private TextField txtname;

    @FXML
    private TextField txtqty;

    @FXML
    private TextField txttype;

    @FXML
    private TextField txtunitprice;

    @FXML
    void btnDeleteOnAction(ActionEvent event) {
        if (txtid.getText().matches("^[P0-9]{4}$")) {
        String id = txtid.getText();

        try {
            boolean isDelete = ItemModel.delete(id);
            if(isDelete){
                new Alert(Alert.AlertType.CONFIRMATION,"ok").show();
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
    }else {
            new Alert(Alert.AlertType.WARNING, "ID NOT VALIED !!!").show();
        }
    }

    @FXML
    void btnSaveOnAction(ActionEvent event) {
        if (txtid.getText().matches("^[P0-9]{4}$")) {
        String id = txtid.getText();
        String name = txtname.getText();
        String type = txttype.getText();
       Double price = Double.valueOf(txtunitprice.getText());
        Integer qty = Integer.valueOf(txtqty.getText());

        Item item = new Item(id, name, type, price, qty);

        try {
            boolean isSave = ItemModel.save(item);

           if(isSave){
                new Alert(Alert.AlertType.CONFIRMATION,"Ok").show();
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
        if (txtid.getText().matches("^[P0-9]{4}$")) {
        String id = txtid.getText();

        try {
            Item item = ItemModel.search(id);

            if (item!= null) {
               txtid.setText(item.getPartId());
               txtname.setText(item.getPartsName());
               txttype.setText(item.getType());
               txtunitprice.setText(String.valueOf(item.getUnitPrice()));
               txtqty.setText(String.valueOf(item.getQtyOnStock()));
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

    }else {
            new Alert(Alert.AlertType.WARNING, "ID NOT VALIED !!!").show();
        }
    }

    @FXML
    void btnUpdateOnAction(ActionEvent event) {
        if (txtid.getText().matches("^[P0-9]{4}$")) {
        String id = txtid.getText();
        String name = txtname.getText();
        String type = txttype.getText();
        Double price = Double.valueOf(txtunitprice.getText());
        Integer qty = Integer.valueOf(txtqty.getText());


        Item item = new Item(id,name,type,price,qty);
        try {
            boolean isUpdate = ItemModel.Update(item);
            if (isUpdate) {
                new Alert(Alert.AlertType.CONFIRMATION, "OK").show();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }else {
            new Alert(Alert.AlertType.WARNING, "ID NOT VALIED !!!").show();
        }
    }

    public void btnClearOnAction(ActionEvent actionEvent) {
        txtid.setText("");
        txtname.setText("");
        txttype.setText("");
        txtunitprice.setText("");
        txtqty.setText("");
    }
}

