package com.example.springsample.controller;

import java.util.List;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.example.springsample.entity.Sample;
import com.example.springsample.service.SampleService;

@RestController
public class SampleController {
    
    private final SampleService sampleService;
    
    public SampleController(SampleService sampleService) {
        this.sampleService = sampleService;
    }
    
    @GetMapping("/samples")
    public List<Sample> findByName(@RequestParam(required = false) String name) {
        if (name == null || name.isEmpty()) {
            return sampleService.findAll();
        }
        return sampleService.findByName(name);
    }
} 