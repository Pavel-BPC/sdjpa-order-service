package com.blinets.os.OrderService.services;

import com.blinets.os.OrderService.dto.Product;

public interface ProductService {

    Product savaProduct(Product product);

    Product updateQOH(Product product, Integer quantityOnHand);
}
