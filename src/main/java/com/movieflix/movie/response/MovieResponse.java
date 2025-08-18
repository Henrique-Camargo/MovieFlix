package com.movieflix.movie.response;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.movieflix.category.response.CategoryResponseDTO;
import com.movieflix.streaming.response.StreamingResponse;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Builder;

import java.time.LocalDate;
import java.util.List;

@Builder
public record MovieResponse(
        @Schema(type = "Long", description = "Codigo do filme")
        Long id,
        @Schema(type = "string", description = "nome do filme")
        String title,
        @Schema(type = "string", description = "descrição do filme")
        String description,
        @Schema(type = "date", description = "data de lançamento do filme. ex: 19/10/1998")
        @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy")
        LocalDate realeseDate,
        @Schema(type = "double", description = "score do filme. ex: 7.8")
        Double rating,
        @Schema(type = "array", description = "lista de codigos de categorias")
        List<CategoryResponseDTO>categories,
        @Schema(type = "array", description = "lista de codigos de streamings")
        List<StreamingResponse>streamings
) {
}
