package com.taskmanager.taskmanager.settings;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/settings")
public class SettingsController {

    private final SettingsService settingsService;

    public SettingsController(SettingsService settingsService) {
        this.settingsService = settingsService;
    }

    @GetMapping
    public Settings getSettings(){
        return settingsService.find();
    }

    @PostMapping
    public void saveSettings(@RequestBody Settings settings){
        settingsService.save(settings);
    }
}
