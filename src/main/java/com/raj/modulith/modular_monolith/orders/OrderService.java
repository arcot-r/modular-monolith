package com.raj.modulith.modular_monolith.orders;

import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.raj.modulith.modular_monolith.shared.OrderPlacedEvent;

@Service
public class OrderService {

    private final OrderRepository orderRepository;
    private final ApplicationEventPublisher eventPublisher;

    public OrderService(OrderRepository orderRepository, ApplicationEventPublisher eventPublisher) {
        this.orderRepository = orderRepository;
        this.eventPublisher = eventPublisher;
    }

    @Transactional
    public Order placeOrder(String product, int quantity) {
        Order order = new Order(product, quantity);
        orderRepository.save(order);
        eventPublisher.publishEvent(new OrderPlacedEvent(order.getId(), product, quantity, order.getCreatedAt()));
        return order;
    }
}