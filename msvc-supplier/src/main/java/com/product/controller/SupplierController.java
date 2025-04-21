package com.product.controller;

import com.product.model.SupplierModel;
import com.product.service.SupplierService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/supplier")
public class SupplierController {
    private final SupplierService supplierService;

    @GetMapping("")
    public ResponseEntity<List<SupplierModel>> getAll() {
        return ResponseEntity.ok(supplierService.findAll());
    }

    @GetMapping("{id}")
    public ResponseEntity<SupplierModel> getById(@PathVariable Long id) {
        return ResponseEntity.ok(supplierService.findById(id));
    }

    @PostMapping("")
    public ResponseEntity<SupplierModel> create(@RequestBody SupplierModel supplierModel) {
        return ResponseEntity.ok(supplierService.create(supplierModel));
    }

    @PutMapping("{id}")
    public ResponseEntity<?> update(@PathVariable Long id, @RequestBody SupplierModel supplierModel) {
        return ResponseEntity.ok(supplierService.update(id, supplierModel));
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        supplierService.deleted(id);
        return ResponseEntity.noContent().build();
    }


}
