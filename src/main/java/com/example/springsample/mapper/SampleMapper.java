package com.example.springsample.mapper;

import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import com.example.springsample.entity.Sample;
 
@Mapper
public interface SampleMapper {
    List<Sample> findAll();
    List<Sample> findByName(String name);
    void upsert(Sample sample);
} 