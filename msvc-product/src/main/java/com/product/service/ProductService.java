package com.product.service;

import com.product.model.ProductModel;
import com.product.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class ProductService {
    private final ProductRepository productRepository;

    public List<ProductModel> getAll() {
        return productRepository.findAll();
    }

    public ProductModel findById(Long id) {
        return productRepository.findById(id).orElseThrow();
    }

    public ProductModel createProduct(ProductModel productModel) {
        return productRepository.saveAndFlush(productModel);
    }

    public String updateProduct(Long id, ProductModel productModel) {
        ProductModel productExist = productRepository.findById(id).orElseThrow();

        if (productExist != null) {
            if (productModel.getName() != null) {
                productExist.setName(productModel.getName());
            }
            if (productModel.getSku() != null) {
                productExist.setSku(productModel.getSku());
            }
            if (productModel.getSupplierId() != null) {
                productExist.setSupplierId(productModel.getSupplierId());
            }
            if (productModel.getSupplierName() != null) {
                productExist.setSupplierName(productModel.getSupplierName());
            }
            productRepository.saveAndFlush(productExist);
            return "Producto Actualizado";
        } else {
            return "Producto no Actualizado";
        }
    }

    public void deleted(Long id) {
        if (productRepository.existsById(id)) {
            productRepository.deleteById(id);
        }
    }

}
