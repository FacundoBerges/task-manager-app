package com.example.taskmanager.persistence.repository;


import com.example.taskmanager.persistence.entity.Task;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ITaskRepository extends JpaRepository<Task, String> {

    List<Task> findByDescriptionContaining(String description);

}
