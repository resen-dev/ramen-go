package com.redventures.ramengo.dto;

import jakarta.validation.constraints.NotNull;
import lombok.Builder;

@Builder
public record CreateOrderDto(

        @NotNull(message = "both brothId and proteinId are required")
        Long brothId,

        @NotNull(message = "both brothId and proteinId are required")
        Long proteinId
) {
}
