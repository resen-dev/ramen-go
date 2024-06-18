package com.redventures.ramengo.dto;

import lombok.Builder;

@Builder
public record CreateOrderDto(

        Long brothId,
        Long proteinId
) {
}
