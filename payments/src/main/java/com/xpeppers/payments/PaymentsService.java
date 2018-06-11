package com.xpeppers.payments;

import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

public class PaymentsService {
    private final List<Payment> payments = new ArrayList<>();

    public boolean receivedFor(UUID orderId) {
        if (orderPaid(orderId) && prepareShippingFor(orderId)) {
            payments.add(new Payment(orderId, new Date()));
            return true;
        }

        return false;
    }

    public List<Payment> allPayments() {
        return new ArrayList<>(payments);
    }

    private boolean prepareShippingFor(UUID orderId) {
        return true;
    }

    private boolean orderPaid(UUID orderId) {
        return true;
    }

    private boolean reserveProductsFor(UUID orderId, String productCode, Integer productQuantity) throws UnirestException {
        HttpResponse<String> response = Unirest.post("http://localhost:8181/pickProducts")
                .field("order_id", orderId)
                .field("product_code", productCode)
                .field("product_quantity", productQuantity)
                .asString();

        return response.getStatus() == 201;
    }
}
