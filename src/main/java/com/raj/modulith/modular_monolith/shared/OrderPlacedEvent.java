package com.raj.modulith.modular_monolith.shared;

import java.time.Instant;
import java.util.UUID;

public record OrderPlacedEvent(UUID orderId, String product, int quantity, Instant createdAt) {}
