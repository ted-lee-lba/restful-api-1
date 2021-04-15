package com.m2u.interview.file.map;

import java.util.regex.Pattern;

import com.m2u.interview.file.DataFileHeader;
import com.m2u.interview.file.DataFileRecord;

public class RecordMapFactory {
    private RecordMapFactory() {}

    @SuppressWarnings("unchecked")
    public static <T> DataFileMap<T> build(String message) {
        if (Pattern.matches(DataFileHeader.RECORD_REGEX_PATTERN, message)) {
            return (DataFileMap<T>) new DataFileHeaderMap();
        }
        if (Pattern.matches(DataFileRecord.RECORD_REGEX_PATTERN, message)) {
            return (DataFileMap<T>) new DataFileRecordMap();
        }
        throw new UnsupportedOperationException("Unable to find mapper for record [" + message + "].");
    }
}