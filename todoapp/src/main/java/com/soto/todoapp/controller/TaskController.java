package com.soto.todoapp.controller;


import com.soto.todoapp.persitence.entity.Task;
import com.soto.todoapp.persitence.entity.TaskStatus;
import com.soto.todoapp.service.TaskService;
import com.soto.todoapp.service.dto.TaskInDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/tasks")
public class TaskController {

    private final TaskService taskService;

    public TaskController(TaskService taskService) {
        this.taskService = taskService;
    }


    @PostMapping
    public Task createTask(@RequestBody TaskInDTO taskInDTO) {
        return this.taskService.createTask(taskInDTO);
    }

    @GetMapping
    public List<Task> findAll(){
        return this.taskService.finAll();
    }

    @GetMapping("/status/{status}")
    public List<Task> finAllByStatus(@PathVariable("status")TaskStatus status){
        return this.taskService.finAllByStatus(status);
    }

    @PatchMapping("/mark_as_finished/{id}")
    public ResponseEntity<Void> markTaskAsFinished(@PathVariable("id") long id){

        this.taskService.markTaskAsFinished(id);
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable("id") Long id) {
        this.taskService.deleteById(id);
        return ResponseEntity.noContent().build();
    }





}
