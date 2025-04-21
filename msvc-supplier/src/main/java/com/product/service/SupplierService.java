package com.product.service;

import com.product.model.SupplierModel;
import com.product.repository.SupplierRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
@Log4j
public class SupplierService {
    private final SupplierRepository supplierRepository;

    public List<SupplierModel> findAll() {
        return supplierRepository.findAll();
    }

    public SupplierModel findById(Long id) {
        return supplierRepository.findById(id).orElseThrow();
    }

    public SupplierModel create(SupplierModel supplierModel) {
        return supplierRepository.saveAndFlush(supplierModel);
    }

    public String update(Long id, SupplierModel supplierModel) {
        SupplierModel supplierExist = supplierRepository.findById(id).get();
        if (supplierExist != null) {
            if (supplierModel.getName() != null) {
                supplierExist.setName(supplierModel.getName());
            }
            if (supplierModel.getEmail() != null) {
                supplierExist.setEmail(supplierModel.getEmail());
            }
            if (supplierModel.getDirection() != null) {
                supplierExist.setDirection(supplierModel.getDirection());
            }
            if (supplierModel.getPhone() != null) {
                supplierExist.setPhone(supplierModel.getPhone());
            }
            supplierRepository.saveAndFlush(supplierExist);
            return "Supplier Actualizado";
        } else {
            return "Supplier no actualizado";
        }
    }

    public void deleted(Long id) {
        if (supplierRepository.existsById(id)) {
            supplierRepository.deleteById(id);
        }
    }

}
