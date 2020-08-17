package com.uspehgp.tasklist.springbootbackend.controller;

import com.uspehgp.tasklist.springbootbackend.entity.Category;
import com.uspehgp.tasklist.springbootbackend.repo.CategoryRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/category")
public class CategoryController {

    private CategoryRepository categoryRepository;

    public CategoryController(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    @GetMapping("/test")
    public List<Category> test() {

        List<Category> list = categoryRepository.findAll();
        System.out.println("list"+ list);
        return list;
    }
    @PostMapping("/add")
    public Category add(@RequestBody Category category){
        return categoryRepository.save(category);
    }
}
