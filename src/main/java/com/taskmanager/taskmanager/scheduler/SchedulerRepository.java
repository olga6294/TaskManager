package com.taskmanager.taskmanager.scheduler;

import com.taskmanager.taskmanager.user.UserContext;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class SchedulerRepository {

    private final int OVERDUE_STATUS_ID = 2;
    private final int UPCOMING_STATUS_ID = 3;

    private final JdbcTemplate jdbcTemplate;
    private final UserContext userContext;

    public SchedulerRepository(JdbcTemplate jdbcTemplate, UserContext userContext) {
        this.jdbcTemplate = jdbcTemplate;
        this.userContext =  userContext;
    }

    public void updateStatusToUpcoming(){
        String sql = String.format("UPDATE Task SET statusId = %d WHERE DATEDIFF(dueDate, CURDATE()) <= (SELECT daysBefore FROM Settings WHERE clientId = %d)", UPCOMING_STATUS_ID, userContext.getClientId());
        jdbcTemplate.execute(sql);
    }

    public void updateStatusToOverdue(){
        String sql = String.format("UPDATE Task SET statusId = %d WHERE DATEDIFF(dueDate, CURDATE()) <= -1", OVERDUE_STATUS_ID);
        jdbcTemplate.execute(sql);
    }

}
