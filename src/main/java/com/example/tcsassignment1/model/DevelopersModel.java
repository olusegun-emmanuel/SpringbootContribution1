package com.example.tcsassignment1.model;

import lombok.Data;

@Data
public class DevelopersModel {
    private Long id;
    private String name;
    private String skills;


    public DevelopersModel() {    }

    @Override
    public String toString() {
        return "DevelopersModel{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", skills=" + skills +
                '}';
    }
}
