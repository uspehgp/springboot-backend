package com.uspehgp.tasklist.springbootbackend.repo;

import com.uspehgp.tasklist.springbootbackend.entity.Priority;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PriorityRepository extends JpaRepository<Priority, Long> {
}
