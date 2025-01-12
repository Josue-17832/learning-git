package com.example.task.Payload;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CreateTaskDTO {
    private Long id;
    private String title;
    private String description;
    private int priority;
    private int userId;
    private int status;

}
