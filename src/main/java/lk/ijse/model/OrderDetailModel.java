package lk.ijse.model;

import lk.ijse.Util.CrudUtil;
import lk.ijse.dto.*;

import java.sql.SQLException;
import java.util.List;

public class OrderDetailModel {
    public static boolean save(String orderId, List<CartOrderDto> orderDtoList) throws SQLException {
        for (CartOrderDto dto : orderDtoList){
            if (!save(orderId,dto)){
                return false;
            }
        }
        return true;
    }

    private static boolean save(String orderId,CartOrderDto dto) throws SQLException {
        String sql = "INSERT INTO orderdetail (orderId,itemCode,orderQTY)VALUES(?,?,?)";
        return CrudUtil.execute(sql,orderId,dto.getCode(),dto.getQty());
    }
}
