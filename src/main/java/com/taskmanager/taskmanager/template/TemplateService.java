package com.taskmanager.taskmanager.template;

import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class TemplateService {

    private final TemplateRepository templateRepository;

    public TemplateService(TemplateRepository templateRepository) {
        this.templateRepository = templateRepository;
    }

    public Iterable<Template> getAll(){
        return templateRepository.findAll();
    }

    public void save(Template template){
        templateRepository.save(template);
    }

    public Optional<Template> findById(int id){
        return templateRepository.findById(id);
    }

    public void update(Template template){
        templateRepository.save(template);
    }

    public void deleteById(int id){
        templateRepository.deleteById(id);
    }
}
