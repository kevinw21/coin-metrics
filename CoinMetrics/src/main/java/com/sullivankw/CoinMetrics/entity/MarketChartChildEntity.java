package com.sullivankw.CoinMetrics.entity;

import javax.persistence.*;
import java.util.Date;
import java.util.UUID;

@Entity
public class MarketChartChildEntity {

    @Id
    private String uuid = UUID.randomUUID().toString();

    private Date date;

    private long unix;

    private double price;

    private double marketCap;

    @ManyToOne
    @JoinTable(
            name = "market_chart_parent_entity_children",
            joinColumns = @JoinColumn(name = "children_uuid"),
            inverseJoinColumns = @JoinColumn(name = "market_chart_parent_entity_uuid")
    )
    private MarketChartParentEntity parent;

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

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
