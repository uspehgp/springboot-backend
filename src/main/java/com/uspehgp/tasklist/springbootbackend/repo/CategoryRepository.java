package com.uspehgp.tasklist.springbootbackend.repo;

import com.uspehgp.tasklist.springbootbackend.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Long> {
    //получить все значения отсортированные по названию
    List<Category> findAllByOrderByTitleAsc();

}
