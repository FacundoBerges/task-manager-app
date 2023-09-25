package com.example.taskmanager.persistence.repository;


import com.example.taskmanager.persistence.entity.Task;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ITaskRepository extends JpaRepository<Task, String> {

    List<Task> findByDescriptionContaining(String description);

}
