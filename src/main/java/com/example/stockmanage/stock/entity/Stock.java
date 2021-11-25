package com.example.stockmanage.stock.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Stock {

    @Id
    @GeneratedValue
    private Long id;
    private String name;
    private int qty;
    private String date;
    private String supplier;

    public Stock(String name, int parseInt, String date, String supplier) {

    }
}
