package com.taskmanager.taskmanager.task;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Optional;

@Service
public class TaskService {

    @Autowired
    private TaskRepository taskRepository;

    //public TaskService(TaskRepository taskRepository) {this.taskRepository = taskRepository;}

    public Iterable<Task> findAll(){
        return taskRepository.findAll();
    }

    public Optional<Task> find(int id){
        return taskRepository.findById(id);
    }

    public void save(Task task){
        taskRepository.save(task);
    }

    public void update(Task task){
        taskRepository.save(task);
    }

    public void delete(int id){
        taskRepository.deleteById(id);
    }
}
