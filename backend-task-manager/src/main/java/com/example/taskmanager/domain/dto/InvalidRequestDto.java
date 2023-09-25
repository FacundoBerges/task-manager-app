package com.example.taskmanager.domain.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDate;

@Data @AllArgsConstructor
public class InvalidRequestDto {

    private LocalDate localDate;
    private int errorCode;
    private String message;
    private String description;

}
