package com.abhinav.ecom_project.service;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.abhinav.ecom_project.model.Product;
import com.abhinav.ecom_project.repo.ProductRepo;

@Service
public class ProductService {

    @Autowired
    private ProductRepo repo;

    public List<Product> getAllProducts() {
        return repo.findAll();
    }

    public Product getProductById(int id) {
        return repo.findById(id).orElse(null);
    }

    public Product addProduct(Product product,
                              MultipartFile imageFile)
            throws IOException {

        product.setImageName(
                imageFile.getOriginalFilename());

        product.setImageType(
                imageFile.getContentType());

        product.setImageData(
                imageFile.getBytes());

        return repo.save(product);
    }

    public Product updateProduct(
            int id,
            Product product,
            MultipartFile imageFile) throws IOException {

        Product existingProduct =
                repo.findById(id).orElse(null);

        if (existingProduct == null) {
            return null;
        }

        product.setId(id);

        if (imageFile != null && !imageFile.isEmpty()) {

            product.setImageName(
                    imageFile.getOriginalFilename());

            product.setImageType(
                    imageFile.getContentType());

            product.setImageData(
                    imageFile.getBytes());

        } else {

            product.setImageName(
                    existingProduct.getImageName());

            product.setImageType(
                    existingProduct.getImageType());

            product.setImageData(
                    existingProduct.getImageData());
        }

        return repo.save(product);
    }
    public void deleteProduct(int id) {
        repo.deleteById(id);
    }
    public List<Product> searchProducts(String keyword) {

        if (keyword == null || keyword.trim().isEmpty()) {
            return repo.findAll();
        }

        return repo.searchProducts(keyword);
    }
}