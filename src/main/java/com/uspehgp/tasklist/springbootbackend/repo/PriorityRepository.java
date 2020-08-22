package com.uspehgp.tasklist.springbootbackend.repo;

import com.uspehgp.tasklist.springbootbackend.entity.Category;
import com.uspehgp.tasklist.springbootbackend.entity.Priority;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PriorityRepository extends JpaRepository<Priority, Long> {

    //получить все значения отсортированные по id
    List<Priority> findAllByOrderByIdAsc();
}
