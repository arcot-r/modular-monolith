package com.raj.modulith.modular_monolith.inventory;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import java.util.UUID;

@Entity
public class Inventory {

    @Id
    private UUID id;
    private String product;
    private int availableQuantity;

    public Inventory() {}

    public Inventory(String product, int availableQuantity) {
        this.id = UUID.randomUUID();
        this.product = product;
        this.availableQuantity = availableQuantity;
    }

    public UUID getId() { return id; }
    public String getProduct() { return product; }
    public int getAvailableQuantity() { return availableQuantity; }

    public void reduceStock(int quantity) {
        this.availableQuantity -= quantity;
    }
}