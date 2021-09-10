package com.sullivankw.CoinMetrics.domain.Coins;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public enum CurrencyEnum {

    aed,
    usd
}
