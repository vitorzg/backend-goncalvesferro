package com.api.goncalvesrep.orcamentos.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.api.goncalvesrep.orcamentos.models.ProductModel;
import com.api.goncalvesrep.orcamentos.services.ProductService;

import jakarta.validation.Valid;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping("/api/products")
public class ProductController {

    @Autowired
    private ProductService productService;

    @GetMapping
    public List<ProductModel> getAllProducts() {
        return productService.getAllProducts();
    }

    @PostMapping
    public ProductModel createProduct(@Valid @RequestBody ProductModel product) {
        return productService.createProduct(product);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProductModel> getProductById(@PathVariable UUID id) {
        Optional<ProductModel> product = productService.getProductById(id);
        return product.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PutMapping("/{id}")
    public ResponseEntity<ProductModel> updateProduct(@PathVariable UUID id, @Valid @RequestBody ProductModel productDetails) {
        Optional<ProductModel> updatedProduct = productService.updateProduct(id, productDetails);
        return updatedProduct.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteProduct(@PathVariable UUID id) {
        productService.deleteProduct(id);
        return ResponseEntity.noContent().build();
    }
}
