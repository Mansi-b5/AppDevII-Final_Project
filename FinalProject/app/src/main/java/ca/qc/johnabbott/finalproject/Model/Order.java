package ca.qc.johnabbott.finalproject.Model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import ca.qc.johnabbott.finalproject.sqlite.Identifiable;

public class Order implements Identifiable<Long> {

    // generate local IDs (in memory only).
    private static int CURRENT_LOCAL_ID = 0;

    private long id;
    private List<CartItem> cartItemList;
    private OrderStatus status;
    private Date orderDate;
    private LocationD location;

    public Order() {
        id = CURRENT_LOCAL_ID++;
        cartItemList = new ArrayList<>();
    }

    public Order(int id, List<CartItem> cartItemList, OrderStatus status) {
        this.id = id;
        this.cartItemList = cartItemList;
        this.status = status;
    }

    public Long getId() {
        return id;
    }

    @Override
    public Order setId(Long id) {
        this.id = id;
        return this;
    }


    public Date getOrderDate() {
        return orderDate;
    }

    public Order setOrderDate(Date date) {
        this.orderDate = date;
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

    public boolean isEmpty() {
        return cartItemList.isEmpty();
    }

    public LocationD getLocation() {
        return location;
    }

    public Order setLocation(LocationD location) {
        this.location = location;
        return this;
    }
}
