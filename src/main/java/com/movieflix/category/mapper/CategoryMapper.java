package com.movieflix.category.mapper;

import com.movieflix.category.request.CategoryRequest;
import com.movieflix.category.response.CategoryResponseDTO;
import com.movieflix.category.model.Category;
import lombok.RequiredArgsConstructor;
import lombok.experimental.UtilityClass;
import org.springframework.stereotype.Component;

@UtilityClass
public class CategoryMapper {

    public static Category toCategory(CategoryRequest categoryRequest) {
        return Category
                .builder()
                .name(categoryRequest.name())
                .build();
    }

    public static CategoryResponseDTO toCategoryResponse(Category category) {
        return CategoryResponseDTO
                .builder()
                .id(category.getId())
                .name(category.getName())
                .build();
    }

}
