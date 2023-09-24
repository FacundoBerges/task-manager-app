package com.example.taskmanager.domain.service;

import com.example.taskmanager.persistence.entity.Task;
import com.example.taskmanager.persistence.mapper.TaskMapper;
import com.example.taskmanager.persistence.repository.ITaskRepository;
import com.example.taskmanager.domain.dto.TaskDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TaskService {
    private final ITaskRepository taskRepository;
    private final TaskMapper mapper;

    @Autowired
    public TaskService(ITaskRepository taskRepository, TaskMapper mapper) {
        this.taskRepository = taskRepository;
        this.mapper = mapper;
    }

    public List<TaskDto> getAll() {
        return mapper.toTaskDTOList(taskRepository.findAll());
    }

    public Optional<TaskDto> add(TaskDto taskDto) {
        if(taskDto == null || taskDto.getDescription().trim().isEmpty()) {
            return Optional.empty();
        }

        Task task = mapper.toTask(taskDto);

        return Optional.of( mapper.toTaskDTO( taskRepository.save(task) ) );
    }

}
