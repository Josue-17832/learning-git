package com.example.task.services;

import com.example.task.Payload.CreateTaskDTO;

import java.util.List;

public interface TaskService {
    public CreateTaskDTO createTask (CreateTaskDTO createTaskDTO);
    public List<CreateTaskDTO> getAllTasks();
    public CreateTaskDTO getTaskById(Long id);
    //public CreateTaskDTO updateTask(Long id, CreateTaskDTO createTaskDTO)
    public int deleteTask(long id);

}
