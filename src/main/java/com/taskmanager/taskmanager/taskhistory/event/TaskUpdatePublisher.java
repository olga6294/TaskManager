package com.taskmanager.taskmanager.taskhistory.event;

import com.taskmanager.taskmanager.taskhistory.TaskUpdateSnapshot;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Component;

@Component
public class TaskUpdatePublisher {

    private final ApplicationEventPublisher applicationEventPublisher;

    public TaskUpdatePublisher(ApplicationEventPublisher applicationEventPublisher) {
        this.applicationEventPublisher = applicationEventPublisher;
    }

    public void publishTaskModification(TaskUpdateSnapshot taskUpdateSnapshot){
        TaskUpdateEvent taskUpdateEvent = new TaskUpdateEvent(this, taskUpdateSnapshot);
        applicationEventPublisher.publishEvent(taskUpdateEvent);
    }
}
