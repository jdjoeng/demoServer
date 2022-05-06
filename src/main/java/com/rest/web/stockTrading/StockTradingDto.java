package com.rest.web.stockTrading;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;

import javax.persistence.Entity;
import javax.persistence.Id;

@Data
public class StockTradingDto {

    private String name;
    private String date;
    private double stockPrice;
    private double budgetHistory;
    private double portfolioHistory;

    public StockTradingDto(String name, String date, double stockPrice, double budgetHistory, double portfolioHistory) {
        this.name = name;
        this.date = date;
        this.stockPrice = stockPrice;
        this.budgetHistory = budgetHistory;
        this.portfolioHistory = portfolioHistory;
    }

}
