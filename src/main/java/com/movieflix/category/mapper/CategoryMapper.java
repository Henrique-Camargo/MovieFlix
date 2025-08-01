package com.movieflix.category.mapper;

import com.movieflix.category.dto.CategoryCreateDTO;
import com.movieflix.category.dto.CategoryResponseDTO;
import com.movieflix.category.model.CategoryModel;
import org.springframework.stereotype.Component;

@Component
public class CategoryMapper {

    public CategoryModel toModel(CategoryCreateDTO dto){
        CategoryModel model = new CategoryModel();
        model.setName(dto.name());
        return model;
    }

    public CategoryResponseDTO toResponseDTO(CategoryModel model){
        return new CategoryResponseDTO(model.getId(), model.getName());
    }

}
