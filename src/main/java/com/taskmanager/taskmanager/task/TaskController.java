package com.taskmanager.taskmanager.task;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TaskController {

    @GetMapping("")
    public String hello(){
        return "Hello, World!";
    }
}
