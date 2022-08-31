package com.blinets.os.OrderService.repository;

import com.blinets.os.OrderService.dto.Product;
import com.blinets.os.OrderService.dto.ProductStatus;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.ActiveProfiles;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@ActiveProfiles("local")
@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
class ProductRepositoryTest {

    @Autowired
    ProductRepository productRepository;

    @Test
    void productRepositoryTest() {
        Product product = new Product(ProductStatus.NEW);
        Product save = productRepository.save(product);
        Product product1 = productRepository.findById(save.getId()).get();
        assertThat(product1).isNotNull();
        assertThat(product1.getCreatedDate()).isNotNull();
        assertThat(product1.getLastModifiedDate()).isNotNull();
        productRepository.delete(product1);
    }
}