package com.taskmanager.taskmanager.user;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class UserRepository {

    private final JdbcTemplate jdbcTemplate;

    public UserRepository(JdbcTemplate jdbcTemplate){
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<User> findAll(){
        String sql = "SELECT * FROM USER";
        return jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(User.class));
    }
}
