package com.sullivankw.CoinMetrics.dto;

import io.swagger.annotations.ApiModelProperty;

public class CoinMarketResponseDTO {

    @ApiModelProperty
    private String coinGeckoId;

    @ApiModelProperty
    private String symbol;

    @ApiModelProperty
    private String name;

    @ApiModelProperty
    private double currentPrice;

    @ApiModelProperty
    private long marketCap;

    @ApiModelProperty
    private long marketCapRank;

    @ApiModelProperty
    private String date;

    public String getCoinGeckoId() {
        return coinGeckoId;
    }

    public void setCoinGeckoId(String coinGeckoId) {
        this.coinGeckoId = coinGeckoId;
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

    public double getCurrentPrice() {
        return currentPrice;
    }

    public void setCurrentPrice(double currentPrice) {
        this.currentPrice = currentPrice;
    }

    public long getMarketCap() {
        return marketCap;
    }

    public void setMarketCap(long marketCap) {
        this.marketCap = marketCap;
    }

    public long getMarketCapRank() {
        return marketCapRank;
    }

    public void setMarketCapRank(long marketCapRank) {
        this.marketCapRank = marketCapRank;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
}
