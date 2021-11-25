package com.example.stockmanage.stock.service;

import com.example.stockmanage.stock.dto.StockDto;
import com.example.stockmanage.stock.entity.Stock;
import com.example.stockmanage.stock.repository.StockRepository;
import com.example.stockmanage.stock.util.CommonResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Service
public class StockService {

    private final StockRepository repository;

    @Autowired
    public StockService(StockRepository repository) {
        this.repository = repository;
    }

    /**
     * This method is responsible save stock.
     *
     * @param dto
     * @return
     */
    public CommonResponse addStock(StockDto dto) {
        CommonResponse commonResponse = new CommonResponse();
        try {
            Stock stock = new Stock();
            stock.setName(dto.getName());
            stock.setQty(Integer.parseInt(dto.getQty()));
            stock.setDate(dto.getDate());
            stock.setSupplier(dto.getSupplier());
            repository.save(stock);
            commonResponse.setErrorMsg(Collections.singletonList("successfully added.."));
            commonResponse.setPayload(Arrays.asList(stock));
        } catch (Exception ex) {
            ex.printStackTrace();
            commonResponse.setErrorMsg((List<String>) ex);
            commonResponse.setStatus(-1);
        }
        return commonResponse;
    }

    /**
     * This method is responsible get all stock
     *
     * @return
     */
    public CommonResponse getAll() {
        CommonResponse commonResponse = new CommonResponse();
        List<Stock> list = repository.findAll();
        if (!list.isEmpty()) {
            commonResponse.setPayload(Arrays.asList(list));
        } else {
            commonResponse.setErrorMsg(Collections.singletonList("stock is empty..."));
        }
        return commonResponse;
    }

    /**
     * This method is responsible update stock
     *
     * @param dto
     * @return
     */
    public CommonResponse updateStock(StockDto dto) {
        CommonResponse commonResponse = new CommonResponse();
        try {
            if (repository.existsById(Long.parseLong(dto.getId()))) {
                Stock stock = repository.save(new Stock(Long.parseLong(dto.getId()), dto.getName(), Integer.parseInt(dto.getQty()), dto.getDate(), dto.getSupplier()));
                commonResponse.setErrorMsg(Arrays.asList("successfully updated..." + stock.getId().toString()));
            } else {
                commonResponse.setErrorMsg(Arrays.asList("check your stock id...."));
            }

        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return commonResponse;
    }

    /**
     * This method is responsible delete stock.
     *
     * @param id
     * @return
     */
    public CommonResponse deleteStock(String id) {
        CommonResponse commonResponse = new CommonResponse();
        try {
            if (repository.existsById(Long.parseLong(id))) {
                repository.deleteById(Long.parseLong(id));
                commonResponse.setErrorMsg(Arrays.asList("successfully deleted" + id));
            } else {
                commonResponse.setErrorMsg(Arrays.asList("check your stock id..."));
            }

        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return commonResponse;
    }

    /**
     * This method is responsible find stock by id
     *
     * @param id
     * @return
     */
    public CommonResponse findById(String id) {
        CommonResponse commonResponse = new CommonResponse();
        try {
            if (repository.existsById(Long.parseLong(id))) {
                Optional<Stock> stock = repository.findById(Long.parseLong(id));
                commonResponse.setPayload(Arrays.asList(stock));
            } else {
                commonResponse.setErrorMsg(Arrays.asList("check your stock id..."));
            }

        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return commonResponse;
    }
}
