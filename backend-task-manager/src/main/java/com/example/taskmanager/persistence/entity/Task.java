package com.example.taskmanager.persistence.entity;

import jakarta.persistence.*;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table
@Getter @Setter
@NoArgsConstructor @AllArgsConstructor
public class Task {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "id_task", nullable = false, unique = true, length = 36)
    private String taskId;

    @Column(nullable = false)
    private String description;

    @Column(nullable = false)
    private boolean finished;

}
