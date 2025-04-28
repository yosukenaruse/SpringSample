package com.example.springsample.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import com.example.springsample.mapper.TestMapper;

@RestController
public class TestController {
    
    private final TestMapper testMapper;
    
    public TestController(TestMapper testMapper) {
        this.testMapper = testMapper;
    }
    
    @GetMapping("/test")
    public int test() {
        return testMapper.selectOne();
    }
} 