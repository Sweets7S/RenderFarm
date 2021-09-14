package com.task.render.controllers;

import com.task.render.entity.Task;
import com.task.render.service.TaskService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

// Sweets
@RestController
@RequestMapping("/task")
public class TaskController {

    private TaskService taskService;

    public TaskController(TaskService taskService){
        this.taskService = taskService;
    }

    @PostMapping
    public Task create(@RequestBody Task task){
        return taskService.create(task);
    }

    @GetMapping
    public List<Task> getAll(){
        return taskService.getAll();
    }
}
