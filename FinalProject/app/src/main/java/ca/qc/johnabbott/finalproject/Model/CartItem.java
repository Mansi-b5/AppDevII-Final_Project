package ca.qc.johnabbott.finalproject.Model;

import java.util.UUID;

import ca.qc.johnabbott.finalproject.sqlite.Identifiable;

public class CartItem implements Identifiable<Long> {

    // generate local IDs (in memory only).
    private static int CURRENT_LOCAL_ID = 0;

    private long id;
    private MenuItem menuItem;
    private int Quantity;
    private double UnitPrice;
    private long menuItemId;
    private long CartId;

    public CartItem() {
        id = CURRENT_LOCAL_ID++;
    }

    public CartItem(int id, MenuItem menuItem, int quantity, double unitPrice) {
        this.id = id;
        this.menuItem = menuItem;
        Quantity = quantity;
        UnitPrice = unitPrice;
    }

    public Long getId() {
        return id;
    }

    @Override
    public CartItem setId(Long id) {
        this.id = id;
        return this;
    }

//    public CartItem setId(long id) {
//        this.id = id;
//        return this;
//    }

    public MenuItem getMenuItem() {
        return menuItem;
    }

    public CartItem setMenuItem(MenuItem product) {
        this.menuItem = product;
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

    public long getCartId() {
        return CartId;
    }

    public CartItem setCartId(long cartId) {
        CartId = cartId;
        return this;
    }

    public long getMenuItemId() {
        return menuItemId;
    }

    public CartItem setMenuItemId(long menuItemId) {
        this.menuItemId = menuItemId;
        return this;
    }
}
