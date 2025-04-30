package com.example.springsample.service;

import java.util.List;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.example.springsample.entity.Sample;
import com.example.springsample.mapper.SampleMapper;

@Service
public class SampleService {
    
    private final SampleMapper sampleMapper;
    
    public SampleService(SampleMapper sampleMapper) {
        this.sampleMapper = sampleMapper;
    }
    
    public List<Sample> findAll() {
        return sampleMapper.findAll();
    }
    
    public List<Sample> findByName(String name) {
        return sampleMapper.findByName(name);
    }

    @Transactional
    public void upsert(Sample sample) {
        sampleMapper.upsert(sample);
    }
} 