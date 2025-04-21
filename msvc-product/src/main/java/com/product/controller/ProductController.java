package com.product.controller;

import com.product.model.ProductModel;
import com.product.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/product")
@RequiredArgsConstructor
public class ProductController {
    private final ProductService productService;

    @GetMapping("")
    public ResponseEntity<List<ProductModel>> getAll() {
        return ResponseEntity.ok(productService.getAll());
    }

    @GetMapping("{id}")
    public ResponseEntity<ProductModel> getById(@PathVariable Long id) {
        return ResponseEntity.ok(productService.findById(id));
    }

    @PostMapping("")
    public ResponseEntity<?> create(@RequestBody ProductModel productModel) {
        return ResponseEntity.ok(productService.createProduct(productModel));
    }

    @PutMapping("{id}")
    public ResponseEntity<?> update(@PathVariable Long id, @RequestBody ProductModel productModel) {
        return ResponseEntity.ok(productService.updateProduct(id, productModel));
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        productService.deleted(id);
        return ResponseEntity.noContent().build();
    }

}
