package com.taskmanager.taskmanager.settings;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SettingsController {

    private final SettingsRepository settingsRepository;

    public SettingsController(SettingsRepository settingsRepository) {
        this.settingsRepository = settingsRepository;
    }

    @GetMapping("/settings")
    public Iterable<Settings> getSettings(){
        return settingsRepository.findAll();
    }

    @PostMapping("/settings")
    public void saveSettings(@RequestBody Settings settings){
        settingsRepository.save(settings);
    }
}
