package app.entities;

import javax.persistence.*;

@Entity
@Table(name = "Buzzd_Inventory")
public class InventoryEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "inventory_id")
    private int inventoryId;

    @Column(name = "manufacturer")
    private String manufacturer;

    @Column(name = "product_name")
    private String productName;

    @Column(name = "product_upc")
    private String upc;

    @Column(name = "in_stock")
    private int stock;

    public int getInventoryId() {
        return inventoryId;
    }

    public void setInventoryId(int inventoryId) {
        this.inventoryId = inventoryId;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getUpc() {
        return upc;
    }

    public void setUpc(String upc) {
        this.upc = upc;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public InventoryEntity() {
    }

    public InventoryEntity(int inventoryId, String manufacturer, String productName, String upc, int stock) {
        this.inventoryId = inventoryId;
        this.manufacturer = manufacturer;
        this.productName = productName;
        this.upc = upc;
        this.stock = stock;
    }

    @Override
    public String toString() {
        return "InventoryEntity{" +
                "inventoryId=" + inventoryId +
                ", manufacturer='" + manufacturer + '\'' +
                ", productName='" + productName + '\'' +
                ", upc='" + upc + '\'' +
                ", stock=" + stock +
                '}';
    }
}
