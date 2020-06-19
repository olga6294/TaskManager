package com.taskmanager.taskmanager.settings;

import com.taskmanager.taskmanager.user.UserContext;
import org.springframework.stereotype.Service;

@Service
public class SettingsService {

    private final SettingsRepository settingsRepository;
    private final UserContext userContext;

    public SettingsService(SettingsRepository settingsRepository, UserContext userContext){
        this.settingsRepository = settingsRepository;
        this.userContext = userContext;
    }

    public Settings find(){
        return settingsRepository.findByClientId(userContext.getClientId());
    }

    public void save(Settings settings){
        settings.setClientId(userContext.getClientId());
        settingsRepository.save(settings);
    }

}
