package com.blinets.os.OrderService.dto;

import jakarta.persistence.Embeddable;

@Embeddable
public class Address {
    private String address;
    private String city;
    private String state;
    private String zipCode;
}
