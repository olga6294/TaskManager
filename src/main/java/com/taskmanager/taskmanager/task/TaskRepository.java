package com.taskmanager.taskmanager.task;

import org.springframework.stereotype.Repository;
import org.springframework.data.repository.CrudRepository;

@Repository
public interface TaskRepository extends CrudRepository<Task, Integer> {

}
