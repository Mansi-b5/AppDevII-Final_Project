package ca.qc.johnabbott.finalproject.viewmodel;

import ca.qc.johnabbott.finalproject.Model.MenuItem;
import ca.qc.johnabbott.finalproject.Model.Order;

public class OrderViewModel extends ObservableModel<OrderViewModel> {
    private MenuItem item ;
    private Order order;

    public MenuItem getItem() {
        return item;
    }

    public OrderViewModel setItem(MenuItem item) {
        this.item = item;
        return this;
    }

    public Order getOrder() {
        return order;
    }

    public OrderViewModel setOrder(Order order) {
        this.order = order;
        return this;
    }

    @Override
    protected OrderViewModel get() {
        return this;
    }
}
