package lk.ijse.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.awt.*;
import java.io.IOException;

public class LoginFormController {

    public javafx.scene.control.TextField txtUserName;
    public javafx.scene.control.TextField txtPassword;
    public javafx.scene.control.Button btnLogin;
    public javafx.scene.control.Button btnSign;
    @FXML
    private AnchorPane root;
    private Label lblLoginText;

    @FXML
    public void btnOnsAction(ActionEvent actionEvent) throws IOException {
        if (actionEvent.getSource() == btnLogin) {
            String username = txtUserName.getText();
            String password = txtPassword.getText();
            if (username.equalsIgnoreCase("tharu") && password.equalsIgnoreCase("1234")) {
                AnchorPane anchorPane = FXMLLoader.load(getClass().getResource("/view/dashboard_form.fxml"));
                Scene scene = new Scene(anchorPane);
                Stage stage = (Stage) root.getScene().getWindow();
                stage.setScene(scene);
                stage.setTitle("Dashboard");
                stage.centerOnScreen();
                return;
            }
            if
            (txtUserName.getText().isEmpty() && txtPassword.getText().isEmpty()) {
                lblLoginText.setText("Please enter your data.");
            } else {
                new Alert(Alert.AlertType.ERROR, "WRONG PASSWORD !!!").show();
            }
        }
        txtUserName.setText("");
        txtPassword.setText("");
    }
}
