package com.taskmanager.taskmanager.task;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class TaskController {

    private final TaskService taskService;

    public TaskController(TaskService taskService) {
        this.taskService = taskService;
    }

    @GetMapping("/all")
    public List<Task> getTaskList(){
        return taskService.findAllTasks();
    }

    @PostMapping("/newtask")
    public void saveTask(@RequestBody Task task){
        taskService.save(task);
    }
}
