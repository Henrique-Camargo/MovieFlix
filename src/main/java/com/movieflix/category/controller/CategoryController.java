package com.movieflix.category.controller;

import com.movieflix.category.dto.CategoryCreateDTO;
import com.movieflix.category.dto.CategoryResponseDTO;
import com.movieflix.category.service.CategoryService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/category")
public class CategoryController {

    @Autowired
    private CategoryService service;

    @PostMapping
    public ResponseEntity<CategoryResponseDTO> create (@Valid @RequestBody CategoryCreateDTO dto){
        CategoryResponseDTO responseDto = service.create(dto);
        return ResponseEntity.status(HttpStatus.CREATED).body(responseDto);
    }

}
