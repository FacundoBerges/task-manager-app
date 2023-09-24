package com.example.taskmanager.web.controller;


import com.example.taskmanager.domain.dto.BadRequestResponseDto;
import com.example.taskmanager.domain.service.TaskService;
import com.example.taskmanager.domain.dto.TaskDto;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/tasks")
public class TaskController {

    private final TaskService taskService;

    @Autowired
    public TaskController(TaskService taskService) {
        this.taskService = taskService;
    }

    @GetMapping
    public ResponseEntity<List<TaskDto>> getTasks() {
        List<TaskDto> tasksList = taskService.getAll();

        return tasksList.isEmpty()
                ? ResponseEntity.noContent().build()
                : ResponseEntity.ok(tasksList);
    }

    @PostMapping
    public ResponseEntity<?> addTask(@RequestBody TaskDto taskDto) {
        Optional<TaskDto> taskDtoOptional = taskService.add(taskDto);

        return taskDtoOptional.isPresent()
                ? ResponseEntity.status( HttpStatus.CREATED ).body(taskDtoOptional.get())
                : ResponseEntity.badRequest().build();
    }

}