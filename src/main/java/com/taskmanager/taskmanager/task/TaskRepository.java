package com.taskmanager.taskmanager.task;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class TaskRepository {

    private final String TASK_STATUS_PLANNED = "PLANNED";
    private final String TASK_STATUS_DONE = "DONE";
    private final String TASK_STATUS_DELETED = "DELETED";

    private final JdbcTemplate jdbcTemplate;

    public TaskRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<Task> findAll(){
        return jdbcTemplate.query("SELECT * FROM Task", new BeanPropertyRowMapper<Task>(Task.class));
    }

    public void update(int id, Task task){
        String sql = String.format("UPDATE Task SET name = '%s', description = '%s', dueDate = '%s' WHERE id = %s", task.getName(), task.getDescription(), task.getDueDate(), id);
        jdbcTemplate.execute(sql);
    }

    public void save(Task task){
        String sql = String.format("INSERT INTO Task(name, description, dueDate, status) VALUES ('%s', '%s', '%s', '%s')", task.getName(), task.getDescription(), task.getDueDate(), TASK_STATUS_PLANNED);
        jdbcTemplate.execute(sql);
    }

    public List<Task> findById(int id){
        return jdbcTemplate.query(String.format("SELECT * FROM Task WHERE id = %s", id), new BeanPropertyRowMapper<Task>(Task.class));
    }

    public void delete(int id){
        String sql = String.format("UPDATE Task SET status = '%s' WHERE id = %d", TASK_STATUS_DELETED, id);
        jdbcTemplate.execute(sql);
    }

    public void solve(int id){
        String sql = String.format("UPDATE Task SET status = '%s' WHERE id = %d", TASK_STATUS_DONE, id);
        jdbcTemplate.execute(sql);
    }

    public void reopen(int id){
        String sql = String.format("UPDATE Task SET status = '%s' WHERE id = %d",TASK_STATUS_PLANNED, id);
        jdbcTemplate.execute(sql);
    }

    public void postpone(Task task){
        String sql = String.format("UPDATE Task SET dueDate = '%s' WHERE id = %d", task.getDueDate(), task.getId());
        jdbcTemplate.execute(sql);
    }
}