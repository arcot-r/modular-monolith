package com.raj.modulith.modular_monolith.inventory;

import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

import com.raj.modulith.modular_monolith.shared.OrderPlacedEvent;

@Component
public class InventoryEventListener {

    private final InventoryService inventoryService;

    public InventoryEventListener(InventoryService inventoryService) {
        this.inventoryService = inventoryService;
    }

    @EventListener
    void handle(OrderPlacedEvent event) {
        inventoryService.reduceStock(event.product(), event.quantity());
    }
}
