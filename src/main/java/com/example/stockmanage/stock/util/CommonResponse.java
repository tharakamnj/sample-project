package com.example.stockmanage.stock.util;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CommonResponse {

    private List<Object> payload = null;
    private List<String> errorMsg = new ArrayList<>();
    private int status = 200;
}
