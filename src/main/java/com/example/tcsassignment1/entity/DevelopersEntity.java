package com.example.tcsassignment1.entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Data
@Table(name = "DEVELOPERS_ENTITY")
public class DevelopersEntity {
    @Id
    private Long id;
    private String name;
    private String skills;
}
