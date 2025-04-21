package com.product.controller;

import com.product.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/product")
@RequiredArgsConstructor
public class ProductController {
    private final ProductService productService;

    @GetMapping("")
    public ResponseEntity<?> getAll() {
        return ResponseEntity.ok("");
    }

    @GetMapping("{id}")
    public ResponseEntity<?> getById(@PathVariable Long id) {
        return ResponseEntity.ok("");
    }

    @PostMapping("")
    public ResponseEntity<?> create() {
        return ResponseEntity.ok("");
    }

    @PutMapping("{id}")
    public ResponseEntity<?> update() {
        return ResponseEntity.ok("");
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {

        return ResponseEntity.noContent().build();
    }

}
