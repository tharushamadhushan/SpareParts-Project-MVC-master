package lk.ijse.controller;


import javafx.fxml.FXML;
import lk.ijse.db.DBConnection;
import net.sf.jasperreports.engine.*;
import net.sf.jasperreports.engine.design.JRDesignQuery;
import net.sf.jasperreports.engine.design.JasperDesign;
import net.sf.jasperreports.engine.xml.JRXmlLoader;
import net.sf.jasperreports.view.JasperViewer;

import java.awt.event.ActionEvent;
import java.io.File;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.HashMap;

public class ReportFormController {

    @FXML

    public void btnReportOnAction ()throws JRException, SQLException, ClassNotFoundException {
       /* InputStream inputStream = this.getClass().getResourceAsStream("/report/report.jrxml");
        try {
            JasperReport compileReport = JasperCompileManager.compileReport(inputStream);
            JasperPrint jasperPrint = JasperFillManager.fillReport(compileReport,null, DBConnection.getInstance().getConnection());
            JasperPrintManager.printReport(jasperPrint,true);
            JasperViewer.viewReport(jasperPrint,false);
        } catch (JRException | SQLException e) {
            e.printStackTrace();
        }
    }*/
       /* try {
            JasperDesign load= JRXmlLoader.load("C:\\Users\\Admin\\Desktop\\finalproject (3)\\finalproject\\finalproject\\src\\main\\resources\\report\\report.jrxml");
            Connection connection=DBConnection.getInstance().getConnection();
            JasperReport compileReport=JasperCompileManager.compileReport(load);

            JasperPrint jasperPrint=JasperFillManager.fillReport(compileReport,null,connection);
            JasperViewer.viewReport(jasperPrint,false);




        } catch (JRException | SQLException e) {
            e.printStackTrace();
        }*/
        JasperDesign load = null;
        load = JRXmlLoader.load(new File("C:\\Users\\Admin\\Desktop\\finalproject (3)\\finalproject\\finalproject\\src\\main\\resources\\report\\newReport.jrxml"));
        JRDesignQuery newQuery = new JRDesignQuery();
        String sql = "select i.description as name,i.unitPrice as unitPrice,oi.orderQTY , i.unitPrice*oi.orderQTY as subTotal  from parts i inner join orderdetail oi on  i.itemCode=oi.itemcode where oi.orderId = '"+"O001"+"'";
        newQuery.setText(sql);
        load.setQuery(newQuery);
        JasperReport js = JasperCompileManager.compileReport(load);
        HashMap<String,Object> hm=new HashMap<>();
        hm.put("sparepartsOrder","Name");
        hm.put("orderId","O001");
        JasperPrint jp = JasperFillManager.fillReport(js, null, DBConnection.getInstance().getConnection());
        JasperViewer viewer = new JasperViewer(jp, false);
        viewer.show();

    }
}
