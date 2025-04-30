package com.example.springsample.controller;

import java.util.List;
import org.springframework.web.bind.annotation.*;
import org.springframework.validation.annotation.Validated;
import com.example.springsample.entity.Sample;
import com.example.springsample.form.SampleForm;
import com.example.springsample.service.SampleService;

@RestController
@RequestMapping("/api/samples")
public class SampleController {
    
    private final SampleService sampleService;
    
    public SampleController(SampleService sampleService) {
        this.sampleService = sampleService;
    }
    
    @GetMapping
    public List<Sample> findAll() {
        return sampleService.findAll();
    }
    
    @GetMapping("/{name}")
    public List<Sample> findByName(@PathVariable String name) {
        return sampleService.findByName(name);
    }
    
    @PostMapping("/upsert")
    public void upsert(@Validated @RequestBody SampleForm form) {
        Sample sample = new Sample();
        sample.setId(form.getId());
        sample.setName(form.getName());
        sampleService.upsert(sample);
    }
} 