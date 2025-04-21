package com.product.service;

import com.product.repository.SupplierRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
@Log4j
public class SupplierService {
    private final SupplierRepository supplierRepository;
}
