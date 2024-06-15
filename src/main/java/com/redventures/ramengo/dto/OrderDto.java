package com.redventures.ramengo.dto;

import lombok.Builder;

import java.math.BigDecimal;

@Builder
public record OrderDto(
        Long id,
        String image,
        String description,
        BigDecimal total
) {
}
