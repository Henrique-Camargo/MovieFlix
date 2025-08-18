package com.movieflix.movie.request;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotEmpty;

import java.time.LocalDate;
import java.util.List;

public record MovieRequest(
        @Schema(type = "string", description = "nome do filme")
        @NotEmpty(message = "Titulo do filme é obrigatorio")
        String title,
        @Schema(type = "string", description = "descrição do filme")
        String description,
        @Schema(type = "date", description = "data de lançamento do filme. ex: 19/10/1998")
        @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy")
        LocalDate realeseDate,
        @Schema(type = "double", description = "score do filme. ex: 7.8")
        Double rating,
        @Schema(type = "array", description = "lista de codigos de categorias")
        List<Long> categories,
        @Schema(type = "array", description = "lista de codigos de streamings")
        List<Long> streamings
) {
}
