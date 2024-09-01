package lk.ijse.model;

import lk.ijse.Util.CrudUtil;

import java.sql.SQLException;
import java.time.LocalDate;

public class SuppliesModel {
    public static boolean save(String suppliesId ,LocalDate date,Double total) throws SQLException {
        String sql = "INSERT INTO suppliersOrder (suppliersOrderID,date,total) VALUES (?,?,?)";
        return CrudUtil.execute(sql,suppliesId,date,total);
    }
}
