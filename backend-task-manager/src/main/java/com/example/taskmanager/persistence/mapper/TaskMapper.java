package com.example.taskmanager.persistence.mapper;

import com.example.taskmanager.domain.dto.TaskDto;
import com.example.taskmanager.persistence.entity.Task;

import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface TaskMapper {

    TaskDto toTaskDTO(Task task);
    List<TaskDto> toTaskDTOList(List<Task> tasks);

    @InheritInverseConfiguration
    @Mapping(target = "idTask", ignore = true)
    Task toTask(TaskDto taskDto);

}
