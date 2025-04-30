package com.example.springsample.service;

import org.springframework.stereotype.Service;
import com.example.springsample.mapper.TestMapper;

@Service
public class TestService {
    
    private final TestMapper testMapper;
    
    public TestService(TestMapper testMapper) {
        this.testMapper = testMapper;
    }
    
    public int selectOne() {
        return testMapper.selectOne();
    }
} 