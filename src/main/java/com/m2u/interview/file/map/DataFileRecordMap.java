package com.m2u.interview.file.map;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import com.m2u.interview.file.DataFileRecord;

public class DataFileRecordMap implements DataFileMap<DataFileRecord> {

    @Override
    public DataFileRecord populate(String message) {
        String[] singleFieldValue = message.split("\\|");
        return DataFileRecord.builder()
            .rawData(message)
            .accountNumber(getAccountNumber(singleFieldValue))
            .amount(getAmount(singleFieldValue))
            .customerId(getCustomerId(singleFieldValue))
            .dateTime(getDateTime(singleFieldValue))
            .description(getDescription(singleFieldValue))
            .build();
    }

    @Override
    public Class<DataFileRecord> getParameterClass() {
        return DataFileRecord.class;
    }

    private LocalDateTime toLocalDateTime(String date, String time) {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        return LocalDateTime.parse(date + " " + time, dtf);
    }

    private String getAccountNumber(String[] val) {
        return val[0];
    }

    private BigDecimal getAmount(String[] val) {
        return new BigDecimal(val[1]);
    }

    private Integer getCustomerId(String[] val) {
        return Integer.valueOf(val[val.length - 1]);
    }

    private LocalDateTime getDateTime(String[] val) {
        return toLocalDateTime(val[val.length - 3], val[val.length - 2]);
    }

    private String getDescription(String[] val) {
        StringBuilder result = new StringBuilder();
        for(int i = 2; i < val.length - 3; i++) {
            result.append(val[i]);
        }
        return result.toString();
    }
}
