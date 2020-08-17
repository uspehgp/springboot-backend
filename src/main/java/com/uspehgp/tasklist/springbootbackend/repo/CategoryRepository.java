package com.uspehgp.tasklist.springbootbackend.repo;

import com.uspehgp.tasklist.springbootbackend.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Long> {
}
