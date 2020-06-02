package com.taskmanager.taskmanager.task;

import ch.qos.logback.classic.db.names.SimpleDBNameResolver;
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
        String sql = "select * from Task";
        return jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(Task.class));
    }

    public  List<Task> find(int id){
        String sql = String.format("select * from Task where id = %d", id);
        return jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(Task.class));
    }

    public void save(Task task){
        String sql = String.format("insert into Task(name, description, dueDate, status) values ('%s', '%s', '%s', '%s')", task.getName(), task.getDescription(), task.getDueDate(), task.getStatus());
        jdbcTemplate.execute(sql);
    }

    public void update(int id, Task task){
        String sql = String.format("update Task set name = '%s', description = '%s', dueDate = '%s', status = '%s' where id = %d", task.getName(), task.getDescription(), task.getDueDate(), task.getStatus(), id);
        jdbcTemplate.execute(sql);
    }

    public void delete(int id){
        String sql = String.format("delete from Task where id = %d", id);
        jdbcTemplate.execute(sql);
    }
}
