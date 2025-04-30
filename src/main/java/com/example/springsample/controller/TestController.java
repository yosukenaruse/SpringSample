package com.example.springsample.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import com.example.springsample.service.TestService;

@RestController
public class TestController {
    
    private final TestService testService;
    
    public TestController(TestService testService) {
        this.testService = testService;
    }
    
    @GetMapping("/test")
    public int test() {
        return testService.selectOne();
    }
} 