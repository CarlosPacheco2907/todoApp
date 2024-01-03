package com.soto.todoapp.service.dto;

import lombok.Data;

import java.time.LocalDateTime;

/**
 * DTO (Data Transfer Object) que representa la entrada de información para la creación o actualización de una tarea.
 */
@Data
public class TaskInDTO {

    /**
     * Título de la tarea.
     */
    private String title;
    /**
     * Descripción de la tarea.
     */
    private String description;
    /**
     * Hora estimada de llegada para la tarea.
     */
    private LocalDateTime eta;

}
