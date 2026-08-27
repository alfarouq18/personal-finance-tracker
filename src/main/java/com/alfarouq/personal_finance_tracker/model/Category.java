package com.alfarouq.personal_finance_tracker.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    public Category(){

    }

    public Long getId(){
        return id;
    }
    public String getName(){
        return name;
    }

    public void setName(String name){
        if(name == null || name.isBlank()) {
            throw new IllegalArgumentException("Category Cannot Be Blank!");
        }
        this.name = name;
    }


}
