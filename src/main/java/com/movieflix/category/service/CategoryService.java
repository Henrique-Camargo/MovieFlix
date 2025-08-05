package com.movieflix.category.service;

import com.movieflix.category.request.CategoryRequest;
import com.movieflix.category.response.CategoryResponseDTO;
import com.movieflix.category.mapper.CategoryMapper;
import com.movieflix.category.model.Category;
import com.movieflix.category.repository.CategoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CategoryService {

    private final CategoryRepository repository;

    public Category save(Category category) {
        return repository.save(category);
    }

    public List<Category> findAll (){
        return repository.findAll();
    }

    public Optional<Category> findById(Long id) {
        return repository.findById(id);
    }

    public void deleteById(Long id) {
        repository.deleteById(id);
    }
}
