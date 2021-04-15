package com.m2u.interview.file.map;

import com.m2u.interview.file.DataFileHeader;

public class DataFileHeaderMap implements DataFileMap<DataFileHeader> {

    @Override
    public DataFileHeader populate(String message) {
        return DataFileHeader.builder()
            .rawData(message).build();
    }

    @Override
    public Class<DataFileHeader> getParameterClass() {
        return DataFileHeader.class;
    }
}
