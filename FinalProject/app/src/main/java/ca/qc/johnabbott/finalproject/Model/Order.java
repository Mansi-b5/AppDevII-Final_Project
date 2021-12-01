package ca.qc.johnabbott.finalproject.Model;

import java.util.List;

public class Order {

    // generate local IDs (in memory only).
    private static int CURRENT_LOCAL_ID = 0;

    private int id;
    private List<CartItem> cartItemList;
    private OrderStatus status;

    public Order() {
        id = CURRENT_LOCAL_ID++;
    }

    public Order(int id, List<CartItem> cartItemList, OrderStatus status) {
        this.id = id;
        this.cartItemList = cartItemList;
        this.status = status;
    }

    public int getId() {
        return id;
    }

    public Order setId(int id) {
        this.id = id;
        return this;
    }

    public List<CartItem> getCartItemList() {
        return cartItemList;
    }

    public Order setCartItemList(List<CartItem> cartItemList) {
        this.cartItemList = cartItemList;
        return this;
    }

    public OrderStatus getStatus() {
        return status;
    }

    public Order setStatus(OrderStatus status) {
        this.status = status;
        return this;
    }
}
