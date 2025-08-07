package com.movieflix.category.request;

import jakarta.validation.constraints.NotBlank;

public record CategoryRequest(
        @NotBlank(message = "O nome e obrigatorio")
        String name
) {
}
