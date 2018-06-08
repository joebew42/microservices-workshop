package com.xpeppers.monolith.orders;

import com.xpeppers.monolith.orders.Order;

import java.util.ArrayList;
import java.util.List;

public class Orders {
    private static final List<Order> orders = new ArrayList<>();

    public void add(Order order) {
        orders.add(order);
    }

    public List<Order> all() {
        return orders;
    }
}