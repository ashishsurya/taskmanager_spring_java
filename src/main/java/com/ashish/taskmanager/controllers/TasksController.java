package com.ashish.taskmanager.controllers;

import com.ashish.taskmanager.entities.TaskEntity;
import com.ashish.taskmanager.services.TaskService;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
    public ResponseEntity<TaskEntity> getTaskById(int id) {
        var task = tasksService.getTaskById(id);

        if(task == null) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(task);
    }


}
