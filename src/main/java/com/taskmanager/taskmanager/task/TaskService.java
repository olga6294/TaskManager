package com.taskmanager.taskmanager.task;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TaskService {

    private final TaskRepository taskRepository;

    public TaskService(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    public List<Task> findAll(){
        return taskRepository.findAll();
    }

    public List<Task> find(int id){
        return taskRepository.find(id);
    }

    public void save(Task task){
        taskRepository.save(task);
    }

    public void update(int id, Task task){
        taskRepository.update(id, task);
    }

    public void delete(int id){
        taskRepository.delete(id);
    }
}
