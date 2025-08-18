package com.movieflix.streaming.request;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotEmpty;

public record StreamingRequest(
        @Schema(type = "string", description = "nome do streaming")
        @NotEmpty(message = "O nome do Streaming é obrigatorio")
        String name
) {
}
