package com.example.stockmanage.stock.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class StockDto {

    private String id;
    private String name;
    private String qty;
    private String date;
    private String supplier;
}
