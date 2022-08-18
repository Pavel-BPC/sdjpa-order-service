package com.blinets.os.OrderService.dto;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class OrderHeaderTest {

    @Test
    void testEquals() {
        OrderHeader orderHeader1 = new OrderHeader();
        orderHeader1.setId(1L);

        OrderHeader orderHeader2 = new OrderHeader();
        orderHeader2.setId(1L);

        OrderHeader orderHeader3 = new OrderHeader();
        orderHeader3.setId(3L);

        assert(orderHeader1.equals(orderHeader2));
        assertFalse(orderHeader1.equals(orderHeader3));
    }
}