package com.raj.modulith.modular_monolith.orders;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/orders")
public class OrderController {

    private final OrderService service;

    public OrderController(OrderService service) {
        this.service = service;
    }

    @PostMapping
    public Order create(@RequestBody OrderRequest request) {
        return service.placeOrder(request.product(), request.quantity());
    }

    public record OrderRequest(String product, int quantity) {}
}