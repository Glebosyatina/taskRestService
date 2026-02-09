package com.spring.myapp.service;

import com.spring.myapp.model.Task;

import java.util.List;

/**
 * service layer - бизенс логика
 */

public interface TaskService {
    Task createTask(Task task);
    List<Task> getAllTask();
    Task getTaskById(Integer id);
    Task updateTaskById(Task task, Integer id);
    Task closeTask(Integer id);
    Task deleteTaskById(Integer id);
    void deleteAll();
    List<Task> filterOpenTasks();
    List<Task> filterCloseTasks();
}
