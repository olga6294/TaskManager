package com.taskmanager.taskmanager.scheduler;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

@Service
public class Scheduler {

    private final SchedulerRepository schedulerRepository;

    public Scheduler(SchedulerRepository schedulerRepository) {
        this.schedulerRepository = schedulerRepository;
    }

    @Scheduled(cron="* */1 * * * *")
    public void monitorStatus(){
        schedulerRepository.updateStatusToUpcoming();
        schedulerRepository.updateStatusToOverdue();
    }
}
