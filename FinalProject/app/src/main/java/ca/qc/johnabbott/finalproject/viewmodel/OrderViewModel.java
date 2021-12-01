package ca.qc.johnabbott.finalproject.viewmodel;

import ca.qc.johnabbott.finalproject.Model.Order;

public class OrderViewModel extends ObservableModel<OrderViewModel> {

    private Order order;

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
