package com.example.taskmanager.domain.service;

import com.example.taskmanager.persistence.entity.Task;
import com.example.taskmanager.persistence.mapper.ITaskMapper;
import com.example.taskmanager.persistence.repository.ITaskRepository;
import com.example.taskmanager.domain.dto.TaskDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TaskService {
    private final ITaskRepository taskRepository;
    private final ITaskMapper mapper;

    @Autowired
    public TaskService(ITaskRepository taskRepository, ITaskMapper mapper) {
        this.taskRepository = taskRepository;
        this.mapper = mapper;
    }

    public List<TaskDto> getAll() {
        return mapper.toTaskDTOList(taskRepository.findAll());
    }

    public Optional<TaskDto> add(TaskDto taskDto) {
        if(     taskDto == null ||
                taskDto.getTaskDescription() == null ||
                taskDto.getTaskDescription().trim().isEmpty() ) {
            return Optional.empty();
        }

        Task task = mapper.toTask(taskDto);

        task.setTaskId("");

        task.setFinished(
            taskDto.getCompleted() != null
                ? taskDto.getCompleted()
                : false
        );

        return Optional.of( mapper.toTaskDTO( taskRepository.save(task) ) );
    }

}
