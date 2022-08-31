package com.blinets.os.OrderService.services.impl;

import com.blinets.os.OrderService.dto.Product;
import com.blinets.os.OrderService.repository.ProductRepository;
import com.blinets.os.OrderService.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductRepository productRepository;

    @Override
    public Product savaProduct(Product product) {
        return productRepository.saveAndFlush(product);
    }

    @Override
    public Product updateQOH(Product product, Integer quantityOnHand) {
        Product product1 = productRepository.findById(product.getId()).orElseThrow();
        product1.setQuantityOnHand(quantityOnHand);
        return productRepository.saveAndFlush(product1);
    }
}
