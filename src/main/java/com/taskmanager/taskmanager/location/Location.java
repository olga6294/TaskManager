package com.taskmanager.taskmanager.location;

import com.taskmanager.taskmanager.task.Task;
import lombok.Data;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Data
public class Location {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private double lat;
    private double lng;
    private String place;

}
