package com.sullivankw.CoinMetrics.dto;

import io.swagger.annotations.ApiModelProperty;

public class MarketHistoryResponseDTO {

    @ApiModelProperty
    private String id;

    @ApiModelProperty
    private String symbol;

    @ApiModelProperty
    private String name;

    private Double currentPrice;

    private String date;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getSymbol() {
        return symbol;
    }

    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getCurrentPrice() {
        return currentPrice;
    }

    public void setCurrentPrice(Double currentPrice) {
        this.currentPrice = currentPrice;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
}
