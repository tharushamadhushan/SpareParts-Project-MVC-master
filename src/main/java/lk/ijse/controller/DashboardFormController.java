package lk.ijse.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import lk.ijse.model.CustomerModel;
import lk.ijse.model.ItemModel;
import lk.ijse.model.OrderModel;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;
import java.net.URI;
import java.net.URL;
import java.sql.SQLException;

public class DashboardFormController {
    public Label lblTotalOrders;
    public Label lblTotalCustomers;
    public Label lblCompanyCount;
    public Label lblTotalSales;
    @FXML
    private AnchorPane root;


    @FXML
    private AnchorPane LoadContext;
    private JInternalFrame stage;



    @FXML
    public void initialize(){

        try {
            int customerCount = CustomerModel.countCustomers();
            int countOrders = OrderModel.countOrders();
            double totalOrderSales = OrderModel.getTotalOrderSales();
            int itemCount= ItemModel.countItem();
            //double totalMonthlySales = OrderModel.getTotalOrderSales();

            lblTotalCustomers.setText(String.valueOf(customerCount));
            lblTotalOrders.setText(String.valueOf(countOrders));
            lblTotalSales.setText(String.valueOf(totalOrderSales));
            lblCompanyCount.setText(String.valueOf(itemCount));
            //lblMonthlyOrders.setText(String.valueOf(totalMonthlySales));
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    @FXML
    void btnCustomerOnAction(ActionEvent event) throws IOException {
        URL resource = getClass().getResource("/view/customer_form.fxml");
        assert resource != null;
        Parent load = FXMLLoader.load(resource);
        LoadContext.getChildren().clear();
        LoadContext.getChildren().add(load);

    }

    @FXML
    void btnSupplierOnAction(ActionEvent event) throws IOException {
        URL resource = getClass().getResource("/view/supplies_form.fxml");
        assert resource != null;
        Parent load = FXMLLoader.load(resource);
        LoadContext.getChildren().clear();
        LoadContext.getChildren().add(load);
    }
    @FXML
    void btnItemOnAction(ActionEvent actionEvent) throws IOException {
        URL resource = getClass().getResource("/view/item_form.fxml");
        assert resource != null;
        Parent load = FXMLLoader.load(resource);
        LoadContext.getChildren().clear();
        LoadContext.getChildren().add(load);
    }

    @FXML
    void btnAttendenceOnAction(ActionEvent actionEvent) throws IOException {
        URL resource = getClass().getResource("/view/attendance_form.fxml");
        assert resource != null;
        Parent load = FXMLLoader.load(resource);
        LoadContext.getChildren().clear();
        LoadContext.getChildren().add(load);
    }

    public void btnEmployeeOnAction(ActionEvent actionEvent) throws IOException {
        URL resource = getClass().getResource("/view/employee_form.fxml");
        assert resource != null;
        Parent load = FXMLLoader.load(resource);
        LoadContext.getChildren().clear();
        LoadContext.getChildren().add(load);
    }

    public void btnDeliveryOnAction(ActionEvent actionEvent) throws IOException {
        URL resource = getClass().getResource("/view/delivery_form.fxml");
        assert resource != null;
        Parent load = FXMLLoader.load(resource);
        LoadContext.getChildren().clear();
        LoadContext.getChildren().add(load);
    }

    public void btnPlaceOrderOnAction(ActionEvent actionEvent) throws IOException {
        URL resource = getClass().getResource("/view/placeorder_form.fxml");
        assert resource != null;
        Parent load = FXMLLoader.load(resource);
        LoadContext.getChildren().clear();
        LoadContext.getChildren().add(load);
    }

    public void btnPlaceSuppliesOnAction(ActionEvent actionEvent) throws IOException {
        URL resource = getClass().getResource("/view/placesupplier_form.fxml");
        assert resource != null;
        Parent load = FXMLLoader.load(resource);
        LoadContext.getChildren().clear();
        LoadContext.getChildren().add(load);
    }

    public void btnReportOnAction(ActionEvent actionEvent) throws IOException {
        URL resource = getClass().getResource("/view/report_form.fxml");
        assert resource != null;
        Parent load = FXMLLoader.load(resource);
        LoadContext.getChildren().clear();
        LoadContext.getChildren().add(load);
    }

    public void btnWhatsappOnAction(ActionEvent actionEvent) {
        try {
            java.awt.Desktop desktop = java.awt.Desktop.getDesktop();
            URI uri = new URI("https://www.whatsapp.com/");
            desktop.browse(uri);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public void btnHomeOnAction(ActionEvent actionEvent) throws IOException {
        URL resource=getClass().getResource("/view/dashboard_form.fxml");
        assert resource != null;
        Parent load = FXMLLoader.load(resource);
        root.getChildren().clear();
        root.getChildren().add(load);
    }

    public void btnLogoutOnAction(ActionEvent actionEvent) throws IOException {
        AnchorPane anchorPane = FXMLLoader.load(getClass().getResource("/view/login_form.fxml"));
        Scene scene = new Scene(anchorPane);
        Stage stage = (Stage) root.getScene().getWindow();
        stage.setScene(scene);
        stage.setTitle("Login Page");
        stage.centerOnScreen();

    }

    public void btnTwitterOnAction(ActionEvent actionEvent) {
        try {
            java.awt.Desktop desktop = java.awt.Desktop.getDesktop();
            URI uri = new URI("https://www.twitter.com/");
            desktop.browse(uri);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public void btnInstagramOnAction(ActionEvent actionEvent) {
        try {
            java.awt.Desktop desktop = java.awt.Desktop.getDesktop();
            URI uri = new URI("https://www.instagram.com/");
            desktop.browse(uri);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public void btnFacebookOnAction(ActionEvent actionEvent) {
        try {
            java.awt.Desktop desktop = java.awt.Desktop.getDesktop();
            URI uri = new URI("https://www.facebook.com/");
            desktop.browse(uri);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
