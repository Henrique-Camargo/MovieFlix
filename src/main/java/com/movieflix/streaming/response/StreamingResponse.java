package com.movieflix.streaming;

import lombok.Builder;

@Builder
public record StreamingResponse(
        Long id,
        String name
) {
}
