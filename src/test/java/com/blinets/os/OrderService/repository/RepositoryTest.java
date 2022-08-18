package com.blinets.os.OrderService.repository;


import com.blinets.os.OrderService.dto.OrderHeader;
import com.blinets.os.OrderService.repository.OrderHeaderRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.ActiveProfiles;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;


@ActiveProfiles("local")
@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class RepositoryTest {

    @Autowired
    OrderHeaderRepository repository;

    @Test
    void repositoryTest(){
        OrderHeader orderHeader = new OrderHeader("Custom Name");
        OrderHeader save = repository.save(orderHeader);
        assertThat(save).isNotNull();
        repository.delete(save);
    }

}
