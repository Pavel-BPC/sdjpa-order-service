package com.blinets.os.OrderService.dto;

import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class OrderApproval extends BaseEntity{
    private String approvalBy;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;

        OrderApproval that = (OrderApproval) o;

        return approvalBy != null ? approvalBy.equals(that.approvalBy) : that.approvalBy == null;
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + (approvalBy != null ? approvalBy.hashCode() : 0);
        return result;
    }
}
