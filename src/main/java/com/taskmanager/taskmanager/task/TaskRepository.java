package com.taskmanager.taskmanager.task;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.SQLWarning;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Repository
public class TaskRepository {

    private final JdbcTemplate jdbcTemplate;

    public TaskRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<Task> findAll(){
        String sql = "SELECT name, description, dueDate, id, status FROM Task";
        return jdbcTemplate.query(sql, taskMapper());
    }

    public void update(int id, Task task){
        String sql = String.format("UPDATE Task SET name = '%s', description = '%s', dueDate = '%s' WHERE id = %s", task.getName(), task.getDescription(), task.getDueDate(), id);
        jdbcTemplate.execute(sql);
    }

    public void save(Task task){
        String sql = String.format("INSERT INTO Task(name, description, dueDate, status) VALUES ('%s', '%s', '%s', '%s')", task.getName(), task.getDescription(), task.getDueDate(), task.getStatus());
        jdbcTemplate.execute(sql);
    }

    public List<Task> findById(int id){
        return jdbcTemplate.query(String.format("SELECT * FROM Task WHERE id = %s", id), taskMapper());
    }

    public void deleteById(int id){
        String sql = String.format("DELETE FROM Task WHERE id = %d", id);
        jdbcTemplate.execute(sql);
    }

    private static RowMapper<Task> taskMapper(){
        return (resultSet, rowNumber) ->
            new Task(
                    resultSet.getInt("id"),
                    resultSet.getString("name"),
                    resultSet.getString("description"),
                    resultSet.getString("dueDate"),
                    resultSet.getString("status")
            );
    }

}