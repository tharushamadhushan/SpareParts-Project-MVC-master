package lk.ijse.dto;

public class Item {
    private String itemCode;
    private String description;
    private String vehicleBrand;
    private Double unitPrice;
    private Integer qtyOnStock;

    public String getPartId() {
        return itemCode;
    }

    public void setPartId(String partId) {
        this.itemCode = partId;
    }

    public String getPartsName() {
        return description;
    }

    public void setPartsName(String partsName) {
        this.description = partsName;
    }

    public String getType() {
        return vehicleBrand;
    }

    public void setType(String type) {
        this.vehicleBrand = type;
    }

    public Double getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(Double unitPrice) {
        this.unitPrice = unitPrice;
    }

    public Integer getQtyOnStock() {
        return qtyOnStock;
    }

    public void setQtyOnStock(Integer qtyOnStock) {
        this.qtyOnStock = qtyOnStock;
    }

    public Item(String itemCode, String description, String vehicleBrand, Double unitPrice, Integer qtyOnStock) {
        this.itemCode = itemCode;
        this.description = description;
        this.vehicleBrand = vehicleBrand;
        this.unitPrice = unitPrice;
        this.qtyOnStock = qtyOnStock;
    }

    public Item(String itemCode, String description, String vehicleBrand,double unitPrice,Integer qtyOnStock) {
    }

    @Override
    public String toString() {
        return "Item{" +
                "partId='" + itemCode + '\'' +
                ", partsName='" + description + '\'' +
                ", type='" + vehicleBrand + '\'' +
                ", unitPrice=" + unitPrice +
                ", qtyOnStock=" + qtyOnStock +
                '}';
    }
}
