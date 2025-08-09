package com.movieflix.movie.request;

import java.time.LocalDate;
import java.util.List;

public record MovieRequest(
        String title,
        String description,
        LocalDate realeseDate,
        Double rating,
        List<Long> categories,
        List<Long> streamings
) {
}
