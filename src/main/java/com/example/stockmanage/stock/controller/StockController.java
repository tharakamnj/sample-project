package com.example.stockmanage.stock.controller;

import com.example.stockmanage.stock.dto.StockDto;
import com.example.stockmanage.stock.service.StockService;
import com.example.stockmanage.stock.util.CommonResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/stock")
public class StockController {

    private final StockService service;

    @Autowired
    public StockController(StockService service) {
        this.service = service;
    }

    @PostMapping("/addStock")
    public CommonResponse addStock(@RequestBody StockDto dto) {
        return service.addStock(dto);
    }

    @GetMapping("/getAllStock")
    public CommonResponse getAll() {
        return service.getAll();
    }

    @PutMapping("/updateStock/{id}")
    public CommonResponse updateStock(@PathVariable("id") String id, @RequestBody StockDto dto) {
        dto.setId(id);
        return service.updateStock(dto);
    }

    @DeleteMapping("/deleteStock/{id}")
    public CommonResponse deleteStock(@PathVariable("id") String id) {
        return service.deleteStock(id);
    }

    @GetMapping("/findById/{id}")
    public CommonResponse findById(@PathVariable("id") String id) {
        return service.findById(id);
    }
}
