package com.taskmanager.taskmanager.task;

import lombok.Data;

@Data
public class Task {

    private String name;
    private String description;
    private String dueDate;
    private String status;
    private int id;

}
