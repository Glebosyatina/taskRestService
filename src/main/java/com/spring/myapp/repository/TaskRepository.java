package com.spring.myapp.repository;

import com.spring.myapp.model.Task;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

/**
 * репозиторный слой, описываем интерфейс репозитория, реализацией можем менять варианты бд(in-memory,pg etc.)
 */

public interface TaskRepository extends JpaRepository<Task, Integer>{
    List<Task> findAllByOpen(Boolean condition);
}
