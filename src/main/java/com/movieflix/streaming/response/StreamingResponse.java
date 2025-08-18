package com.movieflix.streaming.response;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Builder;

@Builder
public record StreamingResponse(
        @Schema(type = "Long", description = "Codigo do streaming")
        Long id,
        @Schema(type = "string", description = "nome do streaming")
        String name
) {
}
