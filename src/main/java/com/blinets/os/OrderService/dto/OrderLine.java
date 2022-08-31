package com.blinets.os.OrderService.dto;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Version;
import lombok.*;
import org.hibernate.Hibernate;

import java.util.Objects;

@Entity
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class OrderLine extends BaseEntity {

    private Integer quantityOrder;

    public OrderLine(Integer quantityOrder) {
        this.quantityOrder = quantityOrder;
    }

    @ManyToOne
    private OrderHeader orderHeader;

    @ManyToOne
    private Product product;

    @Version
    private Integer version;
    public OrderLine(Integer quantityOrder, Product product) {
        this.quantityOrder = quantityOrder;
        this.product = product;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        OrderLine orderLine = (OrderLine) o;
        return getId() != null && Objects.equals(getId(), orderLine.getId());
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}
