package com.ashish.taskmanager.services;


import com.ashish.taskmanager.entities.TaskEntity;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;

@Service
public class TaskService {

    private ArrayList<TaskEntity> tasks = new ArrayList<TaskEntity>();
    private int taskId = 1;


    void addTask(String title, String description, String deadline) {
        TaskEntity task = new TaskEntity();
        task.setId(taskId);
        task.setTitle(title);
        task.setDescription(description);
        task.setDeadline(new Date(deadline)); // TODO : validate date format YYYY-MM-DD
        task.setCompleted(false);

        tasks.add(task);
        taskId++;
    }

    public ArrayList<TaskEntity> getTasks() {
        return tasks;
    }

    public TaskEntity getTaskById(int id) {
        for (TaskEntity task : tasks) {
            if (task.getId() == id) {
                return task;
            }
        }

        return null;
    }
}