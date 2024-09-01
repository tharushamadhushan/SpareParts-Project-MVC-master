package lk.ijse.model;

import lk.ijse.Util.CrudUtil;
import lk.ijse.dto.Supplier;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class SupplierModel {
    public static boolean delete(String id) throws SQLException {
        String sql="DELETE FROM suppliers WHERE suppliersID=?";
        return CrudUtil.execute(sql,id);
    }

    public static boolean save(Supplier supplier) throws SQLException {
        String sql="INSERT INTO suppliers(suppliersID,contact,suppliersName,suppliersNic,suppliersAdress)VALUES(?,?,?,?,?)";
        return CrudUtil.execute(sql,supplier.getSuppliersID(),supplier.getContact(),supplier.getSuppliersName(),supplier.getSuppliersNic(),supplier.getSuppliersAdress());
    }

    public static Supplier search(String id) throws SQLException {
        String sql="SELECT * FROM suppliers WHERE suppliersID=?";
        ResultSet resultSet=CrudUtil.execute(sql,id);

        if (resultSet.next()){
            String suppliersID=resultSet.getString(1);
            String contact=resultSet.getString(2);
            String suppliersName=resultSet.getString(3);
            String suppliersNic=resultSet.getString(4);
            String suppliersAdress=resultSet.getString(5);

            return new Supplier(suppliersID,contact,suppliersName,suppliersNic,suppliersAdress);
        }
        return null;
    }

    public static boolean update(Supplier suppliers) throws SQLException {
        String sql = "UPDATE suppliers SET contact=?,suppliersName=?,suppliersNic=?,suppliersAdress=? WHERE suppliersID=?";
        return CrudUtil.execute(sql,suppliers.getContact(),suppliers.getSuppliersName(),suppliers.getSuppliersNic(),suppliers.getSuppliersAdress(),suppliers.getSuppliersID());
    }

    public static List<String> genarateId() throws SQLException {
        String sql = "SELECT suppliersID FROM suppliers";

        ResultSet resultSet = CrudUtil.execute(sql);
        List<String>id = new ArrayList<>();
       while (resultSet.next()){
           id.add(resultSet.getString(1));
       }
       return id;
    }

    public static String generateNextOrderId() throws SQLException {

        String sql = "SELECT suppliersOrderID FROM suppliersorder ORDER BY suppliersOrderID DESC LIMIT 1";

        ResultSet resultSet = CrudUtil.execute(sql);
        if(resultSet.next()) {
            return splitOrderId(resultSet.getString(1));
        }
        return splitOrderId(null);
    }

    private static String splitOrderId(String orderId) {
        if (orderId != null) {
            String[]strings = orderId.split("K0");
            int id = Integer.parseInt(strings[1]);
            id++;
            return "K0"+id;
        }
        return "K001";
    }


    public static String getName(String id) throws SQLException {
        String sql = "SELECT suppliersName FROM suppliers WHERE suppliersID = ?";
        ResultSet resultSet = CrudUtil.execute(sql,id);

        String name = "" ;

        if (resultSet.next()){
            name  = resultSet.getString(1);
        }
        return name;
    }
}
