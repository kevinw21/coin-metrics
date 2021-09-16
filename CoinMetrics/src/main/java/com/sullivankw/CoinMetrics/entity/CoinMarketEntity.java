package com.sullivankw.CoinMetrics.entity;

import com.sullivankw.CoinMetrics.DateUtils;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.time.LocalDate;
import java.util.UUID;

@Entity
public class CoinMarketEntity {

    @Id
    private String uuid = UUID.randomUUID().toString();

    private String coinGeckoId;

    private String symbol;

    private String name;

    private double currentPrice;

    private long marketCap;

    private long marketCapRank;

    private String date = DateUtils.fromLocalDate(LocalDate.now());

    private LocalDate dateAsDate = LocalDate.now();

    public String getUuid() {
        return uuid;
    }

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

    public LocalDate getDateAsDate() {
        return dateAsDate;
    }
}
