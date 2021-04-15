package com.m2u.interview.file;

import com.m2u.interview.file.map.DataFileMap;
import com.m2u.interview.file.map.RecordMapFactory;

import org.springframework.stereotype.Component;

@Component
public class RecordPopulator {
    public Object populate(String val) {
        DataFileMap<?> mapper = RecordMapFactory.build(val);
        return mapper.populate(val);
    }
}
