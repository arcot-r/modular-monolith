package com.raj.modulith.modular_monolith.shared;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.UUID;

public final class SharedUtils {

    private static final ObjectMapper OBJECT_MAPPER = new ObjectMapper();

    private SharedUtils() {
        // Prevent instantiation
    }

    /**
     * Generate a random UUID string.
     */
    public static String generateId() {
        return UUID.randomUUID().toString();
    }

    /**
     * Convert epoch milliseconds to a local date-time.
     */
    public static LocalDateTime toLocalDateTime(long epochMillis) {
        return Instant.ofEpochMilli(epochMillis)
                      .atZone(ZoneId.systemDefault())
                      .toLocalDateTime();
    }

    /**
     * Convert any object to JSON string.
     */
    public static String toJson(Object obj) {
        try {
            return OBJECT_MAPPER.writeValueAsString(obj);
        } catch (JsonProcessingException e) {
            throw new RuntimeException("JSON serialization failed", e);
        }
    }

    /**
     * Parse a JSON string to an object.
     */
    public static <T> T fromJson(String json, Class<T> clazz) {
        try {
            return OBJECT_MAPPER.readValue(json, clazz);
        } catch (JsonProcessingException e) {
            throw new RuntimeException("JSON deserialization failed", e);
        }
    }

}

