package com.uspehgp.tasklist.springbootbackend.controller;

import com.uspehgp.tasklist.springbootbackend.entity.Priority;
import com.uspehgp.tasklist.springbootbackend.repo.PriorityRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/priority")
public class PriorityController {

    private PriorityRepository priorityRepository;

    public PriorityController(PriorityRepository priorityRepository) {
        this.priorityRepository = priorityRepository;
    }

    @GetMapping("/test")
    public List<Priority> test() {

        List<Priority> list = priorityRepository.findAll();
        System.out.println("list"+ list);
        return list;

    }
    @PostMapping("/add")
    public ResponseEntity<Priority> add(@RequestBody Priority priority){

        // проверка на обязательные параметры
        if (priority.getId() != null && priority.getId() != 0) {
            // id создается автоматически в БД (autoincrement), поэтому его передавать не нужно, иначе может быть конфликт уникальности значения
            return new ResponseEntity("redundant param: id MUST be null", HttpStatus.NOT_ACCEPTABLE);
        }

        // если передали пустое значение title
        if (priority.getTitle() == null || priority.getTitle().trim().length() == 0) {
            return new ResponseEntity("missed param: title", HttpStatus.NOT_ACCEPTABLE);
        }


        return ResponseEntity.ok(priorityRepository.save(priority));
    }
    @PutMapping("/update")
    public ResponseEntity update(@RequestBody Priority priority){

        // проверка на обязательные параметры
        if (priority.getId() == null || priority.getId() == 0) {
            // id создается автоматически в БД (autoincrement), поэтому его передавать нужно только при обновлении, иначе может быть конфликт уникальности значения
            return new ResponseEntity("missed param: id", HttpStatus.NOT_ACCEPTABLE);
        }

        // если передали пустое значение title
        if (priority.getTitle() == null || priority.getTitle().trim().length() == 0) {
            return new ResponseEntity("missed param: title", HttpStatus.NOT_ACCEPTABLE);
        }

        // если передали пустое значение color
        if (priority.getColor() == null || priority.getColor().trim().length() == 0) {
            return new ResponseEntity("missed param: Color", HttpStatus.NOT_ACCEPTABLE);
        }


        return ResponseEntity.ok(priorityRepository.save(priority));
    }
}
