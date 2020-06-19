package com.taskmanager.taskmanager.taskhistory;

import com.taskmanager.taskmanager.taskhistory.event.TaskUpdatePublisher;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/task/update")
public class TaskUpdateController {

    private final TaskUpdatePublisher taskUpdatePublisher;
    private final TaskUpdateService taskUpdateService;

    public TaskUpdateController(TaskUpdatePublisher taskUpdatePublisher, TaskUpdateService taskUpdateService) {
        this.taskUpdatePublisher = taskUpdatePublisher;
        this.taskUpdateService = taskUpdateService;
    }

    @PostMapping
    public void save(@RequestBody TaskUpdateSnapshot taskUpdateSnapshot){
        taskUpdatePublisher.publishTaskModification(taskUpdateSnapshot);
    }

    @GetMapping("/{id}")
    public Iterable<TaskUpdateSnapshot> findAllByTaskId(@PathVariable int id){
        return taskUpdateService.findAllByTaskId(id);
    }
}
