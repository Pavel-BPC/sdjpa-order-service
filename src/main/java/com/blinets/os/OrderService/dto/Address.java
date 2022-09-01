package com.blinets.os.OrderService.dto;

import jakarta.persistence.Embeddable;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Embeddable
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Address {
    @Size(max = 30)
    private String address;
    @Size(max = 30)
    private String city;
    @Size(max = 30)
    private String state;
    @Size(max = 30)
    private String zipCode;
}
