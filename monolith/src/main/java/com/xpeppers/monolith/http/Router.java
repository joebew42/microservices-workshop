package com.xpeppers.monolith.http;

import com.xpeppers.monolith.orders.OrderRepository;
import com.xpeppers.monolith.warehouse.Warehouse;

import static spark.Spark.get;
import static spark.Spark.post;

public class Router {
    public static void main(String[] args) {
        Warehouse warehouse = new Warehouse();
        OrderRepository orderRepository = new OrderRepository();
        OrdersController ordersController = new OrdersController(orderRepository, warehouse);

        post("/orders", ordersController::create);
        get("/orders", ordersController::list);
    }
}
