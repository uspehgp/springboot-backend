package com.uspehgp.tasklist.springbootbackend.controller;

import com.uspehgp.tasklist.springbootbackend.entity.Category;
import com.uspehgp.tasklist.springbootbackend.repo.CategoryRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.NoSuchElementException;

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
    public ResponseEntity<Category> add(@RequestBody Category category){

        // проверка на обязательные параметры
        if (category.getId() != null && category.getId() != 0) {
            // id создается автоматически в БД (autoincrement), поэтому его передавать не нужно, иначе может быть конфликт уникальности значения
            return new ResponseEntity("redundant param: id MUST be null", HttpStatus.NOT_ACCEPTABLE);
        }

        // если передали пустое значение title
        if (category.getTitle() == null || category.getTitle().trim().length() == 0) {
            return new ResponseEntity("missed param: title", HttpStatus.NOT_ACCEPTABLE);
        }


        return ResponseEntity.ok(categoryRepository.save(category));
    }

    @PutMapping("/update")
    public ResponseEntity update(@RequestBody Category category){

        // проверка на обязательные параметры
        if (category.getId() == null || category.getId() == 0) {
            // id создается автоматически в БД (autoincrement), поэтому его передавать нужно только при обновлении, иначе может быть конфликт уникальности значения
            return new ResponseEntity("missed param: id", HttpStatus.NOT_ACCEPTABLE);
        }

        // если передали пустое значение title
        if (category.getTitle() == null || category.getTitle().trim().length() == 0) {
            return new ResponseEntity("missed param: title", HttpStatus.NOT_ACCEPTABLE);
        }

        return ResponseEntity.ok(categoryRepository.save(category));
    }

    @GetMapping("/id/{id}")
    public ResponseEntity<Category> findById(@PathVariable Long id) {

        Category category=null;

        try{
            category = categoryRepository.findById(id).get();
        }catch(NoSuchElementException e){
            e.printStackTrace();
            return new ResponseEntity("id= "+id+"not found", HttpStatus.NOT_ACCEPTABLE); //если объект не будет найден
        }

        return  ResponseEntity.ok(category);

    }

}
