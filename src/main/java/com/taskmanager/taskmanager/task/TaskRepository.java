package com.taskmanager.taskmanager.task;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class TaskRepository {

    private final JdbcTemplate jdbcTemplate;

    public TaskRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<Task> findAll(){
        return jdbcTemplate.query("select * from Task", new BeanPropertyRowMapper<Task>(Task.class));
    }

    public void save(Task task){
        String sql = String.format("insert into Task(name, description, dueDate, status) values ('%s', '%s', '%s', '%s')", task.getName(), task.getDescription(), task.getDueDate(), task.getStatus());
        jdbcTemplate.execute(sql);
    }
}
