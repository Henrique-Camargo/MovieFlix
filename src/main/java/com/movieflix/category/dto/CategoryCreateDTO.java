package com.movieflix.category.dto;

import jakarta.validation.constraints.NotBlank;

public record CategoryCreateDTO(
        @NotBlank(message = "O nome e obrigatorio")
        String name
) {
}
