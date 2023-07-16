package com.ashish.taskmanager.controllers;

import com.ashish.taskmanager.entities.TaskEntity;
import com.ashish.taskmanager.services.TaskService;
import dto.CreateTaskDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.net.http.HttpResponse;
import java.util.List;

@RestController
@RequestMapping("/tasks")
public class TasksController {


    private final TaskService tasksService;

    public TasksController(TaskService tasksService) {
        this.tasksService = tasksService;
    }

    @GetMapping("")
    public ResponseEntity<List<TaskEntity>> getTasks() {
        var tasks = tasksService.getTasks();

        return ResponseEntity.ok(tasks);
    }


    @GetMapping("/{id}")
    public ResponseEntity<TaskEntity> getTaskById(@PathVariable("id") Integer id) {
        var task = tasksService.getTaskById(id);

        if (task == null) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(task);
    }

    @PostMapping("")
    public ResponseEntity<TaskEntity> addTask(@RequestBody CreateTaskDTO taskDTO) {
        var task = tasksService.addTask(taskDTO.getTitle(), taskDTO.getDescription(), taskDTO.getDeadline());
        return ResponseEntity.ok(task);
    }


}
