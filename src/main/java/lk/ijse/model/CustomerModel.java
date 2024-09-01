package lk.ijse.model;

import lk.ijse.Util.CrudUtil;
import lk.ijse.dto.Customer;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CustomerModel {

public static List<String> genarateId() throws SQLException {
        String sql = "SELECT custID FROM customer";
        ResultSet resultSet = CrudUtil.execute(sql);

        List<String>id=new ArrayList<>();

        while (resultSet.next()){
        id.add(resultSet.getString(1));
        }
        return id;
        }

    public static Customer search(String id) throws SQLException {
        String sql="SELECT * FROM customer WHERE custID =? ";
        ResultSet resultSet= CrudUtil.execute(sql,id);

        if (resultSet.next()){

            String cid = resultSet.getString(1);
            String name = resultSet.getString(2);
            String contact = resultSet.getString(3);
            String nic = resultSet.getString(4);

            return new Customer(cid,name,contact,nic);

        }
        return null;
    }

    public static boolean save(Customer customer) throws SQLException {
        String sql = "INSERT INTO customer (custID,custName,contact,custNic) VALUES (?,?,?,?)";
        return CrudUtil.execute(sql,customer.getCustId(),customer.getCustName(),customer.getCustNic(),customer.getContact());
    }

    public static boolean delete(String id) throws SQLException {
        String sql = "DELETE FROM customer WHERE custID=?";
        return CrudUtil.execute(sql,id);
    }

    public static boolean Update(Customer customer) throws SQLException {
        String sql = "UPDATE customer SET custName=?,contact=?,custNic=? WHERE custID=?";
        return CrudUtil.execute(sql,customer.getCustName(),customer.getContact(),customer.getCustNic(),customer.getCustId());
    }

    public static String getName(String id) throws SQLException {
        String sql = "SELECT custName FROM customer WHERE custID = ?";
        ResultSet resultSet = CrudUtil.execute(sql,id);

        String name = "" ;

        if (resultSet.next()){
            name  = resultSet.getString(1);
        }
        return name;
    }

    public static int countCustomers() throws SQLException {
        String sql = "SELECT COUNT(*) as customerCount FROM sparepartsshop.customer;";
        ResultSet resultSet = CrudUtil.execute(sql);
        int count = 0 ;
        if (resultSet.next()) {
            count =  resultSet.getInt(1);
        }
        return count;
    }
}
