package com.movieflix.category.response;

import lombok.Builder;

@Builder
public record CategoryResponseDTO(
        Long id,
        String name
) {
}
