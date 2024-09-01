package lk.ijse.model;

import lk.ijse.db.DBConnection;
import lk.ijse.controller.*;
import lk.ijse.dto.CartOrderDto;
import lk.ijse.dto.CartSupplierDto;

import java.sql.Connection;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

public class PlaceSupplierModel {
    public static boolean save(String  orderId, double total,String suppliersID, List<CartSupplierDto> orderDto) throws SQLException {
        Connection connection = null;

        try {
            connection = DBConnection.getInstance().getConnection();
            connection.setAutoCommit(false);

            boolean isSave = SuppliesModel.save(orderId,LocalDate.now(),total);
            if (isSave){
                boolean isUpdate = ItemModel.updateQtyOrder1(orderDto);
                if (isUpdate){
                    boolean isSaveOrderDetail = SuppliesDetailsModel.save( orderId,orderDto,total);
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
