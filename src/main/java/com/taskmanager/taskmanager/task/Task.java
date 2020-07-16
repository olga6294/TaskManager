package com.taskmanager.taskmanager.task;

import com.taskmanager.taskmanager.location.Location;
import lombok.Data;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Data
public class Task {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private String description;
    private String dueDate;
    private String status;
    private Location location;

}
