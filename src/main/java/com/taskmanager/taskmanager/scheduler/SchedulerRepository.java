package com.taskmanager.taskmanager.scheduler;

import com.taskmanager.taskmanager.user.UserContext;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class SchedulerRepository {

    private final String TASK_STATUS_OVERDUE = "OVERDUE";
    private final String TASK_STATUS_UPCOMING = "UPCOMING";

    private final JdbcTemplate jdbcTemplate;
    private final UserContext userContext;

    public SchedulerRepository(JdbcTemplate jdbcTemplate, UserContext userContext) {
        this.jdbcTemplate = jdbcTemplate;
        this.userContext =  userContext;
    }

    public void updateStatusToUpcoming(){
        String sql = String.format("UPDATE Task SET status = '%s' WHERE DATEDIFF(dueDate, CURDATE()) <= (SELECT daysBefore FROM Settings WHERE clientId = %d)", TASK_STATUS_UPCOMING, userContext.getClientId());
        jdbcTemplate.execute(sql);
    }

    public void updateStatusToOverdue(){
        String sql = String.format("UPDATE Task SET status = '%s' WHERE DATEDIFF(dueDate, CURDATE()) <= -1", TASK_STATUS_OVERDUE);
        jdbcTemplate.execute(sql);
    }

}
