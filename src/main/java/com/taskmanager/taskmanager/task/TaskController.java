package com.taskmanager.taskmanager.task;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/task")
public class TaskController {

    private final TaskService taskService;

    public TaskController(TaskService taskService) {
        this.taskService = taskService;
    }

    @GetMapping
    public Iterable<Task> getTasks(){
        return taskService.findAll();
    }

    @GetMapping("/{id}")
    public List<Task> getTask(@PathVariable("id") int id){
        return taskService.findById(id);
    }

    @PostMapping
    public void saveTask(@RequestBody Task task){
        taskService.save(task);
    }

    @PutMapping("/{id}")
    public void updateTask(@RequestBody Task task, @PathVariable int id){
        taskService.update(id, task);
    }

    @DeleteMapping("/{id}")
    public void deleteTask(@PathVariable("id") int id){
        taskService.delete(id);
    }

    @PutMapping("/{id}/solve")
    public void resolveTask(@PathVariable int id){
        taskService.solve(id);
    }

    @PutMapping("/{id}/reopen")
    public void reopenTask(@PathVariable int id){
        taskService.reopen(id);
    }

    @PutMapping("/{id}/postpone")
    public void postponeTask(@RequestBody Task task){
        taskService.postpone(task);
    }
}
