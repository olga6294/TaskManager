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
        taskRepository.delete(id);
    }

    public void solve(int id){ taskRepository.solve(id);}

    public void reopen(int id){
        taskRepository.reopen(id);
    }

    public void postpone(Task task){
        taskRepository.postpone(task);
    }
}
