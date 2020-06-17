package com.taskmanager.taskmanager.task;

import org.springframework.web.bind.annotation.*;
import java.util.Optional;

@RestController
public class TaskController {

    private final TaskService taskService;

    public TaskController(TaskService taskService) {
        this.taskService = taskService;
    }

    @GetMapping("/task")
    public Iterable<Task> getTasks(){
        return taskService.findAll();
    }

    @GetMapping("/task/{id}")
    public Optional<Task> getTask(@PathVariable("id") int id){
        return taskService.find(id);
    }

    @PostMapping("/task")
    public void saveTask(@RequestBody Task task){
        taskService.save(task);
    }

    @PutMapping("/task/{id}")
    public void updateTask(@RequestBody Task task){
        taskService.update(task);
    }

    @DeleteMapping("/task/{id}")
    public void deleteTask(@PathVariable("id") int id){
        taskService.delete(id);
    }
}
