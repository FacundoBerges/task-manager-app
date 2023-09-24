package com.example.taskmanager.domain.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDate;

@Data @AllArgsConstructor
public class BadRequestResponseDto {

    private LocalDate timestamp;
    private Integer status;
    private String error;
    private String message;

}
