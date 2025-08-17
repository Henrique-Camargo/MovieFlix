package com.movieflix.streaming.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;

public record StreamingRequest(
        @NotEmpty(message = "O nome do Streaming é obrigatorio")
        String name
) {
}
