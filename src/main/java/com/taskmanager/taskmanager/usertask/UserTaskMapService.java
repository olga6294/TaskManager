package com.taskmanager.taskmanager.usertask;

import com.taskmanager.taskmanager.location.LocationRepository;
import com.taskmanager.taskmanager.task.TaskRepository;
import com.taskmanager.taskmanager.user.User;
import com.taskmanager.taskmanager.user.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserTaskMapService {

    private final UserRepository userRepository;
    private final LocationRepository locationRepository;
    private final TaskRepository taskRepository;

    public UserTaskMapService(UserRepository userRepository, LocationRepository locationRepository, TaskRepository taskRepository) {
        this.userRepository = userRepository;
        this.locationRepository = locationRepository;
        this.taskRepository = taskRepository;
    }

    public List<UserTaskDTO> getAllUserTasks(){
        return (userRepository
                .findAll())
                .stream()
                .map(this::getUserTaskDTO)
                .collect(Collectors.toList());
    }

    private UserTaskDTO getUserTaskDTO(User user){
        return new UserTaskDTO(
                user.getFirstName(),
                user.getLastName(),
                user.getTask().getLocation().getLat(),
                user.getTask().getLocation().getLat(),
                user.getTask().getLocation().getPlace()
        );
    }
}
