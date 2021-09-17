package com.sullivankw.CoinMetrics.entity;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Entity
public class MarketChartParentEntity {

    @Id
    private String uuid = UUID.randomUUID().toString();

    private String coinGeckoId;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    private List<MarketChartChildEntity> children = new ArrayList<>();

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    public String getCoinGeckoId() {
        return coinGeckoId;
    }

    public void setCoinGeckoId(String coinGeckoId) {
        this.coinGeckoId = coinGeckoId;
    }

    public List<MarketChartChildEntity> getChildren() {
        return children;
    }

    public void setChildren(List<MarketChartChildEntity> children) {
        this.children.clear();
        this.children.addAll(children);
    }
}
