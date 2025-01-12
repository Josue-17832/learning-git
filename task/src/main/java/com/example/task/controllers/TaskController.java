package com.example.task.controllers;

import com.example.task.Entities.Task;
import com.example.task.Payload.CreateTaskDTO;
import com.example.task.repositories.TaskRepository;
import com.example.task.services.TaskService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping ("/api/v1/tasks")
public class TaskController {
    private final TaskService taskService;
    private final TaskRepository taskRepository;

    public TaskController (TaskService taskService, TaskRepository taskRepository){
        this.taskService = taskService;
        this.taskRepository = taskRepository;
    }
    @PostMapping
    public ResponseEntity<CreateTaskDTO> createTask(@RequestBody CreateTaskDTO createTaskDTO){
        CreateTaskDTO task = taskService.createTask(createTaskDTO);
        return new ResponseEntity<>(task, HttpStatus.CREATED);
    }




    @GetMapping
    public  ResponseEntity<List<CreateTaskDTO>> getAllTasks(){
        List<CreateTaskDTO> tasks = taskService.getAllTasks();
        return new ResponseEntity<>(tasks, HttpStatus.OK);
    }
    @GetMapping("/{id}")
    public ResponseEntity<CreateTaskDTO> getTask(@PathVariable Long id) {
        CreateTaskDTO task = taskService.getTaskById(id);
        if (task == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(task, HttpStatus.OK);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteTask(@PathVariable Long id) {
        int status=taskService.deleteTask(id);
        if (status == 0) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);

    }
}
