package com.blinets.os.OrderService.bootstrap;

import com.blinets.os.OrderService.dto.Customer;
import com.blinets.os.OrderService.dto.OrderApproval;
import com.blinets.os.OrderService.dto.OrderHeader;
import com.blinets.os.OrderService.dto.OrderLine;
import com.blinets.os.OrderService.repository.CustomerRepository;
import com.blinets.os.OrderService.repository.OrderHeaderRepository;
import com.blinets.os.OrderService.repository.OrderLineRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Component
public class Bootstrap implements CommandLineRunner {
    @Autowired
    private BootstrapService bootstrapService;

    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    private OrderHeaderRepository orderHeaderRepository;

    @Autowired
    private OrderLineRepository orderLineRepository;


    @Override
    public void run(String... args) throws Exception {
        bootstrapService.readOrderData();


        OrderHeader orderHeader = new OrderHeader();
        OrderLine orderLine1 = new OrderLine(1);
        OrderLine orderLine2 = orderLineRepository.save(orderLine1);
        System.out.println("OrderLine version : " + orderLine2.getVersion());

        orderLine2.setQuantityOrder(324);
        orderLine2.setOrderHeader(orderHeader);
        OrderLine orderLine3 = orderLineRepository.save(orderLine2);
        System.out.println("OrderLine version : " + orderLine3.getVersion());

        orderHeader.addOrderLines(orderLine3);
        OrderHeader orderHeaderSave = orderHeaderRepository.save(orderHeader);
        System.out.println("OrderHeader version : " + orderHeaderSave.getVersion());


        OrderApproval orderApproval = new OrderApproval();
        orderApproval.setApprovalBy("Nikolas Cage");
        orderHeaderSave.setOrderApproval(orderApproval);
        OrderHeader orderHeader1 = orderHeaderRepository.save(orderHeaderSave);
        System.out.println("OrderHeader version : " + orderHeader1.getVersion());

        orderLineRepository.deleteById(orderLine3.getId());
        orderHeaderRepository.deleteById(orderHeader1.getId());

        customerVersion();
    }

    private void customerVersion() {
        Customer customer = new Customer("Name", "phone", "email");
        Customer save = customerRepository.save(customer);
        System.out.println("Customer version: " + save.getVersion());

        save.setCustomerName("name 2");
        Customer save1 = customerRepository.save(save);
        System.out.println("Customer version: " + save1.getVersion());

        customerRepository.deleteById(save1.getId());
    }

}
