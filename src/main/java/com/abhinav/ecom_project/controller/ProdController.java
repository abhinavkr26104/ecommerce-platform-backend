package com.abhinav.ecom_project.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import com.abhinav.ecom_project.model.Product;
import com.abhinav.ecom_project.service.ProductService;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/api")
public class ProdController {

    @Autowired
    private ProductService service;

    @GetMapping("/")
    public ResponseEntity<String> greet() {
        return ResponseEntity.ok("Hello!!");
    }

    @GetMapping("/products")
    public ResponseEntity<List<Product>> getAllProducts() {

        List<Product> products = service.getAllProducts();

        if (products.isEmpty()) {
            return ResponseEntity.noContent().build();
        }

        return ResponseEntity.ok(products);
    }

    @GetMapping("/product/{id}")
    public ResponseEntity<Product> getProductById(
            @PathVariable int id) {

        Product product = service.getProductById(id);

        if (product == null) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(product);
    }

    @GetMapping("/product/{id}/image")
    public ResponseEntity<byte[]> getImageByProductId(
            @PathVariable int id) {

        Product product = service.getProductById(id);

        if (product == null ||
                product.getImageData() == null) {

            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok()
                .contentType(
                        MediaType.parseMediaType(
                                product.getImageType()))
                .body(product.getImageData());
    }

    @PostMapping("/product")
    public ResponseEntity<?> addProduct(
            @RequestPart Product product,
            @RequestPart MultipartFile imageFile) {

        try {

            Product savedProduct =
                    service.addProduct(product, imageFile);

            return new ResponseEntity<>(
                    savedProduct,
                    HttpStatus.CREATED);

        } catch (Exception e) {

            return ResponseEntity.status(
                    HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(e.getMessage());
        }
    }

    @PutMapping("/product/{id}")
    public ResponseEntity<?> updateProduct(
            @PathVariable int id,
            @RequestPart Product product,
            @RequestPart(required = false)
            MultipartFile imageFile) {

        try {

            Product updatedProduct =
                    service.updateProduct(
                            id,
                            product,
                            imageFile);

            if (updatedProduct == null) {
                return ResponseEntity.notFound().build();
            }

            return ResponseEntity.ok(updatedProduct);

        } catch (Exception e) {

            return ResponseEntity.status(
                    HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(e.getMessage());
        }
    }

    @DeleteMapping("/product/{id}")
    public ResponseEntity<?> deleteProduct(
            @PathVariable int id) {

        Product product =
                service.getProductById(id);

        if (product == null) {
            return ResponseEntity.notFound().build();
        }

        service.deleteProduct(id);

        return ResponseEntity.ok(
                "Product deleted successfully");
    }
    @GetMapping("/products/search")
    public ResponseEntity<List<Product>> searchProducts(
            @RequestParam String keyword) {

        List<Product> products =
                service.searchProducts(keyword);

        return ResponseEntity.ok(products);
    }
}