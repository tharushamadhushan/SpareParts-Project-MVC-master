package lk.ijse.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor

public class CartSupplierOrder {
    private String code;
    private Integer qty;
}