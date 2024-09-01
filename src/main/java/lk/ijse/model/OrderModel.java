package lk.ijse.model;

import lk.ijse.Util.CrudUtil;
import lk.ijse.controller.*;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.LocalTime;

public class OrderModel {
    public static String getNextId() throws SQLException {
        String sql = "SELECT orderId FROM orders ORDER BY orderId DESC LIMIT 1";
        ResultSet resultSet = CrudUtil.execute(sql);

        if (resultSet.next()){
           return nextId(resultSet.getString(1));
        }
        return nextId(null);
    }

    private static String nextId(String currentId) {
        if (currentId != null){
            String[] strings = currentId.split("O0");
            int id = Integer.parseInt(strings[1]);
            id++;

            return "O0"+id;
        }
     return "O001";
    }

    public static boolean save(String orderId, LocalDate date,String custId,double total) throws SQLException {
        String sql = "INSERT INTO orders (orderId,orderDate,custId,total) VALUES (?,?,?,?)";
        return CrudUtil.execute(sql,orderId,date,custId,total);
    }

    public static int countOrders() throws SQLException {
        String sql = "SELECT COUNT(*) FROM sparepartsshop.orders;";
        ResultSet resultSet = CrudUtil.execute(sql);
        int count = 0 ;
        if (resultSet.next()) {
            count =  resultSet.getInt(1);
        }
        return count;
    }

    public static double getTotalOrderSales() throws SQLException {
        String sql = "SELECT SUM(total)  FROM sparepartsshop.orders;";
        ResultSet resultSet = CrudUtil.execute(sql);
        double total = 0 ;
        if (resultSet.next()) {
            total =  resultSet.getInt(1);
        }
        return total;
    }
}
