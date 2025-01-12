package com.example.task.services.impl;

import com.example.task.Payload.CreateTaskDTO;
import com.example.task.Entities.Task;
import com.example.task.repositories.TaskRepository;
import com.example.task.services.TaskService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service

public class TaskServicesImpl implements TaskService {

    @Autowired

    private TaskRepository taskRepository;
    private ModelMapper modelMapper;
    TaskServicesImpl(TaskRepository taskRepository, ModelMapper modelMapper) {
        this.taskRepository = taskRepository;
        this.modelMapper = modelMapper;
    }

    @Override

    public CreateTaskDTO createTask(CreateTaskDTO createTaskDTO) {
        Task taskEntity = modelMapper.map(createTaskDTO, Task.class);
        Task savedTask = taskRepository.save(taskEntity);
        return modelMapper.map(savedTask, CreateTaskDTO.class);
    }

    @Override
    public List<CreateTaskDTO> getAllTasks() {
        List<Task> tasks = taskRepository.findAll();
        List<CreateTaskDTO> taskDTOs = new ArrayList<>();
        tasks.forEach(task -> taskDTOs.add(modelMapper.map(task, CreateTaskDTO.class)));
        return taskDTOs;
    }

    @Override
    public CreateTaskDTO getTaskById(Long id) {
        Task taskEntity = taskRepository.findById(id).orElse(null);
        if (taskEntity == null) {
            return null;
        }else {
            return modelMapper.map(taskEntity, CreateTaskDTO.class);
        }

    }


    @Override
    public int deleteTask(long id) {
        Task task = taskRepository.findById(id).orElse(null);
        if (task == null) {
            return 0;
        }


        return 0;
    }
}
