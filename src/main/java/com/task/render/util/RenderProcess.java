package com.task.render.util;

import com.task.render.entity.Task;
import com.task.render.service.TaskService;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

// Sweets
@Component
public class RenderProcess {

    private static TaskService taskService;

    public RenderProcess(TaskService taskService){
        this.taskService = taskService;
    }

    public static void updateStatus(Task task){
        try {
//            Thread.sleep(60000 + (int) (Math.random() * 240000));
            Thread.sleep(10000 + (int) (Math.random() * 20000));
        }catch (InterruptedException ie){
            System.out.println(ie);
        }
        task.setStatus("COMPLETE");
        task.setDateTime(LocalDateTime.now());
        taskService.updateStatus(task);
    }
}
