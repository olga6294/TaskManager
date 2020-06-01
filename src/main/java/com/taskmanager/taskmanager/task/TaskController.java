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
        return taskService.findAll();
    }

    @PostMapping("/newtask")
    public void saveTask(@RequestBody Task task){
        taskService.save(task);
    }

    @PutMapping("/update/{id}")
    public void updateTask(@PathVariable("id") int id, @RequestBody Task task){
        taskService.update(id, task);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteTask(@PathVariable("id") int id){
        taskService.delete(id);
    }
}
