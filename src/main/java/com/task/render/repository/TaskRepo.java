package com.task.render.repository;

import com.task.render.entity.Task;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TaskRepo extends JpaRepository<Task, Integer> {

    Task findByName(String name);

    List<Task> findAllByUserId(int userId);
}
