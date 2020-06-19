package com.taskmanager.taskmanager.taskhistory.event;

import com.taskmanager.taskmanager.taskhistory.TaskUpdateRepository;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

@Component
public class TaskUpdateListener implements ApplicationListener<TaskUpdateEvent> {

    private final TaskUpdateRepository taskUpdateRepository;

    public TaskUpdateListener(TaskUpdateRepository taskUpdateRepository) {
        this.taskUpdateRepository = taskUpdateRepository;
    }

    @Override
    public void onApplicationEvent(TaskUpdateEvent taskModificationEvent) {
        taskUpdateRepository.save(taskModificationEvent.getTaskUpdateSnapshot());
    }
}
