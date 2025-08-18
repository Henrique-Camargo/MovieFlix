package com.movieflix.category.response;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Builder;

@Builder
public record CategoryResponseDTO(
        @Schema(type = "Long", description = "Codigo da categoria")
        Long id,
        @Schema(type = "string", description = "nome da categoria")
        String name
) {
}
