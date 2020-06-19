package com.taskmanager.taskmanager.settings;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SettingsRepository extends CrudRepository<Settings, Integer> {

    Settings findByClientId(int clientId);

}
