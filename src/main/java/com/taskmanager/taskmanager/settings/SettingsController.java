package com.taskmanager.taskmanager.settings;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SettingsController {

    private final SettingsService settingsService;

    public SettingsController(SettingsService settingsService) {
        this.settingsService = settingsService;
    }

    @GetMapping("/settings")
    public Settings getSettings(){
        return settingsService.find();
    }

    @PostMapping("/settings")
    public void saveSettings(@RequestBody Settings settings){
        settingsService.save(settings);
    }
}
