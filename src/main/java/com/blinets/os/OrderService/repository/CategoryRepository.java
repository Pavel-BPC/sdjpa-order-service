package com.blinets.os.OrderService.repository;

import com.blinets.os.OrderService.dto.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Long> {
    Category findCategoriesByDescription(String description);
}
