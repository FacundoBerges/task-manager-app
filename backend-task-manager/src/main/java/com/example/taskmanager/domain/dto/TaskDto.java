package com.example.taskmanager.domain.dto;


import lombok.*;

@Data @NoArgsConstructor @AllArgsConstructor
public class TaskDto {

    private String id;
    private String taskDescription;
    private Boolean completed;

}
