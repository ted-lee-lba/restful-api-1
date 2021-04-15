package com.m2u.interview.domain.dto;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class RecordDTO {
    private Long id;
    private LocalDateTime trxDateTime;
    private String trxDescr;
    private String accountNumber;
    private BigDecimal trxAmount;
    private Integer customerId;
}
