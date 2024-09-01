package lk.ijse.model;

import lk.ijse.Util.CrudUtil;
import lk.ijse.dto.CartOrderDto;
import lk.ijse.dto.CartSupplierDto;

import java.sql.SQLException;
import java.util.List;

public class SuppliesDetailsModel {
    public static boolean save(String orderId, List<CartSupplierDto> orderDtoList, double total) throws SQLException {
        for (CartSupplierDto dto : orderDtoList){
            if (!save(orderId,dto,total)){
                return false;
            }
        }
        return true;
    }

    private static boolean save(String orderId,CartSupplierDto dto, double total) throws SQLException {
        String sql = "INSERT INTO suppliersorderdetail VALUES(?,?,?,?)";
        return CrudUtil.execute(sql,orderId,dto.getCode(),dto.getQty(),total);
    }
}
