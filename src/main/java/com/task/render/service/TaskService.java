package com.task.render.service;

import com.task.render.entity.Task;
import com.task.render.repository.TaskRepo;
import org.springframework.stereotype.Service;

// Sweets
@Service
public class TaskService {

    private TaskRepo taskRepo;

    public TaskService(TaskRepo taskRepo){
        this.taskRepo = taskRepo;
    }

    public Task create(Task task) {
        task.setStatus("RENDERING");
        return taskRepo.save(task);
    }
}
