package com.task.render.service;

import com.task.render.entity.Task;
import com.task.render.repository.TaskRepo;
import com.task.render.util.RenderProcess;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

// Sweets
@Service
public class TaskService {

    private TaskRepo taskRepo;

    public TaskService(TaskRepo taskRepo){
        this.taskRepo = taskRepo;
    }

    public Task create(Task task) {
        if(isNew(task)) {
            task.setStatus("RENDERING");
            task.setDateTime(LocalDateTime.now());
            task.setTaskId(taskRepo.save(task).getId());
            new Thread(() -> RenderProcess.updateStatus(task)).start();
            return taskRepo.save(task);
        }
        return null;
    }

    public List<Task> getAll() {
        return taskRepo.findAll();
    }

    public void updateStatus(Task task){
        task.setTaskId(task.getId());
        task.setId(0);
        taskRepo.save(task);
    }

    public boolean isNew(Task task){
        if(taskRepo.findByName(task.getName()) == null){
            return true;
        }
        return false;
    }
}
