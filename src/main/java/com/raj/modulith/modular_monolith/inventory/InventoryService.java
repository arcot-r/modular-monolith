package com.raj.modulith.modular_monolith.inventory;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class InventoryService {

    private final InventoryRepository repository;

    public InventoryService(InventoryRepository repository) {
        this.repository = repository;
    }

    @Transactional
    public void reduceStock(String product, int quantity) {
        Inventory item = repository.findByProduct(product)
            .orElseThrow(() -> new IllegalArgumentException("Product not found: " + product));
        item.reduceStock(quantity);
        repository.save(item);
    }
}