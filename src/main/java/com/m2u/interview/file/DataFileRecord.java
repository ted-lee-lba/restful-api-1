package com.m2u.interview.file;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import javax.validation.constraints.NotBlank;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class DataFileRecord {
    public static final String RECORD_REGEX_PATTERN = "^[0-9]{10}\\|\\d+\\.\\d{2}\\|.*\\|[0-9]{4}\\-[0-9]{2}\\-[0-9]{2}\\|[0-9]{2}:[0-9]{2}:[0-9]{2}\\|\\d+$";
    
    @NotBlank
    private String rawData;

    @NotBlank
    private String accountNumber;
    
    @NotBlank
    private BigDecimal amount;

    @NotBlank
    private String description;

    @NotBlank
    private LocalDateTime dateTime;

    @NotBlank
    private Integer customerId;
}
