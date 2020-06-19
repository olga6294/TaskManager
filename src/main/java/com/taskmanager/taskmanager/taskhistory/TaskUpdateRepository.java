package com.taskmanager.taskmanager.taskhistory;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class TaskUpdateRepository {

    private final JdbcTemplate jdbcTemplate;

    public TaskUpdateRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public void save(TaskUpdateSnapshot taskUpdateSnapshot){
        String sql = String.format("INSERT INTO TaskUpdateSnapshot(taskId, name, description, dueDate, solvingDate, status) VALUES (%d, '%s', '%s', '%s', '%s', '%s')", taskUpdateSnapshot.getTaskId(), taskUpdateSnapshot.getName(), taskUpdateSnapshot.getDescription(), taskUpdateSnapshot.getDueDate(), taskUpdateSnapshot.getSolvingDate(), taskUpdateSnapshot.getStatus());
        jdbcTemplate.execute(sql);
    }

    public Iterable<TaskUpdateSnapshot> findByTaskId(int taskId){
        String sql = String.format("SELECT * FROM TaskUpdateSnapshot WHERE taskId = %d", taskId);
        return jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(TaskUpdateSnapshot.class));
    }

}

