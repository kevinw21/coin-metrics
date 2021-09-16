package com.sullivankw.CoinMetrics.dto.gecko;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.sullivankw.CoinMetrics.domain.Coins.CoinData.Roi;
import com.sullivankw.CoinMetrics.domain.Coins.CoinData.SparklineIn7d;
import lombok.*;

@JsonIgnoreProperties(ignoreUnknown = true)
public class CoinMarkets {
    @JsonProperty("id")
    private String id;
    @JsonProperty("symbol")
    private String symbol;
    @JsonProperty("name")
    private String name;
    @JsonProperty("current_price")
    private double currentPrice;
    @JsonProperty("market_cap")
    private long marketCap;
    @JsonProperty("market_cap_rank")
    private long marketCapRank;
//    @JsonProperty("total_volume")
//    private long totalVolume;
//    @JsonProperty("high_24h")
//    private long high24h;
//    @JsonProperty("low_24h")
//    private long low24h;
//    @JsonProperty("price_change_24h")
//    private double priceChange24h;
//    @JsonProperty("price_change_percentage_24h")
//    private double priceChangePercentage24h;
//    @JsonProperty("market_cap_change_24h")
//    private long marketCapChange24h;
//    @JsonProperty("market_cap_change_percentage_24h")
//    private double marketCapChangePercentage24h;
//    @JsonProperty("circulating_supply")
//    private long circulatingSupply;
//    @JsonProperty("total_supply")
//    private long totalSupply;
//    @JsonProperty("ath")
//    private long ath;
//    @JsonProperty("ath_change_percentage")
//    private double athChangePercentage;
//    @JsonProperty("ath_date")
//    private String athDate;
//    @JsonProperty("roi")
//    private Roi roi;
//    @JsonProperty("last_updated")
//    private String lastUpdated;
//    @JsonProperty("sparkline_in_7d")
//    private SparklineIn7d sparklineIn7d;
//    @JsonProperty("price_change_percentage_1h_in_currency")
//    private double priceChangePercentage1hInCurrency;


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
}

