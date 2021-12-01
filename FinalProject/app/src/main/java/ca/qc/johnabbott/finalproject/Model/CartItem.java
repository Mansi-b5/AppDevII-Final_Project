package ca.qc.johnabbott.finalproject.Model;

import java.util.UUID;

public class CartItem {

    // generate local IDs (in memory only).
    private static int CURRENT_LOCAL_ID = 0;

    private int id;
    private Product product;
    private int Quantity;
    private double UnitPrice;

    public CartItem() {
        id = CURRENT_LOCAL_ID++;
    }

    public CartItem(int id, Product product, int quantity, double unitPrice) {
        this.id = id;
        this.product = product;
        Quantity = quantity;
        UnitPrice = unitPrice;
    }

    public int getId() {
        return id;
    }

    public CartItem setId(int id) {
        this.id = id;
        return this;
    }

    public Product getProduct() {
        return product;
    }

    public CartItem setProduct(Product product) {
        this.product = product;
        return this;
    }

    public int getQuantity() {
        return Quantity;
    }

    public CartItem setQuantity(int quantity) {
        Quantity = quantity;
        return this;
    }

    public double getUnitPrice() {
        return UnitPrice;
    }

    public CartItem setUnitPrice(double unitPrice) {
        UnitPrice = unitPrice;
        return this;
    }
}
