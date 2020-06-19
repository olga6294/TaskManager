package com.taskmanager.taskmanager.taskhistory.event;

import com.taskmanager.taskmanager.taskhistory.TaskUpdateSnapshot;
import org.springframework.context.ApplicationEvent;

public class TaskUpdateEvent extends ApplicationEvent {

    private TaskUpdateSnapshot taskUpdateSnapshot;

    public TaskUpdateEvent(Object source, TaskUpdateSnapshot taskUpdateSnapshot) {
        super(source);
        this.taskUpdateSnapshot = taskUpdateSnapshot;
    }

    public TaskUpdateSnapshot getTaskUpdateSnapshot() {
        return taskUpdateSnapshot;
    }
}
