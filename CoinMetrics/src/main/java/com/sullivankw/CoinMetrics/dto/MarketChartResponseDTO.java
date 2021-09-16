package com.sullivankw.CoinMetrics.dto;

import java.util.Date;

public class MarketChartResponseDTO {

    private Date date;

    private long unix;

    private double price;

    private double marketCap;

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public long getUnix() {
        return unix;
    }

    public void setUnix(long unix) {
        this.unix = unix;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public double getMarketCap() {
        return marketCap;
    }

    public void setMarketCap(double marketCap) {
        this.marketCap = marketCap;
    }
}
