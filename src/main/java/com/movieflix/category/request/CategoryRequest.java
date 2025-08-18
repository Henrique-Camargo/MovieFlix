package com.movieflix.category.request;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotEmpty;

public record CategoryRequest(
        @Schema(type = "string", description = "nome do categoria")
        @NotEmpty(message = "O nome da categoria e obrigatorio")
        String name
) {
}
