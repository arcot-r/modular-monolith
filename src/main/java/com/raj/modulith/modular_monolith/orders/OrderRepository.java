package com.raj.modulith.modular_monolith.orders;

import org.springframework.data.jpa.repository.JpaRepository;
import java.util.UUID;

public interface OrderRepository extends JpaRepository<Order, UUID> {
}
