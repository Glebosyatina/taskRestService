package com.spring.myapp.model;

import jakarta.persistence.*;
import lombok.Data; //добавляет boilerplate code getters, setters and etc.
import lombok.NoArgsConstructor;

/**
 * слой доменных сущностей
 */


@Data
@Entity
@NoArgsConstructor
public class Task {

    @Id //primary key for tuples
    @GeneratedValue( strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "description")
    private String description;

    @Column(columnDefinition = "boolean default true")
    private Boolean open;

    public Task(String description){
        this.description = description;
        this.open = true;
    }

    public String getDescription() {
        return this.description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setOpen(Boolean open) {
        this.open = open;
    }
}
