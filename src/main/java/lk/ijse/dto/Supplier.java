package lk.ijse.dto;

public class Supplier {
    private String suppliersID;
    private String contact;
    private String suppliersName;
    private String suppliersNic;
    private String suppliersAdress;

    public String getSuppliersID() {
        return suppliersID;
    }

    public void setSuppliersID(String suppliersID) {
        this.suppliersID = suppliersID;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    public String getSuppliersName() {
        return suppliersName;
    }

    public void setSuppliersName(String suppliersName) {
        this.suppliersName = suppliersName;
    }

    public String getSuppliersNic() {
        return suppliersNic;
    }

    public void setSuppliersNic(String suppliersNic) {
        suppliersNic = suppliersNic;
    }

    public String getSuppliersAdress() {
        return suppliersAdress;
    }

    public void setSuppliersAdress(String suppliersAdress) {
        this.suppliersAdress = suppliersAdress;
    }

    public Supplier(String suppliersID,String contact,String suppliersName,String suppliersNic,String suppliersAdress) {
        this.suppliersID=suppliersID;
        this.contact=contact;
        this.suppliersName=suppliersName;
        this.suppliersNic=suppliersNic;
        this.suppliersAdress=suppliersAdress;
    }

    @Override
    public String toString() {
        return "Supplier{" +
                "suppliersID='" + suppliersID + '\'' +
                ", contact='" + contact + '\'' +
                ", suppliersName='" + suppliersName + '\'' +
                ", suppliersNic='" + suppliersNic + '\'' +
                ", suppliersAdress='" + suppliersAdress + '\'' +
                '}';
    }
}
