package com.alfarouq.personal_finance_tracker.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.PrePersist;

import java.math.BigDecimal;
import java.time.Instant;
import java.time.LocalDateTime;

@Entity
public class Expense {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String description;

    @Column(nullable = false)
    private BigDecimal amount;

    private LocalDateTime date;

    private Instant createdAt;

    @ManyToOne
    @JoinColumn(name = "category_id")
    private Category category;



    public Expense(){
    }

    public Long getId(){
        return id;
    }

    @PrePersist
    public void onCreate(){
        createdAt = Instant.now();
    }

    public void setAmount(BigDecimal amount){
        if(amount != null && amount.compareTo(BigDecimal.ZERO) > 0){
            this.amount = amount;
        }else{
            throw new IllegalArgumentException("Amount Cannot Be Zero Or Less!");
        }
    }

    public Instant getCreatedAt(){
        return createdAt;
    }

    public BigDecimal getAmount(){
        return amount;
    }

    public void setDate(LocalDateTime date){
        this.date = date;
    }

    public LocalDateTime getDate(){
        return date;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDescription(){
        return description;
    }

    public void setCategory(Category category){
        if(category == null){
            throw new IllegalArgumentException("Category Cannot Be Null");
        }
        this.category = category;
    }

    public Category getCategory(){
        return category;
    }

}
