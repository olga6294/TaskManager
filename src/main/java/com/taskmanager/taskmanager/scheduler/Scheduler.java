package com.taskmanager.taskmanager.scheduler;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Scheduled;

public class Scheduler {

    Logger logger = LoggerFactory.getLogger(Scheduler.class);

    @Scheduled(cron="*/2 * * * *")
    public void monitorStatus(){
        logger.info("Teeeeest");
    }
}
