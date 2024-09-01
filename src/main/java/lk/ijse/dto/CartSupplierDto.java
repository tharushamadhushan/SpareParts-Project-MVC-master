package lk.ijse.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class CartSupplierDto {
    private String code;
    private Integer qty;
    private Double unitPrice;
    private Double total;
}
