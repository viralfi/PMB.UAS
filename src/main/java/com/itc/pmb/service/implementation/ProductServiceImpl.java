package com.itc.pmb.service.implementation;

import com.itc.pmb.domain.Product;
import com.itc.pmb.domain.Stats;
import com.itc.pmb.repository.ProductRepository;
import com.itc.pmb.rowmapper.StatsRowMapper;
import com.itc.pmb.service.ProductService;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.Map;

import static com.itc.pmb.query.CustomerQuery.STATS_QUERY;
import static org.springframework.data.domain.PageRequest.of;

@Service
@Transactional
@RequiredArgsConstructor
@Slf4j
public class ProductServiceImpl implements ProductService {
    private final ProductRepository productRepository;
    private final NamedParameterJdbcTemplate jdbc;
    @Override
    public Product createProduct(Product product) {
        product.setCreatedAt(new Date());
        return productRepository.save(product);
    }

    @Override
    public Product updateProduct(Product product) {
        return productRepository.save(product);
    }

    @Override
    public Page<Product> getProducts(int page, int size) {
        return productRepository.findAll(PageRequest.of(page, size));
    }

    @Override
    public Iterable<Product> getProducts() {
        return productRepository.findAll();
    }

    @Override
    public Product getProduct(Long id) {
        return productRepository.findById(id).get();
    }

    @Override
    public Page<Product> searchProducts(String name, int page, int size) {
        return productRepository.findByNameContaining(name, of(page, size));
    }

    @Override
    public Stats getState() {
        return jdbc.queryForObject(STATS_QUERY, Map.of(), new StatsRowMapper());
    }
}
