package com.m2u.interview.file;

import javax.validation.constraints.NotBlank;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class DataFileHeader {
    public static final String RECORD_REGEX_PATTERN = "^ACCOUNT_NUMBER\\|TRX_AMOUNT\\|DESCRIPTION\\|TRX_DATE\\|TRX_TIME\\|CUSTOMER_ID$";

    @NotBlank
    private String rawData;
}
