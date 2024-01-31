package com.itc.pmb.service;

import com.itc.pmb.domain.Product;
import com.itc.pmb.domain.Stats;
import org.springframework.data.domain.Page;

public interface ProductService {
    Product createProduct(Product product);

    Product updateProduct(Product product);

    Page<Product> getProducts(int page, int size);

    Iterable<Product> getProducts();

    Product getProduct(Long id);

    Page<Product> searchProducts(String name, int page, int size);
    Stats getState();
}
