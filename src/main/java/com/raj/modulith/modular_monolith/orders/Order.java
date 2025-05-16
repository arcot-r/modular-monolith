package com.raj.modulith.modular_monolith.orders;

import jakarta.persistence.*;
import java.time.Instant;
import java.util.UUID;

@Entity
@Table(name = "orders")
public class Order {

    @Id
    private UUID id;

    private String product;
    private int quantity;
    private Instant createdAt;

    public Order() {}

    public Order(String product, int quantity) {
        this.id = UUID.randomUUID();
        this.product = product;
        this.quantity = quantity;
        this.createdAt = Instant.now();
    }

    public UUID getId() { return id; }
    public String getProduct() { return product; }
    public int getQuantity() { return quantity; }
    public Instant getCreatedAt() { return createdAt; }
}
