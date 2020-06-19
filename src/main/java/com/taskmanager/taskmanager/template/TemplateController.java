package com.taskmanager.taskmanager.template;

import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/template")
public class TemplateController {

    private final TemplateService templateService;

    public TemplateController(TemplateService templateService) {
        this.templateService = templateService;
    }

    @GetMapping
    public Iterable<Template> findAll(){
        return templateService.getAll();
    }

    @GetMapping("/{id}")
    public Optional<Template> findById(@PathVariable int id){
        return templateService.findById(id);
    }

    @PostMapping
    public void save(@RequestBody Template template){
        templateService.save(template);
    }

    @PutMapping
    public void update(@RequestBody Template template){
        templateService.update(template);
    }

    @DeleteMapping("/{id}/delete")
    public void deleteById(@PathVariable int id){
        templateService.deleteById(id);
    }
}
