package com.movieflix.category.request;

import jakarta.validation.constraints.NotEmpty;

public record CategoryRequest(
        @NotEmpty(message = "O nome da categoria e obrigatorio")
        String name
) {
}
