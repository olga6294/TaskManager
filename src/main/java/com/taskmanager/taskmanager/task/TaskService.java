package com.taskmanager.taskmanager.task;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TaskService {

    private TaskRepository taskRepository;

    public TaskService(TaskRepository taskRepository) {this.taskRepository = taskRepository;}

    public Iterable<Task> findAll(){
        return taskRepository.findAll();
    }

    public List<Task> findById(int id){
        return taskRepository.findById(id);
    }

    public void save(Task task){
        taskRepository.save(task);
    }

    public void update(int id, Task task){
        taskRepository.update(id, task);
    }

    public void delete(int id){
        taskRepository.deleteById(id);
    }

    public void resolve(int id){ taskRepository.resolve(id);}
}
