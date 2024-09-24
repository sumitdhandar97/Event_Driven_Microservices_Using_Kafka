package com.infy.orderservice.controller;

import com.infy.basedomains.dto.Order;
import com.infy.basedomains.dto.OrderEvent;
import com.infy.orderservice.kafka.OrderProducer;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
@RequestMapping("/api/v1")
public class OrderController {
    private OrderProducer orderProducer;
    public OrderController(OrderProducer orderProducer) {
        this.orderProducer = orderProducer;
    }

    @PostMapping("/orders")
   public String placeOrder(@RequestBody Order order){
        order.setOrderId(UUID.randomUUID().toString());
        OrderEvent orderEvent = new OrderEvent();
        orderEvent.setStatus("pending");
        orderEvent.setMessage("order status is in pending state");
        orderEvent.setOrder(order);
        orderProducer.sendMessage(orderEvent);
        return "Order Placed Successfully ...";
    }

}
