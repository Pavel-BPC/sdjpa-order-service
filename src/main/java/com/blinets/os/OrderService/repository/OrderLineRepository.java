package com.blinets.os.OrderService.repository;

import com.blinets.os.OrderService.dto.OrderLine;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderLineRepository extends JpaRepository<OrderLine, Long> {
}
