package com.m2u.interview.file;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Timestamp;

import com.m2u.interview.db.entity.Record;
import com.m2u.interview.db.repository.RecordRepository;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class DataFileProcessor {
    @Autowired
    private RecordPopulator _recordPopulator;

    @Autowired
    private RecordRepository _recordRepository;

    public void processFile(String file) throws IOException {
        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String line = reader.readLine();
            while (StringUtils.isNotBlank(line)) {
                Object record = _recordPopulator.populate(line);

                if (record instanceof DataFileHeader) {
                    line = reader.readLine();
                    continue;
                }

                Record recordEntity = map((DataFileRecord) record);
                _recordRepository.save(recordEntity);

                line = reader.readLine();
            }
        }
    }

    private Record map(DataFileRecord record) {
        return Record.builder().accountNumber(record.getAccountNumber())
            .customerId(record.getCustomerId())
            .trxDateTime(Timestamp.valueOf(record.getDateTime()))
            .trxDescr(record.getDescription())
            .trxAmount(record.getAmount())
            .build();
    }
    
}
