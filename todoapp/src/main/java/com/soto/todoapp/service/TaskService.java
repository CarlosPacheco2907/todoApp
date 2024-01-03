package com.soto.todoapp.service;

import com.soto.todoapp.exceptions.ToDoExceptions;
import com.soto.todoapp.mappper.TaskInDTOToTask;
import com.soto.todoapp.persitence.entity.Task;
import com.soto.todoapp.persitence.entity.TaskStatus;
import com.soto.todoapp.persitence.repository.TaskRepository;
import com.soto.todoapp.service.dto.TaskInDTO;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

/**
 * Clase de servicio para gestionar tareas.
 */
@Service
public class TaskService {

    private final TaskRepository repository;

    private final TaskInDTOToTask mapper;


    /**
     * Construye un TaskService con el repositorio y mapeador proporcionados.
     *
     * @param repository      El repositorio para la persistencia de tareas.
     * @param taskInDTOToTask El mapeador para convertir TaskInDTO a Task.
     */

    public TaskService(TaskRepository repository, TaskInDTOToTask taskInDTOToTask) {
        this.repository = repository;
        this.mapper = taskInDTOToTask;
    }

    /**
     * Crea una nueva tarea basada en el TaskInDTO proporcionado.
     *
     * @param taskInDTO El DTO de entrada que contiene los detalles de la tarea.
     * @return La entidad Task creada.
     */
    public Task createTask(TaskInDTO taskInDTO) {
        Task task = mapper.map(taskInDTO);

        return this.repository.save(task);
    }


    /**
     * Regresa todas las tareas registradas
     * @return una lista con las tareas
     */
    public List<Task> finAll() {
        return this.repository.findAll();
    }

    /**
     * Regresa una lista por status indicado
     * @param status
     * @return una lista de las tareas por status
     */
    public List<Task> finAllByStatus(TaskStatus status){
        return this.repository.findAllByTaskStatus(status);
    }

    /**
     * Actualiza en nuestra base de datos el status de una tarea en base a un id
     * @param id id proporcionado
     */
    @Transactional
    public void markTaskAsFinished(long id){
        Optional<Task> optionalTask = this.repository.findById(id);
        if (optionalTask.isEmpty()) {
            throw new ToDoExceptions("Task not found", HttpStatus.NOT_FOUND);
        }

        this.repository.markTaskAsFinished(id);
    }

    public void deleteById(Long id) {
        Optional<Task> optionalTask = this.repository.findById(id);
        if (optionalTask.isEmpty()) {
            throw new ToDoExceptions("Task not found", HttpStatus.NOT_FOUND);
        }

        this.repository.deleteById(id);
    }




}
