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

    @Override
    public void run(String... args) throws Exception {
        bootstrapService.readOrderData();

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
