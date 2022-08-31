package com.blinets.os.OrderService.bootstrap;

import com.blinets.os.OrderService.dto.OrderHeader;
import com.blinets.os.OrderService.repository.OrderHeaderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
public class Bootstrap implements CommandLineRunner {

    @Autowired
    private OrderHeaderRepository orderHeaderRepository;

    @Transactional
    @Override
    public void run(String... args) throws Exception {
        OrderHeader orderHeader = orderHeaderRepository.findById(1L).get();
        orderHeader.getOrderLines().forEach(orderLine -> {
            System.out.println(orderLine.getProduct().getDescription());
            orderLine.getProduct().getCategory().forEach(
                    category -> System.out.println(category.getDescription())
            );
        });
    }
}
