package lk.ijse.model;

import lk.ijse.Util.CrudUtil;
import lk.ijse.dto.CartOrderDto;
import lk.ijse.dto.CartSupplierDto;
import lk.ijse.dto.Item;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ItemModel {

public static List<String> genarateCode() throws SQLException {
        String sql = "SELECT itemCode FROM parts";
        ResultSet resultSet = CrudUtil.execute(sql);
        List<String>code = new ArrayList<>();

        while (resultSet.next()){
        code.add(resultSet.getString(1));
        }
        return code;
        }

    public static boolean delete(String id) throws SQLException {
        String sql =  "DELETE FROM parts WHERE itemCode = ?";
        return CrudUtil.execute(sql,id);
    }

    public static Item search(String id) throws SQLException {
        String sql = "SELECT * FROM parts WHERE itemCode= ?";
        ResultSet resultSet = CrudUtil.execute(sql,id);

        if (resultSet.next()){
            String pid = resultSet.getString(1);
            String name = resultSet.getString(2);
            String type= resultSet.getString(3);
            Double price = Double.valueOf(resultSet.getString(4));
            Integer qty = Integer.valueOf(resultSet.getString(5));

            return new Item(pid,name,type,price,qty);
        }
        return null;
    }

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
            String[] strings = currentId.split("O00");
            int id = Integer.parseInt(strings[1]);
            id++;

            return "O00"+id;
        }
        return "O001";
    }
    public static boolean updateQtyOrder(List<CartOrderDto> orderDtoList) throws SQLException {
        for (CartOrderDto dto : orderDtoList) {
            if (!updateQtyOrder(dto)){
                return false;
            }
        }
        return true;
    }

    private static boolean updateQtyOrder(CartOrderDto dto) throws SQLException {
        String sql = "UPDATE parts SET qtyOnStock = (qtyOnStock - ?) WHERE itemCode = ?";
        return CrudUtil.execute(sql,dto.getQty(),dto.getCode());
    }
    public static boolean updateQtyOrder1(List<CartSupplierDto> orderDtoList) throws SQLException {
        for (CartSupplierDto dto : orderDtoList) {
            if (!updateQtyOrder1(dto)){
                return false;
            }
        }
        return true;
    }

    private static boolean updateQtyOrder1(CartSupplierDto dto) throws SQLException {
        String sql = "UPDATE parts SET qtyOnStock = (qtyOnStock + ?) WHERE itemCode = ?";
        return CrudUtil.execute(sql,dto.getQty(),dto.getCode());
    }

    public static boolean save(Item item) throws SQLException {
        String sql = "INSERT INTO parts (itemCode,description,vehicleBrand,unitPrice,qtyOnStock) VALUES (?,?,?,?,?)";
        return CrudUtil.execute(sql,item.getPartId(),item.getPartsName(),item.getType(),item.getUnitPrice(),item.getQtyOnStock());
    }

    public static boolean Update(Item item) throws SQLException {
        String sql = "UPDATE parts SET description=?,vehicleBrand=?,unitPrice=?,qtyOnStock=? WHERE itemCode=?";
        return CrudUtil.execute(sql,item.getPartsName(),item.getType(),item.getUnitPrice(),item.getQtyOnStock(),item.getPartId());
    }

    public static int countItem() throws SQLException {
        String sql = "SELECT COUNT(*) as itemCount FROM sparepartsshop.parts;";
        ResultSet resultSet = CrudUtil.execute(sql);
        int count = 0 ;
        if (resultSet.next()) {
            count =  resultSet.getInt(1);
        }
        return count;
    }
}
