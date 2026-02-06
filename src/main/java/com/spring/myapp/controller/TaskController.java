package com.spring.myapp.controller;

import com.spring.myapp.model.Task;
import com.spring.myapp.service.TaskService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * слой контроллеров/адаптеров для общения с внешним миром(http)
 */


@RestController
public class TaskController {

    //в виде зависимости хранит слой бизнес логики
    private TaskService taskService;

    public TaskController(TaskService taskService){
        super();
        this.taskService = taskService;
    }

    //healthcheck
    @GetMapping("/health")
    public HttpStatus healthCheck(){
        return HttpStatus.OK;
    }

    // для создания задач
    @PostMapping("/tasks/create")
    public ResponseEntity<Task> createTask(@RequestBody Task task){
        return new ResponseEntity<Task>(taskService.createTask(task), HttpStatus.CREATED);
    }

    //получить все задачи
    @GetMapping("/tasks")
    public List<Task> getTasks(){
        return taskService.getAllTask();
    }

    //задача по id
    @GetMapping("/tasks/{id}")
    public ResponseEntity<Task> getTask(@PathVariable("id") Integer id){
        return new ResponseEntity<Task>(taskService.getTaskById(id), HttpStatus.OK);
    }

    //обновление задачи
    @PutMapping("/tasks/update/{id}")
    public ResponseEntity<Task> updateTask(@PathVariable("id") Integer id, @RequestBody Task task){
        return new ResponseEntity<Task>(taskService.updateTaskById(task, id), HttpStatus.OK);
    }

    //закрытие задачи, статус open->false
    @PutMapping("/tasks/close/{id}")
    public ResponseEntity<Task> closeTask(@PathVariable("id") Integer id){
        return new ResponseEntity<Task>(taskService.closeTask(id), HttpStatus.OK);
    }

    //удаление задачи
    @DeleteMapping("/tasks/delete/{id}")
    public ResponseEntity<Task> deleteTask(@PathVariable("id") Integer id){
        return new ResponseEntity<Task>(taskService.deleteTaskById(id), HttpStatus.OK);
    }

    //удаление всех задач
    @DeleteMapping("/tasks/delete/all")
    public ResponseEntity<String> deleteAllTasks(){
        taskService.deleteAll();
        return new ResponseEntity<String>("Все задачи удалены", HttpStatus.OK);
    }
}
