package com.m2u.interview.db.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "com.m2u.interview.db.entity.User")
@Table(name = "user")
public class User {
    @Id
    @Column(name = "id", nullable = false)
    private int id;
    @Column(name = "username", nullable = true)
    private String userName;
    @Column(name = "password", nullable = true)
    private String password;
}
