package com.example.taskmanager.persistence.mapper;

import com.example.taskmanager.domain.dto.TaskDto;
import com.example.taskmanager.persistence.entity.Task;

import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ITaskMapper {

    @Mappings({
        @Mapping(source = "taskId", target = "id"),
        @Mapping(source = "description", target = "taskDescription"),
        @Mapping(source = "finished", target = "completed")
    })
    TaskDto toTaskDTO(Task task);
    List<TaskDto> toTaskDTOList(List<Task> tasks);

    @InheritInverseConfiguration
    Task toTask(TaskDto taskDto);

}
