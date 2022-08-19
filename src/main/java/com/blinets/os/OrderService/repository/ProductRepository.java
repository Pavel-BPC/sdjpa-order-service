package com.blinets.os.OrderService.repository;

import com.blinets.os.OrderService.dto.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
    Product findProductByDescription(String description);
}
