package com.m2u.interview.db.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.sql.*;
import javax.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "com.m2u.interview.db.entity.Record")
@Table(name = "record")
public class Record implements Serializable {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "id", nullable = false)
  private Long id;
  @Column(name = "trx_datetime", nullable = true)
  private Timestamp trxDateTime;
  @Column(name = "trx_descr", nullable = true)
  private String trxDescr;
  @Column(name = "account_number", nullable = false)
  private String accountNumber;
  @Column(name = "trx_amount", nullable = true)
  private BigDecimal trxAmount;
  @Column(name = "customer_id", nullable = true)
  private Integer customerId;
}