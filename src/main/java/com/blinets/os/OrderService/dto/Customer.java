package com.blinets.os.OrderService.dto;


import jakarta.persistence.CascadeType;
import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import lombok.*;
import org.hibernate.Hibernate;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Customer extends BaseEntity {
    private String customerName;
    private String phone;
    private String email;
    @Embedded
    private Address address;
    @OneToMany(mappedBy = "customer", cascade = CascadeType.PERSIST)
    private Set<OrderHeader> orderHeader;


    public Customer(String customerName, String phone, String email) {
        this.customerName = customerName;
        this.phone = phone;
        this.email = email;
    }

    public void addOrderHeader(OrderHeader order) {
        if (orderHeader == null) {
            orderHeader = new HashSet<>();
        }
        orderHeader.add(order);
        setOrderHeader(orderHeader);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        Customer customer = (Customer) o;
        return getId() != null && Objects.equals(getId(), customer.getId());
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}
