package com.blinets.os.OrderService.repository;


import com.blinets.os.OrderService.dto.OrderHeader;
import com.blinets.os.OrderService.dto.OrderLine;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.ActiveProfiles;

import java.util.Optional;
import java.util.Set;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;


@ActiveProfiles("local")
@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class RepositoryTest {

    @Autowired
    OrderHeaderRepository repository;

    @Test
    void repositoryTest() {
        OrderHeader orderHeader = new OrderHeader("Custom Name");
        OrderHeader save = repository.save(orderHeader);
        assertThat(save).isNotNull();
        OrderHeader orderHeader1 = repository.findById(save.getId()).get();
        assertThat(orderHeader1).isNotNull();
        assertThat(orderHeader1.getCreatedDate()).isNotNull();
        assertThat(orderHeader1.getLastModifiedDate()).isNotNull();

    }

    @Test
    void orderLineTest() {
        OrderHeader orderHeader = new OrderHeader("Custom Name");
        OrderLine orderLine1 = new OrderLine(1);
        OrderLine orderLine2 = new OrderLine(2);

        orderLine1.setOrderHeader(orderHeader);
        orderLine2.setOrderHeader(orderHeader);

        orderHeader.setOrderLines(Set.of(orderLine1, orderLine2));
        OrderHeader orderHeaderSave = repository.save(orderHeader);

        Optional<OrderHeader> orderHeaderOptional = repository.findById(orderHeaderSave.getId());
        assertThat(orderHeaderOptional.isPresent()).isTrue();
        OrderHeader orderHeaderById = orderHeaderOptional.get();
        assertThat(orderHeaderById.getCustomerName()).isNotNull();
        assertThat(orderHeaderById.getOrderLines().size()).isGreaterThan(0);

    }

}
