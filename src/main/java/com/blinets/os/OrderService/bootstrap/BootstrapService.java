package com.blinets.os.OrderService.bootstrap;

import com.blinets.os.OrderService.dto.OrderHeader;
import com.blinets.os.OrderService.repository.OrderHeaderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class BootstrapService {
    @Autowired
    private OrderHeaderRepository orderHeaderRepository;

    @Transactional
    public void readOrderData() {
        OrderHeader orderHeader = orderHeaderRepository.findById(1L).get();
        orderHeader.getOrderLines().forEach(orderLine -> {
            System.out.println(orderLine.getProduct().getDescription());
            orderLine.getProduct().getCategory().forEach(
                    category -> System.out.println(category.getDescription())
            );
        });
    }
}
