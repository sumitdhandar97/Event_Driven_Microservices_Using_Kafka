package com.infy.basedomains.dto;
//to keep all the domain entities in a different microservice we have created this base domain service
//class used to transfer the data between consumer and producer using apache kafka
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrderEvent {
    private String message;
    private String status;
    private Order order;
}

