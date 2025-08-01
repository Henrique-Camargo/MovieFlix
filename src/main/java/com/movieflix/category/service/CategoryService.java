package com.movieflix.category.service;

import com.movieflix.category.dto.CategoryCreateDTO;
import com.movieflix.category.dto.CategoryResponseDTO;
import com.movieflix.category.mapper.CategoryMapper;
import com.movieflix.category.model.CategoryModel;
import com.movieflix.category.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@Service
public class CategoryService {

    @Autowired
    private CategoryRepository repository;
    @Autowired
    private CategoryMapper mapper;

    @Transactional
    public CategoryResponseDTO create (CategoryCreateDTO dto){
        CategoryModel model = mapper.toModel(dto);
        CategoryModel saved = repository.save(model);
        return mapper.toResponseDTO(saved);
    }

    public List<CategoryModel> findAll (){
        return repository.findAll();
    }

    public CategoryModel findById (Long id){
        return repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Category Not Found"));
    }

//    public CategoryModel update (Long id, CategoryModel categoryUpdate){
//        return repository.
//    }

    public void Delete (@PathVariable Long id){
        repository.deleteById(id);
    }
}
