package com.api.goncalvesrep.orcamentos.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.api.goncalvesrep.orcamentos.models.ProductModel;
import com.api.goncalvesrep.orcamentos.repositories.ProductRepository;

import jakarta.transaction.Transactional;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    public List<ProductModel> getAllProducts() {
        return productRepository.findAll();
    }

    public Optional<ProductModel> getProductById(UUID id) {
        return productRepository.findById(id);
    }

    @Transactional
    public ProductModel createProduct(ProductModel product) {
        return productRepository.save(product);
    }

    @Transactional
    public Optional<ProductModel> updateProduct(UUID id, ProductModel productDetails) {
        return productRepository.findById(id).map(product -> {
            product.setName(productDetails.getName());
            product.setMeters(productDetails.getMeters());
            product.setBar(productDetails.isBar());
            product.setChapa(productDetails.getChapa());
            product.setPrice(productDetails.getPrice());
            return productRepository.save(product);
        });
    }

    @Transactional
    public void deleteProduct(UUID id) {
        productRepository.deleteById(id);
    }
}
