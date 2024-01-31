package com.itc.pmb.resource;

import com.itc.pmb.domain.Product;
import com.itc.pmb.domain.Product;
import com.itc.pmb.domain.HttpResponse;
import com.itc.pmb.dto.UserDTO;
import com.itc.pmb.report.ProductReport;
import com.itc.pmb.service.ProductService;
import com.itc.pmb.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static java.time.LocalDateTime.now;
import static java.util.Map.of;
import static org.springframework.http.HttpHeaders.CONTENT_DISPOSITION;
import static org.springframework.http.HttpStatus.CREATED;
import static org.springframework.http.HttpStatus.OK;
import static org.springframework.http.MediaType.parseMediaType;

@RestController
@RequestMapping(path = "/product")
@RequiredArgsConstructor
public class ProductResource {
    private final ProductService productService;
    private final UserService userService;

    @GetMapping("/listProduct")
    public ResponseEntity<HttpResponse> getProducts(@AuthenticationPrincipal UserDTO user,
                                                     @RequestParam Optional<Integer> page,
                                                     @RequestParam Optional<Integer> size) {
        return ResponseEntity.ok(
                HttpResponse.builder()
                        .timeStamp(now().toString())
                        .data(of("user", userService.getUserByEmail(user.getEmail()),
                                "page", productService.getProducts(page.orElse(0), size.orElse(10)),
                                "stats", productService.getState()))
                        .message("Products retrieved")
                        .status(OK)
                        .statusCode(OK.value())
                        .build());
    }
    @PostMapping("/createProduct")
    public ResponseEntity<HttpResponse> createProduct(@AuthenticationPrincipal UserDTO user,
                                                       @RequestBody Product product) {
        return ResponseEntity.created(URI.create(""))
                .body(
                        HttpResponse.builder()
                                .timeStamp(now().toString())
                                .data(of("user", userService.getUserByEmail(user.getEmail()),
                                        "product", productService.createProduct(product)))
                                .message("Product created")
                                .status(CREATED)
                                .statusCode(CREATED.value())
                                .build());
    }
    @GetMapping("/get/{id}")
    public ResponseEntity<HttpResponse> getProduct(@AuthenticationPrincipal UserDTO user,
                                                    @PathVariable("id") Long id) {
        return ResponseEntity.ok(
                HttpResponse.builder()
                        .timeStamp(now().toString())
                        .data(of("user", userService.getUserByEmail(user.getEmail()),
                                "product", productService.getProduct(id)))
                        .message("Product retrieved")
                        .status(OK)
                        .statusCode(OK.value())
                        .build());
    }
    @GetMapping("/searchProduct")
    public ResponseEntity<HttpResponse> searchProduct(@AuthenticationPrincipal UserDTO user,
                                                       Optional<String> name,
                                                       @RequestParam Optional<Integer> page,
                                                       @RequestParam Optional<Integer> size) {
        return ResponseEntity.ok(
                HttpResponse.builder()
                        .timeStamp(now().toString())
                        .data(of("user", userService.getUserByEmail(user.getEmail()),
                                "page", productService.searchProducts(name.orElse(""), page.orElse(0), size.orElse(10))))
                        .message("Products retrieved")
                        .status(OK)
                        .statusCode(OK.value())
                        .build());
    }
    @PutMapping("/updateProduct")
    public ResponseEntity<HttpResponse> updateProduct(@AuthenticationPrincipal UserDTO user,
                                                       @RequestBody Product product) {
        return ResponseEntity.ok(
                HttpResponse.builder()
                        .timeStamp(now().toString())
                        .data(of("user", userService.getUserByEmail(user.getEmail()),
                                "product", productService.updateProduct(product)))
                        .message("Product updated")
                        .status(OK)
                        .statusCode(OK.value())
                        .build());
    }
    @GetMapping("/download/product")
    public ResponseEntity<Resource> downloadProductReport() {
        List<Product> products = new ArrayList<>();
        productService.getProducts().iterator().forEachRemaining(products::add);
        ProductReport report = new ProductReport(products);
        HttpHeaders headers = new HttpHeaders();
        headers.add("File-Name", "product-report.xlsx");
        headers.add(CONTENT_DISPOSITION, "attachment;File-Name=product-report.xlsx");
        return ResponseEntity.ok().contentType(parseMediaType("application/vnd.ms-excel"))
                .headers(headers).body(report.export());
    }
}
