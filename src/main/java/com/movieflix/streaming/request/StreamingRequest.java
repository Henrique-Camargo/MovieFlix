package com.movieflix.streaming.request;

import jakarta.validation.constraints.NotBlank;

public record StreamingRequest(
        @NotBlank(message = "O nome e obrigatorio")
        String name
) {
}
