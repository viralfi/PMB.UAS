package com.itc.pmb.service;

import com.itc.pmb.domain.Product;
import com.itc.pmb.domain.Stats;
import com.itc.pmb.dto.UserDTO;
import org.springframework.data.domain.Page;
import org.springframework.web.multipart.MultipartFile;

public interface ProductService {
    Product createProduct(Product product);

    Product updateProduct(Product product);

    Page<Product> getProducts(int page, int size);

    Iterable<Product> getProducts();

    Product getProduct(Long id);

    Page<Product> searchProducts(String name, int page, int size);
    Stats getState();
    void uploadImage(Product product, MultipartFile image);
}
