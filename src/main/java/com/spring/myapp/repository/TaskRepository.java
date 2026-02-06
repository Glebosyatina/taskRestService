package com.spring.myapp.repository;

import com.spring.myapp.model.Task;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * репозиторный слой, описываем интерфейс репозитория, реализацией можем менять варианты бд(in-memory,pg etc.)
 */

public interface TaskRepository extends JpaRepository<Task, Integer>{

}
