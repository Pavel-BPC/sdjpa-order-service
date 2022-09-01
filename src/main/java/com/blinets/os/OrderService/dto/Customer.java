package com.blinets.os.OrderService.dto;


import jakarta.persistence.*;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
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
    @Size(max = 50)
    private String customerName;

    @Size(max = 20)
    private String phone;

    @Email
    @Size(max = 30)
    private String email;

    @Valid
    @Embedded
    private Address address;
    @OneToMany(mappedBy = "customer", cascade = CascadeType.PERSIST)
    private Set<OrderHeader> orderHeader;

    @Version
    private Integer version;

    public Customer(String customerName, String phone, String email) {
        this.customerName = customerName;
        this.phone = phone;
        this.email = email;
    }

    public Customer(String customerName, String phone, String email, Address address) {
        this.customerName = customerName;
        this.phone = phone;
        this.email = email;
        this.address = address;
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
