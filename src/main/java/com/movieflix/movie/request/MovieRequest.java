package com.movieflix.movie.request;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.validation.constraints.NotEmpty;

import java.time.LocalDate;
import java.util.List;

public record MovieRequest(
        @NotEmpty(message = "Titulo do filme é obrigatorio")
        String title,
        String description,
        @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy")
        LocalDate realeseDate,
        Double rating,
        List<Long> categories,
        List<Long> streamings
) {
}
