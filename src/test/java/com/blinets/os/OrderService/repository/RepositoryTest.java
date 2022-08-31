package com.blinets.os.OrderService.repository;


import com.blinets.os.OrderService.dto.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.ActiveProfiles;

import java.util.Objects;
import java.util.Optional;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;


@ActiveProfiles("local")
@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class RepositoryTest {

    @Autowired
    OrderHeaderRepository orderHeaderRepository;

    @Autowired
    ProductRepository productRepository;
    @Autowired
    OrderLineRepository orderLineRepository;
    @Autowired
    CategoryRepository categoryRepository;
    @Autowired
    CustomerRepository customerRepository;

    Product product;

    @BeforeEach
    void setUp() {
        Product excitingProduct = new Product(ProductStatus.NEW, "exciting product");
        Product save = productRepository.saveAndFlush(excitingProduct);
        product = save;
    }

    @Test
    void repositoryTest() {
        OrderHeader orderHeader = new OrderHeader();
        OrderHeader save = orderHeaderRepository.save(orderHeader);
        assertThat(save).isNotNull();
        OrderHeader orderHeader1 = orderHeaderRepository.findById(save.getId()).get();
        assertThat(orderHeader1).isNotNull();
        assertThat(orderHeader1.getCreatedDate()).isNotNull();
        assertThat(orderHeader1.getLastModifiedDate()).isNotNull();

    }

    @Test
    void orderLineTest() {
        OrderHeader orderHeader = new OrderHeader();
        OrderLine orderLine1 = new OrderLine(1);
        OrderLine orderLine2 = new OrderLine(2);

        orderLine1.setOrderHeader(orderHeader);
        orderLine2.setOrderHeader(orderHeader);

        orderLine1.setProduct(product);

        orderHeader.addOrderLines(orderLine1);
        orderHeader.addOrderLines(orderLine2);

        OrderApproval orderApproval = new OrderApproval();
        orderApproval.setApprovalBy("Nikolas Cage");
        orderHeader.setOrderApproval(orderApproval);

        OrderHeader orderHeaderSave = orderHeaderRepository.save(orderHeader);

        Optional<OrderHeader> orderHeaderOptional = orderHeaderRepository.findById(orderHeaderSave.getId());
        assertThat(orderHeaderOptional.isPresent()).isTrue();
        OrderHeader orderHeaderById = orderHeaderOptional.get();
        assertThat(orderHeaderById.getOrderLines().size()).isGreaterThan(0);
        assertThat(orderHeaderById.getOrderLines().stream()
                .allMatch(orderLine -> Objects.nonNull(orderLine.getId()))).isTrue();
        assertThat(orderHeaderById.getOrderApproval()).isNotNull();
        assertThat(orderHeaderById.getOrderApproval().getId()).isNotNull();
    }

    @Test
    void productCategoryTest() {
        Product product1 = productRepository.findProductByDescription("PRODUCT1");
        assertThat(product1).isNotNull();
        assertThat(product1.getCategory()).isNotNull();

    }

    @Test
    void customerTest() {
        Customer customer = new Customer("cut name", "phone", "email");
        OrderHeader orderHeader = new OrderHeader();
        customer.addOrderHeader(orderHeader);
        Customer save = customerRepository.save(customer);
        Optional<Customer> byId = customerRepository.findById(save.getId());
        assertThat(byId.isPresent()).isTrue();
        Customer customer1 = byId.get();
        assertThat(customer1.getOrderHeader()).isNotNull();
    }
}
