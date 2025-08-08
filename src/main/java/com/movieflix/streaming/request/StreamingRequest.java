package com.movieflix.streaming.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record StreamingRequest(
        @NotBlank(message = "O nome e obrigatorio")
        String name
) {
}
