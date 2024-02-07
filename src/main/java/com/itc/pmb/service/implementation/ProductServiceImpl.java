package com.itc.pmb.service.implementation;

import com.itc.pmb.domain.Product;
import com.itc.pmb.domain.Role;
import com.itc.pmb.domain.Stats;
import com.itc.pmb.exception.ApiException;
import com.itc.pmb.repository.ProductRepository;
import com.itc.pmb.repository.RoleRepository;
import com.itc.pmb.rowmapper.StatsRowMapper;
import com.itc.pmb.service.ProductService;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Date;
import java.util.Map;

import static com.itc.pmb.dtomapper.UserDTOMapper.fromUser;
import static com.itc.pmb.query.CustomerQuery.STATS_QUERY;
import static java.nio.file.StandardCopyOption.REPLACE_EXISTING;
import static org.springframework.data.domain.PageRequest.of;

@Service
@Transactional
@RequiredArgsConstructor
@Slf4j
public class ProductServiceImpl implements ProductService {
    private final ProductRepository productRepository;
    private final NamedParameterJdbcTemplate jdbc;
    private final RoleRepository<Role> roleRoleRepository;
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

    @Override
    public void uploadImage(Product product, MultipartFile image) {
        Path fileStorageLocation = Paths.get(System.getProperty("user.home") + "/Downloads/products/").toAbsolutePath().normalize();
        if (!Files.exists(fileStorageLocation)) {
            try {
                Files.createDirectories(fileStorageLocation);
            } catch (Exception exception) {
                log.error(exception.getMessage());
                throw new ApiException("Unable to create directories to save image");
            }
            log.info("Created directories: {}", fileStorageLocation);
        }
        try {
            Files.copy(image.getInputStream(), fileStorageLocation.resolve(product + ".png"), REPLACE_EXISTING);
        } catch (IOException exception) {
            log.error(exception.getMessage());
            throw new ApiException(exception.getMessage());
        }
        log.info("File saved in: {} folder", fileStorageLocation);
    }


}
