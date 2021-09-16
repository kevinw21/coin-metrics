package com.sullivankw.CoinMetrics.dto;

import java.util.List;

public class MarketChartResponseWrapperDTO {

    private String coinGeckoId;

    private List<MarketChartResponseDTO> marketData;

    public String getCoinGeckoId() {
        return coinGeckoId;
    }

    public void setCoinGeckoId(String coinGeckoId) {
        this.coinGeckoId = coinGeckoId;
    }

    public List<MarketChartResponseDTO> getMarketData() {
        return marketData;
    }

    public void setMarketData(List<MarketChartResponseDTO> marketData) {
        this.marketData = marketData;
    }
}
