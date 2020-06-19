package com.taskmanager.taskmanager.taskhistory;

import lombok.Data;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Data
@Entity
public class TaskUpdateSnapshot {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private int taskId;
    private String name;
    private String description;
    private String dueDate;
    private String solvingDate;
    private String status;

}
