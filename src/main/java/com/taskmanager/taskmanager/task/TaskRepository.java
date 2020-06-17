package com.taskmanager.taskmanager.task;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class TaskRepository {

    private final JdbcTemplate jdbcTemplate;

    private final String TASK_STATUS_PLANNED_ID = "1";

    public TaskRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<Task> findAll(){
        return jdbcTemplate.query("SELECT Task.name, Task.description, Task.dueDate, Task.id, Status.status FROM Task JOIN Status ON Task.statusId = Status.id", new BeanPropertyRowMapper<Task>(Task.class));
    }

    public void update(int id, Task task){
        String sql = String.format("UPDATE Task SET name = '%s', description = '%s', dueDate = '%s' WHERE id = %s", task.getName(), task.getDescription(), task.getDueDate(), id);
        jdbcTemplate.execute(sql);
    }

    public void save(Task task){
        String sql = String.format("INSERT INTO Task(name, description, dueDate, statusId) VALUES ('%s', '%s', '%s', '%s')", task.getName(), task.getDescription(), task.getDueDate(), TASK_STATUS_PLANNED_ID);
        jdbcTemplate.execute(sql);
    }

    public List<Task> findById(int id){
        return jdbcTemplate.query(String.format("SELECT * FROM Task WHERE id = %s", id), new BeanPropertyRowMapper<Task>(Task.class));
    }

    public void deleteById(int id){
        String sql = String.format("DELETE FROM Task WHERE id = %d", id);
        jdbcTemplate.execute(sql);
    }
}