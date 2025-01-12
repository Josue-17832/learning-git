package com.example.task.Entities;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "tasks")
@Cacheable
@Getter
@Setter
@NoArgsConstructor

public class Task {

    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private int id;
    @Column (nullable = false, unique = true)
    private String title;
    @Column (nullable = false, unique = true)
    private String description;
    @Column (nullable = false)
    private int priority;
    @Column (nullable = false)
    private int userId;
    @Column (nullable = false)
    private int status;
}
