package com.redventures.ramengo.dto;

import lombok.Builder;
import java.math.BigDecimal;

@Builder
public record ProteinDto(
        Long id,
        String imageInactive,
        String imageActive,
        String imageRamen,
        String name,
        String description,
        BigDecimal price
) {
}
