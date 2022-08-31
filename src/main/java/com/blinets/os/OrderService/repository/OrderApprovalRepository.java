package com.blinets.os.OrderService.repository;

import com.blinets.os.OrderService.dto.OrderApproval;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderApprovalRepository extends JpaRepository<OrderApproval, Long> {
}
