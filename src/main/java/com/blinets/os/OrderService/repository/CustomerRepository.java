package com.blinets.os.OrderService.repository;

import com.blinets.os.OrderService.dto.Category;
import com.blinets.os.OrderService.dto.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long> {
}
