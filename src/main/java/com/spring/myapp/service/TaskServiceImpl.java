package com.spring.myapp.service;

import com.spring.myapp.exception.ResourceNotFoundException;
import com.spring.myapp.model.Task;
import com.spring.myapp.repository.TaskRepository;
import org.springframework.stereotype.Service;

import javax.swing.text.html.Option;
import java.util.List;
import java.util.Optional;

@Service
public class TaskServiceImpl implements TaskService{

    /**
     * сервисный слой хранит в себе как зависимость интрефейс репозитория
     */
    private TaskRepository taskRepository;

    public TaskServiceImpl(TaskRepository taskRepository) {
        super();
        this.taskRepository = taskRepository;
    }

    @Override
    public Task createTask(Task task){
        return taskRepository.save(task);
    }

    @Override
    public List<Task> getAllTask() {
        return taskRepository.findAll();
    }

    @Override
    public Task getTaskById(Integer id){
        Optional<Task> task = taskRepository.findById(id);
        if (task.isPresent()){
            return task.get();
        }
        else{
            //если не нашли бросаем исключение
            throw new ResourceNotFoundException("Task", "Id", id);
        }
    }

    @Override
    public Task updateTaskById(Task task, Integer id) {
        //проверка что таска существует
        Task existTask = taskRepository.findById(id).orElseThrow(
                () -> new ResourceNotFoundException("Task", "Id", id)
        );
        existTask.setDescription(task.getDescription());
        taskRepository.save(existTask);
        return existTask;
    }

    @Override
    public Task closeTask(Integer id) {
        Task existTask = taskRepository.findById(id).orElseThrow(
                () -> new ResourceNotFoundException("Task", "Id", id)
        );
        existTask.setOpen(false);
        taskRepository.save(existTask);
        return existTask;
    }

    @Override
    public Task deleteTaskById(Integer id){
        Task existTask = taskRepository.findById(id).orElseThrow(
                () -> new ResourceNotFoundException("Task", "Id", id)
        );
        taskRepository.delete(existTask);
        return existTask;
    }

    @Override
    public void deleteAll() {
        taskRepository.deleteAll();
    }

    @Override
    public List<Task> filterOpenTasks(){
        return taskRepository.findAllByOpen(true);
    }

    @Override
    public List<Task> filterCloseTasks() {
        return taskRepository.findAllByOpen(false);
    }
}
