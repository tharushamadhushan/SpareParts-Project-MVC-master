package lk.ijse.model;

import lk.ijse.db.DBConnection;
import lk.ijse.controller.*;
import lk.ijse.dto.CartOrderDto;

import java.sql.Connection;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

public class PlaceOrderModel {
    public static boolean save(String  orderId, double total,String custId, List<CartOrderDto> orderDto) throws SQLException {
        Connection connection = null;

        try {
            connection = DBConnection.getInstance().getConnection();
            connection.setAutoCommit(false);

            boolean isSave = OrderModel.save(orderId,LocalDate.now(),custId,total);
            if (isSave){
                boolean isUpdate = ItemModel.updateQtyOrder(orderDto);
                if (isUpdate){
                    boolean isSaveOrderDetail = OrderDetailModel.save( orderId,orderDto);
                    if (isSaveOrderDetail){
                        connection.commit();
                        return true;
                    }
                }
            }
            return false;
        } catch (SQLException e) {
            e.printStackTrace();
            connection.rollback();
            return false;
        }finally {
            connection.setAutoCommit(true);
        }
    }
}
