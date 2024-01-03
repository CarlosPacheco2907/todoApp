package com.soto.todoapp.persitence.entity;


import lombok.Data;

import javax.persistence.*;
import java.time.LocalDateTime;

/**
 * Representa una tarea en la aplicación.
 */
@Data
@Entity
@Table(name = "task")
public class Task {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String title;
    private String description;
    private LocalDateTime createdDate;
    private LocalDateTime eta;
    private boolean finished;
    private TaskStatus taskStatus;

}
