package com.ayush.task_manager_spring_boot.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ayush.task_manager_spring_boot.model.Task;

@Repository
public interface TaskRepository extends JpaRepository<Task, Long> {
    
}
