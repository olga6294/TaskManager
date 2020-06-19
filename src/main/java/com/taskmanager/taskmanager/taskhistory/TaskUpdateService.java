package com.taskmanager.taskmanager.taskhistory;

import org.springframework.stereotype.Service;

@Service
public class TaskUpdateService {

    private final TaskUpdateRepository taskUpdateRepository;

    public TaskUpdateService(TaskUpdateRepository taskUpdateRepository) {
        this.taskUpdateRepository = taskUpdateRepository;
    }

    public Iterable<TaskUpdateSnapshot> findAllByTaskId(int taskId){
        return taskUpdateRepository.findByTaskId(taskId);
    }
}
